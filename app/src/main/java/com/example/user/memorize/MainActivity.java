package com.example.user.memorize;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    Button play;
    TextView welcome;
    TextView levd;
    Spinner level;
    Button exit;
    ArrayAdapter<String> mAdapter;
    /*Array containing the levels to which a movie can belong*/
    String[] levelD =
            {
                    "-Select Level-",
                    "Easy","Normal",
                    "Advanced","Hard"
            };

    public void playClick(View view){

        if(level.getSelectedItem().toString().equalsIgnoreCase("-Select Level-")){
            Toast.makeText(MainActivity.this, "Please Select a Level",
                    Toast.LENGTH_SHORT).show();

        }else if(level.getSelectedItem().toString().equalsIgnoreCase("Easy")){
            Intent intent = new Intent(MainActivity.this, gameMenu.class);
            MainActivity.this.startActivity(intent);
        }else if(level.getSelectedItem().toString().equalsIgnoreCase("Normal")){
            Intent intent = new Intent(MainActivity.this, Normal.class);
            MainActivity.this.startActivity(intent);
        }else if(level.getSelectedItem().toString().equalsIgnoreCase("Advanced")){
            Intent intent = new Intent(MainActivity.this, advanced.class);
            MainActivity.this.startActivity(intent);
        }else if(level.getSelectedItem().toString().equalsIgnoreCase("Hard")){
            Intent intent = new Intent(MainActivity.this, hard.class);
            MainActivity.this.startActivity(intent);

        }

    }

    public void exitClick(View view){
        this.finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome = findViewById(R.id.welcome);
        welcome.setVisibility(View.VISIBLE);
        welcome.setX(-500);
        welcome.animate().translationXBy(500).rotation(1800).setDuration(2500);

        play = findViewById(R.id.play);
        play.setVisibility(View.VISIBLE);
        play.setX(-550);
        play.animate().translationXBy(550).rotation(1800).setDuration(2500);

        exit = findViewById(R.id.exit);
        exit.setVisibility(View.VISIBLE);
        exit.setX(-600);
        exit.animate().translationXBy(600).rotation(1800).setDuration(2500);

        levd = findViewById(R.id.levd);
        levd.setVisibility(View.VISIBLE);
        levd.setX(-650);
        levd.animate().translationXBy(650).rotation(1800).setDuration(2500);

        level = findViewById(R.id.level);
        level.setVisibility(View.VISIBLE);
        level.setX(-650);
        level.animate().translationXBy(650).rotation(1800).setDuration(2500);

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,levelD);

        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        level.setAdapter(mAdapter);

       // tv_p1.animate()

    }
}
