package com.elyse.ehill_reflex;

import java.util.Random;

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
