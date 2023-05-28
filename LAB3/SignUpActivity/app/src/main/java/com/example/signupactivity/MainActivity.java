package com.example.signupactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.txtUname);
        password = findViewById(R.id.txtPassword);
    }

    public void signUp(View view) {
        String uName = userName.getText().toString();
        String pwd = password.getText().toString();

        //Let's validate the password
        if(!isValidPassword(pwd)){
            Toast.makeText(getApplicationContext(), "Password is not valid", Toast.LENGTH_LONG).show();
            return;
        }
        Intent intent = new Intent(MainActivity.this, LoginSuccessful.class); //We use .class becos the next java program refers not to the java file but the CLASS file
        intent.putExtra("un", uName);
        intent.putExtra("pass", pwd);
        startActivity(intent); //Starts the activity
    }
    Pattern lowerCase = Pattern.compile("^.*[a-z].*$"); //^ Starts with a small case character and $ represents the end
    Pattern upperCase = Pattern.compile("^.*[A-Z].*$");
    Pattern number = Pattern.compile("^.*[0-9].*$");
    Pattern specialChar = Pattern.compile("^.*[^A-Za-z0-9].*$"); //Cap ie "^" inside square braces indicates that it's negation
    //ie, anything other than upper, lowercase and numbers, is a special character

    private boolean isValidPassword(String pwd) {
        if(pwd.length()<8)
            return false;
        else if(!lowerCase.matcher(pwd).matches())
            return false;
        else if(!upperCase.matcher(pwd).matches())
            return false;
        else if(!number.matcher(pwd).matches())
            return false;
        else if(!specialChar.matcher(pwd).matches())
            return false;

        return true;

    }
}