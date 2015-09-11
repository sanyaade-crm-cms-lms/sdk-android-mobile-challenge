package com.anypresence.sdk.cache.greendao;

//
//  CorporatePaymentsLoginHelper.java
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
import com.anypresence.sdk.cache.internal.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.anypresence.sdk.cache.internal.*;
import com.anypresence.sdk.cache.internal.APObjectsAPCachedRequests;
import com.anypresence.anypresence_inc.citi_mobile_challenge.dao.DaoMaster;
import com.anypresence.anypresence_inc.citi_mobile_challenge.dao.DaoSession;
import android.database.sqlite.SQLiteDatabase;
import com.anypresence.sdk.citi_mobile_challenge.models.*;
import com.anypresence.rails_droid.*;
import com.anypresence.sdk.config.Config;
import com.anypresence.sdk.citi_mobile_challenge.models.*;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import static com.anypresence.sdk.config.Config.DEBUG_MODE;

import java.util.*;

/**
 *
 * GreenDAO helper for <tt>CorporatePaymentsLogin</tt>.
 *
 */
class CorporatePaymentsLoginHelper implements IGreenDAOHelper {
	private static Log log = LogFactory
			.getLog(CorporatePaymentsLoginHelper.class);

	public com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APObject createObject(
			com.anypresence.sdk.IAPObject object) {
		com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLogin _object = CorporatePaymentsLoginHelper
				.copyToDao((com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin) object);
		if (object.getObjectId() != null) {
			_object.setObjectId(object.getObjectId().stringify());
		}

		// Set update time
		_object.set_cacheUpdatedAt(new Date());

		return _object;
	}

	/**
	 * <p>
	 * Gets the <tt>CorporatePaymentsLogin</tt> objects from the cache by object id on the provided object.
	 * </p>
	 * 
	 * <p>The LazyList list that is returned must be closed as well<p>
	 * {@code
	 * ((LazyList)list).close();
	 * }
	 *
	 * @return a LazyList list of objects if <tt>object</tt> is not null, otherwise, it returns null.
	 */
	public List<? extends com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APObject> getObjectsByObjectId(
			com.anypresence.sdk.IAPObject object) {
		if (object == null)
			return null;

		return ((DaoSession) CacheManager.getInstance().getDAOSession()
				.getRaw())
				.getCorporatePaymentsLoginDao()
				.queryBuilder()
				.where(com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLoginDao.Properties.ObjectId
						.eq(object.getObjectId().stringify())).listLazy();
	}

	public Long insertObject(
			com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APObject object) {
		if (Config.getInstance().getCacheStrategy() == Config.CacheStrategy.OVERWRITE) {
			return ((DaoSession) CacheManager.getInstance().getDAOSession()
					.getRaw())
					.getCorporatePaymentsLoginDao()
					.insertOrReplace(
							(com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLogin) object);
		}

		return ((DaoSession) CacheManager.getInstance().getDAOSession()
				.getRaw())
				.getCorporatePaymentsLoginDao()
				.insert((com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLogin) object);
	}

	public void updateObject(com.anypresence.sdk.IAPObject object) {

		List<? extends com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APObject> objects = getObjectsByObjectId(object);
		try {
			if ((objects != null) && !objects.isEmpty()) {
				com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLogin _object = (com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLogin) objects
						.get(0);

				_object.update();
			}
		} finally {
			if (objects != null) {
				((LazyList) objects).close();
			}
		}
	}

	public void updateEachObject(
			com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APObject object,
			IAPCachedRequest request,
			List<? extends com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APObject> existingObjects) {
		for (com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLogin tobject : (List<com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLogin>) existingObjects) {
			try {
				Long origId = tobject.getId();
				Utilities.shallowCopyObjects(tobject, object);
				tobject.setId(origId);
				tobject.setAPCachedRequest(((com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequest) request
						.getRaw()));
				((DaoSession) CacheManager.getInstance().getDAOSession()
						.getRaw()).getCorporatePaymentsLoginDao().update(
						tobject);
				CacheManager
						.getInstance()
						.addToAPCachedRequests(
								tobject.getId(),
								((com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequest) request
										.getRaw()).getId());
				if (DEBUG_MODE) {
					log.info(ReflectionToStringBuilder.toString(tobject));
				}
			} catch (CopyException e) {
				//
			}
		}
	}

