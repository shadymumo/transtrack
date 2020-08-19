package com.kenyankoda.transporttrackerke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }





    public void gotologin(View v){

        Intent myIntent = new Intent(DashboardActivity.this,LoginActivity.class);
        startActivity(myIntent);
    }


    public void gotoregister(View v){

        Intent myIntent = new Intent(DashboardActivity.this, RegisterActivity.class);
        startActivity(myIntent);
    }
}