package com.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    boolean isEmpty = true;
    String numOld= "";
    EditText edt;
    String operator = "+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt = findViewById(R.id.editText);
    }

    public void clearEvent(View view) {
        edt.setText("0");
        isEmpty=true;
    }

    public void numberEvent(View view) {
        if(isEmpty)
            edt.setText("");
        isEmpty = false;
        String number = edt.getText().toString();
        switch (view.getId()) {
            case R.id.btn0:number+="0";break;
            case R.id.btn1:number+="1";break;
            case R.id.btn2:number+="2";break;
            case R.id.btn3:number+="3";break;
            case R.id.btn4:number+="4";break;
            case R.id.btn5:number+="5";break;
            case R.id.btn6:number+="6";break;
            case R.id.btn7:number+="7";break;
            case R.id.btn8:number+="8";break;
            case R.id.btn9:number+="9";break;
            case R.id.btnDot:number+=".";break;
            case R.id.btnPlusMinus:number="-"+number;break;
        }
        edt.setText(number);
    }

    public void operatorEvent(View view) {
        isEmpty = true;
        numOld = edt.getText().toString();//Strores the number in old Variable(numOld)
        switch (view.getId()){
            case R.id.btnDivide:operator = "/"; break;
            case R.id.btnMultiply:operator = "*"; break;
            case R.id.btnPlus:operator = "+"; break;
            case R.id.btnSub:operator = "-"; break;

        if(!operator.isEmpty()){
            Double ans=0.0;
            switch(operator){
                case "+":   ans = Double.parseDouble(numOld) + Double.parseDouble(edt.getText().toString()); break;
                case "-":   ans = Double.parseDouble(numOld) - Double.parseDouble(edt.getText().toString()); break;
                case "*":   ans = Double.parseDouble(numOld) * Double.parseDouble(edt.getText().toString()); break;
                case "/":   ans = Double.parseDouble(numOld) / Double.parseDouble(edt.getText().toString()); break;
                default :   ans = Double.parseDouble(edt.getText().toString());
            }
            edt.setText(ans.toString());
        }
        numOld = edt.getText().toString();
        Double ans=0.0;
        switch(view.getId()){
            case R.id.btnPlus: operator="+"; break;
            case R.id.btnSub: operator="-"; break;
            case R.id.btnMultiply: operator="*"; break;
            case R.id.btnDivide: operator="/"; break;
            case R.id.btnSquared:  ans = Double.parseDouble(numOld.toString()) * Double.parseDouble(edt.getText().toString());
                edt.setText(ans.toString());
                return;
            case R.id.btnPercent:   ans = Double.parseDouble(numOld.toString()) / 100;
                edt.setText(ans.toString());
                return;
        }
        edt.setText("");
    }

    public void equalEvent(View view) {
        String numNew = edt.getText().toString();
        double result = 0.0;
        switch (operator){
            case "+":
                result=Double.parseDouble(numOld)+Double.parseDouble(numNew);
                break;
            case "-":
                result=Double.parseDouble(numOld)-Double.parseDouble(numNew);
                break;
            case "*":
                result=Double.parseDouble(numOld)*Double.parseDouble(numNew);
                break;
            case "/":
                result=Double.parseDouble(numOld)/Double.parseDouble(numNew);
                break;
        }
        edt.setText(result+"");
    }

    public void percentEvent(View view) {
        double num = Double.parseDouble(edt.getText().toString()) / 100;
        edt.setText(num+"");
        isEmpty=true;
    }
}