package com.example.cgpa;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import java.lang.String;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6;
    Button b1, b2;

    TextView s;

    TextView[] t = new TextView[6];
    int i,su=0;
    float sgpa;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText) findViewById(R.id.s1);
        e2=(EditText) findViewById(R.id.s2);
        e3=(EditText) findViewById(R.id.s3);
        e4=(EditText) findViewById(R.id.s4);
        e5=(EditText) findViewById(R.id.s5);
        e6=(EditText) findViewById(R.id.s6);

        t[0]=(TextView) findViewById(R.id.c1);
        t[1]=(TextView) findViewById(R.id.c2);
        t[2]=(TextView) findViewById(R.id.c3);
        t[3]=(TextView) findViewById(R.id.c4);
        t[4]=(TextView) findViewById(R.id.c5);
        t[5]=(TextView) findViewById(R.id.c6);

        b1=(Button) findViewById(R.id.b1);
        b2=(Button) findViewById(R.id.b2);

        s=(TextView) findViewById(R.id.cg);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] g=new String[6];
                int[] c=new int[6];
                g[0]=e1.getText().toString().toLowerCase();
                g[1]=e2.getText().toString().toLowerCase();
                g[2]=e3.getText().toString().toLowerCase();
                g[3]=e4.getText().toString().toLowerCase();
                g[4]=e5.getText().toString().toLowerCase();
                g[5]=e6.getText().toString().toLowerCase();

                for(i=0;i<6;i++){
                    t[i].setTextSize(20);
                    switch (g[i]) {
                        case "o":
                            su = su + 10;
                            t[i].setText("P");
                            t[i].setTextColor(Color.parseColor("#1ABC9C"));
                            break;
                        case "a+":
                            su = su + 9;
                            t[i].setText("P");
                            t[i].setTextColor(Color.parseColor("#1ABC9C"));
                            break;
                        case "a":
                            t[i].setText("P");
                            t[i].setTextColor(Color.parseColor("#1ABC9C"));
                            su = su + 8;
                            break;
                        case "b+":
                            t[i].setText("P");
                            t[i].setTextColor(Color.parseColor("#1ABC9C"));
                            su = su + 7;
                            break;
                        case "b":
                            t[i].setText("P");
                            t[i].setTextColor(Color.parseColor("#1ABC9C"));
                            su = su + 6;
                            break;
                        case "c":
                            t[i].setText("P");
                            t[i].setTextColor(Color.parseColor("#1ABC9C"));
                            su += 5;
                            break;
                        default:
                            t[i].setTextColor(Color.parseColor("#ff0000"));
                            t[i].setText("F");
                            break;
                    }
                }

                sgpa=su/6;
                s.setText(String.format("%.2f",sgpa));
            }
        });

    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
            intent.putExtra(" ",sgpa);
            startActivity(intent);
        }
    });
    }
}