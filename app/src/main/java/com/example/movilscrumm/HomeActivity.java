package com.example.movilscrumm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                //Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
                Intent loginIntent = new Intent(getApplicationContext(), ProductListActivity.class);
                startActivity(loginIntent);
            }
        });
    }
}