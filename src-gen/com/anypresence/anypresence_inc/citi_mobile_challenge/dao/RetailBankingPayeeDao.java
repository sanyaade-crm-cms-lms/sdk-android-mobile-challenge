package com.anypresence.anypresence_inc.citi_mobile_challenge.dao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;

import com.anypresence.anypresence_inc.citi_mobile_challenge.dao.RetailBankingPayee;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table RETAILBANKINGPAYEES.
 */
public class RetailBankingPayeeDao
		extends
			AbstractDao<RetailBankingPayee, Long> {

	public static final String TABLENAME = "RETAILBANKINGPAYEES";

	/**
	 * Properties of entity RetailBankingPayee.<br/>
	 * Can be used for QueryBuilder and for referencing column names.
	 */
	public static class Properties {
		public final static Property Id = new Property(0, Long.class, "id",
				true, "_id");
		public final static Property AddPayeeDetails = new Property(1,
				String.class, "addPayeeDetails", false, "ADD_PAYEE_DETAILS");
		public final static Property BankNameExt = new Property(2,
				String.class, "bankNameExt", false, "BANK_NAME_EXT");
		public final static Property DetailPrefix = new Property(3,
				String.class, "detailPrefix", false, "DETAIL_PREFIX");
		public final static Property LastPaymentAmt = new Property(4,
				Float.class, "lastPaymentAmt", false, "LAST_PAYMENT_AMT");
		public final static Property PayeeAccount = new Property(5,
				String.class, "payeeAccount", false, "PAYEE_ACCOUNT");
		public final static Property PayeeDescription = new Property(6,
				String.class, "payeeDescription", false, "PAYEE_DESCRIPTION");
		public final static Property PayeeListIdTwo = new Property(7,
				Integer.class, "payeeListIdTwo", false, "PAYEE_LIST_ID_TWO");
		public final static Property PayeeListIdType = new Property(8,
				Integer.class, "payeeListIdType", false, "PAYEE_LIST_ID_TYPE");
		public final static Property PayeeType = new Property(9, Integer.class,
				"payeeType", false, "PAYEE_TYPE");
		public final static Property PaymentMethod = new Property(10,
				String.class, "paymentMethod", false, "PAYMENT_METHOD");
		public final static Property Scope = new Property(11, String.class,
				"scope", false, "SCOPE");
		public final static Property ObjectId = new Property(12, String.class,
				"objectId", false, "OBJECT_ID");
		public final static Property _cacheUpdatedAt = new Property(13,
				java.util.Date.class, "_cacheUpdatedAt", false,
				"_CACHE_UPDATED_AT");
		public final static Property ApCachedRequestId = new Property(14,
				Long.class, "apCachedRequestId", false, "AP_CACHED_REQUEST_ID");
	};

	private DaoSession daoSession;

	public RetailBankingPayeeDao(DaoConfig config) {
		super(config);
	}

	public RetailBankingPayeeDao(DaoConfig config, DaoSession daoSession) {
		super(config, daoSession);
		this.daoSession = daoSession;
	}

	/** Creates the underlying database table. */
	public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
		String constraint = ifNotExists ? "IF NOT EXISTS " : "";
		db.execSQL("CREATE TABLE " + constraint + "'RETAILBANKINGPAYEES' (" + //
				"'_id' INTEGER PRIMARY KEY ," + // 0: id
				"'ADD_PAYEE_DETAILS' TEXT," + // 1: addPayeeDetails
				"'BANK_NAME_EXT' TEXT," + // 2: bankNameExt
				"'DETAIL_PREFIX' TEXT," + // 3: detailPrefix
				"'LAST_PAYMENT_AMT' REAL," + // 4: lastPaymentAmt
				"'PAYEE_ACCOUNT' TEXT," + // 5: payeeAccount
				"'PAYEE_DESCRIPTION' TEXT," + // 6: payeeDescription
				"'PAYEE_LIST_ID_TWO' INTEGER," + // 7: payeeListIdTwo
				"'PAYEE_LIST_ID_TYPE' INTEGER," + // 8: payeeListIdType
				"'PAYEE_TYPE' INTEGER," + // 9: payeeType
				"'PAYMENT_METHOD' TEXT," + // 10: paymentMethod
				"'SCOPE' TEXT," + // 11: scope
				"'OBJECT_ID' TEXT," + // 12: objectId
				"'_CACHE_UPDATED_AT' INTEGER," + // 13: _cacheUpdatedAt
				"'AP_CACHED_REQUEST_ID' INTEGER);"); // 14: apCachedRequestId
		// Add Indexes
		db.execSQL("CREATE UNIQUE INDEX " + constraint
				+ "IDX_RETAILBANKINGPAYEES_OBJECT_ID ON RETAILBANKINGPAYEES"
				+ " (OBJECT_ID);");
	}

	/** Drops the underlying database table. */
	public static void dropTable(SQLiteDatabase db, boolean ifExists) {
		String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "")
				+ "'RETAILBANKINGPAYEES'";
		db.execSQL(sql);
	}

	/** @inheritdoc */
	@Override
	protected void bindValues(SQLiteStatement stmt, RetailBankingPayee entity) {
		stmt.clearBindings();

		Long id = entity.getId();
		if (id != null) {
			stmt.bindLong(1, id);
		}

		String addPayeeDetails = entity.getAddPayeeDetails();
		if (addPayeeDetails != null) {
			stmt.bindString(2, addPayeeDetails);
		}

		String bankNameExt = entity.getBankNameExt();
		if (bankNameExt != null) {
			stmt.bindString(3, bankNameExt);
		}

		String detailPrefix = entity.getDetailPrefix();
		if (detailPrefix != null) {
			stmt.bindString(4, detailPrefix);
		}

		Float lastPaymentAmt = entity.getLastPaymentAmt();
		if (lastPaymentAmt != null) {
			stmt.bindDouble(5, lastPaymentAmt);
		}

		String payeeAccount = entity.getPayeeAccount();
		if (payeeAccount != null) {
			stmt.bindString(6, payeeAccount);
		}

		String payeeDescription = entity.getPayeeDescription();
		if (payeeDescription != null) {
			stmt.bindString(7, payeeDescription);
		}

		Integer payeeListIdTwo = entity.getPayeeListIdTwo();
		if (payeeListIdTwo != null) {
			stmt.bindLong(8, payeeListIdTwo);
		}

		Integer payeeListIdType = entity.getPayeeListIdType();
		if (payeeListIdType != null) {
			stmt.bindLong(9, payeeListIdType);
		}

		Integer payeeType = entity.getPayeeType();
		if (payeeType != null) {
			stmt.bindLong(10, payeeType);
		}

		String paymentMethod = entity.getPaymentMethod();
		if (paymentMethod != null) {
			stmt.bindString(11, paymentMethod);
		}

		String scope = entity.getScope();
		if (scope != null) {
			stmt.bindString(12, scope);
		}

		String objectId = entity.getObjectId();
		if (objectId != null) {
			stmt.bindString(13, objectId);
		}

		java.util.Date _cacheUpdatedAt = entity.get_cacheUpdatedAt();
		if (_cacheUpdatedAt != null) {
			stmt.bindLong(14, _cacheUpdatedAt.getTime());
		}

		Long apCachedRequestId = entity.getApCachedRequestId();
		if (apCachedRequestId != null) {
			stmt.bindLong(15, apCachedRequestId);
		}
	}

	@Override
	protected void attachEntity(RetailBankingPayee entity) {
		super.attachEntity(entity);
		entity.__setDaoSession(daoSession);
	}

	/** @inheritdoc */
	@Override
	public Long readKey(Cursor cursor, int offset) {
		return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
	}

	/** @inheritdoc */
	@Override
	public RetailBankingPayee readEntity(Cursor cursor, int offset) {
		RetailBankingPayee entity = new RetailBankingPayee(
				//
				cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
				cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // addPayeeDetails
				cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // bankNameExt
				cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // detailPrefix
				cursor.isNull(offset + 4) ? null : cursor.getFloat(offset + 4), // lastPaymentAmt
				cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // payeeAccount
				cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // payeeDescription
				cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7), // payeeListIdTwo
				cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8), // payeeListIdType
				cursor.isNull(offset + 9) ? null : cursor.getInt(offset + 9), // payeeType
				cursor.isNull(offset + 10) ? null : cursor
						.getString(offset + 10), // paymentMethod
				cursor.isNull(offset + 11) ? null : cursor
						.getString(offset + 11), // scope
				cursor.isNull(offset + 12) ? null : cursor
						.getString(offset + 12), // objectId
				cursor.isNull(offset + 13) ? null : new java.util.Date(cursor
						.getLong(offset + 13)), // _cacheUpdatedAt
				cursor.isNull(offset + 14) ? null : cursor.getLong(offset + 14) // apCachedRequestId
		);
		return entity;
	}

	/** @inheritdoc */
	@Override
	public void readEntity(Cursor cursor, RetailBankingPayee entity, int offset) {
		entity.setId(cursor.isNull(offset + 0) ? null : cursor
				.getLong(offset + 0));
		entity.setAddPayeeDetails(cursor.isNull(offset + 1) ? null : cursor
				.getString(offset + 1));
		entity.setBankNameExt(cursor.isNull(offset + 2) ? null : cursor
				.getString(offset + 2));
		entity.setDetailPrefix(cursor.isNull(offset + 3) ? null : cursor
				.getString(offset + 3));
		entity.setLastPaymentAmt(cursor.isNull(offset + 4) ? null : cursor
				.getFloat(offset + 4));
		entity.setPayeeAccount(cursor.isNull(offset + 5) ? null : cursor
				.getString(offset + 5));
		entity.setPayeeDescription(cursor.isNull(offset + 6) ? null : cursor
				.getString(offset + 6));
		entity.setPayeeListIdTwo(cursor.isNull(offset + 7) ? null : cursor
				.getInt(offset + 7));
		entity.setPayeeListIdType(cursor.isNull(offset + 8) ? null : cursor
				.getInt(offset + 8));
		entity.setPayeeType(cursor.isNull(offset + 9) ? null : cursor
				.getInt(offset + 9));
		entity.setPaymentMethod(cursor.isNull(offset + 10) ? null : cursor
				.getString(offset + 10));
		entity.setScope(cursor.isNull(offset + 11) ? null : cursor
				.getString(offset + 11));
		entity.setObjectId(cursor.isNull(offset + 12) ? null : cursor
				.getString(offset + 12));
		entity.set_cacheUpdatedAt(cursor.isNull(offset + 13)
				? null
				: new java.util.Date(cursor.getLong(offset + 13)));
		entity.setApCachedRequestId(cursor.isNull(offset + 14) ? null : cursor
				.getLong(offset + 14));
	}

	/** @inheritdoc */
	@Override
	protected Long updateKeyAfterInsert(RetailBankingPayee entity, long rowId) {
		entity.setId(rowId);
		return rowId;
	}

	/** @inheritdoc */
	@Override
	public Long getKey(RetailBankingPayee entity) {
		if (entity != null) {
			return entity.getId();
		} else {
			return null;
		}
	}

	/** @inheritdoc */
	@Override
	protected boolean isEntityUpdateable() {
		return true;
	}

	private String selectDeep;

	protected String getSelectDeep() {
		if (selectDeep == null) {
			StringBuilder builder = new StringBuilder("SELECT ");
			SqlUtils.appendColumns(builder, "T", getAllColumns());
			builder.append(',');
			SqlUtils.appendColumns(builder, "T0", daoSession
					.getAPCachedRequestDao().getAllColumns());
			builder.append(" FROM RETAILBANKINGPAYEES T");
			builder.append(" LEFT JOIN APCACHED_REQUEST T0 ON T.'AP_CACHED_REQUEST_ID'=T0.'_id'");
			builder.append(' ');
			selectDeep = builder.toString();
		}
		return selectDeep;
	}

	protected RetailBankingPayee loadCurrentDeep(Cursor cursor, boolean lock) {
		RetailBankingPayee entity = loadCurrent(cursor, 0, lock);
		int offset = getAllColumns().length;

		APCachedRequest aPCachedRequest = loadCurrentOther(
				daoSession.getAPCachedRequestDao(), cursor, offset);
		entity.setAPCachedRequest(aPCachedRequest);

		return entity;
	}

	public RetailBankingPayee loadDeep(Long key) {
		assertSinglePk();
		if (key == null) {
			return null;
		}

		StringBuilder builder = new StringBuilder(getSelectDeep());
		builder.append("WHERE ");
		SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
		String sql = builder.toString();

		String[] keyArray = new String[]{key.toString()};
		Cursor cursor = db.rawQuery(sql, keyArray);

		try {
			boolean available = cursor.moveToFirst();
			if (!available) {
				return null;
			} else if (!cursor.isLast()) {
				throw new IllegalStateException(
						"Expected unique result, but count was "
								+ cursor.getCount());
			}
			return loadCurrentDeep(cursor, true);
		} finally {
			cursor.close();
		}
	}

	/** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
	public List<RetailBankingPayee> loadAllDeepFromCursor(Cursor cursor) {
		int count = cursor.getCount();
		List<RetailBankingPayee> list = new ArrayList<RetailBankingPayee>(count);

		if (cursor.moveToFirst()) {
			if (identityScope != null) {
				identityScope.lock();
				identityScope.reserveRoom(count);
			}
			try {
				do {
					list.add(loadCurrentDeep(cursor, false));
				} while (cursor.moveToNext());
			} finally {
				if (identityScope != null) {
					identityScope.unlock();
				}
			}
		}
		return list;
	}

	protected List<RetailBankingPayee> loadDeepAllAndCloseCursor(Cursor cursor) {
		try {
			return loadAllDeepFromCursor(cursor);
		} finally {
			cursor.close();
		}
	}

	/** A raw-style query where you can pass any WHERE clause and arguments. */
	public List<RetailBankingPayee> queryDeep(String where,
			String... selectionArg) {
		Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
		return loadDeepAllAndCloseCursor(cursor);
	}

}
