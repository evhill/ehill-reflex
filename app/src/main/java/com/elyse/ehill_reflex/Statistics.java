package com.elyse.ehill_reflex;

import android.content.Intent;

import java.util.ArrayList;

/**
 * Created by Elyse on 10/4/2015.
 *
 * This project is part of Elyse Hill's Reflex Game Project: ehill-reflex.

         ehill-reflex is free software: you can redistribute it and/or modify
         it under the terms of the GNU General Public License as published by
         the Free Software Foundation, either version 3 of the License, or
         (at your option) any later version.

         ehill-reflex is distributed in the hope that it will be useful,
         but WITHOUT ANY WARRANTY; without even the implied warranty of
         MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
         GNU General Public License for more details.

         You should have received a copy of the GNU General Public License
         along with Foobar.  If not, see <http://www.gnu.org/licenses/>
 */
public class Statistics {

    //Single Player reaction times. For use in finding averages/means/medians
    private ArrayList<Long> reactionTimes;
    private int playerOne;
    private int playerTwo;
    private int playerThree;
    private int playerFour;

    public Statistics() {
        this.reactionTimes = new ArrayList<Long>();
        this.playerOne = 0;
        this.playerTwo = 0;
        this.playerThree = 0;
        this.playerFour = 0;
    }


    // Set Reaction Times
    public void addReactionTimes(long time){
        reactionTimes.add(time);
        //Save addition
    }

    public ArrayList<Long> getReactionTimes() {
        return reactionTimes;
    }

    // Set button presses to specific player
    public void IncrementWinnerCount(int count){
        switch (count){
            case 1:
                playerOne = playerOne++;
                break;
            case 2:
                playerTwo = playerTwo++;
                break;
            case 3:
                playerThree = playerThree++;
                break;
            case 4:
                playerFour = playerFour++;
                break;
        }
        //save
    }


    /* Clear the statistics */
    public void clearAll(){
        reactionTimes.clear();
        playerOne = 0;
        playerTwo = 0;
        playerThree = 0;
        playerFour = 0;
    }


    /* Calculations for the Max, Min, Average and Median times. */
    public long getMax(){
        long max = 0;
        for(int i = 0; i < reactionTimes.size(); i++){
            if(reactionTimes.get(i) > max)
                max = reactionTimes.get(i);
        }
        return max;
    }

    public long getMin(){
        long min = 10000;
        for(int i = 0; i < reactionTimes.size(); i++){
            if(reactionTimes.get(i) < min)
                min = reactionTimes.get(i);
        }
        return min;
    }

    public long getAve(){
        long ave = 0;
        long iterations = 0;
        for(int i = 0; i < reactionTimes.size(); i++){
            ave = ave + i;
            iterations++;
        }
        return ave/iterations;
    }

    public long getMedian(){
        return 0;
    }
}
