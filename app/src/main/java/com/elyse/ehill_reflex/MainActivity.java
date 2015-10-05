package com.elyse.ehill_reflex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FileManager allStats = new FileManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /*
     * Instructions used from main Android Developer Instructions for all three methods
     *
     * http://developer.android.com/training/basics/firstapp/starting-activity.html
     * retrieved: Oct 3, 2015
     */

    /* Called when the user clicks on the "Test Your Reaction" button */
    public void startReactionTest(View view){
        Intent intent = new Intent(this, ReactionTestActivity.class);
        startActivity(intent);
    }
    /* Called when the user clicks on the "Play With Your Friends" button */
    public void startGameShow(View view){
        Intent intent = new Intent(this, GameShowActivity.class);
        startActivity(intent);

    }
    /* Called when the user clicks on the "Your Stats" button*/
    public void showStatistics(View view){
        Intent intent = new Intent(this, StatisticsActivity.class);
        startActivity(intent);

    }
}
