package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ed;
    String op = "+";
    String oldNum, newNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed = findViewById(R.id.display);
    }

    public void numberEvent(View view) { //View is a class and view is the variable of the class, observe the casing
        String num = ed.getText().toString();
        switch(view.getId()){
            case R.id.btn0:num+=0;break;
            case R.id.btn1:num+=1;break;
            case R.id.btn2:num+=2;break;
            case R.id.btn3:num+=3;break;
            case R.id.btn4:num+=4;break;
            case R.id.btn5:num+=5;break;
            case R.id.btn6:num+=6;break;
            case R.id.btn7:num+=7;break;
            case R.id.btn8:num+=8;break;
            case R.id.btn9:num+=9;break;
        }
        ed.setText(num);
    }

    public void operatorEvent(View view) {
        oldNum = ed.getText().toString();
        switch (view.getId()){
            case R.id.btnPlus:op = "+"; break;
            case R.id.btnNeg: op = "-"; break;
            case R.id.btnMul:op = "*"; break;
            case R.id.btnDiv:op = "/"; break;
        }
        ed.getText().clear();
    }

    public void clearEvent(View view) {

        ed.getText().clear();
    }

    public void assignEvent(View view) {
        newNum = ed.getText().toString();
        Double result = 0.0;
        switch (op){
            case "+": result=Double.parseDouble(oldNum) + Double.parseDouble(newNum); break;
            case "-": result=Double.parseDouble(oldNum) - Double.parseDouble(newNum); break;
            case "*": result=Double.parseDouble(oldNum) * Double.parseDouble(newNum); break;
            case "/": result=Double.parseDouble(oldNum) / Double.parseDouble(newNum); break;
        }
        ed.setText(result + " ");
    }


}