	public void deleteAllInCacheWithObjectIdPredicate(String objectId) {
		((DaoSession) CacheManager.getInstance().getDAOSession().getRaw())
				.getCorporatePaymentsLoginDao()
				.queryBuilder()
				.where(com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLoginDao.Properties.ObjectId
						.eq(objectId)).buildDelete()
				.executeDeleteWithoutDetachingEntities();
	}

	@Deprecated
	public void deleteAllInCacheWithScopePredicate(String scope) {
		((DaoSession) CacheManager.getInstance().getDAOSession().getRaw())
				.getCorporatePaymentsLoginDao()
				.queryBuilder()
				.where(com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLoginDao.Properties.Scope
						.eq(scope)).buildDelete()
				.executeDeleteWithoutDetachingEntities();
	}

	public <T extends com.anypresence.sdk.IAPObject> List<T> fetchInCacheWithAPCachedRequestPredicate(
			IAPCachedRequest request) {
		List<T> objects = new ArrayList<T>();
		String query = ", APOBJECTS_APCACHED_REQUESTS R WHERE T._ID=R.AP_OBJECT_ID AND R.AP_CACHED_REQUEST_ID=?";

		List<com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLogin> cachedObjects = ((DaoSession) CacheManager
				.getInstance().getDAOSession().getRaw())
				.getCorporatePaymentsLoginDao()
				.queryRawCreate(
						query,
						((com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequest) request
								.getRaw()).getId()).listLazy();

		objects.addAll((List<T>) getCloneObjects(cachedObjects));
		return objects;
	}

	public <T extends com.anypresence.sdk.IAPObject> List<T> fetchInCacheWithPredicates(
			Map<String, String> predicates) {
		return fetchInCacheWithScopePredicate(null, predicates, null, null);
	}

	public <T extends com.anypresence.sdk.IAPObject> List<T> fetchInCacheWithObjectIdPredicate(
			String objectId) {
		List<T> objects = new ArrayList<T>();
		List<com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLogin> cachedObjects = ((DaoSession) CacheManager
				.getInstance().getDAOSession().getRaw())
				.getCorporatePaymentsLoginDao()
				.queryBuilder()
				.where(com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLoginDao.Properties.ObjectId
						.eq(objectId)).listLazy();

		objects.addAll((List<T>) getCloneObjects(cachedObjects));
		return objects;
	}

