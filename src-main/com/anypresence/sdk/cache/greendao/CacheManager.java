package com.anypresence.sdk.cache.greendao;

//
//  CacheManager.java
//  
//
//  Generated by AnyPresence, Inc on 2015-09-11
//  Copyright (c) 2015. All rights reserved.
//

import de.greenrobot.dao.query.*;
import de.greenrobot.dao.*;
import com.anypresence.sdk.acl.*;
import com.anypresence.sdk.callbacks.*;
import com.anypresence.sdk.query.*;
import com.anypresence.sdk.APSDKSetup;
import java.lang.reflect.*;
import com.anypresence.sdk.cache.*;
import com.anypresence.sdk.*;
import com.anypresence.sdk.cache.internal.*;
import com.anypresence.sdk.config.Config;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.anypresence.sdk.cache.internal.*;
import com.anypresence.sdk.cache.internal.APObjectsAPCachedRequests;
import com.anypresence.anypresence_inc.citi_mobile_challenge.dao.DaoMaster;
import com.anypresence.anypresence_inc.citi_mobile_challenge.dao.DaoSession;
import android.database.sqlite.SQLiteDatabase;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.anypresence.rails_droid.*;
import static com.anypresence.sdk.config.Config.DEBUG_MODE;
import java.util.*;
import java.util.Map.Entry;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import java.lang.ref.*;
import org.apache.http.client.utils.*;
import org.apache.http.*;
import java.nio.charset.Charset;
import java.net.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.anypresence.rails_droid.RemoteRailsConfig;
import com.anypresence.sdk.http.HttpAdapter;
import com.anypresence.rails_droid.http.RouterAdapter;

/**
 *
 * CacheManager to handle GreenDAO
 *
 */
public class CacheManager implements ICacheManager {
	private static Log log = LogFactory.getLog(CacheManager.class);

	private static IDAOSession daoSession;
	private static CacheManager cacheManager = null;

	private static DaoMaster daoMaster = null;
	private static SQLiteDatabase db = null;

	public static final int APCACHED_REQUEST_LIMIT = 50;

	/** Date format for parsing date string. This is the format for Date#toString() */
	public static final DateFormat DATE_FORMAT = new SimpleDateFormat(
			"EEE MMM dd HH:mm:ss zzz yyyy");

	// Register classes
	private static Class<?> apCachedRequestDAOClass;
	private static Class<?> apCachedRequestsClass;
	private static Class<?> apObjectsAPObjectsAPCachedRequestsClass;
	private static Class<?> apObjectsAPCachedRequestsDAOClass;

	private WeakReference<Context> context;

	private String databaseName;

	private CacheManager() {
	}

