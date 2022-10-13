package com.example.foodengine;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignUp_Activity extends AppCompatActivity {
        EditText mFullName,mEmail,mPassword,mPhone;
        Button mRegisterBtn;
        TextView mLoginBtn;
        FirebaseAuth fAuth;


@Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_);

        mFullName = findViewById(R.id.fullName);
        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.password);
        mPhone = findViewById(R.id.phone);
        mRegisterBtn = findViewById(R.id.loginbtn);
        mLoginBtn = findViewById(R.id.createText);

        fAuth = FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser() != null) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
        }

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        String email = mEmail.getText().toString().trim();
                        String password = mPassword.getText().toString().trim();

                        if (TextUtils.isEmpty(email)) {
                                mEmail.setError("Email is Required");
                                return;
                        }

                        if (TextUtils.isEmpty(password)) {
                                mPassword.setError("Password is Required");
                                return;
                        }

                        if (password.length() < 6) {
                                mPassword.setError("Password must be >= 6 character");
                                return;
                        }

                        fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                                Toast.makeText(SignUp_Activity.this, "User Created.", Toast.LENGTH_SHORT).show();
                                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                        } else {
                                                Toast.makeText(SignUp_Activity.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                }
                        });
                }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                        startActivity(new Intent(getApplicationContext(),SignIn_Activity.class));
                }
        });



        getSupportActionBar().setTitle("Sign Up");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
}
@Override
public boolean onSupportNavigateUp(){
        onBackPressed();
        return super.onSupportNavigateUp();
        }
}
