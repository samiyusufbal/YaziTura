package com.yazbozkod.yazitura;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.view.View;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "YaziTuraYBK.db";
    public static final String TABLE_NAME = "Ayarlar";
    private static final String PARA_BIRIMI = "ParaBirimi";
    private static final String ARKA_PLAN = "ArkaPlan";
    private static final String TITRESIM = "Titresim";
    private static final String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
            "Id INTEGER PRIMARY KEY, " +
            "ParaBirimi NUMERIC DEFAULT 6, " +
            "ArkaPlan TEXT, " +
            "Titresim NUMERIC)";
    private static final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS TABLE_NAME";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int il) {
        db.execSQL(SQL_DELETE_TABLE);
        onCreate(db);
    }
    protected void updateArkaPlanRengi(int renkKaynagi, View view) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ARKA_PLAN, renkKaynagi);

        int updatedRows = db.update(TABLE_NAME, values, null, null);

        // Güncelleme işlemi başarısız ise yeni bir satır ekleyelim
        if (updatedRows == 0) {
            db.insert(TABLE_NAME, null, values);
        }
        int arkaPlanRenkKaynagi = getArkaPlanRengi();
        view.setBackgroundColor(arkaPlanRenkKaynagi);
        db.close();
    }
    protected int getArkaPlanRengi() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {ARKA_PLAN};
        Cursor cursor = db.query(TABLE_NAME, projection, null, null, null, null, null);
        int renkKaynagi = 0;

        if (cursor.moveToFirst()) {
            int renkColumnIndex = cursor.getColumnIndex(ARKA_PLAN);
            renkKaynagi = cursor.getInt(renkColumnIndex);
        }

        cursor.close();
        db.close();

        return renkKaynagi;
    }

    protected void updatePara(int para) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PARA_BIRIMI, para);

        int updatedRows = db.update(TABLE_NAME, values, null, null);

        // Güncelleme işlemi başarısız ise yeni bir satır ekleyelim
        if (updatedRows == 0) {
            db.insert(TABLE_NAME, null, values);
        }
        db.close();
    }

    protected int getPara() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {PARA_BIRIMI};
        Cursor cursor = db.query(TABLE_NAME, projection, null, null, null, null, null);
        int paraBirimi = 0;

        if (cursor.moveToFirst()) {
            int paraBirimiIndex = cursor.getColumnIndex(PARA_BIRIMI);
            paraBirimi = cursor.getInt(paraBirimiIndex);
        }

        cursor.close();
        db.close();

        return paraBirimi;
    }

    protected void updateTitresim(int deger) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TITRESIM, deger);

        int updatedRows = db.update(TABLE_NAME, values, null, null);

        // Güncelleme işlemi başarısız ise yeni bir satır ekleyelim
        if (updatedRows == 0) {
            db.insert(TABLE_NAME, null, values);
        }
        db.close();
    }

    protected int getTitresim() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {TITRESIM};
        Cursor cursor = db.query(TABLE_NAME, projection, null, null, null, null, null);
        int paraBirimi = 0;

        if (cursor.moveToFirst()) {
            int paraBirimiIndex = cursor.getColumnIndex(TITRESIM);
            paraBirimi = cursor.getInt(paraBirimiIndex);
        }

        cursor.close();
        db.close();

        return paraBirimi;
    }

    protected void startArkaPlanRengi(int renkKaynagi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ARKA_PLAN, renkKaynagi);

        boolean recordExists = checkRecordExists(db);

        if (!recordExists) {
            db.insert(TABLE_NAME, null, values);
        }

        db.close();
    }

    private boolean checkRecordExists(SQLiteDatabase db) {
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM " + TABLE_NAME, null);
        boolean recordExists = false;

        if (cursor != null && cursor.moveToFirst()) {
            int rowCount = cursor.getInt(0);
            recordExists = rowCount > 0;
            cursor.close();
        }

        return recordExists;
    }


}
