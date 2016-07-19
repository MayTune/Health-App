package com.example.aishwarya.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Info extends AppCompatActivity {
    TextView res,stat;
    RadioButton rb1,rb2;
    Button cal;
    EditText ht,wt,sleep,wquantity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        rb1=(RadioButton)findViewById(R.id.male);
        rb2=(RadioButton)findViewById(R.id.female);
        addListenerOnButton();
        Button go1=(Button)findViewById(R.id.go1);
        Button go2=(Button)findViewById(R.id.go2);
        go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sleep=(EditText)findViewById(R.id.editText);
                TextView com1=(TextView)findViewById(R.id.com);
                String val1=sleep.getText().toString();
                int n1=Integer.parseInt(val1);
                if(n1<=6){
                    com1.setText("Comment:Too little sleep");
                }
                else if((n1>6) &&(n1<9)){
                    com1.setText("Comment:Proper sleep, well done");
                }
                else{
                    com1.setText("Comment:Too much sleep");
                }
            }
        });

        go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wquantity=(EditText)findViewById(R.id.editText);
                TextView com2=(TextView)findViewById(R.id.comm);
                String val1=sleep.getText().toString();
                int n1=Integer.parseInt(val1);
                if(n1<=6){
                    com2.setText("Comment:Too little water");
                }
                else if((n1>6) &&(n1<15)){
                    com2.setText("Comment:Proper water intake, well done");
                }
                else{
                    com2.setText("Comment:Too much water :P");
                }
            }
        });

    }
    public void addListenerOnButton(){
        cal=(Button)findViewById(R.id.cal);
        cal.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          res=(TextView)findViewById(R.id.res);
                                          stat=(TextView)findViewById(R.id.stat);
                                          ht=(EditText)findViewById(R.id.ht);
                                          wt=(EditText)findViewById(R.id.wt);
                                          String value1=ht.getText().toString();
                                          String value2=wt.getText().toString();
                                          Float f1=Float.parseFloat(value1);
                                          Float f2=Float.parseFloat(value2);
                                          float result=(f2/(f1*f1))*10000;
                                          if(rb1.isChecked())
                                          {
                                            res.setText("BMI: "+String.format("%f",result));
                                              if(result<=18.5){
                                                  stat.setText("Status:Underweight");
                                              }
                                              else if((result>18.5) &&(result<25)){
                                                  stat.setText("Status:Healthy");
                                              }
                                              else if((result>25) &&(result<30)){
                                                  stat.setText("Status:Overweight");
                                              }
                                              else
                                              {
                                                  stat.setText("Status:Obese");
                                              }
                                          }
                                          else if(rb2.isChecked())
                                          {
                                              res.setText("BMI: "+String.format("%f",result));
                                              if(result<=18){
                                                  stat.setText("Status:Underweight");
                                              }
                                              else if((result>18) &&(result<24)){
                                                  stat.setText("Status:Healthy");
                                              }
                                              else if((result>24) &&(result<30)){
                                                  stat.setText("Status:Overweight");
                                              }
                                              else{
                                                  stat.setText("Status:Overweight");
                                              }
                                          }

                                          }
        }
        );
    }
}
