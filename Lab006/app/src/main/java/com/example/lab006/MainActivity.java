package com.example.lab006;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {
    TextView resxml, resjson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resxml=findViewById(R.id.resxml);
        resjson = findViewById(R.id.resjson);
    }

    public void XMLParser(View view) {
        try {
            InputStream inputStream = getAssets().open("city.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputStream);
            Element element = doc.getDocumentElement();
            element.normalize();

            NodeList nodeList = doc.getElementsByTagName("place");
            resxml.setText("XML DATA");
            for(int i =0; i<nodeList.getLength();i++){

            }




        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    public void JSONParser(View view) {
    }
}