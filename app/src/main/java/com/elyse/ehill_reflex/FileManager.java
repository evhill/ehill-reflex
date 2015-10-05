package com.elyse.ehill_reflex;

import android.view.View;

/**
 * Created by Elyse on 10/4/2015.
 *
 *  This project is part of Elyse Hill's Reflex Game Project: ehill-reflex.

        ehill-reflex is free software: you can redistribute it and/or modify
         it under the terms of the GNU General Public License as published by
         the Free Software Foundation, either version 3 of the License, or
         (at your option) any later version.

        ehill-reflex is distributed in the hope that it will be useful,
         but WITHOUT ANY WARRANTY; without even the implied warranty of
         MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
         GNU General Public License for more details.

         You should have received a copy of the GNU General Public License
         along with ehill-reflex.  If not, see <http://www.gnu.org/licenses/>
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
