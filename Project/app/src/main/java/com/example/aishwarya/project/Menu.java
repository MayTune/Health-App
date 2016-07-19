package com.example.aishwarya.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    Button mb1,mb2,mb3,mb4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mb1=(Button)findViewById(R.id.mb1);
        mb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Menu.this,Counter.class);
                startActivity(intent);

            }
        });
        mb2=(Button)findViewById(R.id.mb2);
        mb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Menu.this,WaterReminder.class);
                startActivity(intent);

            }
        });
        mb3=(Button)findViewById(R.id.mb3);
        mb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Menu.this,ExerciseTimer.class);
                startActivity(intent);

            }
        });
        mb4=(Button)findViewById(R.id.mb4);
        mb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Menu.this,Info.class);
                startActivity(intent);

            }
        });
    }
}
