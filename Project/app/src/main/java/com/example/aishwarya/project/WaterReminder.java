package com.example.aishwarya.project;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WaterReminder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_reminder);
        Button menu=(Button)findViewById(R.id.mbutton);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(WaterReminder.this,Menu.class);
                startActivity(intent);
            }
        });
        Button water=(Button)findViewById(R.id.water);
        water.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {

                try {

                    //Create a new PendingIntent and add it to the AlarmManager
                    Intent intent = new Intent(WaterReminder.this, RingAlarm.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(WaterReminder.this,
                            12345, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                    AlarmManager am =
                            (AlarmManager)getSystemService(Activity.ALARM_SERVICE);
                    am.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(),
                            2*60*60*1000,pendingIntent);
                    Toast.makeText(WaterReminder.this,"Reminder set successfully",Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    Toast.makeText(WaterReminder.this,e.getMessage().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
