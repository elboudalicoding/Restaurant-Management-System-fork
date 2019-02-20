package tnt.crasher.restaurant_management_system.Database;

import android.content.Context;
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

    private static final String CREATE_FOOD_TABLE = "CREATE TABLE " + FOOD_TABLE + " (" +
            FOOD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            FOOD_NAME + " TEXT, " +
            FOOD_DESCRIPTION + " TEXT, " +
            FOOD_RATING + " TEXT, " +
            FOOD_PRICE + " TEXT, " +
            FOOD_TYPE + " INTEGER); ";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_FOOD_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + FOOD_TABLE);
        onCreate(db);
    }
}
