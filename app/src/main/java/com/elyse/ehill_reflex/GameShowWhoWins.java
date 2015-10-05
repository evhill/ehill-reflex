package com.elyse.ehill_reflex;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

/**
 * Created by Elyse on 10/5/2015.
 */
public class GameShowWhoWins extends GameShowActivity{

    String playerID;
    int player;

    public void setPlayerID(int i){
        playerID = "Player" + i + "Wins";
        player = i;
    }

    public void WinnerAlertMessage(Context context){
        AlertDialog.Builder winningPlayer = new AlertDialog.Builder(context);
        winningPlayer.setTitle(playerID)
                .setPositiveButton(R.string.ResetTimer, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        allStats.updateWinner(player);
                    }
                });
        winningPlayer.show();
    }

}
