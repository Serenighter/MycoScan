package com.example.mycoscan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MushroomDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mushrooms.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "mushrooms";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_EDIBILITY = "edibility";
    public static final String COLUMN_IMAGE = "image";

    private Context context;  // Zmienna kontekstu, aby mieć dostęp do context.deleteDatabase()

    // Konstruktor
    public MushroomDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;  // Inicjalizowanie kontekstu
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_EDIBILITY + " INTEGER, " +
                COLUMN_IMAGE + " BLOB)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Metoda do usuwania bazy danych
    public void deleteDatabase() {
        context.deleteDatabase(DATABASE_NAME);  // Usuwa plik bazy danych
    }

    // Inne metody bazy danych (np. insert, update, get)
    public void insertMushroom(String title, String description, int edibility, byte[] image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_DESCRIPTION, description);
        values.put(COLUMN_EDIBILITY, edibility);
        values.put(COLUMN_IMAGE, image);

        db.insert(TABLE_NAME, null, values);
    }

    public Cursor getAllMushrooms() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_NAME, null, null, null, null, null, null);
    }

    public void insertOrUpdateMushroom(String title, String description, int edibility, byte[] image) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_TITLE + "=?", new String[]{title}, null, null, null);

        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_DESCRIPTION, description);
        values.put(COLUMN_EDIBILITY, edibility);
        values.put(COLUMN_IMAGE, image);

        if (cursor != null && cursor.moveToFirst()) {
            db.update(TABLE_NAME, values, COLUMN_TITLE + "=?", new String[]{title});
        } else {
            db.insert(TABLE_NAME, null, values);
        }

        if (cursor != null) {
            cursor.close();
        }
        db.close();
    }
    public void clearAllMushrooms() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null); // Usuwa wszystkie rekordy z tabeli
        db.close();
    }

}
