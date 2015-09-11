package com.anypresence.sdk.citi_mobile_challenge.models;

//
//  CorporatePaymentsLogin.java
//  
//
//  Generated by AnyPresence, Inc on 2015-09-11
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
import com.google.common.util.concurrent.FutureCallback;

import org.robolectric.util.DatabaseConfig;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

@DatabaseConfig.UsingDatabaseMap(SQLiteMap.class)
@RunWith(RobolectricTestRunner.class)
public class CorporatePaymentsLoginLocalSaveTest
		extends
			CorporatePaymentsLoginLocal {
	@Before
	public void setup() {
		super.setup();
	}

	@Test
	public void shouldBeAbleSaveIntoCache()
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
		com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin
				.queryInBackground(
						"all",
						null,
						new APFutureCallback<List<com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin>>() {
							@Override
							public void finished(
									List<com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin> arg0,
									Throwable ex) {
								objects = arg0;
								lock.countDown();
							}
						});
		lock.await();
		Assert.assertTrue(objects.size() >= 1);

		List<com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin> objectsInCache = com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin
				.loadAllInCache();
		Assert.assertTrue(objectsInCache.size() == 2);

		com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin object0 = objectsInCache
				.get(0);
		object0.saveInCache();
		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin
				.loadAllInCache().size() == 2);

		// Delete all objects in the cache
		com.anypresence.sdk.APObject.deleteAllInCache();
		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin
				.loadAllInCache().size() == 0);

		object0.saveInCache();
		Assert.assertTrue(com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin
				.loadAllInCache().size() == 1);

		// Save object to cache without a remote object id
		com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin object1 = new com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin();
		object1.saveInCache();

		com.anypresence.sdk.APObject.deleteAllInCache();
		com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin object2 = new com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin();
		object2.updateInCache();
		objectsInCache = com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin
				.loadAllInCache();
		Assert.assertTrue(objectsInCache.isEmpty());
	}

}
