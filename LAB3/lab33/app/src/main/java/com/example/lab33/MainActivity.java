package com.example.lab33;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
EditText userName, password;
Button btn;
int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.txt_username);
        password = findViewById(R.id.txt_password);
    }

    public void signUpEvent(View view) {
        String uName = userName.getText().toString();
        String pwd = password.getText().toString();

        if(!isValidPassword(pwd)){
            Toast.makeText(MainActivity.this, "Invalid Password", Toast.LENGTH_LONG).show();
            return;
        }
        Intent it = new Intent(MainActivity.this, LoginActivity.class);
        it.putExtra("userName", uName);
        it.putExtra("pwd", pwd);
        startActivity(it);
    }
    Pattern lowercase = Pattern.compile("^.*[a-z].*$");
    Pattern uppercase = Pattern.compile("^.*[A-Z].*$");
    Pattern numbers = Pattern.compile("^.*[0-9].*$");
    Pattern specialChar = Pattern.compile("^.*[^a-zA-Z0-9].*$");

    private boolean isValidPassword(String pwd) {
        if(pwd.length() < 8)
            return false;
        if(!lowercase.matcher(pwd).matches())
            return false;
        if(!uppercase.matcher(pwd).matches())
            return false;
        if(!numbers.matcher(pwd).matches())
            return false;
        if(!specialChar.matcher(pwd).matches())
            return false;
        return true;
    }

    public void loginEvent(View view) {
    }
}