package com.anypresence.sdk.citi_mobile_challenge.models;

//
//  RetailBankingAccount.java
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

import com.anypresence.sdk.APSDKSetup;
import com.anypresence.sdk.acl.*;
import com.anypresence.sdk.cache.*;
import com.anypresence.sdk.config.Config;
import com.anypresence.sdk.query.*;
import com.anypresence.sdk.citi_mobile_challenge.*;
import com.anypresence.rails_droid.http.IRestClient;
import com.anypresence.rails_droid.http.RestClientFactory;
import com.anypresence.rails_droid.*;
import org.robolectric.Robolectric;
import com.google.common.util.concurrent.FutureCallback;

import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

public class RetailBankingAccountLocal {
	protected List<com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingAccount> createdObjects;
	protected List<com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingAccount> objects;
	protected static CountDownLatch lock = new CountDownLatch(1);

	/**
	
	 **/

	protected Context context = null;

	protected IRestClient getTestRestClient() {
		return new MockJSONRestClient() {
			@Override
			public List<String> get(URI uri) throws JSONException, IOException,
					URISyntaxException, JSONException, RemoteRequestException {
				List<String> list = new ArrayList<String>();
				list.add("[{\"id\":\"0\",\"account_status\":\"fake\",\"balances\":{\"data0\":\"fake0\",\"data1\":\"fake1\"},\"category_code\":0,\"cops_indicator\":\"fake\",\"details_exist\":\"fake\",\"display_acct_no\":\"fake\",\"is_destination_account\":\"fake\",\"is_source_account\":\"fake\",\"msgs\":{\"data0\":\"fake0\",\"data1\":\"fake1\"},\"offers_indicator\":\"fake\",\"product_currency\":\"fake\",\"product_description\":\"fake\",\"product_type\":0,\"txn_exist\":\"fake\"},{\"id\":\"1\",\"account_status\":\"fake\",\"balances\":{\"data0\":\"fake0\",\"data1\":\"fake1\"},\"category_code\":0,\"cops_indicator\":\"fake\",\"details_exist\":\"fake\",\"display_acct_no\":\"fake\",\"is_destination_account\":\"fake\",\"is_source_account\":\"fake\",\"msgs\":{\"data0\":\"fake0\",\"data1\":\"fake1\"},\"offers_indicator\":\"fake\",\"product_currency\":\"fake\",\"product_description\":\"fake\",\"product_type\":0,\"txn_exist\":\"fake\"}]");
				return list;
			}

			@Override
			public List<String> get(URI uri, Map<String, String> headers)
					throws JSONException, IOException, URISyntaxException,
					JSONException, RemoteRequestException {
				return null;
			}

			@Override
			public List<String> post(URI uri, String body,
					Map<String, String> headers) throws IOException,
					RemoteRequestException {
				return null;
			}

			@Override
			public List<String> post(URI uri, String body) throws IOException,
					RemoteRequestException {
				return null;
			}

			@Override
			public List<String> get(RemoteRequest remoteRequest)
					throws IOException, URISyntaxException, JSONException,
					RemoteRequestException {
				return get(remoteRequest.getPathAsURI());
			}

			@Override
			public List<String> post(RemoteRequest remoteRequest, String body)
					throws IOException, RemoteRequestException {
				return null;
			}

			@Override
			public List<String> put(RemoteRequest remoteRequest, String body)
					throws IOException, RemoteRequestException {
				return null;
			}

			@Override
			public List<String> put(URI uri, String body) throws IOException,
					RemoteRequestException {
				return null;
			}

		};
	}

	public void setup() {
		APSDKSetup.setDBStoreType(DBStoreType.IN_MEMORY);
		com.anypresence.rails_droid.RemoteRailsConfig.DEBUG = true;
		if (context == null) {
			context = Robolectric.buildActivity(MyActivity.class).attach()
					.create().get();
			APSetup.setBaseUrl("http://localhost");
			APSetup.setup();
			Config.TEST_MODE = true;
			APSetup.setupOrm(context);
		}
	}

}
