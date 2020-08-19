package com.kenyankoda.transporttrackerke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MembersAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members_adapter);
    }




    public void gotomap(View v) {

        Intent myIntent = new Intent(MembersAdapterActivity.this, MapsActivity.class);
        startActivity(myIntent);
    }


    public void gotomap2(View v) {

        Intent myIntent = new Intent(MembersAdapterActivity.this, MapsActivity2.class);
        startActivity(myIntent);
    }

    public void gotomap3(View v) {

        Intent myIntent = new Intent(MembersAdapterActivity.this, MapsActivityNext.class);
        startActivity(myIntent);
    }
}