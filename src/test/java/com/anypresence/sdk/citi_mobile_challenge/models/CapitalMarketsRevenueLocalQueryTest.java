package com.anypresence.sdk.citi_mobile_challenge.models;

//
//  CapitalMarketsRevenue.java
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
public class CapitalMarketsRevenueLocalQueryTest
		extends
			CapitalMarketsRevenueLocal {
	@Before
	public void setup() {
		super.setup();
	}

	@Test
	public void shouldHaveScopes() {

		Assert.assertEquals(
				"all",
				com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue.Scopes.ALL);

		Assert.assertEquals(
				"exact_match",
				com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue.Scopes.EXACT_MATCH);

		Assert.assertEquals(
				"count",
				com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue.Scopes.COUNT);

		Assert.assertEquals(
				"count_exact_match",
				com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue.Scopes.COUNT_EXACT_MATCH);

		Assert.assertEquals(
				"revenues",
				com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue.Scopes.REVENUES);

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
		com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
				.queryInBackground(
						"all",
						null,
						new APFutureCallback<List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue>>() {
							@Override
							public void finished(
									List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue> arg0,
									Throwable ex) {
								objects = arg0;
								lock.countDown();
							}
						});
		lock.await();
		Assert.assertTrue(objects.size() >= 1);

		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
				.loadAllInCache().size() == 2);

		Map<String, String> predicates = new HashMap<String, String>();
		predicates.put("ObjectId", "1");
		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
				.fetchInCacheWithPredicates(predicates).size() == 1);

		predicates.clear();
		predicates.put("ObjectId", "non-existent");
		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
				.fetchInCacheWithPredicates(predicates).size() == 0);

		DateTimeFormatter fmt = DateTimeFormat
				.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

		Assert.assertTrue(com.anypresence.sdk.APSDKSetup
				.getCacheManager()
				.fetchInCacheWithLatestAPCachedRequestPredicate(
						com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue.class,
						"all", null, null, null).size() == 2);

		predicates.clear();
		predicates.put("ObjectId", "1");

		predicates.put("clientId", "not_fake");

		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
				.fetchInCacheWithPredicates(predicates).size() == 0);

		Map<String, String> params = new HashMap<String, String>();

		params.put("client_id", "fake");

		lock = new CountDownLatch(1);
		List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue> cached = com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
				.queryInBackground(
						"all",
						params,
						new APFutureCallback<List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue>>() {
							@Override
							public void finished(
									List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue> arg0,
									Throwable ex) {
								objects = arg0;
								lock.countDown();
							}
						});
		lock.await();
		// There's no cached data yet
		Assert.assertTrue(cached.size() == 0);

		lock = new CountDownLatch(1);
		cached = com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
				.queryInBackground(
						"all",
						params,
						new APFutureCallback<List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue>>() {
							@Override
							public void finished(
									List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue> arg0,
									Throwable ex) {
								objects = arg0;
								lock.countDown();
							}
						});
		lock.await();
		// Now there's cached data
		Assert.assertTrue(cached.size() > 0);

		com.anypresence.sdk.APObject.deleteAllInCache();
		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
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
						list.add("[{\"id\":\"0\",\"client_id\":\"fake\",\"client_name\":\"fake\",\"client_tier\":\"fake\",\"gross_comm\":0,\"month\":\"fake\",\"product_id\":\"fake\",\"product_name\":\"fake\",\"profit_loss\":0,\"region\":\"fake\",\"year\":0}]");
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

		com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
				.queryInBackground(
						"all",
						0,
						1,
						new APFutureCallback<List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue>>() {
							@Override
							public void finished(
									List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue> arg0,
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
						list.add("[{\"id\":\"1\",\"client_id\":\"fake\",\"client_name\":\"fake\",\"client_tier\":\"fake\",\"gross_comm\":0,\"month\":\"fake\",\"product_id\":\"fake\",\"product_name\":\"fake\",\"profit_loss\":0,\"region\":\"fake\",\"year\":0}]");
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

		com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
				.queryInBackground(
						"all",
						1,
						1,
						new APFutureCallback<List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue>>() {
							@Override
							public void finished(
									List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue> arg0,
									Throwable ex) {
								objects = arg0;
								lock.countDown();
							}
						});
		lock.await();

		List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue> cachedObjects = com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
				.fetchInCacheWithScopePredicate("all");
		Assert.assertTrue(cachedObjects.size() == 1);

		params.clear();
		params.put("client_id", "fakest_string");
		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
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

						list.add("[{\"id\":\"0\",\"client_id\":\"fakest_string\",\"client_name\":\"fake\",\"client_tier\":\"fake\",\"gross_comm\":0,\"month\":\"fake\",\"product_id\":\"fake\",\"product_name\":\"fake\",\"profit_loss\":0,\"region\":\"fake\",\"year\":0},{\"id\":\"1\",\"client_id\":\"fakest_string\",\"client_name\":\"fake\",\"client_tier\":\"fake\",\"gross_comm\":0,\"month\":\"fake\",\"product_id\":\"fake\",\"product_name\":\"fake\",\"profit_loss\":0,\"region\":\"fake\",\"year\":0},{\"id\":\"2\",\"client_id\":\"fakest_string\",\"client_name\":\"fake\",\"client_tier\":\"fake\",\"gross_comm\":0,\"month\":\"fake\",\"product_id\":\"fake\",\"product_name\":\"fake\",\"profit_loss\":0,\"region\":\"fake\",\"year\":0}]");
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

		com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
				.queryInBackground(
						"exact_match",
						new APFutureCallback<List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue>>() {
							@Override
							public void finished(
									List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue> arg0,
									Throwable ex) {
								objects = arg0;
								lock.countDown();
							}
						});
		lock.await();

		params.clear();
		params.put("client_id", "fakest_string");
		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
				.fetchInCacheWithScopePredicate("exact_match", params, null,
						null).size() == 3);

		params.clear();
		params.put("client_id", "fakest_string");
		params.put("object_id", "0");
		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
				.fetchInCacheWithScopePredicate("exact_match", params, null,
						null).size() == 1);

		params.clear();
		params.put("fake", "fakest_string");
		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
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

						list.add("[{\"id\":\"0\",\"client_id\":\"fakest_string\",\"client_name\":\"fake\",\"client_tier\":\"fake\",\"gross_comm\":0,\"month\":\"fake\",\"product_id\":\"fake\",\"product_name\":\"fake\",\"profit_loss\":0,\"region\":\"fake\",\"year\":0},{\"id\":\"1\",\"client_id\":\"fakest_string\",\"client_name\":\"fake\",\"client_tier\":\"fake\",\"gross_comm\":0,\"month\":\"fake\",\"product_id\":\"fake\",\"product_name\":\"fake\",\"profit_loss\":0,\"region\":\"fake\",\"year\":0},{\"id\":\"2\",\"client_id\":\"fakest_string\",\"client_name\":\"fake\",\"client_tier\":\"fake\",\"gross_comm\":0,\"month\":\"fake\",\"product_id\":\"fake\",\"product_name\":\"fake\",\"profit_loss\":0,\"region\":\"fake\",\"year\":0}]");
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
		params.put("client_id", "fakest_string");
		params.put("fake", "fakest_string");

		lock = new CountDownLatch(1);
		com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
				.queryInBackground(
						"exact_match",
						params,
						new APFutureCallback<List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue>>() {
							@Override
							public void finished(
									List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue> arg0,
									Throwable ex) {
								objects = arg0;
								lock.countDown();
							}
						});
		lock.await();

		Assert.assertTrue(
				"Should match with scope and params",
				com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
						.fetchInCacheWithParameterPredicate("exact_match",
								params).size() == 3);

		RestClientFactory
				.registerJSONRestClientImplementation(new MockJSONRestClient() {
					@Override
					public List<String> get(URI uri) throws JSONException,
							IOException, URISyntaxException, JSONException,
							RemoteRequestException {
						List<String> list = new ArrayList<String>();

						list.add("[{\"id\":\"3\",\"client_id\":\"fakest_string\",\"client_name\":\"fake\",\"client_tier\":\"fake\",\"gross_comm\":0,\"month\":\"fake\",\"product_id\":\"fake\",\"product_name\":\"fake\",\"profit_loss\":0,\"region\":\"fake\",\"year\":0},{\"id\":\"4\",\"client_id\":\"fakest_string\",\"client_name\":\"fake\",\"client_tier\":\"fake\",\"gross_comm\":0,\"month\":\"fake\",\"product_id\":\"fake\",\"product_name\":\"fake\",\"profit_loss\":0,\"region\":\"fake\",\"year\":0},{\"id\":\"5\",\"client_id\":\"fakest_string\",\"client_name\":\"fake\",\"client_tier\":\"fake\",\"gross_comm\":0,\"month\":\"fake\",\"product_id\":\"fake\",\"product_name\":\"fake\",\"profit_loss\":0,\"region\":\"fake\",\"year\":0}]");
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
		com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
				.queryInBackground(
						"exact_match",
						new APFutureCallback<List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue>>() {
							@Override
							public void finished(
									List<com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue> arg0,
									Throwable ex) {
								objects = arg0;
								lock.countDown();
							}
						});

		Map<String, String> exactMatchParams = new HashMap<String, String>();
		exactMatchParams.put("client_id", "fakest_string");

		com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
				.query("exact_match", exactMatchParams);
		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
				.fetchInCacheWithParameterPredicate("exact_match",
						exactMatchParams).size() == 3);

		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
				.loadAllInCache().size() == 6);

		params.put("fake", "fakest_string0");
		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue
				.fetchInCacheWithParameterPredicate("exact_match", params)
				.size() == 0);

	}

}
