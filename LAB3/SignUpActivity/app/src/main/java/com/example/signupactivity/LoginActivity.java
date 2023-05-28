package com.example.signupactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText loginUser, loginPwd;
    String regUname = getIntent().getStringExtra("un");
    String regPwd = getIntent().getStringExtra("pass");
    int counter = 2;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginUser = findViewById(R.id.loginUser);
        loginPwd = findViewById(R.id.loginPwd);
        loginBtn = findViewById(R.id.button);
    }

    public void loginEvent(View view) {
        String un = loginUser.getText().toString();
        String pass = loginPwd.getText().toString();
        if(regUname.equals(un) && regPwd.equals(pass)){
            Intent intent = new Intent(LoginActivity.this, LoginSuccessful.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_LONG).show();
            counter--;
        }
        if(counter==0){
            loginBtn.setEnabled(false);
        }
    }
}