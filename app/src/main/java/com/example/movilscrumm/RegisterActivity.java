package com.example.movilscrumm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private Button btnRegister;
    private EditText email;
    private EditText password;
    private EditText confirmPassword;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        email  = (EditText) findViewById(R.id.email);
        password  = (EditText) findViewById(R.id.password);
        confirmPassword  = (EditText) findViewById(R.id.confirmPassword);
        mAuth = FirebaseAuth.getInstance();

        setRegisterButton();
    }

    private void setRegisterButton() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    private void register() {
        String emailText = email.getText().toString().trim();
        String passwordText = password.getText().toString().trim();
        String confirmPasswordText = confirmPassword.getText().toString().trim();
        if(passwordText.compareTo(confirmPasswordText) != 0){
            Toast.makeText(getApplicationContext(),"Las contraseñas son diferentes",Toast.LENGTH_SHORT).show();
            return;
        }
         mAuth.createUserWithEmailAndPassword(emailText,passwordText)
                 .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {
                         if(task.isSuccessful()){
                             Toast.makeText(getApplicationContext(),"Usuario registrado",Toast.LENGTH_SHORT).show();
                             Intent logintIntent = new Intent(getApplicationContext(),LoginActivity.class);
                             startActivity(logintIntent);
                         }
                     }
                 }).addOnFailureListener(new OnFailureListener() {
                     @Override
                     public void onFailure(@NonNull Exception e) {
                         System.out.println("________"+e.getMessage());
                         switch (e.getMessage()) {
                             case "The email address is badly formatted.":
                                 Toast.makeText(getApplicationContext(),"Correo invalido",Toast.LENGTH_SHORT).show();
                             case "The given password is invalid. [ Password should be at least 6 characters ]":
                                 Toast.makeText(getApplicationContext(),"La contraseña deber  ser de almenos  6 caracteres",Toast.LENGTH_SHORT).show();
                             default:
                                 Toast.makeText(getApplicationContext(),"Error de registro",Toast.LENGTH_SHORT).show();
                         }
                     }
                 });
    }
}