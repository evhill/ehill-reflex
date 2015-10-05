package com.elyse.ehill_reflex;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
         along with ehill-reflex.  If not, see <http://www.gnu.org/licenses/>
 */
public class ReactionTestActivity extends MainActivity {

    Button validButton;
    Button invalidButton;
    int valid = 1, invalid = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reaction_test);
        validButton = (Button) findViewById(R.id.ClickHere);
        invalidButton = (Button) findViewById(R.id.WaitToClick);
        ReactionTestWelcomeMessage();
    }

    /*
     * Create an AlertDialogue that describes this game mode. Prompts the user to begin the game mode
     * and then begins the timer.
     */

    // Android Developers:
    //      http://developer.android.com/guide/topics/ui/dialogs.html - Oct, 4, 2015
    public void ReactionTestWelcomeMessage(){
        AlertDialog.Builder welcome = new AlertDialog.Builder(ReactionTestActivity.this);
        welcome.setTitle(R.string.ReactionTestWelcome)
                .setPositiveButton(R.string.ReactionWelcomeStart, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        BeginTesting();
                        invalidButtonPress();
                    }
                });
        welcome.show();
    }

    /* Get a new timer with a random time between 10 and 2000ms */
    public void BeginTesting(){
        final ReactionTimer newTest = new ReactionTimer(2000, 10);
        newTest.setRandomTime();
        new CountDownTimer(newTest.getRandomTime(), 100){
            public void onTick(long millisUntilFinished){
                //do nothing the user shouldn't see the timer
            }
            public void onFinish(){
                //switch button layouts
                validButton.setVisibility(View.VISIBLE);
                invalidButton.setVisibility(View.GONE);
                validButtonPress(newTest);
            }
        }.start();
    }

    /* We can only make a valid button press once the countdown has ended and the prompt is given. To
    * do this we create a new time variable that tracks when the button is created. This will be
    * used to track our reaction time */
    public void validButtonPress(final ReactionTimer timer){
        final long startTime = System.currentTimeMillis();
        validButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final long reactionTime = timer.getReactionTime(startTime);
                String s;
                AlertDialog.Builder yourReactionTime = new AlertDialog.Builder(ReactionTestActivity.this);
                yourReactionTime.setTitle(R.string.ReactionTime)
                        .setMessage(s = String.valueOf(reactionTime) + "ms")
                        .setPositiveButton(R.string.ResetTimer, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                allStats.updateReactionTimes(reactionTime);
                                ResetReactionView();
                            }
                        });
                yourReactionTime.show();
            }
        });
    }

    /* Making an invalid button press is available from the start of the test. If the button is
    * pressed before the prompt to click is displayed, then an AlertDialog is given to inform the
    * player of the mistake, and the timer is reset */
    public void invalidButtonPress(){
        final Context context = this;
        invalidButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder pressedTooFast = new AlertDialog.Builder(ReactionTestActivity.this);
                pressedTooFast.setTitle(R.string.ClickedBeforePrompt)
                        .setPositiveButton(R.string.ResetTimer, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ResetReactionView();
                            }
                        });
                pressedTooFast.show();
            }
        });
    }

    public void ResetReactionView(){
        validButton.setVisibility(View.GONE);
        invalidButton.setVisibility(View.VISIBLE);
        BeginTesting();
    }
}
