package com.example.lab3databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHandler extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "products";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_PRODUCT_NAME = "name";
    private static final String COLUMN_PRODUCT_PRICE = "price";
    private static final String DATABASE_NAME = "products.db";
    private static final int DATABASE_VERSION = 1;

    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table_cmd = "CREATE TABLE " + TABLE_NAME +
                "(" + COLUMN_ID + "INTEGER PRIMARY KEY, " +
                COLUMN_PRODUCT_NAME + " TEXT, " +
                COLUMN_PRODUCT_PRICE + " DOUBLE " + ")";

        db.execSQL(create_table_cmd);

        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCT_NAME, "Latte");
        values.put(COLUMN_PRODUCT_PRICE, 4.99);
        db.insert(TABLE_NAME, null, values);

        values.clear();
        values.put(COLUMN_PRODUCT_NAME, "Cappuccino");
        values.put(COLUMN_PRODUCT_PRICE, 5.49);
        db.insert(TABLE_NAME, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        return db.rawQuery(query, null); // returns "cursor" all products from the table
    }

    public void addProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_PRODUCT_NAME, product.getProductName());
        values.put(COLUMN_PRODUCT_PRICE, product.getProductPrice());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Cursor findProductByName(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME +
                " WHERE " + COLUMN_PRODUCT_NAME + " = ?";
        String[] selectionArgs = {name};

        return db.rawQuery(query, selectionArgs);
    }

    public Cursor findProductByPrice(double price){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME +
                " WHERE " + COLUMN_PRODUCT_PRICE + " = ?";
        String[] selectionArgs = {String.valueOf(price)};

        return db.rawQuery(query, selectionArgs);
    }

    public Cursor findProductByNameAndPrice(String name, double price) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_NAME +
                " WHERE " + COLUMN_PRODUCT_NAME + " = ? AND " + COLUMN_PRODUCT_PRICE + " = ?";

        String[] selectionArgs = {
                name,
                String.valueOf(price)
        };

        return db.rawQuery(query, selectionArgs);
    }

    public void deleteProductByNameAndPrice(String name, double price) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(
            TABLE_NAME,
                null,
                COLUMN_PRODUCT_NAME +"=? AND "+ COLUMN_PRODUCT_PRICE + "=?",
                new String[]{name, String.valueOf(price)},
                null, null, null
        );
        if (cursor.moveToFirst()) {
            db.delete(TABLE_NAME, COLUMN_PRODUCT_NAME +"=? AND "+ COLUMN_PRODUCT_PRICE + "=?", new String[]{name, String.valueOf(price)});
        }

        db.close();
    }
}
