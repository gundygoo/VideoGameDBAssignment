package com.oudersonstudios.videogamedbassignment.AsyncTasks;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;

import com.oudersonstudios.videogamedbassignment.Activities.QueryAndResultActivity;

/**
 * Created by Erik on 4/30/2017.
 */

public class LoadDatabase extends AsyncTask<Object, Void, SQLiteDatabase> {
    QueryAndResultActivity callingActivity = null;
    @Override
    protected SQLiteDatabase doInBackground(Object... params) {
        SQLiteOpenHelper helper = (SQLiteOpenHelper) params[0];
        callingActivity = (QueryAndResultActivity) params[1];
        SQLiteDatabase writableDatabase = helper.getWritableDatabase();
        return writableDatabase;
    }

    @Override
    protected void onPostExecute(SQLiteDatabase db){
        callingActivity.setDB(db);
    }
}