	public <T extends com.anypresence.sdk.IAPObject> List<T> fetchInCacheWithScopePredicate(
			String scope, Map<String, String> params, Integer offset,
			Integer limit) {
		List<T> objects = new ArrayList<T>();

		if (!isDaoSetup()) {
			return objects;
		}

		Map<String, String> whereApCachedRequestsMap = new HashMap<String, String>();
		if (scope != null) {
			whereApCachedRequestsMap.put("Scope", scope);
		}
		List<WhereCondition> whereApCachedRequests = new ArrayList<WhereCondition>();
		GreenDAOUtility.processAPCachedRequestParams(whereApCachedRequests,
				whereApCachedRequestsMap);

		List<com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequest> apCachedRequests = ((DaoSession) CacheManager
				.getInstance().getDAOSession().getRaw())
				.getAPCachedRequestDao()
				.queryBuilder()
				.where(com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequestDao.Properties.Type
						.eq(com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin.class
								.getSimpleName().toLowerCase()),
						whereApCachedRequests.toArray(new WhereCondition[0]))
				.orderDesc(
						com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequestDao.Properties._cacheUpdatedAt)
				.listLazy();

		if (DEBUG_MODE) {
			log.info("There are " + apCachedRequests.size()
					+ " APCachedRequests");
		}
		for (com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequest latestAPCachedRequest : apCachedRequests) {
			log.info("  APCachedRequests "
					+ ReflectionToStringBuilder
							.reflectionToString(latestAPCachedRequest));
		}
		try {
			if (apCachedRequests != null && !apCachedRequests.isEmpty()) {
				List<com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APObjectsAPCachedRequests> apObjectsApCachedRequests = null;
				if (scope != null) {
					String query = " WHERE T.AP_CACHED_REQUEST_ID IN (SELECT R._ID FROM APCACHED_REQUEST R WHERE R.TYPE=? AND R.SCOPE=? ORDER BY R._CACHE_UPDATED_AT DESC LIMIT 1) ";
					apObjectsApCachedRequests = ((DaoSession) CacheManager
							.getInstance().getDAOSession().getRaw())
							.getAPObjectsAPCachedRequestsDao()
							.queryRawCreate(
									query,
									com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin.class
											.getSimpleName().toLowerCase(),
									scope).listLazy();
				} else {
					String query = " WHERE T.AP_CACHED_REQUEST_ID IN (SELECT R._ID FROM APCACHED_REQUEST R WHERE R.TYPE=? ORDER BY R._CACHE_UPDATED_AT DESC LIMIT 1) ";
					apObjectsApCachedRequests = ((DaoSession) CacheManager
							.getInstance().getDAOSession().getRaw())
							.getAPObjectsAPCachedRequestsDao()
							.queryRawCreate(
									query,
									com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin.class
											.getSimpleName().toLowerCase())
							.listLazy();
				}
				try {
					if (DEBUG_MODE) {
						for (com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APObjectsAPCachedRequests r : apObjectsApCachedRequests) {
							log.info("Searching in cache with: (scope="
									+ scope
									+ "),(apObjectsApCachedRequests="
									+ ReflectionToStringBuilder
											.reflectionToString(r));
						}
					}
					StringBuilder queryString = new StringBuilder();
					boolean hasInvalidParam = false;
					if (params != null) {
						hasInvalidParam = processParamsIntoStringBuffer(
								queryString, params);
					}

					try {
						Query<com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLogin> query = null;
						if (!hasInvalidParam
								&& !apObjectsApCachedRequests.isEmpty()) {
							com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APObjectsAPCachedRequests apObjectsApCachedRequest = apObjectsApCachedRequests
									.get(0);
							String rawQuery = ", APOBJECTS_APCACHED_REQUESTS AR WHERE AR.AP_OBJECT_ID=T._ID AND AR.AP_CACHED_REQUEST_ID=?  ";
							if (!queryString.toString().isEmpty()) {
								rawQuery += " AND " + queryString.toString();
							}

							if (limit != null) {
								rawQuery += " LIMIT=" + limit.toString();
							}

							if (offset != null) {
								rawQuery += " OFFSET=" + offset.toString();
							}

							if (DEBUG_MODE) {
								log.info("Raw query: " + rawQuery);
							}

							query = ((DaoSession) CacheManager.getInstance()
									.getDAOSession().getRaw())
									.getCorporatePaymentsLoginDao()
									.queryRawCreate(
											rawQuery,
											apObjectsApCachedRequest
													.getApCachedRequestId());

							objects.addAll((List<T>) getCloneObjects(query
									.listLazyUncached()));
						}
					} catch (Exception e) {
						log.error(
								"Unable to query for data: " + e.getMessage(),
								e);
					}
				} finally {
					((LazyList) apObjectsApCachedRequests).close();
				}
			}
		} finally {
			((LazyList) apCachedRequests).close();
		}

		return objects;
	}

	public <T extends com.anypresence.sdk.IAPObject> List<T> fetchInCacheWithIds(
			Set<Long> objectIds) {
		QueryBuilder<com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLogin> queryBuilder = ((DaoSession) CacheManager
				.getInstance().getDAOSession().getRaw())
				.getCorporatePaymentsLoginDao()
				.queryBuilder()
				.where(com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLoginDao.Properties.Id
						.in(objectIds));
		return (List<T>) getCloneObjects(queryBuilder.listLazy());
	}

	public <T extends com.anypresence.sdk.IAPObject> List<T> loadAllInCache() {
		List<T> objects = new ArrayList<T>();
		if (!isDaoSetup()) {
			return objects;
		}
		objects.addAll((List<T>) getCloneObjects(((DaoSession) CacheManager
				.getInstance().getDAOSession().getRaw())
				.getCorporatePaymentsLoginDao().queryBuilder().listLazy()));
		return objects;
	}

