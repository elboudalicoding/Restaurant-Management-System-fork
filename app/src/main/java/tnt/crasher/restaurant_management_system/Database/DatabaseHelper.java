package tnt.crasher.restaurant_management_system.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Information

    private static final String DATABASE_NAME = "Restaurant.db";
    private static final int DATABASE_VERSION = 1;

    // Menu Table
    private static final String FOOD_TABLE = "tbl_food";
    private static final String FOOD_ID = "food_id";
    private static final String FOOD_NAME = "food_name";
    private static final String FOOD_DESCRIPTION = "food_description";
    private static final String FOOD_RATING = "food_rating";
    private static final String FOOD_PRICE = "food_price";
    private static final String FOOD_TYPE = "food_food";

    //
    private static final String FOOD_AMOUNT = "food_amount";

    private static final String CREATE_FOOD_TABLE = "CREATE TABLE " + FOOD_TABLE + " (" +
            FOOD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            FOOD_NAME + " TEXT, " +
            FOOD_DESCRIPTION + " TEXT, " +
            FOOD_RATING + " DOUBLE, " +
            FOOD_PRICE + " DOUBLE, " +
            FOOD_TYPE + " INTEGER); ";

    // Staff Table
    private static final String STAFF_TABLE  = "tbl_staff";
    private static final String STAFF_ID = "staff_id";
    private static final String STAFF_LASTNAME = "staff_lname";
    private static final String STAFF_FIRSTNAME = "staff_fname";
    private static final String STAFF_POSITION = "staff_position";
    private static final String STAFF_TIME_IN = "staff_time_in";
    private static final String STAFF_TIME_OUT = "staff_time_out";

    private static final String CREATE_STAFF_TABLE = "CREATE TABLE " + STAFF_TABLE + " (" +
            STAFF_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            STAFF_LASTNAME + " TEXT, " +
            STAFF_FIRSTNAME + " TEXT, " +
            STAFF_POSITION + " TEXT, " +
            STAFF_TIME_IN + " TEXT, " +
            STAFF_TIME_OUT + " TEXT)";

    // Membership Table
    private static final String MEMBER_TABLE = "tbl_member";
    private static final String MEMBER_ID = "member_id";
    private static final String MEMBER_LASTNAME = "member_lname";
    private static final String MEMBER_FIRSTNAME = "member_fname";
    private static final String MEMBER_STATUS = "member_status";

    private static final String CREATE_MEMBER_TABLE = "CREATE TABLE " + MEMBER_TABLE + " (" +
            MEMBER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            MEMBER_LASTNAME + " TEXT, " +
            MEMBER_FIRSTNAME + " TEXT, " +
            MEMBER_STATUS + " TEXT)";


    // History Table
    private static final String HISTORY_TABLE = "tbl_history";
    private static final String HISTORY_ID = "history_id";
    private static final String HISTORY_TIME = "history_time";

    private static final String CREATE_HISTORY_TABLE = "CREATE TABLE " + HISTORY_TABLE + "(" +
            HISTORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            HISTORY_TIME + " TEXT, " +
            FOOD_NAME + " TEXT," +
            FOOD_AMOUNT + " INTEGER);";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_FOOD_TABLE);
        db.execSQL(CREATE_STAFF_TABLE);
        db.execSQL(CREATE_MEMBER_TABLE);
        db.execSQL(CREATE_HISTORY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + FOOD_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + STAFF_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + MEMBER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + HISTORY_TIME);
        onCreate(db);
    }

    // INSERT NEW MENU
    public boolean addMenu(String name, String description, double rating, double price, int type){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(FOOD_NAME, name);
        contentValues.put(FOOD_DESCRIPTION, description);
        contentValues.put(FOOD_RATING, rating);
        contentValues.put(FOOD_PRICE, price);
        contentValues.put(FOOD_TYPE, type);

        long results = db.insert(FOOD_TABLE, null, contentValues);

        if(results == -1)
            return false;
        else
            return true;
    }

    // REGISTER NEW STAFF

    public boolean addStaff(String lastname, String firstname, String position, String timeIn, String timeOut){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(STAFF_LASTNAME, lastname);
        contentValues.put(STAFF_FIRSTNAME, firstname);
        contentValues.put(STAFF_POSITION, position);
        contentValues.put(STAFF_TIME_IN, timeIn);
        contentValues.put(STAFF_TIME_OUT, timeOut);

        long results = db.insert(STAFF_TABLE, null, contentValues);

        if(results == -1)
            return false;
        else
            return true;
    }

    public Cursor getStaff(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + STAFF_TABLE + ";";
        Cursor data = db.rawQuery(query, null);
        return data;
    }


    // Register a member

    public boolean addMember(String lastname, String firstname, String status){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MEMBER_LASTNAME, lastname);
        contentValues.put(MEMBER_FIRSTNAME, firstname);
        contentValues.put(MEMBER_STATUS, status);

        long results = db.insert(MEMBER_TABLE, null, contentValues);

        if(results == -1)
            return false;
        else
            return true;
    }

    // Add History

    public boolean addHistory(String time, String food_name, int food_amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(HISTORY_TIME, time);
        contentValues.put(FOOD_NAME, food_name);
        contentValues.put(FOOD_AMOUNT, food_amount);

        long results = db.insert(HISTORY_TABLE, null, contentValues);

        if (results == -1)
            return false;
        else
            return true;
    }

    // Get Menu

    public Cursor getMenu(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + FOOD_TABLE + ";";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getMenu(int type){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + FOOD_TABLE + " WHERE " + FOOD_TYPE + "=" + type + ";";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

}
