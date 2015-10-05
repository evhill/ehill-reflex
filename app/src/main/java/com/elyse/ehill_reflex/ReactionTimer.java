package com.elyse.ehill_reflex;

import java.util.Random;

/**
 * Created by Elyse on 10/4/2015.
 */
public class ReactionTimer {
    private int maxMilli, minMilli;
    private int randomTime;
    private long reactionTime;

    public ReactionTimer(int maxMilli, int minMilli) {
        this.maxMilli = maxMilli;
        this.minMilli = minMilli;
        this.randomTime = 0;
        this.reactionTime = 0;
    }

    //Bill the Lizard - retrieved Oct 4, 2015
    //http://stackoverflow.com/questions/6078157/random-nextfloat-is-not-applicable-for-floats
    public void setRandomTime() {
        Random random = new Random();
        this.randomTime = random.nextInt(maxMilli - minMilli) + minMilli;
    }

    public int getRandomTime() {
        return randomTime;
    }

    public long getReactionTime(long startTime){
        this.reactionTime = System.currentTimeMillis() - startTime;
        return reactionTime;
    }

}
