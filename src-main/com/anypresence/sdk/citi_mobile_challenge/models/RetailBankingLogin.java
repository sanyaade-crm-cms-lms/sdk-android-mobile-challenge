package com.anypresence.sdk.citi_mobile_challenge.models;

//
//  RetailBankingLogin.java
//  
//
//  Generated by AnyPresence, Inc on 2015-09-11
//  Copyright (c) 2015. All rights reserved.
//

import com.google.common.util.concurrent.*;
import java.util.*;
import java.util.concurrent.Callable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.lang.reflect.Field;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import com.anypresence.rails_droid.*;
import com.anypresence.rails_droid.http.RequestMethod;
import com.anypresence.sdk.acl.*;
import com.anypresence.sdk.callbacks.*;
import com.anypresence.sdk.query.*;
import com.anypresence.sdk.config.Config;
import com.anypresence.sdk.acl.UnauthorizedException;
import com.anypresence.sdk.*;
import com.anypresence.sdk.cache.*;
import com.anypresence.sdk.cache.greendao.*;
import com.anypresence.sdk.parse.*;
import java.net.MalformedURLException;
import com.anypresence.rails_droid.RemoteRailsConfig;
import com.anypresence.rails_droid.http.RouterAdapter;
import com.anypresence.sdk.http.HttpAdapter;
import com.anypresence.sdk.Utility;

import com.jayway.jsonpath.PathNotFoundException;

import static com.anypresence.sdk.config.Config.DEBUG_MODE;
import static com.anypresence.sdk.http.HttpAdapter.JSON;
import static com.anypresence.sdk.http.HttpAdapter.XML;
import static com.anypresence.sdk.http.HttpAdapter.FORM_ENCODED;

/**
 * This class represents a model constructed from the Designer.
 *
 * Fields that are to be serialized into json must be annotated with <tt>@Expose</tt>.
 */
public final class RetailBankingLogin extends com.anypresence.sdk.APObject {
	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(RetailBankingLogin.class);

	private static final String TAG = "RetailBankingLogin";

	/**
	 *  Scope names for RetailBankingLogin.
	 */
	public static class Scopes {

		public final static String ALL = "all";

		public final static String EXACT_MATCH = "exact_match";

		public final static String COUNT = "count";

		public final static String COUNT_EXACT_MATCH = "count_exact_match";

	}

	private static QueryScope getScope(String scope) {
		if (getQueryScopes().get(scope) == null) {
			return getQueryScopes().get("all");
		}

		return getQueryScopes().get(scope);
	}

	@SerializedName("token")
	@Expose
	private ObjectId token;
	// Getter/Setter for the id
	@Override
	public ObjectId getObjectId() {
		return token;
	}

	@Override
	public void setObjectId(ObjectId id) {
		this.token = id;
	}

	public ObjectId getToken() {
		return getObjectId();
	}

	public void setToken(ObjectId token) {
		setObjectId(token);
	}

	public void setTokenAsString(String token) {
		setObjectId(new ObjectId(token));
	}

	// Getters/setters for field definitions.

	@SerializedName("is_eligible_for_offers")
	@Expose
	private String isEligibleForOffers;

	public String getIsEligibleForOffers() {
		return isEligibleForOffers;
	}

	public void setIsEligibleForOffers(String isEligibleForOffers) {
		this.isEligibleForOffers = isEligibleForOffers;
	}

	@SerializedName("is_person_to_person_required")
	@Expose
	private String isPersonToPersonRequired;

	public String getIsPersonToPersonRequired() {
		return isPersonToPersonRequired;
	}

	public void setIsPersonToPersonRequired(String isPersonToPersonRequired) {
		this.isPersonToPersonRequired = isPersonToPersonRequired;
	}

	@SerializedName("password")
	@Expose
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@SerializedName("username")
	@Expose
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Copies provided object.
	 */
	public static final RetailBankingLogin copy(RetailBankingLogin orig) {
		final RetailBankingLogin newObject = new RetailBankingLogin();

		if (orig.getToken() != null)
			newObject.setToken(new ObjectId(orig.getToken()));

		if (orig.getIsEligibleForOffers() != null)
			newObject.setIsEligibleForOffers(new String(orig
					.getIsEligibleForOffers()));

		if (orig.getIsPersonToPersonRequired() != null)
			newObject.setIsPersonToPersonRequired(new String(orig
					.getIsPersonToPersonRequired()));

		if (orig.getPassword() != null)
			newObject.setPassword(new String(orig.getPassword()));

		if (orig.getUsername() != null)
			newObject.setUsername(new String(orig.getUsername()));

		return newObject;
	}

	// Query scopes
	private static Map<String, QueryScope> queryScopes = new HashMap<String, QueryScope>();

