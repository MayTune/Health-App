package com.example.aishwarya.project;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ExerciseTimer extends AppCompatActivity {
    TextView text1;
    EditText hrs,mins,secs;
    int seconds=0,minutes=0,hours=0,t;
    Button timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_timer);
        text1=(TextView)findViewById(R.id.textView1);
        hrs=(EditText)findViewById(R.id.hrs);
        mins=(EditText)findViewById(R.id.mins);
        secs=(EditText)findViewById(R.id.secs);
        timer=(Button)findViewById(R.id.timer) ;
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value1,value2,value3;
                hours=0;
                minutes=0;
                seconds=0;
                try {
                    value1 = hrs.getText().toString();
                    value2 = mins.getText().toString();
                    value3 = secs.getText().toString();
                    hours = Integer.parseInt(value1);
                    minutes = Integer.parseInt(value2);
                    seconds = Integer.parseInt(value3);
                    t = (60 * 60 * hours) + (60 * minutes) + seconds;
                    reverseTimer(t, text1);
                }
                catch(Exception e){
                    Toast.makeText(ExerciseTimer.this,"Enter all fields correctly",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void reverseTimer(int Seconds,final TextView tv){

        new CountDownTimer(Seconds* 1000+1000, 1000) {

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int hours=seconds/3600;
                int r=seconds%3600;
                int minutes = r/ 60;
                seconds = r % 60;
                tv.setText("TIME : " +String.format("%02d", hours)+":"+ String.format("%02d", minutes)
                        + ":" + String.format("%02d", seconds));
            }

            public void onFinish() {
                tv.setText("You are done!! Great Workout!!");
            }
        }.start();
    }
}
