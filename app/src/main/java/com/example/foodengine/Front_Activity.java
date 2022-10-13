package com.example.foodengine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class Front_Activity extends AppCompatActivity {

    Button login , btnsignup ,mskipbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getSupportActionBar().hide();


        login = findViewById(R.id.btnlogin);
        btnsignup = findViewById(R.id.btnsignUp);
        mskipbtn = findViewById(R.id.mskipbtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Front_Activity.this, "Login has been clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Front_Activity.this , SignIn_Activity.class);
                startActivity(intent);
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Front_Activity.this , SignUp_Activity.class);
                startActivity(intent);
            }
        });

        mskipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Front_Activity.this,"TSKip working",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Front_Activity.this , MainActivity.class);
                startActivity(intent);
            }
        });
    }
}


