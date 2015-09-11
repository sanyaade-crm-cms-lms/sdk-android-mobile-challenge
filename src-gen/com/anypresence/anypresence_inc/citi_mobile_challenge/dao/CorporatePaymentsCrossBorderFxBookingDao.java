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

import com.anypresence.anypresence_inc.citi_mobile_challenge.dao.CorporatePaymentsCrossBorderFxBooking;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table CORPORATEPAYMENTSCROSSBORDERFXBOOKINGS.
 */
public class CorporatePaymentsCrossBorderFxBookingDao
		extends
			AbstractDao<CorporatePaymentsCrossBorderFxBooking, Long> {

	public static final String TABLENAME = "CORPORATEPAYMENTSCROSSBORDERFXBOOKINGS";

	/**
	 * Properties of entity CorporatePaymentsCrossBorderFxBooking.<br/>
	 * Can be used for QueryBuilder and for referencing column names.
	 */
	public static class Properties {
		public final static Property Id = new Property(0, Long.class, "id",
				true, "_id");
		public final static Property AcceptedOn = new Property(1, String.class,
				"acceptedOn", false, "ACCEPTED_ON");
		public final static Property AcceptedBy = new Property(2, String.class,
				"acceptedBy", false, "ACCEPTED_BY");
		public final static Property RateReference = new Property(3,
				String.class, "rateReference", false, "RATE_REFERENCE");
		public final static Property Scope = new Property(4, String.class,
				"scope", false, "SCOPE");
		public final static Property ObjectId = new Property(5, String.class,
				"objectId", false, "OBJECT_ID");
		public final static Property _cacheUpdatedAt = new Property(6,
				java.util.Date.class, "_cacheUpdatedAt", false,
				"_CACHE_UPDATED_AT");
		public final static Property ApCachedRequestId = new Property(7,
				Long.class, "apCachedRequestId", false, "AP_CACHED_REQUEST_ID");
	};

	private DaoSession daoSession;

	public CorporatePaymentsCrossBorderFxBookingDao(DaoConfig config) {
		super(config);
	}

	public CorporatePaymentsCrossBorderFxBookingDao(DaoConfig config,
			DaoSession daoSession) {
		super(config, daoSession);
		this.daoSession = daoSession;
	}

	/** Creates the underlying database table. */
	public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
		String constraint = ifNotExists ? "IF NOT EXISTS " : "";
		db.execSQL("CREATE TABLE " + constraint
				+ "'CORPORATEPAYMENTSCROSSBORDERFXBOOKINGS' (" + //
				"'_id' INTEGER PRIMARY KEY ," + // 0: id
				"'ACCEPTED_ON' TEXT," + // 1: acceptedOn
				"'ACCEPTED_BY' TEXT," + // 2: acceptedBy
				"'RATE_REFERENCE' TEXT," + // 3: rateReference
				"'SCOPE' TEXT," + // 4: scope
				"'OBJECT_ID' TEXT," + // 5: objectId
				"'_CACHE_UPDATED_AT' INTEGER," + // 6: _cacheUpdatedAt
				"'AP_CACHED_REQUEST_ID' INTEGER);"); // 7: apCachedRequestId
		// Add Indexes
		db.execSQL("CREATE UNIQUE INDEX "
				+ constraint
				+ "IDX_CORPORATEPAYMENTSCROSSBORDERFXBOOKINGS_OBJECT_ID ON CORPORATEPAYMENTSCROSSBORDERFXBOOKINGS"
				+ " (OBJECT_ID);");
	}

	/** Drops the underlying database table. */
	public static void dropTable(SQLiteDatabase db, boolean ifExists) {
		String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "")
				+ "'CORPORATEPAYMENTSCROSSBORDERFXBOOKINGS'";
		db.execSQL(sql);
	}

	/** @inheritdoc */
	@Override
	protected void bindValues(SQLiteStatement stmt,
			CorporatePaymentsCrossBorderFxBooking entity) {
		stmt.clearBindings();

		Long id = entity.getId();
		if (id != null) {
			stmt.bindLong(1, id);
		}

		String acceptedOn = entity.getAcceptedOn();
		if (acceptedOn != null) {
			stmt.bindString(2, acceptedOn);
		}

		String acceptedBy = entity.getAcceptedBy();
		if (acceptedBy != null) {
			stmt.bindString(3, acceptedBy);
		}

		String rateReference = entity.getRateReference();
		if (rateReference != null) {
			stmt.bindString(4, rateReference);
		}

		String scope = entity.getScope();
		if (scope != null) {
			stmt.bindString(5, scope);
		}

		String objectId = entity.getObjectId();
		if (objectId != null) {
			stmt.bindString(6, objectId);
		}

		java.util.Date _cacheUpdatedAt = entity.get_cacheUpdatedAt();
		if (_cacheUpdatedAt != null) {
			stmt.bindLong(7, _cacheUpdatedAt.getTime());
		}

		Long apCachedRequestId = entity.getApCachedRequestId();
		if (apCachedRequestId != null) {
			stmt.bindLong(8, apCachedRequestId);
		}
	}

	@Override
	protected void attachEntity(CorporatePaymentsCrossBorderFxBooking entity) {
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
	public CorporatePaymentsCrossBorderFxBooking readEntity(Cursor cursor,
			int offset) {
		CorporatePaymentsCrossBorderFxBooking entity = new CorporatePaymentsCrossBorderFxBooking(
				//
				cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
				cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // acceptedOn
				cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // acceptedBy
				cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // rateReference
				cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // scope
				cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // objectId
				cursor.isNull(offset + 6) ? null : new java.util.Date(cursor
						.getLong(offset + 6)), // _cacheUpdatedAt
				cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7) // apCachedRequestId
		);
		return entity;
	}

	/** @inheritdoc */
	@Override
	public void readEntity(Cursor cursor,
			CorporatePaymentsCrossBorderFxBooking entity, int offset) {
		entity.setId(cursor.isNull(offset + 0) ? null : cursor
				.getLong(offset + 0));
		entity.setAcceptedOn(cursor.isNull(offset + 1) ? null : cursor
				.getString(offset + 1));
		entity.setAcceptedBy(cursor.isNull(offset + 2) ? null : cursor
				.getString(offset + 2));
		entity.setRateReference(cursor.isNull(offset + 3) ? null : cursor
				.getString(offset + 3));
		entity.setScope(cursor.isNull(offset + 4) ? null : cursor
				.getString(offset + 4));
		entity.setObjectId(cursor.isNull(offset + 5) ? null : cursor
				.getString(offset + 5));
		entity.set_cacheUpdatedAt(cursor.isNull(offset + 6)
				? null
				: new java.util.Date(cursor.getLong(offset + 6)));
		entity.setApCachedRequestId(cursor.isNull(offset + 7) ? null : cursor
				.getLong(offset + 7));
	}

	/** @inheritdoc */
	@Override
	protected Long updateKeyAfterInsert(
			CorporatePaymentsCrossBorderFxBooking entity, long rowId) {
		entity.setId(rowId);
		return rowId;
	}

	/** @inheritdoc */
	@Override
	public Long getKey(CorporatePaymentsCrossBorderFxBooking entity) {
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
			builder.append(" FROM CORPORATEPAYMENTSCROSSBORDERFXBOOKINGS T");
			builder.append(" LEFT JOIN APCACHED_REQUEST T0 ON T.'AP_CACHED_REQUEST_ID'=T0.'_id'");
			builder.append(' ');
			selectDeep = builder.toString();
		}
		return selectDeep;
	}

	protected CorporatePaymentsCrossBorderFxBooking loadCurrentDeep(
			Cursor cursor, boolean lock) {
		CorporatePaymentsCrossBorderFxBooking entity = loadCurrent(cursor, 0,
				lock);
		int offset = getAllColumns().length;

		APCachedRequest aPCachedRequest = loadCurrentOther(
				daoSession.getAPCachedRequestDao(), cursor, offset);
		entity.setAPCachedRequest(aPCachedRequest);

		return entity;
	}

	public CorporatePaymentsCrossBorderFxBooking loadDeep(Long key) {
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
	public List<CorporatePaymentsCrossBorderFxBooking> loadAllDeepFromCursor(
			Cursor cursor) {
		int count = cursor.getCount();
		List<CorporatePaymentsCrossBorderFxBooking> list = new ArrayList<CorporatePaymentsCrossBorderFxBooking>(
				count);

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

	protected List<CorporatePaymentsCrossBorderFxBooking> loadDeepAllAndCloseCursor(
			Cursor cursor) {
		try {
			return loadAllDeepFromCursor(cursor);
		} finally {
			cursor.close();
		}
	}

	/** A raw-style query where you can pass any WHERE clause and arguments. */
	public List<CorporatePaymentsCrossBorderFxBooking> queryDeep(String where,
			String... selectionArg) {
		Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
		return loadDeepAllAndCloseCursor(cursor);
	}

}
