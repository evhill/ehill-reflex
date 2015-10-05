package com.elyse.ehill_reflex;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;

/**
 * Created by Elyse on 10/4/2015.
 *
 *This project is part of Elyse Hill's Reflex Game Project: ehill-reflex.

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
 *
 */
public class GameShowActivity extends MainActivity{

    Button playerOne;
    Button playerTwo;
    Button playerThree;
    Button playerFour;

    private String playerID;
    private int player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PickNumberOfPlayersMessage();
        playerOne = (Button) findViewById(R.id.PlayerOne);
        playerTwo = (Button) findViewById(R.id.PlayerTwo);
        playerThree = (Button) findViewById(R.id.PlayerThree);
        playerFour = (Button) findViewById(R.id.PlayerFour);
    }

    /*
     * An AlertDialog is presented and ask how many players are playing (2-4). Shows the appropriate
     * layout once it is selected.
     */
    public void PickNumberOfPlayersMessage(){
        AlertDialog.Builder welcome = new AlertDialog.Builder(GameShowActivity.this);
        welcome.setTitle(R.string.SelectNumberOfPlayers)
                .setItems(R.array.NumberOfPlayers, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Selected two player mode
                        if (which == 0) {
                            setContentView(R.layout.multiplayer_two_buttons);
                        }
                        // Selected three player mode
                        if (which == 1) {
                            setContentView(R.layout.multiplayer_three_buttons);
                        }
                        // Selected four player mode
                        if (which == 2) {
                            setContentView(R.layout.multiplayer_four_buttons);
                        }
                    }
                });
        welcome.show();
    }

    /* WhoWins takes the button press of the corresponding button and sends it to a general alert
    * message to be counted */
    public void WhoWins() {
        playerOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playerID = getString(R.string.Player1Wins);
                player = 1;
                WinnerAlertMessage(playerID);
            }
        });
        playerTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playerID = getString(R.string.Player2Wins);
                player = 2;
                WinnerAlertMessage(playerID);
            }
        });
        playerThree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playerID = getString(R.string.Player3Wins);
                player = 3;
                WinnerAlertMessage(playerID);
            }
        });
        playerFour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playerID = getString(R.string.Player4Wins);
                player = 4;
                WinnerAlertMessage(playerID);
            }
        });

    }

    /* This was supposed to be a more general alert case in GameShowWhoWins to show who wins for each given
    * round. However it's not popping up and I'm not really sure why. Sorry.
    * */
    public void WinnerAlertMessage(String ID){
        AlertDialog.Builder winningPlayer = new AlertDialog.Builder(GameShowActivity.this);
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