	/**
	 * Copies provided DAO object.
	 */
	public static final com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin copyFromDao(
			com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLogin orig) {
		final com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin newObject = new com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin();

		if (orig.getToken() != null)
			newObject.setTokenAsString(orig.getToken().toString());

		if (orig.getPassword() != null)
			newObject.setPassword(orig.getPassword().toString());

		if (orig.getUsername() != null)
			newObject.setUsername(orig.getUsername().toString());

		return newObject;
	}

	/**
	 * Copies provided object as DAO object.
	 */
	public static final com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLogin copyToDao(
			com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin orig) {
		final com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLogin newObject = new com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLogin();

		if (orig.getToken() != null)
			newObject.setObjectId(orig.getToken().toString());

		if (orig.getPassword() != null)
			newObject.setPassword(orig.getPassword().toString());

		if (orig.getUsername() != null)
			newObject.setUsername(orig.getUsername().toString());

		return newObject;
	}

	private static List<com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin> getCloneObjects(
			List<com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLogin> objects) {
		List<com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin> clonedObjects = null;
		try {
			clonedObjects = shallowCloneList(objects);
		} finally {
			if (clonedObjects == null) {
				clonedObjects = new ArrayList<com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin>();
			}
		}

		return clonedObjects;
	}

	/**
	 * Perform a shallow clone of list of <tt>com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLogin</tt>.
	 *
	 * @param objects list of <tt>com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLogin</tt>.
	 * @return list of <tt>CorporatePaymentsLogin</tt>.
	 */
	private static List<com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin> shallowCloneList(
			List<com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLogin> objects) {
		List<com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin> newObjects = new ArrayList<com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin>();
		try {
			for (com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLogin object : objects) {
				com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin newObject = new com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin();
				newObject = copyFromDao(object);

				newObjects.add(newObject);
			}
		} finally {
			if (objects != null) {
				((LazyList) objects).close();
			}
		}
		return newObjects;
	}

	private static boolean processParamsIntoStringBuffer(StringBuilder sb,
			Map<String, String> params) {
		for (Map.Entry<String, String> entry : params.entrySet()) {
			if (entry.getValue() == null) {
				continue;
			}
			try {
				// The properties needs to be in camel-case form
				Field field = com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLoginDao.Properties.class
						.getField(Inflector.camelize(entry.getKey(), true));
				Property property = (Property) field.get(null);

				String parsedString = GreenDAOUtility.parsedValue(
						property.type, entry.getValue());
				if (parsedString == null)
					continue;
				if (!sb.toString().isEmpty()) {
					sb = sb.append(" AND ");
				}
				sb = sb.append(" T."
						+ Inflector.underscore(entry.getKey()).toUpperCase()
						+ "=" + parsedString);
			} catch (SecurityException e) {
				e.printStackTrace();
				return true;
			} catch (NoSuchFieldException e) {
				log.error("The field " + entry.getKey()
						+ " does not map to any property on the model.", e);
				return true;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				return true;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				return true;
			}
		}
		return false;
	}

	private static Boolean processParams(List<WhereCondition> list,
			Map<String, String> params) {
		for (Map.Entry<String, String> entry : params.entrySet()) {
			if (entry.getValue() == null) {
				continue;
			}
			try {
				// The properties needs to be in camel-case form
				Field field = com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsLoginDao.Properties.class
						.getField(Inflector.camelize(entry.getKey(), true));
				WhereCondition eq = GreenDAOUtility.processParams(field,
						entry.getValue());
				if (eq == null)
					continue;
				list.add(eq);
			} catch (SecurityException e) {
				e.printStackTrace();
				return true;
			} catch (NoSuchFieldException e) {
				// log.error("The field " + entry.getKey() + " does not map to any property on the model.", e);
				return true;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				return true;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				return true;
			}
		}
		return false;
	}

	private Boolean isDaoSetup() {
		if (((DaoSession) CacheManager.getInstance().getDAOSession().getRaw())
				.getCorporatePaymentsLoginDao() == null) {
			log.info("The ORM has not been setup yet.");
			return false;
		}
		return true;
	}
}