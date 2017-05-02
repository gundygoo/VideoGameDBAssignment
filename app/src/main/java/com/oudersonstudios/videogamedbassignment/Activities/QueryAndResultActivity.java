package com.oudersonstudios.videogamedbassignment.Activities;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.oudersonstudios.videogamedbassignment.AsyncTasks.LoadDatabase;
import com.oudersonstudios.videogamedbassignment.R;
import com.oudersonstudios.videogamedbassignment.Utils.Constants;
import com.oudersonstudios.videogamedbassignment.Utils.DatabaseAccessor;
import com.oudersonstudios.videogamedbassignment.Utils.HandleMenu;

import java.util.ArrayList;
import java.util.List;

public class QueryAndResultActivity extends AppCompatActivity {
    String tableSelection = "";
    static SQLiteDatabase db = null;
    DatabaseAccessor dbAccessor;
    Button runQueryButton;
    EditText nameEntry;
    List<String> returnedFromQuery = new ArrayList<>();
    ListView queryResultsList;
    Context context;
    ShareActionProvider mActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_and_result);
        context = this;

        Spinner tableSelectSpinner = (Spinner) findViewById(R.id.tableSelectDropdown);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(context, R.array.tables_array, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tableSelectSpinner.setAdapter(spinnerAdapter);
        tableSelectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                tableSelection = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //TODO anything??
            }
        });

        nameEntry = (EditText) findViewById(R.id.queryEditTextBox);

        queryResultsList = (ListView) findViewById(R.id.queryResultListView);
        ArrayAdapter listAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, returnedFromQuery);
        queryResultsList.setAdapter(listAdapter);

        runQueryButton = (Button) findViewById(R.id.runQueryButton);
        runQueryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tableSelection.equals("")){
                    Toast.makeText(context, "Please Select Which Table You Would Like To Query From", Toast.LENGTH_SHORT).show();
                }
                else {
                    runQueryButton.setText("Running Query...");
                    runQueryButton.setClickable(false);

                    //perform select query here
                    String selectQuery = "";
                    String nameColumnName = "";
                    switch(tableSelection){
                        case "Video Games":
                            selectQuery = "SELECT * FROM " + Constants.VIDEO_GAME_TABLE_NAME +
                                    " WHERE " + Constants.COLUMN_NAME_GAME_NAME + " LIKE '%" + nameEntry.getText().toString() + "%'";
                            nameColumnName = Constants.COLUMN_NAME_GAME_NAME;
                            break;
                        case "Platforms":
                            selectQuery = "SELECT * FROM " + Constants.PLATFORM_TABLE_NAME +
                                    " WHERE " + Constants.COLUMN_NAME_PLATFORM_PL + " LIKE '%" + nameEntry.getText().toString() + "%'";
                            nameColumnName = Constants.COLUMN_NAME_PLATFORM_PL;
                            break;
                        case "Publishers":
                            selectQuery = "SELECT * FROM " + Constants.PUBLISHER_TABLE_NAME +
                                    " WHERE " + Constants.COLUMN_NAME_PUBLISHER_PB + " LIKE '%" + nameEntry.getText().toString() + "%'";
                            nameColumnName = Constants.COLUMN_NAME_PUBLISHER_PB;
                            break;
                        case "Series":
                            selectQuery = "SELECT * FROM " + Constants.SERIES_TABLE_NAME +
                                    " WHERE " + Constants.COLUMN_NAME_SERIES_NAME_SR + " LIKE '%" + nameEntry.getText().toString() + "%'";
                            nameColumnName = Constants.COLUMN_NAME_SERIES_NAME_SR;
                            break;
                        default:
                            Toast.makeText(context, "You did not select a valid table to query from.  Please try again after making a selection", Toast.LENGTH_SHORT).show();
                    }

                    if (!selectQuery.equals("")){
                        Cursor cursor = db.rawQuery(selectQuery, null);
                        returnedFromQuery = new ArrayList<String>();
                        if (cursor != null){
                            if (cursor.moveToFirst()){
                                do {
                                    returnedFromQuery.add(cursor.getString(cursor.getColumnIndex(nameColumnName)));
                                } while (cursor.moveToNext());
                            }
                            cursor.close();
                        }
                    }

                    ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, returnedFromQuery);
                    queryResultsList.setAdapter(adapter);
                    runQueryButton.setText("Run Query");
                    runQueryButton.setClickable(true);
                }
            }
        });

        if (db == null){
            dbAccessor = new DatabaseAccessor(this);

            Object[] params = new Object[2];
            params[0] = dbAccessor;
            params[1] = this;
            new LoadDatabase().execute(params);
        }
    }

    public void setDB(SQLiteDatabase db){
        this.db = db;
        runQueryButton.setText("Run Query");
        runQueryButton.setClickable(true);
    }

    public static SQLiteDatabase getDB(){
        return db;
    }

    @Override
    protected void onDestroy(){
        if (db != null && db.isOpen()){
            db.close();
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_toolbar_menu, menu);

        MenuItem shareItem = menu.findItem(R.menu.main_toolbar_menu);

        // To retrieve the Action Provider
        mActionProvider = (ShareActionProvider)
                MenuItemCompat.getActionProvider(shareItem);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (!HandleMenu.onOMenuItemSelected(item, this)) {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

}
