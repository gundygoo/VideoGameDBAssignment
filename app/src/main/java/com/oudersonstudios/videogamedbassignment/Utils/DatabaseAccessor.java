package com.oudersonstudios.videogamedbassignment.Utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Erik on 4/18/2017.
 */

public class DatabaseAccessor extends SQLiteOpenHelper{
    private static final String CREATE_TABLE_VIDEO_GAMES = "CREATE TABLE "
            + Constants.VIDEO_GAME_TABLE_NAME + "(" +
            Constants.COLUMN_NAME_GAME_NAME + " TEXT PRIMARY KEY," +
            Constants.COLUMN_NAME_PUBLISHER_VG + " TEXT," +
            Constants.COLUMN_NAME_RELEASE_YEAR + " TEXT," +
            Constants.COLUMN_NAME_GENRE + " TEXT," +
            Constants.COLUMN_NAME_RATING + " TEXT," +
            Constants.COLUMN_NAME_PLATFORM_VG + " TEXT," +
            Constants.COLUMN_NAME_SERIES_NAME_VG + " TEXT" + ")";

    private static final String CREATE_TABLE_PUBLISHERS = "CREATE TABLE "
            + Constants.PUBLISHER_TABLE_NAME + "(" +
            Constants.COLUMN_NAME_PUBLISHER_PB + " TEXT PRIMARY KEY," +
            Constants.COLUMN_NAME_PUBLISHER_LOCATION + " TEXT," +
            Constants.COLUMN_NAME_YEAR_ESTABLISHED + " TEXT" + ")";

    private static final String CREATE_TABLE_PLATFORMS = "CREATE TABLE "
            + Constants.PLATFORM_TABLE_NAME + "(" +
            Constants.COLUMN_NAME_PLATFORM_PL + " TEXT PRIMARY KEY," +
            Constants.COLUMN_NAME_DEVELOPER + " TEXT," +
            Constants.COLUMN_NAME_YEAR_RELEASED + " TEXT" + ")";

    //TODO add series table creation
    public DatabaseAccessor (Context context){
        super(context, Constants.VIDEO_GAME_DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_VIDEO_GAMES);
        sqLiteDatabase.execSQL(CREATE_TABLE_PUBLISHERS);
        sqLiteDatabase.execSQL(CREATE_TABLE_PLATFORMS);
        //TODO add series table
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Constants.VIDEO_GAME_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Constants.PUBLISHER_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Constants.PLATFORM_TABLE_NAME);
        //TODO add series table

        onCreate(sqLiteDatabase);
    }
}
