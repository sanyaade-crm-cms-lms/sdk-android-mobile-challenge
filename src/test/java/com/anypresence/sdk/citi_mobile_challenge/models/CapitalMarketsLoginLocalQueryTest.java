package com.anypresence.sdk.citi_mobile_challenge.models;

//
//  CapitalMarketsLogin.java
//  
//
//  Generated by AnyPresence, Inc on 2015-09-15
//  Copyright (c) 2015. All rights reserved.
//

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.anypresence.*;
import org.json.JSONException;
import de.greenrobot.dao.Property;

import com.anypresence.sdk.APSDKSetup;
import com.anypresence.sdk.acl.*;
import com.anypresence.sdk.config.Config;
import com.anypresence.sdk.query.*;
import com.anypresence.sdk.cache.*;
import com.anypresence.rails_droid.http.*;
import com.anypresence.rails_droid.*;
import com.anypresence.sdk.citi_mobile_challenge.*;
import com.anypresence.sdk.citi_mobile_challenge.*;
import com.google.common.util.concurrent.FutureCallback;

import org.robolectric.util.DatabaseConfig;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@DatabaseConfig.UsingDatabaseMap(SQLiteMap.class)
@RunWith(RobolectricTestRunner.class)
public class CapitalMarketsLoginLocalQueryTest extends CapitalMarketsLoginLocal {
	@Before
	public void setup() {
		super.setup();
	}

	@Test
	public void shouldHaveScopes() {

		Assert.assertEquals(
				"all",
				com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin.Scopes.ALL);

		Assert.assertEquals(
				"exact_match",
				com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin.Scopes.EXACT_MATCH);

		Assert.assertEquals(
				"count",
				com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin.Scopes.COUNT);

		Assert.assertEquals(
				"count_exact_match",
				com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin.Scopes.COUNT_EXACT_MATCH);

	}

	@Test
	public void shouldBeAbleQueryFromCache()
			throws com.anypresence.sdk.acl.UnauthorizedException,
			RemoteRequestException, InterruptedException,
			ClassNotFoundException {
		APSetup.setBaseUrl("http://localhost");
		APSetup.setup();
		Config.getInstance().setStrictQueryFieldCheck(false);
		APSDKSetup.setDBStoreType(DBStoreType.IN_MEMORY);
		Config.DEBUG_MODE = true;

		RemoteRailsConfig.getInstance().setInlineMode(true);

		lock = new CountDownLatch(1);
		IRestClient client = getTestRestClient();
		RestClientFactory.registerJSONRestClientImplementation(client);
		com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
				.queryInBackground(
						"all",
						null,
						new APFutureCallback<List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin>>() {
							@Override
							public void finished(
									List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin> arg0,
									Throwable ex) {
								objects = arg0;
								lock.countDown();
							}
						});
		lock.await();
		Assert.assertTrue(objects.size() >= 1);

		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
				.loadAllInCache().size() == 2);

