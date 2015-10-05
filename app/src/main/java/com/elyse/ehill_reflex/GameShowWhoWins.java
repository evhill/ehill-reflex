package com.elyse.ehill_reflex;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

/**
 * Created by Elyse on 10/5/2015.
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
         along with ehill-reflex.  If not, see <http://www.gnu.org/licenses/>
 */
public class GameShowWhoWins extends GameShowActivity{

    private String playerID;
    private int player;

    public void setPlayerID(int i){
        playerID = "Player" + i + "Wins";
        player = i;
    }

    /* Meant to be a separate controller class for generating a winner message based on who clicks
    * the button first. However I had problems getting it to work*/
    public void WinnerAlertMessage(Context context){
        AlertDialog.Builder winningPlayer = new AlertDialog.Builder(context);
        winningPlayer.setTitle(playerID)
                .setPositiveButton(R.string.ResetTimer, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        allStats.IncrementWinnerCount(player);
                        //allStats.updateWinner(player);
                    }
                });
        winningPlayer.show();
    }

}
