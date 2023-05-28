package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = findViewById(R.id.edtNumber);
    }

    public void Del(View view) {
        String numdel = number.getText().toString();
        numdel = numdel.substring(0,numdel.length()-1);
        number.setText(numdel);
    }

    public void one(View view) {
        number.append("1");
    }

    public void two(View view) {
        number.append("2");
    }

    public void three(View view) {
        number.append("3");
    }


    public void four(View view) {
        number.append("4");
    }

    public void five(View view) {
        number.append("5");
    }

    public void six(View view) {
        number.append("6");
    }

    public void seven(View view) {
        number.append("7");
    }

    public void eight(View view) {
        number.append("8");
    }

    public void nine(View view) {
        number.append("9");
    }

    public void star(View view) {
        number.append("*");
    }

    public void zero(View view) {
        number.append("0");
    }

    public void hash(View view) {
        number.append("#");
    }

    public void call(View view) {
        String mynum = number.getText().toString();
        Intent it = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+mynum));
        startActivity(it);
    }

    public void save(View view) {
        String mynum = number.getText().toString();
        Intent it = new Intent(Intent.ACTION_INSERT, ContactsContract.Contacts.CONTENT_URI);
        it.putExtra(ContactsContract.Intents.Insert.PHONE, mynum);
        startActivity(it);
    }
}