	public void setQueryScopes(Map<String, QueryScope> queryScopes) {
		this.queryScopes = queryScopes;
	}

	public static Map<String, QueryScope> getQueryScopes() {
		return queryScopes;
	}

	static {

		QueryScope queryScopeall = new QueryScope();
		queryScopeall.setName("all");

		queryScopes.put(queryScopeall.getName(), queryScopeall);

		QueryScope queryScopeexact_match = new QueryScope();
		queryScopeexact_match.setName("exact_match");

		queryScopes.put(queryScopeexact_match.getName(), queryScopeexact_match);

		QueryScope queryScopecount = new QueryScope();
		queryScopecount.setName("count");

		queryScopes.put(queryScopecount.getName(), queryScopecount);

		QueryScope queryScopecount_exact_match = new QueryScope();
		queryScopecount_exact_match.setName("count_exact_match");

		queryScopes.put(queryScopecount_exact_match.getName(),
				queryScopecount_exact_match);

	}

	/**
	 * Fetches a <tt>RetailBankingLogin</tt> with the provided <tt>objectId</tt>.
	 *
	 * @param objectId the id of the object
	 * @return an instance of <tt>RetailBankingLogin</tt>
	 * @throws RemoteRequestException If there are other issues with the request.
	 */
	public static RetailBankingLogin fetch(String objectId)
			throws RemoteRequestException {
		RemoteRequest.RemoteRequestBuilder remoteRequestBuilder = RemoteRailsConfig
				.getRouterAdapterByClassOrUseDefaultAdapter(
						RetailBankingLogin.class).createRemoteRequestBuilder(
						RequestMethod.GET, RetailBankingLogin.class);

		RetailBankingLogin object = new RetailBankingLogin();
		object.setObjectIdAsString(objectId);

		remoteRequestBuilder.context(object);

		RemoteRequest remoteRequest = remoteRequestBuilder
				.createRemoteRequest();
		remoteRequest = Utility.interpolateRemoteRequest(remoteRequest);

		return com.anypresence.sdk.APObject.fetch(remoteRequest,
				RetailBankingLogin.class);
	}

	/**
	 * Fetches a <tt>RetailBankingLogin</tt> with the provided <tt>objectId</tt> in the background.
	 *
	 * <p>
	 * The {@link import com.anypresence.sdk.callbacks.APCallback} callback allows you to run code in the main UI thread.
	 * </p>
	 * <p>
	 * Example:
	 * </p>
	 * <pre>
	 * {@code
	 * RetailBankingLogin.fetchInBackground("123", new APCallback<RetailBankingLogin>() {
	 *     
	 *     public void finished(RetailBankingLogin object, Throwable ex) {
	 *         if (ex == null) {
	 *             Log.i(TAG, "Object fetched!");
	 *         } else {
	 *             Log.e(TAG, "Unable to fetch object!", ex);
	 *         }
	 *     }
	 * });
	 * }
	 * </pre>
	 *
	 * @see import com.anypresence.sdk.callbacks.APCallback
	 * @param objectId the id of the object
	 * @param futureCallback the callback that handles the result of the request.
	
	 * @return the cached <tt>RetailBankingLogin</tt> if it exists, otherwise, null.
	
	 */
	public static RetailBankingLogin

	fetchInBackground(String objectId,
			IAPFutureCallback<RetailBankingLogin> futureCallback) {

		return com.anypresence.sdk.APObject.fetchInBackground(objectId,
				RetailBankingLogin.class, futureCallback);

	}

	/**
	 * Queries for <tt>RetailBankingLogin</tt> with the provided <tt>scope</tt>.
	 *
	 * Note: the scopes were defined from the Designer.
	 *
	 * @param scope the scope to perform the query.
	 * @throws RemoteRequestException If there are other issues with the request.
	 */
	public static List<RetailBankingLogin> query(String scope)
			throws RemoteRequestException {
		return query(scope, null, null, null);
	}

	/**
	 * Queries for <tt>RetailBankingLogin</tt> with the provided <tt>scope</tt> and other params.
	 *
	 * Note: the scopes were defined from the Designer.
	 *
	 * @param scope the scope to perform the query.
	 * @param params a map of parameters.
	 * @param offset offset for the query, or <tt>null</tt> for no offset.
	 * @param limit max results to return back, <tt>null</tt> for no limit.
	 * @throws RemoteRequestException If there are other issues with the request.
	 */
	public static List<RetailBankingLogin> query(String scope,
			Map<String, String> params, Integer offset, Integer limit)
			throws RemoteRequestException {
		RemoteRequest.RemoteRequestBuilder remoteRequestBuilder = RemoteRailsConfig
				.getRouterAdapterByClassOrUseDefaultAdapter(
						RetailBankingLogin.class).createRemoteRequestBuilder(
						scope, RequestMethod.GET, RetailBankingLogin.class);
		remoteRequestBuilder.query(scope);
		if (params != null) {
			remoteRequestBuilder.addToParameters(params);
			remoteRequestBuilder.context(params);
		}
		if (offset != null) {
			remoteRequestBuilder.addToParameters("offset", offset.toString());
		}

		if (limit != null) {
			remoteRequestBuilder.addToParameters("limit", limit.toString());
		}
		RemoteRequest remoteRequest = remoteRequestBuilder
				.createRemoteRequest();

		return com.anypresence.sdk.APObject.query(remoteRequest, offset, limit,
				RetailBankingLogin.class);
	}

