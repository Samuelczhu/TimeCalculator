package com.example.timecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TwentyFourHour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twenty_four_hour);

        //finding all the views
        final EditText start_hour = (EditText) findViewById(R.id.start_hour_24);
        final EditText start_minute = (EditText) findViewById(R.id.start_minute_24);
        final EditText end_hour = (EditText) findViewById(R.id.end_hour_24);
        final EditText end_minute = (EditText) findViewById(R.id.end_minute_24);
        final EditText deduct_hour = (EditText) findViewById(R.id.deduct_hour_24);
        Button calculate = (Button) findViewById(R.id.calculate_24);
        final TextView display = (TextView) findViewById(R.id.display_24);

        //action for calculate button
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calculate the time difference in 24-hour system
                try {
                    //read inputs
                    int startHour = Integer.valueOf(start_hour.getText().toString());
                    int startMinute = Integer.valueOf(start_minute.getText().toString());
                    int endHour = Integer.valueOf(end_hour.getText().toString());
                    int endMinute = Integer.valueOf(end_minute.getText().toString());
                    Editable dHour = deduct_hour.getText();
                    double deductHour;
                    if (dHour==null||dHour.toString().equals("")) {
                        deductHour = 0;
                        deduct_hour.setText("0");
                    }
                    else
                        deductHour = Double.valueOf(dHour.toString());

                    //calculate and display answer
                    double answer = TimeCalculator.twentyFourCalc(startHour,startMinute,endHour,endMinute,deductHour);
                    display.setText(String.valueOf(answer));
                } catch (Exception e) {
                    Toast.makeText(TwentyFourHour.this,getString(R.string.invalid_input),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
