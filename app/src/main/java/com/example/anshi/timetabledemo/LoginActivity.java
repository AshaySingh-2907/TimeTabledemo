package com.example.anshi.timetabledemo;


import android.app.ProgressDialog;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText Name,Password;
    private TextView Info;
    private Button Login;
    private int counter=5;
    private TextView userRegistration;
    private FirebaseAuth firebaseAuth;
    private TextView forgotPassword;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Name=findViewById(R.id.etName);
        Password=findViewById(R.id.etPassword);
        Info=findViewById(R.id.tvInfo);
        Login=findViewById(R.id.btnLogin);
        userRegistration=findViewById(R.id.tvRegister);
        forgotPassword=findViewById(R.id.tvForgotPassword);

        Info.setText("No of attempts remaining:5");

        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        FirebaseUser user=firebaseAuth.getCurrentUser();
        if(user !=null)
        {
            finish();
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
        }

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    validate(Name.getText().toString().trim(),Password.getText().toString().trim());
                }
                catch (Exception e)
                {
                    Toast.makeText(LoginActivity.this,"Please Enter all fields",Toast.LENGTH_SHORT).show();
                }

            }
        });

        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,PasswordActivity.class));
            }
        });


    }


    private void validate(String userName,String userPassword)
    {

        progressDialog.setMessage("In Process,Chill a bit");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(userName,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                }
                else
                {

                    Toast.makeText(LoginActivity.this,"LOGIN FAILED",Toast.LENGTH_SHORT).show();

                    counter--;
                    Info.setText("Number of attempts remaining:"+counter);
                    progressDialog.dismiss();
                    if(counter==0)
                    {
                        Login.setEnabled(false);
                    }

                }
            }
        });

    }


}
