package com.example.aishwarya.project;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class Counter extends Activity implements SensorEventListener {
    private TextView textView, text2, text3;
    private SensorManager mSensorManager;
    private Sensor mStepCounterSensor;
    private Sensor mStepDetectorSensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        textView = (TextView) findViewById(R.id.count);
        text2 = (TextView) findViewById(R.id.distance);
        text3 = (TextView) findViewById(R.id.calories);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mStepCounterSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        mStepDetectorSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        Button menu=(Button)findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Counter.this,Menu.class);
                startActivity(intent);
            }
        });

    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        float[] values = sensorEvent.values;
        int value = -1;
        if (values.length > 0) {
            value = (int) values[0];
        }
        if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            textView.setText("Steps detected: " + value);
            text2.setText("Distance covered: " + value * 0.3 + " mtrs");
            double cal = 0.045 * value;
            NumberFormat n = NumberFormat.getNumberInstance();
            n.setMaximumFractionDigits(2);
            String s = n.format(cal);
            cal = Double.parseDouble(s);
            text3.setText("Calories burnt: " + cal + " cal");
        } else if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            textView.setText("Step detector detected :" + value);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mStepCounterSensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    public void onStart() {
        super.onStart();

    }
}
