package com.kenyankoda.transporttrackerke;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    EditText e4_email;
    FirebaseAuth auth;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        e4_email = findViewById(R.id.editTextTextEmailAddress);
        auth = FirebaseAuth.getInstance();
        dialog= new ProgressDialog(this);
    }






    public void gotopassword(View v){



        dialog.setMessage("checking email address");
        dialog.show();
        //check if email is registered
        auth.fetchSignInMethodsForEmail(e4_email.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                    @Override
                    public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                        if(task.isSuccessful()) {
                            dialog.dismiss();
                            boolean check;
                            check = !Objects.requireNonNull(Objects.requireNonNull(task.getResult()).getSignInMethods()).isEmpty();

                            if(!check){
//email does not exist
                                Intent myIntent = new Intent(RegisterActivity.this, PasswordActivity.class);
                                myIntent.putExtra("email",e4_email.getText().toString());
                                startActivity(myIntent);
                                finish();
                            }
                            else{
                                dialog.dismiss();

                                Toast.makeText(getApplicationContext(),"this email is already registered",Toast.LENGTH_LONG).show();

                            }



                        }
                    }
                });


    }

    }