	static public CacheManager getInstance() {
		if (cacheManager == null) {
			cacheManager = new CacheManager();
		}

		return cacheManager;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public Context getAndroidContext() {
		return (context != null) ? context.get() : null;
	}

	public void setAndroidContext(Context context) {
		this.context = new WeakReference<Context>(context);
	}

	public static WhereCondition getConditional(Property whereCondition,
			String val) {
		WhereCondition eq = null;
		if (whereCondition.type == Integer.class) {
			eq = whereCondition.eq(Integer.parseInt(val));
		} else if (whereCondition.type == Boolean.class) {
			eq = whereCondition.eq(Boolean.parseBoolean(val));
		} else if (whereCondition.type == Long.class) {
			eq = whereCondition.eq(Long.parseLong(val));
		} else if (whereCondition.type == String.class) {
			eq = whereCondition.eq(val);
		} else {
			log.info("The type " + whereCondition.type.toString()
					+ " is not supported as a conditional at this time.");
		}
		return eq;
	}

	public static WhereCondition processParams(Field field, String value)
			throws IllegalAccessException {
		Property whereCondition = (Property) field.get(null);
		return getConditional(whereCondition, value);
	}

	/**
	 * Registers the class
	 */
	public void registerAPCachedRequestsClass(Class<?> clazz) {
		apCachedRequestsClass = clazz;
	}

	public void registerAPObjectsAPObjectsAPCachedRequestsClass(Class<?> clazz) {
		apObjectsAPObjectsAPCachedRequestsClass = clazz;
	}

	public void registerAPCachedRequestDAOClass(Class<?> clazz) {
		apCachedRequestDAOClass = clazz;
	}

	public void registerAPObjectsAPCachedRequestsDAOClass(Class<?> clazz) {
		apObjectsAPCachedRequestsDAOClass = clazz;
	}

	/**
	 * @see ICacheManager#getDAOSession()
	 */
	@Override
	public IDAOSession getDAOSession() {
		return daoSession;
	}

	public void setDaoSession(DaoSession session) {
		this.daoSession = new GreenDAOSessionHelper(session);
	}

	/**
	 * @see ICacheManager#createAPCachedRequest()
	 */
	@Override
	public IAPCachedRequest createAPCachedRequest() {
		if (apCachedRequestsClass == null) {
			throw new IllegalStateException(
					"Unable to instantiate because the corresponding class has not been registered");
		}
		return new APCachedRequest(apCachedRequestsClass);
	}

	/**
	 * @see ICacheManager#createAPObjectsAPCachedRequests()
	 */
	@Override
	public IAPObjectsAPCachedRequests createAPObjectsAPCachedRequests() {
		if (apObjectsAPObjectsAPCachedRequestsClass == null) {
			throw new IllegalStateException(
					"Unable to instantiate because the corresponding class has not been registered");
		}
		return new APObjectsAPCachedRequests(
				apObjectsAPObjectsAPCachedRequestsClass);
	}

	/**
	 * @see ICacheManager#updateInCache(Class, IAPObject)
	 */
	@Override
	public <T extends IAPObject> void updateInCache(Class<T> clazz,
			IAPObject object) {
		if (object.getObjectId() == null) {
			log.error("Unable to update to cache because the object id is null");
			return;
		}

		GreenDAOHelper.getInstance(clazz).updateObject(object);
	}

	/**
	 * @see ICacheManager#saveInCache(Class, APObject, String)
	 */
	@Override
	public <T extends IAPObject> void saveInCache(Class<T> clazz,
			IAPObject object, String scope) {
		if (object.getObjectId() == null) {
			log.info("Saving to cache: object id is null");
		}
		com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequest cachedRequest = null;
		Long cachedRequestId = null;
		com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APObject _object = GreenDAOHelper
				.getInstance(clazz).createObject(object);
		if (daoSession.getRaw() != null) {
			if (object.getObjectId() != null)
				_object.setObjectId(object.getObjectId().stringify());
			_object.set_cacheUpdatedAt(new Date());
			cachedRequest = new com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequest();
			if (scope != null) {
				cachedRequest.setScope(scope);
			}
			cachedRequest.setType(object.getClass().getSimpleName()
					.toLowerCase());
			cachedRequestId = ((DaoSession) daoSession.getRaw())
					.getAPCachedRequestDao().insert(cachedRequest);
			if (Config.getInstance().getCacheStrategy() == Config.CacheStrategy.OVERWRITE
					&& object.getObjectId() != null) {
				List<? extends com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APObject> existingObjects = GreenDAOHelper
						.getInstance(clazz).getObjectsByObjectId(object);

				try {
					if (existingObjects == null || existingObjects.isEmpty()) {
						Long id = GreenDAOHelper.getInstance(clazz)
								.insertObject(_object);
						addToAPCachedRequests(id, cachedRequestId);
						log.info("Added " + this.getClass().getName()
								+ " to cache: local id: " + _object.getId()
								+ ", remote object id: "
								+ _object.getObjectId());
						if (DEBUG_MODE) {
							log.info(ReflectionToStringBuilder
									.toString(_object));
						}
					} else {
						IAPCachedRequest request = CacheManager.getInstance()
								.createAPCachedRequest();
						request.setScope(cachedRequest.getScope());
						request.setParameter(cachedRequest.getParameter());
						request.set_cacheUpdatedAt(cachedRequest
								.get_cacheUpdatedAt());
						request.setType(clazz.getSimpleName().toLowerCase());
						GreenDAOHelper.getInstance(clazz).updateEachObject(
								_object, request, existingObjects);
					}
				} finally {
					if (existingObjects != null)
						((LazyList<? extends com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APObject>) existingObjects)
								.close();
				}
			} else {
				Long id = GreenDAOHelper.getInstance(clazz).insertObject(
						_object);
				addToAPCachedRequests(id, cachedRequestId);
				log.info("Added " + object.getClass().getName()
						+ " to cache: local id: " + _object.getId()
						+ ", remote object id: " + _object.getObjectId());
				if (DEBUG_MODE) {
					log.info(ReflectionToStringBuilder.toString(_object));
				}
			}
		}
	}

	/**
	 * @see ICacheManager#saveAPCachedRequest(IAPCachedRequest)
	 */
	@Override
	public void saveAPCachedRequest(IAPCachedRequest request) {
		((DaoSession) daoSession.getRaw())
				.getAPCachedRequestDao()
				.insert((com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequest) request
						.getRaw());
	}

	/**
	 * @see ICacheManager#saveInCacheWithRequest(Class, APObject, IAPCachedRequest)
	 */
	@Override
	public <T extends IAPObject> void saveInCacheWithRequest(Class<T> clazz,
			IAPObject object, IAPCachedRequest request) {
		com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APObject _object = null;
		if (CacheManager.getInstance().getDAOSession() == null) {
			log.info("The Cachemanager is not setup");
			return;
		}

		_object = GreenDAOHelper.getInstance(clazz).createObject(object);

		if (Config.getInstance().getCacheStrategy() == Config.CacheStrategy.OVERWRITE
				&& object.getObjectId() != null) {
			List<? extends com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APObject> existingObjects = GreenDAOHelper
					.getInstance(clazz).getObjectsByObjectId(object);

			try {
				if (existingObjects != null && existingObjects.isEmpty()) {
					Long id = GreenDAOHelper.getInstance(clazz).insertObject(
							_object);
					if (DEBUG_MODE) {
						log.info(ReflectionToStringBuilder.toString(_object));
					}
					addToAPCachedRequests(
							id,
							((com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequest) request
									.getRaw()).getId());
				} else {
					GreenDAOHelper.getInstance(clazz).updateEachObject(_object,
							request, existingObjects);
				}
			} finally {
				if (existingObjects != null)
					((LazyList<? extends com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APObject>) existingObjects)
							.close();

			}
		} else {
			Long id = GreenDAOHelper.getInstance(clazz).insertObject(_object);
			addToAPCachedRequests(
					id,
					((com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequest) request
							.getRaw()).getId());
		}
	}

	// Fetching from cache

	/**
	 * @see ICacheManager#fetchInCacheWithParameterPredicate(Class, String, Map)
	 */
	@Override
	public <T extends IAPObject> List<T> fetchInCacheWithParameterPredicate(
			Class<T> clazz, String scope, Map<String, String> params) {
		List<T> objects = new ArrayList<T>();
		if (CacheManager.getInstance().getDAOSession() == null) {
			log.info("The Cachemanager is not setup");
			return objects;
		}

		// A null scope should be treated as an empty string
		if (scope == null) {
			scope = "";
		}

		APObject.QueryScopeBuilder<T> q = new APObject.QueryScopeBuilder<T>(
				clazz, scope, params);
		String query = q.build();
		query = query + "%";

		// Get the last apCachedRequests that matches the scope + param
		List<com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequest> apCachedRequests = ((DaoSession) daoSession
				.getRaw())
				.getAPCachedRequestDao()
				.queryBuilder()
				.where(com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequestDao.Properties.Scope
						.eq(scope),
						com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequestDao.Properties.Type
								.eq(clazz.getSimpleName().toLowerCase()))
				.orderDesc(
						com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequestDao.Properties._cacheUpdatedAt)
				.limit(APCACHED_REQUEST_LIMIT).list();

		if (apCachedRequests != null && !apCachedRequests.isEmpty()) {
			if (DEBUG_MODE) {
				if (params != null) {
					log.info("Looking for ap cached requests matching params: ");
					for (Entry<String, String> entry : params.entrySet()) {
						log.info(" " + entry.getKey() + "=>" + entry.getValue());
					}
				}
			}
			com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequest matchedAPCachedRequest = null;
			for (com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequest request : apCachedRequests) {
				if (DEBUG_MODE) {
					String queryParam = request.getParameter();
					log.info(" Query params for: " + request + " : "
							+ queryParam);
				}
				if (findMatchingParams(request, params,
						getQueryPrefixForHttpAdapter(clazz))) {
					matchedAPCachedRequest = request;
					break;
				}
			}
			if (matchedAPCachedRequest != null) {
				List<com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APObjectsAPCachedRequests> apObjectsApCachedRequests = ((DaoSession) daoSession
						.getRaw())
						.getAPObjectsAPCachedRequestsDao()
						.queryBuilder()
						.where(com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APObjectsAPCachedRequestsDao.Properties.ApCachedRequestId
								.eq(matchedAPCachedRequest.getId())).listLazy();
				if (DEBUG_MODE) {
					log.info("Searching in cache for request: (scope=" + scope
							+ "),(query=\"" + query + "\")");
				}
				try {
					Set<Long> objectIds = new HashSet<Long>();
					for (com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APObjectsAPCachedRequests r : apObjectsApCachedRequests) {
						if (r.getApObjectId() == null)
							continue;

						objectIds.add(r.getApObjectId());
						if (DEBUG_MODE) {
							log.info("Searching in cache with: (scope="
									+ scope
									+ "),(query=\""
									+ query
									+ "\"),"
									+ "(apObjectsApCachedRequests="
									+ ReflectionToStringBuilder
											.reflectionToString(r));
						}
					}

					objects = GreenDAOHelper.getInstance(clazz)
							.fetchInCacheWithIds(objectIds);
				} finally {
					if (apObjectsApCachedRequests != null) {
						((LazyList) apObjectsApCachedRequests).close();
					}
				}
			} else {
				if (DEBUG_MODE) {
					log.info("Cannot find matching ap cached request");
				}
			}
		}

		return objects;
	}

	/**
	 * @see ICacheManager#fetchInCacheWithAPCachedRequestPredicate(Class, IAPCachedRequest)
	 */
	@Override
	public <T extends IAPObject> List<T> fetchInCacheWithAPCachedRequestPredicate(
			Class<T> clazz, IAPCachedRequest request) {
		return GreenDAOHelper.getInstance(clazz)
				.fetchInCacheWithAPCachedRequestPredicate(request);
	}

	/**
	 * @see ICacheManager#fetchInCacheWithObjectIdPredicate(Class, String)
	 */
	@Override
	public <T extends IAPObject> List<T> fetchInCacheWithObjectIdPredicate(
			Class<T> clazz, String objectId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("ObjectId", objectId);

		return GreenDAOHelper.getInstance(clazz)
				.fetchInCacheWithObjectIdPredicate(objectId);
	}

	/**
	 * @see ICacheManager#fetchInCacheWithScopePredicate(Class, String, Map, Integer, Integer)
	 */
	@Override
	public <T extends IAPObject> List<T> fetchInCacheWithScopePredicate(
			Class<T> clazz, String scope, Map<String, String> params,
			Integer offset, Integer limit) {
		return GreenDAOHelper.getInstance(clazz)
				.fetchInCacheWithScopePredicate(scope, params, offset, limit);
	}

	/**
	 * @see ICacheManager#fetchInCacheWithLatestAPCachedRequestPredicate(Class, String, Map, Integer, Integer)
	 */
	@Override
	public <T extends IAPObject> List<T> fetchInCacheWithLatestAPCachedRequestPredicate(
			Class<T> clazz, String scope, Map<String, String> params,
			Integer offset, Integer limit) {
		List<T> objects = new ArrayList<T>();
		if (CacheManager.getInstance().getDAOSession() == null) {
			log.info("The Cachemanager is not setup");
			return objects;
		}

		// A null scope should be treated as an empty string
		if (scope == null) {
			scope = "";
		}

		List<com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequest> apCachedRequests = ((DaoSession) daoSession
				.getRaw())
				.getAPCachedRequestDao()
				.queryBuilder()
				.where(com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequestDao.Properties.Scope
						.eq(scope),
						com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequestDao.Properties.Type
								.eq(clazz.getSimpleName().toLowerCase()))
				.orderDesc(
						com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequestDao.Properties._cacheUpdatedAt)
				.list();

		if (apCachedRequests != null && !apCachedRequests.isEmpty()) {
			com.anypresence.sdk.cache.internal.APCachedRequest latestAPCachedRequest = new com.anypresence.sdk.cache.internal.APCachedRequest(
					com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequest.class);
			latestAPCachedRequest.setInstance(apCachedRequests.get(0));

			objects = fetchInCacheWithAPCachedRequestPredicate(clazz,
					latestAPCachedRequest);
		}

		return objects;
	}

	/**
	 * @see ICacheManager#fetchInCacheWithPredicates(Class, Map)
	 */
	@Override
	public <T extends IAPObject> List<T> fetchInCacheWithPredicates(
			Class<T> clazz, Map<String, String> predicates) {
		return GreenDAOHelper.getInstance(clazz).fetchInCacheWithPredicates(
				predicates);
	}

	/**
	 * @see ICacheManager#loadAllInCache(Class)
	 */
	@Override
	public <T extends IAPObject> List<T> loadAllInCache(Class<T> clazz) {
		return GreenDAOHelper.getInstance(clazz).loadAllInCache();
	}

	// Deletion from cache

	/**
	 * @see ICacheManager#deleteAllInCache()
	 */
	@Override
	public void deleteAllInCache() {

		((DaoSession) daoSession.getRaw()).getCapitalMarketsActivityDao()
				.deleteAll();

		((DaoSession) daoSession.getRaw()).getCapitalMarketsContactDao()
				.deleteAll();

		((DaoSession) daoSession.getRaw()).getCapitalMarketsContentServiceDao()
				.deleteAll();

		((DaoSession) daoSession.getRaw()).getCapitalMarketsLoginDao()
				.deleteAll();

		((DaoSession) daoSession.getRaw()).getCapitalMarketsOrderDao()
				.deleteAll();

		((DaoSession) daoSession.getRaw()).getCapitalMarketsRevenueDao()
				.deleteAll();

		((DaoSession) daoSession.getRaw()).getCorporatePaymentsAccountDao()
				.deleteAll();

		((DaoSession) daoSession.getRaw()).getCorporatePaymentsBeneficiaryDao()
				.deleteAll();

		((DaoSession) daoSession.getRaw())
				.getCorporatePaymentsCrossBorderFxBookingDao().deleteAll();

		((DaoSession) daoSession.getRaw())
				.getCorporatePaymentsCrossBorderFxPaymentDao().deleteAll();

		((DaoSession) daoSession.getRaw())
				.getCorporatePaymentsCrossBorderFxQuoteDao().deleteAll();

		((DaoSession) daoSession.getRaw()).getCorporatePaymentsLoginDao()
				.deleteAll();

		((DaoSession) daoSession.getRaw()).getCorporatePaymentsPaymentDao()
				.deleteAll();

		((DaoSession) daoSession.getRaw()).getRetailBankingAccountDao()
				.deleteAll();

		((DaoSession) daoSession.getRaw()).getRetailBankingAccountBalanceDao()
				.deleteAll();

		((DaoSession) daoSession.getRaw())
				.getRetailBankingAccountFundTransferDao().deleteAll();

		((DaoSession) daoSession.getRaw())
				.getRetailBankingAccountTransactionDao().deleteAll();

		((DaoSession) daoSession.getRaw()).getRetailBankingForeignCurrencyDao()
				.deleteAll();

		((DaoSession) daoSession.getRaw()).getRetailBankingLocationDao()
				.deleteAll();

		((DaoSession) daoSession.getRaw()).getRetailBankingLoginDao()
				.deleteAll();

		((DaoSession) daoSession.getRaw()).getRetailBankingPayeeDao()
				.deleteAll();

		((DaoSession) daoSession.getRaw()).getRetailBankingPayeeTypeDao()
				.deleteAll();

	}

	/**
	 * @see ICacheManager#deleteAllInCacheWithScopePredicate(Class, String)
	 */
	@Override
	public <T extends IAPObject> void deleteAllInCacheWithObjectIdPredicate(
			Class<T> clazz, String objectId) {
		GreenDAOHelper.getInstance(clazz)
				.deleteAllInCacheWithObjectIdPredicate(objectId);
	}

	/**
	 * @see ICacheManager#deleteAllInCacheWithScopePredicate(Class, String)
	 */
	@Override
	public <T extends IAPObject> void deleteAllInCacheWithScopePredicate(
			Class<T> clazz, String scope) {
		GreenDAOHelper.getInstance(clazz).deleteAllInCacheWithScopePredicate(
				scope);
	}

	/**
	 * @see ICacheManager#disableOrm()
	 */
	@Override
	public void disableOrm() {
		if (db != null) {
			db.close();
		}
		daoMaster = null;
		daoSession = null;
	}

	/**
	 * @see ICacheManager#setupOrm(DBStoreType)
	 */
	@Override
	public void setupOrm(DBStoreType dbStoreType) {
		if (daoMaster != null && daoSession != null) {
			log.debug("Skipping setup of ORM since it was setup already.");
			log.debug("Please close the database first by calling disableOrm.");
			return;
		}
		DaoMaster.DevOpenHelper helper = null;
		if (dbStoreType == DBStoreType.IN_MEMORY) {
			if (com.anypresence.sdk.config.Config.TEST_MODE) {
				// For unit tests, the path needs to be non-null so that the in-memory db can be used.
				helper = new DaoMaster.DevOpenHelper(getAndroidContext(), "",
						null);
			} else {
				helper = new DaoMaster.DevOpenHelper(getAndroidContext(), null,
						null);
			}
		} else if (dbStoreType == DBStoreType.SQLITE3) {
			helper = new DaoMaster.DevOpenHelper(getAndroidContext(),
					getDatabaseName(), null);
		} else {
			throw new IllegalStateException("Unrecognized database store type");
		}
		db = helper.getWritableDatabase();
		daoMaster = new DaoMaster(db);

		registerAPCachedRequestsClass(com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequest.class);
		setDaoSession(daoMaster.newSession());
		com.anypresence.sdk.APObject
				.setCacheManager(com.anypresence.sdk.APSDKSetup.cacheManager);
		com.anypresence.sdk.APSDKSetup.setCacheManager(this);

	}

	/*
	 * Adds into ap objects to ap cached request join
	 *
	 * @param objectId the APObjectId
	 * @param apCachedRequestId the apCachedRequestId
	 */
	public void addToAPCachedRequests(Long objectId, Long apCachedRequestId) {
		com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APObjectsAPCachedRequests apObjectsAPCachedRequest = new com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APObjectsAPCachedRequests();
		apObjectsAPCachedRequest.setApCachedRequestId(apCachedRequestId);
		apObjectsAPCachedRequest.setApObjectId(objectId);
		((DaoSession) CacheManager.getInstance().getDAOSession().getRaw())
				.getAPObjectsAPCachedRequestsDao().insert(
						apObjectsAPCachedRequest);
	}

	private String getQueryPrefixForHttpAdapter(Class<?> clazz) {
		RouterAdapter routerAdapter = RemoteRailsConfig
				.getRouterAdapterByClassOrUseDefaultAdapter(clazz);
		if (routerAdapter instanceof HttpAdapter) {
			return ((HttpAdapter) routerAdapter).getQueryPrefix();
		} else {
			return "";
		}
	}

	private boolean findMatchingParams(
			com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequest request,
			Map<String, String> params, String queryPrefix) {
		String queryParam = request.getParameter();
		Map<String, String> queryParams = new HashMap<String, String>();
		if (params != null) {
			for (Entry<String, String> entry : params.entrySet()) {
				String value = (entry.getValue() == null) ? "" : entry
						.getValue();
				if (!queryPrefix.isEmpty()) {
					queryParams.put(queryPrefix + "[" + entry.getKey() + "]",
							value);
				} else {
					queryParams.put(entry.getKey(), value);
				}
			}
		}
		try {
			URI uri = new URI("?" + queryParam);
			if (DEBUG_MODE) {
				log.info("URI is: " + uri);
			}
			List<NameValuePair> pairs = URLEncodedUtils.parse(uri, "utf-8");
			for (Entry<String, String> entry : queryParams.entrySet()) {
				boolean found = false;
				String paramValue = (entry.getValue() == null) ? "" : entry
						.getValue();
				for (NameValuePair pair : pairs) {
					if (!queryPrefix.isEmpty()
							&& !pair.getName().startsWith(queryPrefix))
						continue;
					String value = (pair.getValue() == null) ? "" : pair
							.getValue();
					if (pair.getName().equals(entry.getKey())
							&& value.equals(paramValue)) {
						found = true;
						break;
					}
				}

				if (!found) {
					return false;
				}
			}

		} catch (URISyntaxException e) {
			log.error("Invalid URI.", e);
			return false;
		}

		return true;
	}

}