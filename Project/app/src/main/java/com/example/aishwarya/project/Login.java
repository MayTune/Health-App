package com.example.aishwarya.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText name,uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button log=(Button)findViewById(R.id.log);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=(EditText)findViewById( R.id.name);
                uname=(EditText)findViewById(R.id.uname);
                String NAME=name.getText().toString();
                String UNAME=uname.getText().toString();
                Intent i= new Intent(Login.this,MainActivity.class);
                i.putExtra("U",UNAME);
                startActivity(i);
            }
        });
    }
}