		Map<String, String> predicates = new HashMap<String, String>();
		predicates.put("ObjectId", "1");
		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
				.fetchInCacheWithPredicates(predicates).size() == 1);

		predicates.clear();
		predicates.put("ObjectId", "non-existent");
		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
				.fetchInCacheWithPredicates(predicates).size() == 0);

		DateTimeFormatter fmt = DateTimeFormat
				.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

		Assert.assertTrue(com.anypresence.sdk.APSDKSetup
				.getCacheManager()
				.fetchInCacheWithLatestAPCachedRequestPredicate(
						com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin.class,
						"all", null, null, null).size() == 2);

		predicates.clear();
		predicates.put("ObjectId", "1");

		predicates.put("password", "not_fake");

		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
				.fetchInCacheWithPredicates(predicates).size() == 0);

		Map<String, String> params = new HashMap<String, String>();

		params.put("password", "fake");

		lock = new CountDownLatch(1);
		List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin> cached = com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
				.queryInBackground(
						"all",
						params,
						new APFutureCallback<List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin>>() {
							@Override
							public void finished(
									List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin> arg0,
									Throwable ex) {
								objects = arg0;
								lock.countDown();
							}
						});
		lock.await();
		// There's no cached data yet
		Assert.assertTrue(cached.size() == 0);

		lock = new CountDownLatch(1);
		cached = com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
				.queryInBackground(
						"all",
						params,
						new APFutureCallback<List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin>>() {
							@Override
							public void finished(
									List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin> arg0,
									Throwable ex) {
								objects = arg0;
								lock.countDown();
							}
						});
		lock.await();
		// Now there's cached data
		Assert.assertTrue(cached.size() > 0);

		com.anypresence.sdk.APObject.deleteAllInCache();
		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
				.loadAllInCache().size() == 0);

		// Test other scopes
		lock = new CountDownLatch(1);
		RestClientFactory
				.registerJSONRestClientImplementation(new MockJSONRestClient() {

					@Override
					public List<String> get(URI uri) throws JSONException,
							IOException, URISyntaxException, JSONException,
							RemoteRequestException {
						List<String> list = new ArrayList<String>();
						list.add("[{\"token\":\"0\",\"password\":\"fake\",\"username\":\"fake\"}]");
						return list;
					}

					@Override
					public List<String> get(URI uri, Map<String, String> headers)
							throws JSONException, IOException,
							URISyntaxException, JSONException,
							RemoteRequestException {
						return null;
					}

					@Override
					public List<String> post(URI uri, String body,
							Map<String, String> headers) throws IOException,
							RemoteRequestException {
						return null;
					}

					@Override
					public List<String> post(URI uri, String body)
							throws IOException, RemoteRequestException {
						return null;
					}

					@Override
					public List<String> put(URI uri, String body)
							throws IOException, RemoteRequestException {
						return null;
					}

					@Override
					public List<String> get(RemoteRequest remoteRequest)
							throws IOException, URISyntaxException,
							JSONException, RemoteRequestException {
						return get(remoteRequest.getPathAsURI());
					}

					@Override
					public List<String> post(RemoteRequest remoteRequest,
							String body) throws IOException,
							RemoteRequestException {
						return null;
					}

					@Override
					public List<String> put(RemoteRequest remoteRequest,
							String body) throws IOException,
							RemoteRequestException {
						return null;
					}
				});

		com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
				.queryInBackground(
						"all",
						0,
						1,
						new APFutureCallback<List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin>>() {
							@Override
							public void finished(
									List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin> arg0,
									Throwable ex) {
								objects = arg0;
								lock.countDown();
							}
						});
		lock.await();

		lock = new CountDownLatch(1);
		RestClientFactory
				.registerJSONRestClientImplementation(new MockJSONRestClient() {

					@Override
					public List<String> get(URI uri) throws JSONException,
							IOException, URISyntaxException, JSONException,
							RemoteRequestException {
						List<String> list = new ArrayList<String>();
						list.add("[{\"token\":\"1\",\"password\":\"fake\",\"username\":\"fake\"}]");
						return list;
					}

					@Override
					public List<String> get(URI uri, Map<String, String> headers)
							throws JSONException, IOException,
							URISyntaxException, JSONException,
							RemoteRequestException {
						return null;
					}

					@Override
					public List<String> post(URI uri, String body,
							Map<String, String> headers) throws IOException,
							RemoteRequestException {
						return null;
					}

					@Override
					public List<String> post(URI uri, String body)
							throws IOException, RemoteRequestException {
						return null;
					}

					@Override
					public List<String> put(URI uri, String body)
							throws IOException, RemoteRequestException {
						return null;
					}

					@Override
					public List<String> get(RemoteRequest remoteRequest)
							throws IOException, URISyntaxException,
							JSONException, RemoteRequestException {
						return get(remoteRequest.getPathAsURI());
					}

					@Override
					public List<String> post(RemoteRequest remoteRequest,
							String body) throws IOException,
							RemoteRequestException {
						return null;
					}

					@Override
					public List<String> put(RemoteRequest remoteRequest,
							String body) throws IOException,
							RemoteRequestException {
						return null;
					}
				});

		com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
				.queryInBackground(
						"all",
						1,
						1,
						new APFutureCallback<List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin>>() {
							@Override
							public void finished(
									List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin> arg0,
									Throwable ex) {
								objects = arg0;
								lock.countDown();
							}
						});
		lock.await();

		List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin> cachedObjects = com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
				.fetchInCacheWithScopePredicate("all");
		Assert.assertTrue(cachedObjects.size() == 1);

		params.clear();
		params.put("password", "fakest_string");
		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
				.fetchInCacheWithScopePredicate("all", params, null, null)
				.size() == 0);

		lock = new CountDownLatch(1);
		RestClientFactory
				.registerJSONRestClientImplementation(new MockJSONRestClient() {
					@Override
					public List<String> get(URI uri) throws JSONException,
							IOException, URISyntaxException, JSONException,
							RemoteRequestException {
						List<String> list = new ArrayList<String>();

						list.add("[{\"token\":\"0\",\"password\":\"fakest_string\",\"username\":\"fake\"},{\"token\":\"1\",\"password\":\"fakest_string\",\"username\":\"fake\"},{\"token\":\"2\",\"password\":\"fakest_string\",\"username\":\"fake\"}]");
						return list;
					}

					@Override
					public List<String> get(URI uri, Map<String, String> headers)
							throws JSONException, IOException,
							URISyntaxException, JSONException,
							RemoteRequestException {
						return null;
					}

					@Override
					public List<String> post(URI uri, String body,
							Map<String, String> headers) throws IOException,
							RemoteRequestException {
						return null;
					}

					@Override
					public List<String> post(URI uri, String body)
							throws IOException, RemoteRequestException {
						return null;
					}

					@Override
					public List<String> put(URI uri, String body)
							throws IOException, RemoteRequestException {
						return null;
					}

					@Override
					public List<String> get(RemoteRequest remoteRequest)
							throws IOException, URISyntaxException,
							JSONException, RemoteRequestException {
						return get(remoteRequest.getPathAsURI());
					}

					@Override
					public List<String> post(RemoteRequest remoteRequest,
							String body) throws IOException,
							RemoteRequestException {
						return null;
					}

					@Override
					public List<String> put(RemoteRequest remoteRequest,
							String body) throws IOException,
							RemoteRequestException {
						return null;
					}
				});

		com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
				.queryInBackground(
						"exact_match",
						new APFutureCallback<List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin>>() {
							@Override
							public void finished(
									List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin> arg0,
									Throwable ex) {
								objects = arg0;
								lock.countDown();
							}
						});
		lock.await();

		params.clear();
		params.put("password", "fakest_string");
		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
				.fetchInCacheWithScopePredicate("exact_match", params, null,
						null).size() == 3);

		params.clear();
		params.put("password", "fakest_string");
		params.put("object_id", "0");
		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
				.fetchInCacheWithScopePredicate("exact_match", params, null,
						null).size() == 1);

		params.clear();
		params.put("fake", "fakest_string");
		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
				.fetchInCacheWithScopePredicate("exact_match", params, null,
						null).size() == 0);

		com.anypresence.sdk.APObject.deleteAllInCache();

		// Fetch in cache with parameters

		RestClientFactory
				.registerJSONRestClientImplementation(new MockJSONRestClient() {
					@Override
					public List<String> get(URI uri) throws JSONException,
							IOException, URISyntaxException, JSONException,
							RemoteRequestException {
						List<String> list = new ArrayList<String>();

						list.add("[{\"token\":\"0\",\"password\":\"fakest_string\",\"username\":\"fake\"},{\"token\":\"1\",\"password\":\"fakest_string\",\"username\":\"fake\"},{\"token\":\"2\",\"password\":\"fakest_string\",\"username\":\"fake\"}]");
						return list;
					}

					@Override
					public List<String> get(URI uri, Map<String, String> headers)
							throws JSONException, IOException,
							URISyntaxException, JSONException,
							RemoteRequestException {
						return null;
					}

					@Override
					public List<String> post(URI uri, String body,
							Map<String, String> headers) throws IOException,
							RemoteRequestException {
						return null;
					}

					@Override
					public List<String> post(URI uri, String body)
							throws IOException, RemoteRequestException {
						return null;
					}

					@Override
					public List<String> put(URI uri, String body)
							throws IOException, RemoteRequestException {
						return null;
					}

					@Override
					public List<String> get(RemoteRequest remoteRequest)
							throws IOException, URISyntaxException,
							JSONException, RemoteRequestException {
						return get(remoteRequest.getPathAsURI());
					}

					@Override
					public List<String> post(RemoteRequest remoteRequest,
							String body) throws IOException,
							RemoteRequestException {
						return null;
					}

					@Override
					public List<String> put(RemoteRequest remoteRequest,
							String body) throws IOException,
							RemoteRequestException {
						return null;
					}
				});

		params.clear();
		params.put("password", "fakest_string");
		params.put("fake", "fakest_string");

		lock = new CountDownLatch(1);
		com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
				.queryInBackground(
						"exact_match",
						params,
						new APFutureCallback<List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin>>() {
							@Override
							public void finished(
									List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin> arg0,
									Throwable ex) {
								objects = arg0;
								lock.countDown();
							}
						});
		lock.await();

		Assert.assertTrue(
				"Should match with scope and params",
				com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
						.fetchInCacheWithParameterPredicate("exact_match",
								params).size() == 3);

		RestClientFactory
				.registerJSONRestClientImplementation(new MockJSONRestClient() {
					@Override
					public List<String> get(URI uri) throws JSONException,
							IOException, URISyntaxException, JSONException,
							RemoteRequestException {
						List<String> list = new ArrayList<String>();

						list.add("[{\"token\":\"3\",\"password\":\"fakest_string\",\"username\":\"fake\"},{\"token\":\"4\",\"password\":\"fakest_string\",\"username\":\"fake\"},{\"token\":\"5\",\"password\":\"fakest_string\",\"username\":\"fake\"}]");
						return list;
					}

					@Override
					public List<String> get(URI uri, Map<String, String> headers)
							throws JSONException, IOException,
							URISyntaxException, JSONException,
							RemoteRequestException {
						return null;
					}

					@Override
					public List<String> post(URI uri, String body,
							Map<String, String> headers) throws IOException,
							RemoteRequestException {
						return null;
					}

					@Override
					public List<String> post(URI uri, String body)
							throws IOException, RemoteRequestException {
						return null;
					}

					@Override
					public List<String> put(URI uri, String body)
							throws IOException, RemoteRequestException {
						return null;
					}

					@Override
					public List<String> get(RemoteRequest remoteRequest)
							throws IOException, URISyntaxException,
							JSONException, RemoteRequestException {
						return get(remoteRequest.getPathAsURI());
					}

					@Override
					public List<String> post(RemoteRequest remoteRequest,
							String body) throws IOException,
							RemoteRequestException {
						return null;
					}

					@Override
					public List<String> put(RemoteRequest remoteRequest,
							String body) throws IOException,
							RemoteRequestException {
						return null;
					}
				});

		lock = new CountDownLatch(1);
		com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
				.queryInBackground(
						"exact_match",
						new APFutureCallback<List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin>>() {
							@Override
							public void finished(
									List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin> arg0,
									Throwable ex) {
								objects = arg0;
								lock.countDown();
							}
						});

		Map<String, String> exactMatchParams = new HashMap<String, String>();
		exactMatchParams.put("password", "fakest_string");

		com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
				.query("exact_match", exactMatchParams);
		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
				.fetchInCacheWithParameterPredicate("exact_match",
						exactMatchParams).size() == 3);

		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
				.loadAllInCache().size() == 6);

		params.put("fake", "fakest_string0");
		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin
				.fetchInCacheWithParameterPredicate("exact_match", params)
				.size() == 0);

	}

}
