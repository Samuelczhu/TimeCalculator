package com.example.timecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class TwelveHour extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twelve_hour);

        //find all views
        final EditText start_hour = (EditText) findViewById(R.id.start_hour_12);
        final EditText start_minute = (EditText) findViewById(R.id.start_minute_12);
        final ToggleButton start_is_PM = (ToggleButton) findViewById(R.id.startIsPM);
        final EditText end_hour = (EditText) findViewById(R.id.end_hour_12);
        final EditText end_minute = (EditText) findViewById(R.id.end_minute_12);
        final ToggleButton end_is_PM = (ToggleButton) findViewById(R.id.endIsPM);
        final EditText deduct_hour = (EditText) findViewById(R.id.deduct_hour_12);
        Button calculate = (Button) findViewById(R.id.calculate_12);
        final TextView display = (TextView) findViewById(R.id.display_12);

        //the calculate action
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calculate the time difference in 12-hour system
                try {
                    //read inputs
                    int startHour = Integer.valueOf(start_hour.getText().toString());
                    int startMinute = Integer.valueOf(start_minute.getText().toString());
                    boolean startIsPM = start_is_PM.isChecked();
                    int endHour = Integer.valueOf(end_hour.getText().toString());
                    int endMinute = Integer.valueOf(end_minute.getText().toString());
                    boolean endIsPM = end_is_PM.isChecked();
                    Editable dHour = deduct_hour.getText();
                    double deductHour;
                    if (dHour==null||dHour.toString().equals("")) {
                        deductHour = 0;
                        deduct_hour.setText("0");
                    }
                    else
                        deductHour = Double.valueOf(dHour.toString());

                    //calculate and display answer
                    double answer = TimeCalculator.twelveCalc(startHour,startMinute,startIsPM,endHour,endMinute,endIsPM,deductHour);
                    display.setText(String.valueOf(answer));
                } catch (Exception e) {
                    Toast.makeText(TwelveHour.this,getString(R.string.invalid_input),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