	/**
	 * Queries for <tt>RetailBankingLogin</tt> with the provided <tt>scope</tt> and other params.
	 *
	 * Note: the scopes were defined from the Designer.
	 *
	 * @param scope the scope to perform the query.
	 * @param params a map of parameters.
	 * @throws RemoteRequestException If there are other issues with the request.
	 */
	public static List<RetailBankingLogin> query(String scope,
			Map<String, String> params) throws RemoteRequestException {
		return query(scope, params, null, null);
	}

	/**
	 * Queries for <tt>RetailBankingLogin</tt> with the provided <tt>scope</tt> and other params.
	 *
	 * Note: the scopes were defined from the Designer.
	 *
	 * @param scope the scope to perform the query.
	 * @param params a map of parameters.
	 * @throws RemoteRequestException If there are other issues with the request.
	 */
	public static List<RetailBankingLogin> queryInBackground(
			final String scope, Map<String, String> params,
			IAPFutureCallback<List<RetailBankingLogin>> futureCallback) {

		return queryInBackground(scope, params, null, null, futureCallback);

	}

	/**
	 * Queries for <tt>RetailBankingLogin</tt> with the provided <tt>scope</tt> in the background.
	 *
	 * Note: the scopes were defined from the Designer.
	 *
	 * <p>
	 * The {@link import com.anypresence.sdk.callbacks.APCallback} callback allows you to run code in the main UI thread.
	 * </p>
	 * <p>
	 * Example:
	 * </p>
	 * <pre>
	 * {@code
	 * RetailBankingLogin.queryInBackground("all", new APCallback<List<RetailBankingLogin>>() {
	 *     
	 *     public void finished(List<RetailBankingLogin> objects, Throwable ex) {
	 *         if (ex == null) {
	 *             Log.i(TAG, "Objects fetched!");
	 *         } else {
	 *             Log.e(TAG, "Unable to fetch objects!", ex);
	 *         }
	 *     }
	 * });
	 * }
	 * </pre>
	 *
	 * @see import com.anypresence.sdk.callbacks.APCallback
	 * @param scope the scope to perform the query.
	 * @param futureCallback the callback that handles the result of the request.
	 * @return list of cached <tt>RetailBankingLogin</tt> objects.
	 */
	public static List<RetailBankingLogin> queryInBackground(String scope,
			IAPFutureCallback<List<RetailBankingLogin>> futureCallback) {

		return queryInBackground(scope, null, null, null, futureCallback);

	}

	/**
	 * Queries for <tt>RetailBankingLogin</tt> with the provided <tt>scope</tt> in the background.
	 *
	 * Note: the scopes were defined from the Designer.
	 * <p>
	 * The {@link import com.anypresence.sdk.callbacks.APCallback} callback allows you to run code in the main UI thread.
	 * </p>
	 * <p>
	 * Example:
	 * </p>
	 * <pre>
	 * {@code
	 * RetailBankingLogin.queryInBackground("all", 0, 25, new APCallback<List<RetailBankingLogin>>() {
	 *     
	 *     public void finished(List<RetailBankingLogin> objects, Throwable ex) {
	 *         if (ex == null) {
	 *             Log.i(TAG, "Objects fetched!");
	 *         } else {
	 *             Log.e(TAG, "Unable to fetch objects!", ex);
	 *         }
	 *     }
	 * });
	 * }
	 * </pre>
	 *
	 * @see import com.anypresence.sdk.callbacks.APCallback
	 * @param scope the scope to perform the query.
	 * @param offset offset for the query, or <tt>null</tt> for no offset.
	 * @param limit max results to return back, <tt>null</tt> for no limit.
	 * @param futureCallback the callback that handles the result of the request.
	 * @return list of cached <tt>RetailBankingLogin</tt> objects.
	 */
	public static List<RetailBankingLogin> queryInBackground(String scope,
			Integer offset, Integer limit,
			IAPFutureCallback<List<RetailBankingLogin>> futureCallback) {

		return queryInBackground(scope, null, offset, limit, futureCallback);

	}

