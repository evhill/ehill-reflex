package com.elyse.ehill_reflex;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Elyse on 10/4/2015.
 */
public class StatisticsActivity extends MainActivity{

    Button clearButton;
    EditText maximumTime;
    EditText minimumTime;
    EditText averageTime;
    EditText medianTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics);
        clearButton =(Button) findViewById(R.id.ClearButton);

        //maximumTime = (EditTextView) findViewById(R.id.MaximumTimeField);
        //minimumTime = (EditText) findViewById(R.id.MinimumTimeField);
        //averageTime = (EditText) findViewById(R.id.AverageTimeField);
        //medianTime = (EditText) findViewById(R.id.MedianTimeField);

        setStatsView();
    }

    /*
     * Use an AlertDialog to choose what statistics to show. We want the min/max/average/median
     * values of: All reactions, last 10 reactions, and last 100 reactions. We will populate
     */

    // Clear Statistics
    public void ClearStatistics(){
        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                allStats.clearAllStatistics();
            }
        });
    }

    /* The setStatsView would call the getMax, metMin etc on the AllStats object and then set the
     * appropriate text field */
    public void setStatsView(){
        //maximumField =....
    }
    // Send Email
    public void SendStatisticsEmail(){

    }
}
