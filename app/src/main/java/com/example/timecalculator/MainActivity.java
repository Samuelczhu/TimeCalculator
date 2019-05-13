package com.example.timecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find all the buttons
        Button but_twelve = (Button) findViewById(R.id.but_twelve);
        Button but_twenty_four = (Button) findViewById(R.id.but_twenty_four);

        //set onclick listener
        but_twelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to twelve system activity
                Intent intent = new Intent(MainActivity.this, TwelveHour.class);
                startActivity(intent);
            }
        });
        but_twenty_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to twenty four system activity
                Intent intent = new Intent(MainActivity.this, TwentyFourHour.class);
                startActivity(intent);
            }
        });
    }
}
