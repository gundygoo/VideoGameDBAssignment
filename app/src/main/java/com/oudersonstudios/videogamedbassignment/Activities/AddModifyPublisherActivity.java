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

import com.oudersonstudios.videogamedbassignment.Models.Publisher;
import com.oudersonstudios.videogamedbassignment.R;
import com.oudersonstudios.videogamedbassignment.Utils.Constants;

public class AddModifyPublisherActivity extends AppCompatActivity {
    EditText publisherName;
    EditText publisherLocation;
    EditText publisherYearEstablished;
    Button savePublisherButton;
    Context context;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_modify_publisher);
        context = this;

        db = QueryAndResultActivity.getDB();

        publisherName = (EditText) findViewById(R.id.publisherNameEditText);
        publisherLocation = (EditText) findViewById(R.id.publisherLocationEditText);
        publisherYearEstablished = (EditText) findViewById(R.id.publisherYearEditText);

        savePublisherButton = (Button) findViewById(R.id.save_publisher_button);
        savePublisherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Publisher newPublisher = new Publisher(
                        publisherName.getText().toString(),
                        publisherLocation.getText().toString(),
                        publisherYearEstablished.getText().toString()
                );
                createPublisher(newPublisher);
                Intent intent = new Intent(context, QueryAndResultActivity.class);
                startActivity(intent);
            }
        });
    }

    public long createPublisher(Publisher publisher) {
        ContentValues publisherValues = new ContentValues();
        publisherValues.put(Constants.COLUMN_NAME_PUBLISHER_PB, publisher.getName());
        publisherValues.put(Constants.COLUMN_NAME_PUBLISHER_LOCATION, publisher.getLocation());
        publisherValues.put(Constants.COLUMN_NAME_YEAR_ESTABLISHED, publisher.getYearEstablished());

        long publisher_id = db.insert(Constants.PUBLISHER_TABLE_NAME, null, publisherValues);

        return publisher_id;
    }
}
