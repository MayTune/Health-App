package com.example.aishwarya.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper mViewFlipper;
    public static TextView login;
   static int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(i==0){
            login=(TextView)findViewById(R.id.login);
            login.setClickable(true);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    i=1;
                    Intent i=new Intent(MainActivity.this,Login.class);
                    startActivity(i);
                }
            });
        }
        if(i==1){
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                String value = extras.getString("U");
                login=(TextView)findViewById(R.id.login);
                login.setText("Hi "+value);
                login.setClickable(false);
            }
        }
        mViewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);
        mViewFlipper.setAutoStart(true);
        mViewFlipper.setFlipInterval(3000);
        mViewFlipper.setInAnimation(MainActivity.this, android.R.anim.slide_in_left); //use either the default slide animation in sdk or create your own ones
        mViewFlipper.setOutAnimation(MainActivity.this, android.R.anim.slide_out_right);
        mViewFlipper.startFlipping();
        Button button=(Button)findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Menu.class);
                startActivity(intent);
            }
        });
    }
}
