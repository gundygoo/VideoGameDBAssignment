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

import com.oudersonstudios.videogamedbassignment.Models.Platform;
import com.oudersonstudios.videogamedbassignment.R;
import com.oudersonstudios.videogamedbassignment.Utils.Constants;

public class AddModifyPlatformActivity extends AppCompatActivity {
    EditText platformName;
    EditText platformDeveloper;
    EditText platformYearReleased;
    Button savePlatformButton;
    Context context;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_modify_platform);
        context = this;

        db = QueryAndResultActivity.getDB();

        platformName = (EditText) findViewById(R.id.platformNameEditText);
        platformDeveloper = (EditText) findViewById(R.id.platformDeveloperEditText);
        platformYearReleased = (EditText) findViewById(R.id.platformYearEditText);

        savePlatformButton = (Button) findViewById(R.id.save_platform_button);
        savePlatformButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Platform newPlatform = new Platform(
                        platformName.getText().toString(),
                        platformDeveloper.getText().toString(),
                        platformYearReleased.getText().toString()
                );
                createPlatform(newPlatform);
                Intent intent = new Intent(context, QueryAndResultActivity.class);
                startActivity(intent);
            }
        });
    }

    public long createPlatform(Platform platform) {
        ContentValues platformValues = new ContentValues();
        platformValues.put(Constants.COLUMN_NAME_PLATFORM_PL, platform.getName());
        platformValues.put(Constants.COLUMN_NAME_DEVELOPER, platform.getDeveloper());
        platformValues.put(Constants.COLUMN_NAME_YEAR_RELEASED, platform.getYearReleased());

        long platform_id = db.insert(Constants.PLATFORM_TABLE_NAME, null, platformValues);

        return platform_id;
    }
}