	/**
	 * Queries for <tt>RetailBankingLogin</tt> with the provided <tt>scope</tt> in the background.
	 *
	 * Note: the scopes were defined from the Designer.
	 * <p>
	 * The {@link import com.anypresence.sdk.callbacks.APCallback} callback allows you to run code in the main UI thread.
	 * </p>
	 * <p>
	 * Example:
	 * </p>
	 * <pre>
	 * {@code
	 * Map<String,String> params = new HashMap<String,String>();
	 * params.put("name", "test");
	 * RetailBankingLogin.queryInBackground("all", params, 0, 25, new APCallback<List<RetailBankingLogin>>() {
	 *     
	 *     public void finished(List<RetailBankingLogin> objects, Throwable ex) {
	 *         if (ex == null) {
	 *             Log.i(TAG, "Objects fetched!");
	 *         } else {
	 *             Log.e(TAG, "Unable to fetch objects!", ex);
	 *         }
	 *     }
	 * });
	 * }
	 * </pre>
	 *
	 * @see import com.anypresence.sdk.callbacks.APCallback
	 * @param scope the scope to perform the query.
	 * @param params a map of parameters.
	 * @param offset offset for the query, or <tt>null</tt> for no offset.
	 * @param limit max results to return back, <tt>null</tt> for no limit.
	 * @param futureCallback the callback that handles the result of the request.
	 */
	public static List<RetailBankingLogin> queryInBackground(
			final String scope, Map<String, String> params, Integer offset,
			Integer limit,
			IAPFutureCallback<List<RetailBankingLogin>> futureCallback) {

		RemoteRequest.RemoteRequestBuilder remoteRequestBuilder = RemoteRailsConfig
				.getRouterAdapterByClassOrUseDefaultAdapter(
						RetailBankingLogin.class).createRemoteRequestBuilder(
						scope, RequestMethod.GET, RetailBankingLogin.class);
		remoteRequestBuilder.query(scope);
		if (params != null) {
			remoteRequestBuilder.addToParameters(params);
			remoteRequestBuilder.context(params);
		}

		if (offset != null) {
			remoteRequestBuilder.addToParameters("offset", offset.toString());
		}

		if (limit != null) {
			remoteRequestBuilder.addToParameters("limit", limit.toString());
		}

		RemoteRequest remoteRequest = remoteRequestBuilder
				.createRemoteRequest();

		if (DEBUG_MODE) {
			System.out.println(ReflectionToStringBuilder
					.reflectionToString(remoteRequest));
		}

		return com.anypresence.sdk.APObject.queryInBackground(remoteRequest,
				RetailBankingLogin.class, futureCallback);

	}

	/**
	 * Performs aggregate query with the provided <tt>scope</tt>.
	 *
	 * Note: the scopes were defined from the Designer.
	 *
	 * @param scope the scope to perform the query.
	 * @param params a map of parameters.
	 * @throws RemoteRequestException If there are other issues with the request.
	 */
	public static String aggregateQuery(String scope, Map<String, String> params)
			throws RemoteRequestException {
		return com.anypresence.sdk.APObject.aggregateQuery(scope, params,
				RetailBankingLogin.class);
	}

	/**
	 * Performs aggregate query with the provided <tt>scope</tt> in the background.
	 *
	 * Note: the scopes were defined from the Designer.
	 * <p>
	 * The {@link import com.anypresence.sdk.callbacks.APCallback} callback allows you to run code in the main UI thread.
	 * </p>
	 * <p>
	 * Example:
	 * </p>
	 * <pre>
	 * {@code
	 * Map<String,String> params = new HashMap<String,String>();
	 * RetailBankingLogin.aggregateQueryInBackground("count", params, new APCallback<String>() {
	 *     
	 *     public void finished(String count, Throwable ex) {
	 *         if (ex == null) {
	 *             Log.i(TAG, "success");
	 *         } else {
	 *             Log.e(TAG, "failure", ex);
	 *         }
	 *     }
	 * });
	 * }
	 * </pre>
	 *
	 * @see import com.anypresence.sdk.callbacks.APCallback
	 * @param scope the scope to perform the query.
	 * @param params a map of parameters.
	 * @param futureCallback the callback that handles the result of the request.
	 */
	public static void aggregateQueryInBackground(String scope,
			Map<String, String> params, IAPFutureCallback<String> futureCallback) {
		com.anypresence.sdk.APObject.aggregateQueryInBackground(scope, params,
				RetailBankingLogin.class, futureCallback);
	}

	/**
	 * Deletes all data in cache for <tt>RetailBankingLogin</tt>.
	 */
	public static void deleteAllInCache() {
		com.anypresence.sdk.APObject.deleteAllInCache();
	}

