package com.example.l8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = findViewById(R.id.edtNumber);
    }

    public void delete(View view) {
        String mynum = num.getText().toString();
        mynum = mynum.substring(0,mynum.length()-1);
        num.setText(mynum);
    }

    public void one(View view) {
        num.append("1");
    }

    public void two(View view) {
        num.append("2");
    }

    public void three(View view) {
        num.append("3");
    }

    public void four(View view) {
        num.append("4");
    }

    public void five(View view) {
        num.append("5");
    }

    public void six(View view) {
        num.append("6");
    }

    public void seven(View view) {
        num.append("7");
    }

    public void eight(View view) {
        num.append("8");
    }

    public void nine(View view) {
        num.append("9");
    }

    public void star(View view) {
        num.append("*");
    }

    public void zero(View view) {
        num.append("0");
    }

    public void hash(View view) {
        num.append("#");
    }

    public void call(View view) {
        String mynum = num.getText().toString(); //First read the number using getText
        Intent it = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+mynum));//Use Intent and Parse the num using Uri.parse() method
        startActivity(it);//Start the activity
    }

    public void save(View view) {
        String mynum = num.getText().toString();
        Intent it = new Intent(Intent.ACTION_INSERT, ContactsContract.Contacts.CONTENT_URI);//Do a study on this first, starts the action to Insert
        it.putExtra(ContactsContract.Intents.Insert.PHONE, mynum); //Sounds like SQL & Plain English statements: INSERTS the Data
        startActivity(it);//Finally start the intent
    }
}