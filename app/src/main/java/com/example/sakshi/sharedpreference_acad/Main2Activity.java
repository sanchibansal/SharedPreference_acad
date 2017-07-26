package com.example.sakshi.sharedpreference_acad;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ///shared preference
        SharedPreferences sharedPreferences = getSharedPreferences("pref",MODE_PRIVATE);
        //getting shared preference data fro name, age, phone and city
        String name = sharedPreferences.getString("Name","null");
        int age = sharedPreferences.getInt("Age",0);
        String phone = sharedPreferences.getString("Phone","0");
        String city = sharedPreferences.getString("City","null");
        text = (TextView)findViewById(R.id.text);
        //setting data in TextView
        text.setText("Name: "+name+"\nAge: "+age+"\nPhone: "+phone+"\nCity: "+city);
    }
}
