package com.akshara.becomputer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    private String username, fullname,email, password;
    private EditText etUsername, etFullname, etEmail, etPassword;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //VariableName = findViewById(ID of View .xml file ko)
        btnSignup = findViewById(R.id.btnSignup);

        etUsername = findViewById(R.id.etUsername);
        etFullname = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(meroValidation()){
                    Intent intent = new Intent(SignupActivity.this,
                            LoginActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(SignupActivity.this,
                       "Please enter details correctly",Toast.LENGTH_LONG)
                       .show();
                }
            }
        });

        setAppBar();

    }

    private void setAppBar(){
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }
    private boolean meroValidation() {
        username = etUsername.getText().toString();
        fullname = etFullname.getText().toString();
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();

        if(username.isEmpty()){
            etUsername.setError("Username cannot be blank");
            return  false;
        }
        if(fullname.isEmpty()){
            etFullname.setError("Fullname cannot be blank");
            return false;}
        if(email.isEmpty()){
            etEmail.setError("Email cannot be blank");
            return false;
        }
        if(password.isEmpty()){
            etPassword.setError("Password cannot be blank");
            return false;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}