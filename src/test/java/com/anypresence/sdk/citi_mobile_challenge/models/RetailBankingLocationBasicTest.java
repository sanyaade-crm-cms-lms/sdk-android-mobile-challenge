package com.anypresence.sdk.citi_mobile_challenge.models;

//
//  RetailBankingLocation.java
//  
//
//  Generated by AnyPresence, Inc on 2015-09-11
//  Copyright (c) 2015. All rights reserved.
//

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;
import java.util.Map.Entry;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.anypresence.*;

import com.anypresence.sdk.APSDKSetup;
import com.anypresence.sdk.acl.*;
import com.anypresence.sdk.config.Config;
import com.anypresence.sdk.query.*;
import com.anypresence.sdk.citi_mobile_challenge.*;
import com.anypresence.rails_droid.RemoteRailsConfig;
import com.anypresence.rails_droid.ObjectId;
import com.anypresence.rails_droid.RemoteRequestException;
import com.google.common.util.concurrent.FutureCallback;

public class RetailBankingLocationBasicTest {
	private static RemoteRailsConfig config;
	private List<com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingLocation> createdObjects;

	private static CountDownLatch lock = new CountDownLatch(1);

	// Please create a user with the necessary roles with this username
	// and password...
	private final static String USERNAME = "foo";
	private final static String PASSWORD = "password";

	private static String testLiveBackend = null;

	final static int MAX_ENTITIES = 5;

	/**
	
	 **/

	@BeforeClass
	public static void init() throws InterruptedException,
			RemoteRequestException {
		testLiveBackend = System.getProperty("testLiveBackend");

		if (testLiveBackend == null)
			return;
		if (testLiveBackend != null && !testLiveBackend.equals("yes")) {
			return;
		}
		APSetup.setBaseUrl("http://localhost");
		APSetup.setup();
		Config.getInstance().setStrictQueryFieldCheck(false);

		// Login first before creating entities.
		AuthManagerFactory.getInstance().authenticateUser(USERNAME, PASSWORD,
				new FutureCallback<String>() {
					@Override
					public void onSuccess(String result) {
						System.out.println("The user has been authenticated.");
						lock.countDown();
					}

					@Override
					public void onFailure(Throwable err) {
						err.printStackTrace();
					}
				});

		// Wait for latch to be free before continuing as the authentication was done asynchronously.
		if (!lock.await(5000, TimeUnit.MILLISECONDS)) {
			Assert.fail("Unable to run the tests because we can't authenticate. Please check the errors and make sure that the user "
					+ USERNAME + " exists.");
		}

		List<com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingLocation> objects = com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingLocation
				.query("all");
		if (!objects.isEmpty()) {
			Assert.fail("Unable to run test as there are data for RetailBankingLocation.");
		}

	}

	@Test
	public void shouldBeAbletoQueryForAll() throws UnauthorizedException,
			RemoteRequestException {
		if (testLiveBackend == null)
			return;
		if (testLiveBackend != null && !testLiveBackend.equals("yes")) {
			return;
		}

		createdObjects = new ArrayList<com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingLocation>();

		// Create some entities.
		for (int i = 0; i < MAX_ENTITIES; i++) {
			com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingLocation obj = new com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingLocation();

			obj.save();
			createdObjects.add(obj);
		}

		List<com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingLocation> objects = com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingLocation
				.query("all");
		Assert.assertTrue(objects.size() >= MAX_ENTITIES);

		// Test limiting result.
		objects = com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingLocation
				.query("all", null, 0, 2);
		Assert.assertEquals(2, objects.size());
	}

	@Test
	public void shouldBeAbletoQueryForExactMatch()
			throws UnauthorizedException, RemoteRequestException,
			SecurityException, NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		if (testLiveBackend == null)
			return;
		if (testLiveBackend != null && !testLiveBackend.equals("yes")) {
			return;
		}

		Map<String, String> params = new HashMap<String, String>();

		com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingLocation obj = new com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingLocation();

		obj.save();

		obj.reload();

		params.put("id", obj.getId().toString());

		createdObjects = new ArrayList<com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingLocation>();
		createdObjects.add(obj);

		List<com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingLocation> objects = com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingLocation
				.query("exact_match", params, null, null);
		Assert.assertEquals(1, objects.size());
	}

	@After
	public void cleanUp() throws RemoteRequestException {
		if (createdObjects == null)
			return;

		for (com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingLocation category : createdObjects) {
			category.delete();
		}

	}

}