	/**
	 * Loads all <tt>RetailBankingLogin</tt> objects in local cache.
	 *
	 * @return list of <tt>RetailBankingLogin</tt>
	 */
	public static List<RetailBankingLogin> loadAllInCache() {
		return com.anypresence.sdk.APSDKSetup.getCacheManager().loadAllInCache(
				RetailBankingLogin.class);
	}

	/**
	 * Loads <tt>RetailBankingLogin</tt> objects in local cache.
	 *
	 * @param offset the offset
	 * @param limit the limit
	 * @return list of <tt>RetailBankingLogin</tt>
	 */
	public static List<RetailBankingLogin> loadInCache(Integer offset,
			Integer limit) {
		return null;
	}

	/**
	 * Updates object in cache if the object id is not null.
	 */
	public void updateInCache() {
		com.anypresence.sdk.APSDKSetup.getCacheManager().updateInCache(
				RetailBankingLogin.class, this);
	}

	/**
	 * Saves object into cache.
	 */
	public void saveInCache() {
		saveInCache(null);
	}

	/**
	 * Saves object into cache with provided scope.
	 */
	public void saveInCache(String scope) {
		com.anypresence.sdk.APSDKSetup.getCacheManager().saveInCache(
				RetailBankingLogin.class, this, scope);
	}

	/**
	 * Saves object into cache with provided <tt>APCachedRequest</tt>.
	 */
	public void saveInCacheWithRequest(IAPCachedRequest request) {
		com.anypresence.sdk.APSDKSetup
				.getCacheManager()
				.saveInCacheWithRequest(RetailBankingLogin.class, this, request);
	}

	/**
	 * Deletes all <tt>RetailBankingLogin</tt> objects in cache that has
	 * this instance's object id.
	 */
	public void deleteInCache() {
		if (this.getObjectId() != null) {
			deleteAllInCacheWithObjectIdPredicate(this.getObjectId()
					.stringify());
		} else {
			log.info("Cannot delete in local cache since the objectId is not set");
		}
	}

	/**
	 * Fetches <tt>RetailBankingLogin</tt> from cache with provided remote object id.
	 * 
	 * @param objectId the remote object id.
	 * @return a list of <tt>RetailBankingLogin</tt>;
	 */
	public static List<RetailBankingLogin> fetchInCacheWithObjectIdPredicate(
			String objectId) {
		return com.anypresence.sdk.APSDKSetup.getCacheManager()
				.fetchInCacheWithObjectIdPredicate(RetailBankingLogin.class,
						objectId);
	}

	/**
	 * Fetches <tt>RetailBankingLogin</tt> from cache by searching for requests matching 
	 * the exact scope and parameters provided.
	 * <p>
	 * Example:
	 * </p>
	 * <pre>
	 * {@code
	 * Map<String,String> params = new HashMap<String,String>();
	 * params.put("name", "test");
	 * RetailBankingLogin.queryInBackground("all", params, new APCallback<List<RetailBankingLogin>>() {
	 *     
	 *     public void finished(List<RetailBankingLogin> objects, Throwable ex) {
	 *         if (ex == null) {
	 *             Log.i(TAG, "Objects fetched!");
	 *         } else {
	 *             Log.e(TAG, "Unable to fetch objects!", ex);
	 *         }
	 *     }
	 * });
	 * // Get the cached objects from the above query.
	 * RetailBankingLogin.fetchInCacheWithParameterPredicate("all", params);
	 * }
	 *
	 * </pre>
	 * 
	 * @param scope the scope 
	 * @param params the parameter
	 * @return a list of <tt>RetailBankingLogin</tt>;
	 */
	public static List<RetailBankingLogin> fetchInCacheWithParameterPredicate(
			String scope, Map<String, String> params) {
		return com.anypresence.sdk.APSDKSetup.getCacheManager()
				.fetchInCacheWithParameterPredicate(RetailBankingLogin.class,
						scope, params);
	}

	/**
	 * Fetches <tt>RetailBankingLogin</tt> from cache with provided scope.
	 * 
	 * @param scope the scope.
	 * @return a list of <tt>RetailBankingLogin</tt>;
	 */
	public static List<RetailBankingLogin> fetchInCacheWithScopePredicate(
			String scope, Integer offset, Integer limit) {
		return fetchInCacheWithScopePredicate(scope, null, offset, limit);
	}

	/**
	 * Fetches <tt>RetailBankingLogin</tt> from cache with provided scope.
	 * 
	 * @param scope the scope.
	 * @return a list of <tt>RetailBankingLogin</tt>;
	 */
	public static List<RetailBankingLogin> fetchInCacheWithScopePredicate(
			String scope) {
		return fetchInCacheWithScopePredicate(scope, null, null);
	}

