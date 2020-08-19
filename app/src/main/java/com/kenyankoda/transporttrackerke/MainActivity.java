package com.kenyankoda.transporttrackerke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }






    public void gotodash(View v){

        Intent myIntent = new Intent(MainActivity.this,DashboardActivity.class);
        startActivity(myIntent);
    }


    public void gotoadapter(View v){

        Intent myIntent = new Intent(MainActivity.this, MembersAdapterActivity.class);
        startActivity(myIntent);
    }








}