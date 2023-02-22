package com.example.snekaershigh;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                MostrarLogin();
            }
        }, 3000);
    }
    private void MostrarLogin(){
        Intent intent = new Intent(MainActivity.this, TelaLogin.class);
        startActivity(intent);
        finish();
    }
    }