	/**
	 * Fetches <tt>RetailBankingLogin</tt> from cache with provided scope.
	 * 
	 * @param scope the scope
	 * @param params the parameters
	 * @return a list of <tt>RetailBankingLogin</tt>;
	 */
	public static List<RetailBankingLogin> fetchInCacheWithScopePredicate(
			String scope, Map<String, String> params) {
		return fetchInCacheWithScopePredicate(scope, params, null, null);
	}

	/**
	 * Fetches <tt>RetailBankingLogin</tt> from cache with provided scope.
	 * 
	 * @param scope the scope.
	 * @param params the parameters
	 * @param offset the offset
	 * @param limit the limit
	 * @return a list of <tt>RetailBankingLogin</tt>;
	 */
	public static List<RetailBankingLogin> fetchInCacheWithScopePredicate(
			String scope, Map<String, String> params, Integer offset,
			Integer limit) {
		return com.anypresence.sdk.APSDKSetup.getCacheManager()
				.fetchInCacheWithScopePredicate(RetailBankingLogin.class,
						scope, params, offset, limit);
	}

	/**
	 * Fetches <tt>RetailBankingLogin</tt> from cache with provided request.
	 * 
	 * @param request instance of <tt>com.anypresence.anypresence_inc.citi_mobile_challenge.dao.APCachedRequest</tt>.
	 * @return a list of <tt>RetailBankingLogin</tt>;
	 */
	public static List<RetailBankingLogin> fetchInCacheWithAPCachedRequestPredicate(
			IAPCachedRequest request) {
		return com.anypresence.sdk.APSDKSetup.getCacheManager()
				.fetchInCacheWithAPCachedRequestPredicate(
						RetailBankingLogin.class, request);
	}

	/**
	 * Fetches <tt>RetailBankingLogin</tt> from cache with latest request.
	 * 
	 * @param scope the scope to perform the query.
	 * @param params a map of parameters.
	 * @param offset offset for the query, or <tt>null</tt> for no offset.
	 * @param limit max results to return back, <tt>null</tt> for no limit.
	 * @return a list of <tt>RetailBankingLogin</tt>;
	 */
	public static List<RetailBankingLogin> fetchInCacheWithLatestAPCachedRequestPredicate(
			String scope, Map<String, String> params, Integer offset,
			Integer limit) {
		return com.anypresence.sdk.APSDKSetup.getCacheManager()
				.fetchInCacheWithLatestAPCachedRequestPredicate(
						RetailBankingLogin.class, scope, params, offset, limit);
	}

	/**
	 * Fetches <tt>RetailBankingLogin</tt> from cache with predicates.
	 *
	 * @see com.anypresence.anypresence_inc.citi_mobile_challenge.dao.RetailBankingLoginDao.Properties
	 *
	 * @param predicates hash of predicates
	 * @return a list of <tt>RetailBankingLogin</tt>
	 */
	public static List<RetailBankingLogin> fetchInCacheWithPredicates(
			Map<String, String> predicates) {
		return com.anypresence.sdk.APSDKSetup.getCacheManager()
				.fetchInCacheWithPredicates(RetailBankingLogin.class,
						predicates);
	}

	/**
	 * Deletes <tt>RetailBankingLogin</tt> from cache matching <tt>objectId</tt>.
	 * 
	 * @param objectId the remote object id.
	 */
	public static void deleteAllInCacheWithObjectIdPredicate(String objectId) {
		com.anypresence.sdk.APSDKSetup.getCacheManager()
				.deleteAllInCacheWithObjectIdPredicate(
						RetailBankingLogin.class, objectId);
	}

	/**
	 * Deletes <tt>RetailBankingLogin</tt> from cache matching <tt>scope</tt>.
	 * 
	 * @param scope the scope.
	 */
	public static void deleteAllInCacheWithScopePredicate(String scope) {
		com.anypresence.sdk.APSDKSetup.getCacheManager()
				.deleteAllInCacheWithScopePredicate(RetailBankingLogin.class,
						scope);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).

		append(token).

		append(isEligibleForOffers).

		append(isPersonToPersonRequired).

		append(password).

		append(username).

		append(getObjectId()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (obj.getClass() != this.getClass()))
			return false;
		RetailBankingLogin other = (RetailBankingLogin) obj;
		return new EqualsBuilder().

		append(token, other.token).

		append(isEligibleForOffers, other.isEligibleForOffers).

		append(isPersonToPersonRequired, other.isPersonToPersonRequired).

		append(password, other.password).

		append(username, other.username).

