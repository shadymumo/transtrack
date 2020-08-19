package com.kenyankoda.transporttrackerke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PasswordActivity extends AppCompatActivity
{
    String email;
    EditText e3_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);


        e3_password = findViewById(R.id.editTextTextPassword);

        setContentView(R.layout.activity_password);

        Intent myIntent = getIntent();
        if(myIntent!=null) {
            email = myIntent.getStringExtra("email");

        }








    }



    public void gotoname(View v){

if(e3_password==null)
{

    Toast.makeText(getApplicationContext(),"key in your password",Toast.LENGTH_LONG).show();



    }
else
    {


        Intent myIntent = new Intent(PasswordActivity.this, NamePicActivity.class);
        myIntent.putExtra("email",email );
        myIntent.putExtra("password",e3_password.getText().toString());
        startActivity(myIntent);
        finish();

}
    }




}