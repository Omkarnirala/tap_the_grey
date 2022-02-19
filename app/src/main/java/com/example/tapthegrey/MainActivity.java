package com.example.tapthegrey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    int count;
    Random rand = new Random();
    TextView displayScore;
    ImageView red, blue, yellow, green;
    int int_random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        red = findViewById(R.id.imageView3);
        blue = findViewById(R.id.imageView0);
        green = findViewById(R.id.imageView1);
        yellow = findViewById(R.id.imageView2);
        displayScore = findViewById(R.id.textView);

        setColor();
        updateDisplay();
        listner();

    }

    private void setColor() {
        red.setBackgroundColor(ContextCompat.getColor(this,R.color.red));
        blue.setBackgroundColor(ContextCompat.getColor(this,R.color.blue));
        green.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
        yellow.setBackgroundColor(ContextCompat.getColor(this,R.color.yellow));
    }

    private void updateDisplay() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                colorChange();
            }

        },0,1000);//Update text every second
    }

    void colorChange(){
        int_random = rand.nextInt(4);
        if(int_random == 0){
            red.setBackgroundColor(ContextCompat.getColor(this,R.color.grey));
            blue.setBackgroundColor(ContextCompat.getColor(this,R.color.blue));
            green.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
            yellow.setBackgroundColor(ContextCompat.getColor(this,R.color.yellow));
        }else if(int_random == 1){
            blue.setBackgroundColor(ContextCompat.getColor(this,R.color.grey));
            red.setBackgroundColor(ContextCompat.getColor(this,R.color.red));
            green.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
            yellow.setBackgroundColor(ContextCompat.getColor(this,R.color.yellow));
        }else if(int_random == 2){
            green.setBackgroundColor(ContextCompat.getColor(this,R.color.grey));
            blue.setBackgroundColor(ContextCompat.getColor(this,R.color.blue));
            red.setBackgroundColor(ContextCompat.getColor(this,R.color.red));
            yellow.setBackgroundColor(ContextCompat.getColor(this,R.color.yellow));
        }else if(int_random == 3){
            yellow.setBackgroundColor(ContextCompat.getColor(this,R.color.grey));
            blue.setBackgroundColor(ContextCompat.getColor(this,R.color.blue));
            red.setBackgroundColor(ContextCompat.getColor(this,R.color.red));
            green.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
        }else{
            Toast.makeText(this, "Wrong value", Toast.LENGTH_SHORT).show();
        }
        displayScore.setText(String.valueOf(count));

    }

    private void listner() {
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(int_random == 0){
                    count++;
                }else{
                    count = 0;
                    Toast.makeText(MainActivity.this, "Game Over!!! \n Your score is:"+count, Toast.LENGTH_SHORT).show();
                }
            }
        });
        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(int_random == 3){
                    count++;
                }else{
                    count = 0;
                    Toast.makeText(MainActivity.this, "Game Over!!! \n Your score is:"+count, Toast.LENGTH_SHORT).show();
                }
            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(int_random == 2){
                    count++;
                }else{
                    count = 0;
                    Toast.makeText(MainActivity.this, "Game Over!!! \n Your score is:"+count, Toast.LENGTH_SHORT).show();
                }
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(int_random == 1){
                    count++;
                }else{
                    count = 0;
                    Toast.makeText(MainActivity.this, "Game Over!!! \n Your score is:"+count, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}