package com.example.sakshi.sharedpreference_acad;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //declaring buttons and editTexts
    Button save, show;
    EditText name, age, phone, city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //associating buttons and editexts with their respective Ids
        save = (Button)findViewById(R.id.save);
        show = (Button) findViewById(R.id.show);
        name = (EditText)findViewById(R.id.name);
        age = (EditText)findViewById(R.id.age);
        phone = (EditText)findViewById(R.id.phone);
        city = (EditText)findViewById(R.id.city);
        //creating shared preference
        final SharedPreferences sharedPreferences = getSharedPreferences("pref",MODE_PRIVATE);
        //on click listener for save button
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getting data from name editText
                String getname = name.getText().toString();
                //getting data from age EditText
                int getage = Integer.parseInt(age.getText().toString());
                //getting data from phone EditText
                String getphone = phone.getText().toString();
                //getting data from city EditText
                String getcity = city.getText().toString();
                //Shared Preference Editor for editing shared preference
                SharedPreferences.Editor editor = sharedPreferences.edit();
                //putting values of name, age, phone and city in shared preference
                editor.putString("Name",getname);
                editor.putInt("Age",getage);
                editor.putString("Phone",getphone);
                editor.putString("City",getcity);
                //committing changes in shared preference
                editor.commit();
                //Toast for showing data has been saved
                Toast.makeText(MainActivity.this, "Data Saved!", Toast.LENGTH_SHORT).show();
            }
        });
        //on click listener for show button
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent for opening new activity
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });
    }
}
