package com.example.user.memorize;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

public class advanced extends AppCompatActivity {

    TextView tv_p1, timertv; //, tv_p2;

    ImageView iv_11, iv_12, iv_13, iv_14,
            iv_21, iv_22, iv_23, iv_24,
            iv_31, iv_32, iv_33, iv_34,
            iv_41, iv_42, iv_43, iv_44,
            iv_51, iv_52, iv_53, iv_54;

    //array for the images
    Integer [] cardsArray = {101, 102, 103, 104,105, 106, 107, 108, 109, 110,
                            201, 202, 203, 204, 205, 206, 207, 208, 209, 210};

    //actual images
    int image101, image102, image103, image104, image105, image106, image107, image108, image109, image110,
            image201, image202, image203, image204, image205, image206, image207, image208, image209, image210;

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;

    int turn = 1,playerPoints = 0, sec=52;
    String  s;
    //, cpuPoints = 0;

    Timer t = new Timer();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);

        tv_p1 = findViewById(R.id.tv_p1);
        tv_p1.setY(-550);
        tv_p1.animate().translationYBy(550).setDuration(2500);
        timertv = findViewById(R.id.timer);
        timertv.setY(-550);
        timertv.animate().translationYBy(550).setDuration(2500);

        iv_11 = findViewById(R.id.iv_11);
        iv_11.setY(1000);
        iv_11.animate().translationYBy(-1000).setDuration(2500);
        iv_12 =  findViewById(R.id.iv_12);
        iv_12.setY(1000);
        iv_12.animate().translationYBy(-1000).setDuration(2500);
        iv_13 =  findViewById(R.id.iv_13);
        iv_13.setY(1000);
        iv_13.animate().translationYBy(-1000).setDuration(2500);
        iv_14 =  findViewById(R.id.iv_14);
        iv_14.setY(1000);
        iv_14.animate().translationYBy(-1000).setDuration(2500);
        iv_21 =  findViewById(R.id.iv_21);
        iv_21.setY(1000);
        iv_21.animate().translationYBy(-1000).setDuration(2500);
        iv_22 =  findViewById(R.id.iv_22);
        iv_22.setY(1000);
        iv_22.animate().translationYBy(-1000).setDuration(2500);
        iv_23 =  findViewById(R.id.iv_23);
        iv_23.setY(1000);
        iv_23.animate().translationYBy(-1000).setDuration(2500);
        iv_24 =  findViewById(R.id.iv_24);
        iv_24.setY(1000);
        iv_24.animate().translationYBy(-1000).setDuration(2500);
        iv_31 =  findViewById(R.id.iv_31);
        iv_31.setY(1000);
        iv_31.animate().translationYBy(-1000).setDuration(2500);
        iv_32 =  findViewById(R.id.iv_32);
        iv_32.setY(1000);
        iv_32.animate().translationYBy(-1000).setDuration(2500);
        iv_33 =  findViewById(R.id.iv_33);
        iv_33.setY(1000);
        iv_33.animate().translationYBy(-1000).setDuration(2500);
        iv_34 =  findViewById(R.id.iv_34);
        iv_34.setY(1000);
        iv_34.animate().translationYBy(-1000).setDuration(2500);
        iv_41 =  findViewById(R.id.iv_41);
        iv_41.setY(1000);
        iv_41.animate().translationYBy(-1000).setDuration(2500);
        iv_42 =  findViewById(R.id.iv_42);
        iv_42.setY(1000);
        iv_42.animate().translationYBy(-1000).setDuration(2500);
        iv_43 =  findViewById(R.id.iv_43);
        iv_43.setY(1000);
        iv_43.animate().translationYBy(-1000).setDuration(2500);
        iv_44 =  findViewById(R.id.iv_44);
        iv_44.setY(1000);
        iv_44.animate().translationYBy(-1000).setDuration(2500);
        iv_51 =  findViewById(R.id.iv_51);
        iv_51.setY(1000);
        iv_51.animate().translationYBy(-1000).setDuration(2500);
        iv_52 =  findViewById(R.id.iv_52);
        iv_52.setY(1000);
        iv_52.animate().translationYBy(-1000).setDuration(2500);
        iv_53 =  findViewById(R.id.iv_53);
        iv_53.setY(1000);
        iv_53.animate().translationYBy(-1000).setDuration(2500);
        iv_54 =  findViewById(R.id.iv_54);
        iv_54.setY(1000);
        iv_54.animate().translationYBy(-1000).setDuration(2500);

        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_13.setTag("2");
        iv_14.setTag("3");
        iv_21.setTag("4");
        iv_22.setTag("5");
        iv_23.setTag("6");
        iv_24.setTag("7");
        iv_31.setTag("8");
        iv_32.setTag("9");
        iv_33.setTag("10");
        iv_34.setTag("11");
        iv_41.setTag("12");
        iv_42.setTag("13");
        iv_43.setTag("14");
        iv_44.setTag("15");
        iv_51.setTag("16");
        iv_52.setTag("17");
        iv_53.setTag("18");
        iv_54.setTag("19");

        //load the card images
        frontOfCardsResources();
        //shuffles the images
        Collections.shuffle(Arrays.asList(cardsArray));

        Timer();

        //changing the color of the second player to inactive
        //tv_p2.setTextColor(Color.GRAY);


        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_11, theCard);
            }
        });

        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_11, theCard);
            }
        });

        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_12, theCard);
            }
        });

        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_13, theCard);
            }
        });

        iv_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_14, theCard);
            }
        });

        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_21, theCard);
            }
        });

        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_22, theCard);
            }
        });

        iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_23, theCard);
            }
        });

        iv_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_24, theCard);
            }
        });

        iv_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_31, theCard);
            }
        });

        iv_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_32, theCard);
            }
        });

        iv_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_33, theCard);
            }
        });

        iv_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_34, theCard);
            }
        });

        iv_41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_41, theCard);
            }
        });

        iv_42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_42, theCard);
            }
        });

        iv_43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_43, theCard);
            }
        });

        iv_44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_44, theCard);
            }
        });

        iv_51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_51, theCard);
            }
        });

        iv_52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_52, theCard);
            }
        });

        iv_53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_53, theCard);
            }
        });

        iv_54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_54, theCard);
            }
        });

    }

    private void doStuff(ImageView iv, int card){
        //set the correct image
        if(cardsArray[card] == 101){
            iv.setImageResource(image101);
        }else if(cardsArray[card] == 102){
            iv.setImageResource(image102);
        }else if(cardsArray[card] == 103){
            iv.setImageResource(image103);
        }else if(cardsArray[card] == 104){
            iv.setImageResource(image104);
        }else if(cardsArray[card] == 105){
            iv.setImageResource(image105);
        }else if(cardsArray[card] == 106){
            iv.setImageResource(image106);
        }else if(cardsArray[card] == 107){
            iv.setImageResource(image107);
        }else if(cardsArray[card] == 108){
            iv.setImageResource(image108);
        }else if(cardsArray[card] == 109){
            iv.setImageResource(image109);
        }else if(cardsArray[card] == 110) {
            iv.setImageResource(image110);
        } else if(cardsArray[card] == 201){
            iv.setImageResource(image201);
        }else if(cardsArray[card] == 202){
            iv.setImageResource(image202);
        }else if(cardsArray[card] == 203){
            iv.setImageResource(image203);
        }else if(cardsArray[card] == 204){
            iv.setImageResource(image204);
        }else if(cardsArray[card] == 205){
            iv.setImageResource(image205);
        }else if(cardsArray[card] == 206){
            iv.setImageResource(image206);
        }else if(cardsArray[card] == 207){
        iv.setImageResource(image207);
        }else if(cardsArray[card] == 208){
        iv.setImageResource(image208);
        }else if(cardsArray[card] == 209){
        iv.setImageResource(image209);
        }else if(cardsArray[card] == 210){
        iv.setImageResource(image210);
    }

        //check which image is selected
        if(cardNumber == 1){
            firstCard= cardsArray[card];
            if(firstCard > 200){
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;

            iv.setEnabled(false);
        }else if(cardNumber == 2){
            secondCard = cardsArray[card];
            if(secondCard > 200){
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;

            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_14.setEnabled(false);
            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);
            iv_24.setEnabled(false);
            iv_31.setEnabled(false);
            iv_32.setEnabled(false);
            iv_33.setEnabled(false);
            iv_34.setEnabled(false);
            iv_41.setEnabled(false);
            iv_42.setEnabled(false);
            iv_43.setEnabled(false);
            iv_44.setEnabled(false);
            iv_51.setEnabled(false);
            iv_52.setEnabled(false);
            iv_53.setEnabled(false);
            iv_54.setEnabled(false);


            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //check if the selected images are equal
                    calculate();
                }
            }, 1000);
        }
    }

    private void calculate(){
        //if images are equal
        if(firstCard == secondCard) {
            if (clickedFirst == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {
                iv_14.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 6) {
                iv_23.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 7) {
                iv_24.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 8) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 9) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 10) {
                iv_33.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 11) {
                iv_34.setVisibility(View.INVISIBLE);
            }else if (clickedFirst == 12) {
                iv_41.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 13) {
                iv_42.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 14) {
                iv_43.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 15) {
                iv_44.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 16) {
                iv_51.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 17) {
                iv_52.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 18) {
                iv_53.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 19) {
                iv_54.setVisibility(View.INVISIBLE);
            }

            if (clickedSecond == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 3) {
                iv_14.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 6) {
                iv_23.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 7) {
                iv_24.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 8) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 9) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 10) {
                iv_33.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 11) {
                iv_34.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 12) {
                iv_41.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 13) {
                iv_42.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 14) {
                iv_43.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 15) {
                iv_44.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 16) {
                iv_51.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 17) {
                iv_52.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 18) {
                iv_53.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 19) {
                iv_54.setVisibility(View.INVISIBLE);
            }

            //add points to the current player
            if (turn == 1) {
                playerPoints++;
                tv_p1.setText("P1: " + playerPoints);
            } /*else if (turn == 2) {
                cpuPoints++;
                tv_p2.setText("P2: " + cpuPoints);
            }*/

        }else {
            iv_11.setImageResource(R.drawable.ic_back);
            iv_12.setImageResource(R.drawable.ic_back);
            iv_13.setImageResource(R.drawable.ic_back);
            iv_14.setImageResource(R.drawable.ic_back);
            iv_21.setImageResource(R.drawable.ic_back);
            iv_22.setImageResource(R.drawable.ic_back);
            iv_23.setImageResource(R.drawable.ic_back);
            iv_24.setImageResource(R.drawable.ic_back);
            iv_31.setImageResource(R.drawable.ic_back);
            iv_32.setImageResource(R.drawable.ic_back);
            iv_33.setImageResource(R.drawable.ic_back);
            iv_34.setImageResource(R.drawable.ic_back);
            iv_41.setImageResource(R.drawable.ic_back);
            iv_42.setImageResource(R.drawable.ic_back);
            iv_43.setImageResource(R.drawable.ic_back);
            iv_44.setImageResource(R.drawable.ic_back);
            iv_51.setImageResource(R.drawable.ic_back);
            iv_52.setImageResource(R.drawable.ic_back);
            iv_53.setImageResource(R.drawable.ic_back);
            iv_54.setImageResource(R.drawable.ic_back);

            if (turn == 1) {
               // turn = 2;
                tv_p1.setTextColor(Color.BLACK);
              //  tv_p2.setTextColor(Color.BLACK);
            } /*else if (turn == 2) {
                turn = 1;
                tv_p2.setTextColor(Color.GRAY);
                tv_p1.setTextColor(Color.BLACK);
            }*/
        }
        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_14.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);
        iv_24.setEnabled(true);
        iv_31.setEnabled(true);
        iv_32.setEnabled(true);
        iv_33.setEnabled(true);
        iv_34.setEnabled(true);
        iv_41.setEnabled(true);
        iv_42.setEnabled(true);
        iv_43.setEnabled(true);
        iv_44.setEnabled(true);
        iv_51.setEnabled(true);
        iv_52.setEnabled(true);
        iv_53.setEnabled(true);
        iv_54.setEnabled(true);


        checkEnd();
    }

    private void checkEnd(){
        if(iv_11.getVisibility() == View.INVISIBLE &&
                iv_12.getVisibility() == View.INVISIBLE &&
                iv_13.getVisibility() == View.INVISIBLE &&
                iv_14.getVisibility() == View.INVISIBLE &&
                iv_21.getVisibility() == View.INVISIBLE &&
                iv_22.getVisibility() == View.INVISIBLE &&
                iv_23.getVisibility() == View.INVISIBLE &&
                iv_24.getVisibility() == View.INVISIBLE &&
                iv_31.getVisibility() == View.INVISIBLE &&
                iv_32.getVisibility() == View.INVISIBLE &&
                iv_33.getVisibility() == View.INVISIBLE &&
                iv_34.getVisibility() == View.INVISIBLE &&
                iv_41.getVisibility() == View.INVISIBLE &&
                iv_42.getVisibility() == View.INVISIBLE &&
                iv_43.getVisibility() == View.INVISIBLE &&
                iv_44.getVisibility() == View.INVISIBLE &&
                iv_51.getVisibility() == View.INVISIBLE &&
                iv_52.getVisibility() == View.INVISIBLE &&
                iv_53.getVisibility() == View.INVISIBLE &&
                iv_54.getVisibility() == View.INVISIBLE){

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(advanced.this);
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setTitle("Congrats");
            alertDialogBuilder.setMessage("POINT: " + playerPoints + "\nTIMER: " + s );
            alertDialogBuilder.setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(getApplicationContext(), gameMenu.class);
                    startActivity(intent);
                    finish();

                }
            })
                    .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
            t.cancel();
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    public void Timer(){

        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        s = Integer.toString(sec);
                        timertv.setText(s +" "+"s");
                        sec --;
                        stop();

                    }

                });

            }
        }, 0, 1000);

    }

    public void stop(){
        if (sec==-1) {
            t.cancel();
            t.purge();
            TimeOver();

        }}

    public void TimeOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(advanced.this);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setTitle("Game Over");
        alertDialogBuilder.setMessage("POINT: " + playerPoints);
        alertDialogBuilder.setPositiveButton("New Game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(getApplicationContext(), gameMenu.class);
                startActivity(intent);
                finish();
            }
        })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void frontOfCardsResources(){

        image101 = R.drawable.ic_image101;
        image102 = R.drawable.ic_image102;
        image103 = R.drawable.ic_image103;
        image104 = R.drawable.ic_image104;
        image105 = R.drawable.ic_image105;
        image106 = R.drawable.ic_image106;
        image107 = R.drawable.ic_image107;
        image108 = R.drawable.ic_image108;
        image109 = R.drawable.ic_image109;
        image110 = R.drawable.ic_image110;
        image201 = R.drawable.ic_image101;
        image202 = R.drawable.ic_image102;
        image203 = R.drawable.ic_image103;
        image204 = R.drawable.ic_image104;
        image205 = R.drawable.ic_image105;
        image206 = R.drawable.ic_image106;
        image207 = R.drawable.ic_image107;
        image208 = R.drawable.ic_image108;
        image209 = R.drawable.ic_image109;
        image210 = R.drawable.ic_image110;


    }
}