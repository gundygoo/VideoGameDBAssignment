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

import com.oudersonstudios.videogamedbassignment.Models.VideoGame;
import com.oudersonstudios.videogamedbassignment.R;
import com.oudersonstudios.videogamedbassignment.Utils.Constants;

public class AddModifyVideoGameActivity extends AppCompatActivity {
    EditText videoGameName;
    EditText videoGamePublisher;
    EditText videoGameReleaseYear;
    EditText videoGameGenre;
    EditText videoGameRating;
    EditText videoGamePlatform;
    EditText videoGameSeries;
    Button saveVideoGameButton;
    Context context;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_modify_video_game);
        context = this;

        db = QueryAndResultActivity.getDB();

        videoGameName = (EditText) findViewById(R.id.videoGameNameEditText);
        videoGamePublisher = (EditText) findViewById(R.id.videoGamePublisherEditText);
        videoGameReleaseYear = (EditText) findViewById(R.id.videoGameReleaseYearEditText);
        videoGameGenre = (EditText) findViewById(R.id.videoGameGenreEditText);
        videoGameRating = (EditText) findViewById(R.id.videoGameRatingEditText);
        videoGamePlatform = (EditText) findViewById(R.id.videoGamePlatformEditText);
        videoGameSeries = (EditText) findViewById(R.id.videoGameSeriesEditText);

        saveVideoGameButton = (Button) findViewById(R.id.save_videoGame_button);
        saveVideoGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoGame videoGame = new VideoGame(
                        videoGameName.getText().toString(),
                        videoGamePublisher.getText().toString(),
                        videoGameReleaseYear.getText().toString(),
                        videoGameGenre.getText().toString(),
                        videoGameRating.getText().toString(),
                        videoGamePlatform.getText().toString(),
                        videoGameSeries.getText().toString()
                );
                createVideoGame(videoGame);
                Intent intent = new Intent(context, QueryAndResultActivity.class);
                startActivity(intent);
            }
        });
    }

    public long createVideoGame(VideoGame videoGame) {
        ContentValues videoGameValues = new ContentValues();
        videoGameValues.put(Constants.COLUMN_NAME_GAME_NAME, videoGame.getName());
        videoGameValues.put(Constants.COLUMN_NAME_PUBLISHER_VG, videoGame.getPublisher());
        videoGameValues.put(Constants.COLUMN_NAME_RELEASE_YEAR,  videoGame.getReleaseYear());
        videoGameValues.put(Constants.COLUMN_NAME_GENRE, videoGame.getGenre());
        videoGameValues.put(Constants.COLUMN_NAME_RATING, videoGame.getEsrbRating());
        videoGameValues.put(Constants.COLUMN_NAME_PLATFORM_VG, videoGame.getPlatform());
        videoGameValues.put(Constants.COLUMN_NAME_SERIES_NAME_VG, videoGame.getSeriesName());

        long videoGame_id = db.insert(Constants.VIDEO_GAME_TABLE_NAME, null, videoGameValues);

        return videoGame_id;
    }
}
