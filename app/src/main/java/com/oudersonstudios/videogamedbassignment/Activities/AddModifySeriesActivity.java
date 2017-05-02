package com.oudersonstudios.videogamedbassignment.Activities;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.oudersonstudios.videogamedbassignment.Models.Series;
import com.oudersonstudios.videogamedbassignment.R;
import com.oudersonstudios.videogamedbassignment.Utils.Constants;

public class AddModifySeriesActivity extends AppCompatActivity {
    EditText seriesName;
    EditText seriesNumberGames;
    EditText seriesYearStarted;
    Button saveSeriesButton;
    Context context;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_modify_series);
        context = this;

        db = QueryAndResultActivity.getDB();

        seriesName = (EditText) findViewById(R.id.seriesNameEditText);
        seriesNumberGames = (EditText) findViewById(R.id.seriesGameNumberEditText);
        seriesYearStarted = (EditText) findViewById(R.id.seriesYearEditText);

        saveSeriesButton = (Button) findViewById(R.id.save_series_button);
        saveSeriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Series newSeries = new Series(
                        seriesName.getText().toString(),
                        seriesNumberGames.getText().toString(),
                        seriesYearStarted.getText().toString()
                );
                createSeries(newSeries);
                Intent intent = new Intent(context, QueryAndResultActivity.class);
                startActivity(intent);
            }
        });
    }

    public long createSeries(Series series) {
        ContentValues seriesValues = new ContentValues();
        seriesValues.put(Constants.COLUMN_NAME_SERIES_NAME_SR, series.getName());
        seriesValues.put(Constants.COLUMN_NAME_NUMBER_GAMES, series.getNumberOfGames());
        seriesValues.put(Constants.COLUMN_NAME_YEAR_STARTED, series.getYearStarted());

        long series_id = db.insert(Constants.SERIES_TABLE_NAME, null, seriesValues);

        return series_id;
    }
}
