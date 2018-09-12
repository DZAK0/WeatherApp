package com.jw.weatherapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button weather;
    private EditText city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weather = findViewById(R.id.WeatherButton);
        city = findViewById(R.id.CityNameEditText);
        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Check()) {
                    Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                    intent.putExtra("City", city.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    private boolean Check() {
        if(city.getText().toString().equals("")){
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
            dialogBuilder.setCancelable(false);
            dialogBuilder.setTitle("Error!");
            dialogBuilder.setMessage("Enter city name!");
            dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AlertDialog dialog = dialogBuilder.create();
            dialog.show();
            return false;
        }
        return true;
    }
}
