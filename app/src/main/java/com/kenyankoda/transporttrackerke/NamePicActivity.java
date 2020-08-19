package com.kenyankoda.transporttrackerke;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class NamePicActivity extends AppCompatActivity {

    String email,password,name;
    EditText e5_name;
    FirebaseAuth auth;
    FirebaseUser user;
    String userId;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_pic);

        auth= FirebaseAuth.getInstance();
        progressDialog= new ProgressDialog(this);
        Intent myIntent = getIntent();
        e5_name = findViewById(R.id.editTextTextPersonName2);

        if(myIntent!=null)
        {
            email= myIntent.getStringExtra("email");
            password= myIntent.getStringExtra("password");
        }

    }
    public void gotoadapter(View v){
        Intent myIntent= new Intent(NamePicActivity.this,MembersAdapterActivity.class);
        myIntent.putExtra("name",e5_name.getText().toString());
        myIntent.putExtra("email",email);
        myIntent.putExtra("password",password);




        startActivity(myIntent);
        finish();
    }

    public void registerUser(View V)
    {

        progressDialog.setMessage("Please wait as we are creating an account for you.");
        progressDialog.show();
        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            //insert realtime database


                            user = auth.getCurrentUser();
                            CreateUser createUser = new CreateUser(email,password,"false","na","na");
                            user = auth.getCurrentUser();
                            userId = Objects.requireNonNull(user).getUid();








                        }

                    }
                });
        Intent myIntent= new Intent(NamePicActivity.this,MembersAdapterActivity.class);
        myIntent.putExtra("name",e5_name.getText().toString());
        myIntent.putExtra("email",email);
        myIntent.putExtra("password",password);



        sendVerificationEmail();
        startActivity(myIntent);
        finish();
    }

    public void sendVerificationEmail()
    {
        user.sendEmailVerification();








    }

}