package com.elyse.ehill_reflex;

import android.view.View;

/**
 * Created by Elyse on 10/4/2015.
 */
public class FileManager {

    private static final String REFLEXFILE = "file.sav";
    protected Statistics filesStats;

    public void updateWinner(int i){
        filesStats.IncrementWinnerCount(i);
    }

    public void updateReactionTimes(long i){
        filesStats.addReactionTimes(i);
    }

    public void load(){
        //load from disk
    }

    public void save(){
        //save to disk
    }

    public void clearAllStatistics(){
        filesStats.clearAll();
        //save
    }

}
