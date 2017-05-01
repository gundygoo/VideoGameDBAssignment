package com.oudersonstudios.videogamedbassignment.Utils;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;

import com.oudersonstudios.videogamedbassignment.Activities.AddModifyPlatformActivity;
import com.oudersonstudios.videogamedbassignment.Activities.AddModifyPublisherActivity;
import com.oudersonstudios.videogamedbassignment.Activities.AddModifySeriesActivity;
import com.oudersonstudios.videogamedbassignment.Activities.AddModifyVideoGameActivity;
import com.oudersonstudios.videogamedbassignment.R;

/**
 * Created by Erik on 3/20/2017.
 */

public class HandleMenu {
    public static boolean onOMenuItemSelected(MenuItem item, Activity act){
        int id = item.getItemId();
        Intent intent = null;

        switch(id){
            case R.id.action_addPlatformActivity:
                if (act.getClass() != AddModifyPlatformActivity.class){
                    intent = new Intent(act, AddModifyPlatformActivity.class);
                    act.startActivity(intent);
                    return true;
                }
                Toast.makeText(act.getBaseContext(), "Clicked on Current Activity", Toast.LENGTH_SHORT).show();
                return false;

            case R.id.action_addPublisherActivity:
                if (act.getClass() != AddModifyPublisherActivity.class){
                    intent = new Intent(act, AddModifyPublisherActivity.class);
                    act.startActivity(intent);
                    return true;
                }
                Toast.makeText(act.getBaseContext(), "Clicked on Current Activity", Toast.LENGTH_SHORT).show();
                return false;

            case R.id.action_addSeriesActivity:
                if (act.getClass() != AddModifySeriesActivity.class){
                    intent = new Intent(act, AddModifySeriesActivity.class);
                    act.startActivity(intent);
                    return true;
                }
                Toast.makeText(act.getBaseContext(), "Clicked on Current Activity", Toast.LENGTH_SHORT).show();
                return false;

            case R.id.action_addVideoGameActivity:
                if (act.getClass() != AddModifyVideoGameActivity.class){
                    intent = new Intent(act, AddModifyVideoGameActivity.class);
                    act.startActivity(intent);
                    return true;
                }
                Toast.makeText(act.getBaseContext(), "Clicked on Current Activity", Toast.LENGTH_SHORT).show();
                return false;
        }
        return false;
    }
}
