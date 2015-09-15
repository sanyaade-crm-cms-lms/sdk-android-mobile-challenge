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

import com.anypresence.anypresence_inc.citi_mobile_challenge.dao.RetailBankingRewardsCatalog;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table RETAILBANKINGREWARDSCATALOGS.
 */
public class RetailBankingRewardsCatalogDao
		extends
			AbstractDao<RetailBankingRewardsCatalog, Long> {

	public static final String TABLENAME = "RETAILBANKINGREWARDSCATALOGS";

	/**
	 * Properties of entity RetailBankingRewardsCatalog.<br/>
	 * Can be used for QueryBuilder and for referencing column names.
	 */
	public static class Properties {
		public final static Property Id = new Property(0, Long.class, "id",
				true, "_id");
		public final static Property ItemCategory = new Property(1,
				String.class, "itemCategory", false, "ITEM_CATEGORY");
		public final static Property ItemCode = new Property(2, String.class,
				"itemCode", false, "ITEM_CODE");
		public final static Property ItemDescription = new Property(3,
				String.class, "itemDescription", false, "ITEM_DESCRIPTION");
		public final static Property ItemName = new Property(4, String.class,
				"itemName", false, "ITEM_NAME");
		public final static Property PointRequired = new Property(5,
				Integer.class, "pointRequired", false, "POINT_REQUIRED");
		public final static Property PointsAvailable = new Property(6,
				Integer.class, "pointsAvailable", false, "POINTS_AVAILABLE");
		public final static Property Scope = new Property(7, String.class,
				"scope", false, "SCOPE");
		public final static Property ObjectId = new Property(8, String.class,
				"objectId", false, "OBJECT_ID");
		public final static Property _cacheUpdatedAt = new Property(9,
				java.util.Date.class, "_cacheUpdatedAt", false,
				"_CACHE_UPDATED_AT");
		public final static Property ApCachedRequestId = new Property(10,
				Long.class, "apCachedRequestId", false, "AP_CACHED_REQUEST_ID");
	};

	private DaoSession daoSession;

	public RetailBankingRewardsCatalogDao(DaoConfig config) {
		super(config);
	}

	public RetailBankingRewardsCatalogDao(DaoConfig config,
			DaoSession daoSession) {
		super(config, daoSession);
		this.daoSession = daoSession;
	}

	/** Creates the underlying database table. */
	public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
		String constraint = ifNotExists ? "IF NOT EXISTS " : "";
		db.execSQL("CREATE TABLE " + constraint
				+ "'RETAILBANKINGREWARDSCATALOGS' (" + //
				"'_id' INTEGER PRIMARY KEY ," + // 0: id
				"'ITEM_CATEGORY' TEXT," + // 1: itemCategory
				"'ITEM_CODE' TEXT," + // 2: itemCode
				"'ITEM_DESCRIPTION' TEXT," + // 3: itemDescription
				"'ITEM_NAME' TEXT," + // 4: itemName
				"'POINT_REQUIRED' INTEGER," + // 5: pointRequired
				"'POINTS_AVAILABLE' INTEGER," + // 6: pointsAvailable
				"'SCOPE' TEXT," + // 7: scope
				"'OBJECT_ID' TEXT," + // 8: objectId
				"'_CACHE_UPDATED_AT' INTEGER," + // 9: _cacheUpdatedAt
				"'AP_CACHED_REQUEST_ID' INTEGER);"); // 10: apCachedRequestId
		// Add Indexes
		db.execSQL("CREATE UNIQUE INDEX "
				+ constraint
				+ "IDX_RETAILBANKINGREWARDSCATALOGS_OBJECT_ID ON RETAILBANKINGREWARDSCATALOGS"
				+ " (OBJECT_ID);");
	}

	/** Drops the underlying database table. */
	public static void dropTable(SQLiteDatabase db, boolean ifExists) {
		String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "")
				+ "'RETAILBANKINGREWARDSCATALOGS'";
		db.execSQL(sql);
	}

	/** @inheritdoc */
	@Override
	protected void bindValues(SQLiteStatement stmt,
			RetailBankingRewardsCatalog entity) {
		stmt.clearBindings();

		Long id = entity.getId();
		if (id != null) {
			stmt.bindLong(1, id);
		}

		String itemCategory = entity.getItemCategory();
		if (itemCategory != null) {
			stmt.bindString(2, itemCategory);
		}

		String itemCode = entity.getItemCode();
		if (itemCode != null) {
			stmt.bindString(3, itemCode);
		}

		String itemDescription = entity.getItemDescription();
		if (itemDescription != null) {
			stmt.bindString(4, itemDescription);
		}

		String itemName = entity.getItemName();
		if (itemName != null) {
			stmt.bindString(5, itemName);
		}

		Integer pointRequired = entity.getPointRequired();
		if (pointRequired != null) {
			stmt.bindLong(6, pointRequired);
		}

		Integer pointsAvailable = entity.getPointsAvailable();
		if (pointsAvailable != null) {
			stmt.bindLong(7, pointsAvailable);
		}

		String scope = entity.getScope();
		if (scope != null) {
			stmt.bindString(8, scope);
		}

		String objectId = entity.getObjectId();
		if (objectId != null) {
			stmt.bindString(9, objectId);
		}

		java.util.Date _cacheUpdatedAt = entity.get_cacheUpdatedAt();
		if (_cacheUpdatedAt != null) {
			stmt.bindLong(10, _cacheUpdatedAt.getTime());
		}

		Long apCachedRequestId = entity.getApCachedRequestId();
		if (apCachedRequestId != null) {
			stmt.bindLong(11, apCachedRequestId);
		}
	}

	@Override
	protected void attachEntity(RetailBankingRewardsCatalog entity) {
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
	public RetailBankingRewardsCatalog readEntity(Cursor cursor, int offset) {
		RetailBankingRewardsCatalog entity = new RetailBankingRewardsCatalog(
				//
				cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
				cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // itemCategory
				cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // itemCode
				cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // itemDescription
				cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // itemName
				cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // pointRequired
				cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6), // pointsAvailable
				cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // scope
				cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // objectId
				cursor.isNull(offset + 9) ? null : new java.util.Date(cursor
						.getLong(offset + 9)), // _cacheUpdatedAt
				cursor.isNull(offset + 10) ? null : cursor.getLong(offset + 10) // apCachedRequestId
		);
		return entity;
	}

	/** @inheritdoc */
	@Override
	public void readEntity(Cursor cursor, RetailBankingRewardsCatalog entity,
			int offset) {
		entity.setId(cursor.isNull(offset + 0) ? null : cursor
				.getLong(offset + 0));
		entity.setItemCategory(cursor.isNull(offset + 1) ? null : cursor
				.getString(offset + 1));
		entity.setItemCode(cursor.isNull(offset + 2) ? null : cursor
				.getString(offset + 2));
		entity.setItemDescription(cursor.isNull(offset + 3) ? null : cursor
				.getString(offset + 3));
		entity.setItemName(cursor.isNull(offset + 4) ? null : cursor
				.getString(offset + 4));
		entity.setPointRequired(cursor.isNull(offset + 5) ? null : cursor
				.getInt(offset + 5));
		entity.setPointsAvailable(cursor.isNull(offset + 6) ? null : cursor
				.getInt(offset + 6));
		entity.setScope(cursor.isNull(offset + 7) ? null : cursor
				.getString(offset + 7));
		entity.setObjectId(cursor.isNull(offset + 8) ? null : cursor
				.getString(offset + 8));
		entity.set_cacheUpdatedAt(cursor.isNull(offset + 9)
				? null
				: new java.util.Date(cursor.getLong(offset + 9)));
		entity.setApCachedRequestId(cursor.isNull(offset + 10) ? null : cursor
				.getLong(offset + 10));
	}

	/** @inheritdoc */
	@Override
	protected Long updateKeyAfterInsert(RetailBankingRewardsCatalog entity,
			long rowId) {
		entity.setId(rowId);
		return rowId;
	}

	/** @inheritdoc */
	@Override
	public Long getKey(RetailBankingRewardsCatalog entity) {
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
			builder.append(" FROM RETAILBANKINGREWARDSCATALOGS T");
			builder.append(" LEFT JOIN APCACHED_REQUEST T0 ON T.'AP_CACHED_REQUEST_ID'=T0.'_id'");
			builder.append(' ');
			selectDeep = builder.toString();
		}
		return selectDeep;
	}

	protected RetailBankingRewardsCatalog loadCurrentDeep(Cursor cursor,
			boolean lock) {
		RetailBankingRewardsCatalog entity = loadCurrent(cursor, 0, lock);
		int offset = getAllColumns().length;

		APCachedRequest aPCachedRequest = loadCurrentOther(
				daoSession.getAPCachedRequestDao(), cursor, offset);
		entity.setAPCachedRequest(aPCachedRequest);

		return entity;
	}

	public RetailBankingRewardsCatalog loadDeep(Long key) {
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
	public List<RetailBankingRewardsCatalog> loadAllDeepFromCursor(Cursor cursor) {
		int count = cursor.getCount();
		List<RetailBankingRewardsCatalog> list = new ArrayList<RetailBankingRewardsCatalog>(
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

	protected List<RetailBankingRewardsCatalog> loadDeepAllAndCloseCursor(
			Cursor cursor) {
		try {
			return loadAllDeepFromCursor(cursor);
		} finally {
			cursor.close();
		}
	}

	/** A raw-style query where you can pass any WHERE clause and arguments. */
	public List<RetailBankingRewardsCatalog> queryDeep(String where,
			String... selectionArg) {
		Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
		return loadDeepAllAndCloseCursor(cursor);
	}

}
