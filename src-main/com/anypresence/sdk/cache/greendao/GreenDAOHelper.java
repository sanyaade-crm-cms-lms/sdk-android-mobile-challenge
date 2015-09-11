package com.anypresence.sdk.cache.greendao;

//
//  GreenDAOHelper.java
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

import static com.anypresence.sdk.config.Config.DEBUG_MODE;

import java.util.*;

final class GreenDAOHelper {
	public static IGreenDAOHelper getInstance(Class<?> clazz) {

		if (clazz == com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsActivity.class) {

			return new CapitalMarketsActivityHelper();
		}

		else if (clazz == com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsContact.class) {

			return new CapitalMarketsContactHelper();
		}

		else if (clazz == com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsContentService.class) {

			return new CapitalMarketsContentServiceHelper();
		}

		else if (clazz == com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsLogin.class) {

			return new CapitalMarketsLoginHelper();
		}

		else if (clazz == com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsOrder.class) {

			return new CapitalMarketsOrderHelper();
		}

		else if (clazz == com.anypresence.sdk.citi_mobile_challenge.models.CapitalMarketsRevenue.class) {

			return new CapitalMarketsRevenueHelper();
		}

		else if (clazz == com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsAccount.class) {

			return new CorporatePaymentsAccountHelper();
		}

		else if (clazz == com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsBeneficiary.class) {

			return new CorporatePaymentsBeneficiaryHelper();
		}

		else if (clazz == com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsCrossBorderFxBooking.class) {

			return new CorporatePaymentsCrossBorderFxBookingHelper();
		}

		else if (clazz == com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsCrossBorderFxPayment.class) {

			return new CorporatePaymentsCrossBorderFxPaymentHelper();
		}

		else if (clazz == com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsCrossBorderFxQuote.class) {

			return new CorporatePaymentsCrossBorderFxQuoteHelper();
		}

		else if (clazz == com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsLogin.class) {

			return new CorporatePaymentsLoginHelper();
		}

		else if (clazz == com.anypresence.sdk.citi_mobile_challenge.models.CorporatePaymentsPayment.class) {

			return new CorporatePaymentsPaymentHelper();
		}

		else if (clazz == com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingAccount.class) {

			return new RetailBankingAccountHelper();
		}

		else if (clazz == com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingAccountBalance.class) {

			return new RetailBankingAccountBalanceHelper();
		}

		else if (clazz == com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingAccountFundTransfer.class) {

			return new RetailBankingAccountFundTransferHelper();
		}

		else if (clazz == com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingAccountTransaction.class) {

			return new RetailBankingAccountTransactionHelper();
		}

		else if (clazz == com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingForeignCurrency.class) {

			return new RetailBankingForeignCurrencyHelper();
		}

		else if (clazz == com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingLocation.class) {

			return new RetailBankingLocationHelper();
		}

		else if (clazz == com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingLogin.class) {

			return new RetailBankingLoginHelper();
		}

		else if (clazz == com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingPayee.class) {

			return new RetailBankingPayeeHelper();
		}

		else if (clazz == com.anypresence.sdk.citi_mobile_challenge.models.RetailBankingPayeeType.class) {

			return new RetailBankingPayeeTypeHelper();
		}

		else {
			throw new IllegalStateException("Unknown class");
		}
	}
}