		append(getObjectId(), other.getObjectId()).isEquals();
	}

	// Backend on Device
	public static String MAPPING = "RetailBankingLogin";
	public static String BASE_URL = "";
	public static String PORT = "";
	public static String PREFIX = "";
	public static String QUERY_PREFIX = "";
	public static boolean USE_SUFFIX = false;

	/**
	 * Deprecated: Pulled up into HttpAdapter
	 */
	@Override
	@Deprecated
	public String requestMapping() {
		return MAPPING;
	}

	/**
	 * Deprecated: Pulled up into HttpAdapter
	 */
	@Override
	@Deprecated
	public String requestBaseUrl() throws MalformedURLException {
		return BASE_URL;
	}

	/**
	 * Deprecated: Pulled up into HttpAdapter
	 */
	@Override
	@Deprecated
	public String requestPrefix() {
		return PREFIX;
	}

	/**
	 * Deprecated: Pulled up into HttpAdapter
	 */
	@Deprecated
	public static String requestQueryPrefix() {
		if (QUERY_PREFIX.isEmpty()) {
			return "%s";
		}
		return QUERY_PREFIX + "[%s]";
	}

	@Override
	public String serialize() {
		String bodyFormat = getSerializationBodyFormat();
		SerializerBuilder builder = null;

		String recordSelector = HttpAdapter.createResponseWrangling(this)
				.getRecordSelector();
		if (XML.equals(bodyFormat)) {
			builder = new XmlSerializer.XmlSerializerBuilder(recordSelector);
		} else if (JSON.equals(bodyFormat)) {
			builder = new JsonSerializer.JsonSerializerBuilder(recordSelector);
		} else if (FORM_ENCODED.equals(bodyFormat)) {
			builder = new FormEncodedSerializer.FormEncodedSerializerBuilder(
					recordSelector);
		}

		final RouterAdapter routerAdapter = RemoteRailsConfig
				.getRouterAdapterByClass(this.getClass());
		if (builder != null && routerAdapter != null) {

			builder.addFieldMapping(((HttpAdapter) routerAdapter)
					.getConfigurationsAsConfiguration("POST")
					.getResponseRemoteFieldName("token"), "token");

			builder.addFieldMapping(((HttpAdapter) routerAdapter)
					.getConfigurationsAsConfiguration("POST")
					.getResponseRemoteFieldName("is_eligible_for_offers"),
					"is_eligible_for_offers");

			builder.addFieldMapping(
					((HttpAdapter) routerAdapter)
							.getConfigurationsAsConfiguration("POST")
							.getResponseRemoteFieldName(
									"is_person_to_person_required"),
					"is_person_to_person_required");

			builder.addFieldMapping(((HttpAdapter) routerAdapter)
					.getConfigurationsAsConfiguration("POST")
					.getResponseRemoteFieldName("password"), "password");

			builder.addFieldMapping(((HttpAdapter) routerAdapter)
					.getConfigurationsAsConfiguration("POST")
					.getResponseRemoteFieldName("username"), "username");

			return builder.create().serialize(this);
		} else {
			return super.serialize();
		}
	}

	@Override
	public ArrayList<RemoteObject> deserializeArray(String queryScope,
			String input) {
		String bodyFormat = getDeserializationBodyFormat();
		if (XML.equals(bodyFormat)) {
			return deserializeArrayAsXml(queryScope, input);
		} else if (JSON.equals(bodyFormat)) {
			return deserializeArrayAsJson(queryScope, input);
		} else {
			return deserializeArrayAsJson(queryScope, input);
		}
	}

	@Override
	public ArrayList<RemoteObject> deserializeArray(String input) {
		return deserializeArray("", input);
	}

	private ArrayList<RemoteObject> deserializeArrayAsXml(String queryScope,
			String input) {
		ArrayList<RemoteObject> objects = new ArrayList<RemoteObject>();

		XmlParser parser = new XmlParser(input);
		XmlElement parent = ((XmlElement) parser.parse(HttpAdapter
				.createResponseWrangling(queryScope, this)
				.getCollectionSelector(), XmlElement.class)).getParent();
		for (int i = 0; i < parent.getChildCount(); i++) {
			objects.add(deserialize(queryScope, new XmlParser(parent.get(i))));
		}

		return objects;
	}

	private ArrayList<RemoteObject> deserializeArrayAsJson(String queryScope,
			String input) {
		ArrayList<RemoteObject> objects = new ArrayList<RemoteObject>();

		JsonParser parser = new JsonParser(input);
		JsonArray parent = ((JsonElement) parser.parse(HttpAdapter
				.createResponseWrangling(queryScope, this)
				.getCollectionSelector(), JsonElement.class)).getAsJsonArray();
		for (int i = 0; i < parent.size(); i++) {
			objects.add(deserialize(queryScope, new JsonParser(parent.get(i))));
		}

		return objects;
	}

	@Override
	public String getDeserializationBodyFormat() {
		final HttpAdapter routerAdapter = (HttpAdapter) RemoteRailsConfig
				.getRouterAdapterByClass(this.getClass());
		if (routerAdapter == null
				|| routerAdapter.getConfigurationsAsConfiguration("GET") == null) {
			return RemoteRailsConfig.getInstance().getDefaultRouterAdapter()
					.getSuffix();
		}
		return routerAdapter.getConfigurationsAsConfiguration("GET")
				.getBodyFormat();
	}

	@Override
	public String getSerializationBodyFormat() {
		final HttpAdapter routerAdapter = (HttpAdapter) RemoteRailsConfig
				.getRouterAdapterByClass(this.getClass());
		if (routerAdapter == null
				|| routerAdapter.getConfigurationsAsConfiguration("GET") == null) {
			return RemoteRailsConfig.getInstance().getDefaultRouterAdapter()
					.getSuffix();
		}
		return routerAdapter.getConfigurationsAsConfiguration("POST")
				.getBodyFormat();
	}

	@Override
	public RemoteObject deserialize(String queryScope, String input) {
		String bodyFormat = getDeserializationBodyFormat();
		// TODO parse role if auth object
		Parser parser = null;
		if (XML.equals(bodyFormat)) {
			parser = createXmlParser(queryScope, input);
		} else if (JSON.equals(bodyFormat)) {
			parser = createJsonParser(queryScope, input);
		} else {
			parser = createJsonParser(queryScope, input);
		}

		return deserialize(queryScope, parser);
	}

	@Override
	public RemoteObject deserialize(String input) {
		return deserialize("", input);
	}

	private Parser createXmlParser(String queryScope, String input) {
		Parser parser = new XmlParser(input);
		if (!HttpAdapter.createResponseWrangling(queryScope, this)
				.getRecordSelector().isEmpty()) {
			((XmlParser) parser).setRootElement(parser.parse(HttpAdapter
					.createResponseWrangling(queryScope, this)
					.getRecordSelector(), XmlElement.class));
		}
		return parser;
	}

	private Parser createJsonParser(String queryScope, String input) {
		Parser parser = new JsonParser(input);
		if (!HttpAdapter.createResponseWrangling(queryScope, this)
				.getRecordSelector().isEmpty()) {
			((JsonParser) parser).setRootElement(parser.parse(HttpAdapter
					.createResponseWrangling(queryScope, this)
					.getRecordSelector(), JsonElement.class));
		}
		return parser;
	}

	public RemoteObject deserialize(String queryScope, Parser parser) {
		final RouterAdapter routerAdapter = RemoteRailsConfig
				.getRouterAdapterByClass(this.getClass());
		RetailBankingLogin object = new RetailBankingLogin();
		HttpAdapter.Configuration configuration = null;
		if ((routerAdapter != null) && (routerAdapter instanceof HttpAdapter)) {
			if (queryScope != null && !queryScope.isEmpty()) {
				configuration = ((HttpAdapter) routerAdapter)
						.getScopedConfigurationsByNameAsConfiguration(queryScope);
			} else {
				configuration = ((HttpAdapter) routerAdapter)
						.getConfigurationsAsConfiguration("GET");
			}
		}
		if (configuration != null) {

			try {

				object.token = parser.parse(
						configuration.getResponseRemoteFieldName("token"),
						ObjectId.class);

			} catch (PathNotFoundException e) {
				log.info("Unable to deserialize field: " + e.getMessage());
			}

			try {

				object.isEligibleForOffers = parser.parse(configuration
						.getResponseRemoteFieldName("is_eligible_for_offers"),
						String.class);

			} catch (PathNotFoundException e) {
				log.info("Unable to deserialize field: " + e.getMessage());
			}

			try {

				object.isPersonToPersonRequired = parser
						.parse(configuration
								.getResponseRemoteFieldName("is_person_to_person_required"),
								String.class);

			} catch (PathNotFoundException e) {
				log.info("Unable to deserialize field: " + e.getMessage());
			}

			try {

				object.password = parser.parse(
						configuration.getResponseRemoteFieldName("password"),
						String.class);

			} catch (PathNotFoundException e) {
				log.info("Unable to deserialize field: " + e.getMessage());
			}

			try {

				object.username = parser.parse(
						configuration.getResponseRemoteFieldName("username"),
						String.class);

			} catch (PathNotFoundException e) {
				log.info("Unable to deserialize field: " + e.getMessage());
			}

		} else {
			// Default to use gson deserializer
			String json = "";
			if (parser instanceof JsonParser) {
				json = ((JsonParser) parser).getRootElement().toString();
			}

			object = (RetailBankingLogin) Utilities.transformJsonToObject(json,
					this.getClass());
		}

		return object;
	}

}
