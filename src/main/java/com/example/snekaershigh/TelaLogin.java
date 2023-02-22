package com.example.snekaershigh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaLogin extends AppCompatActivity {
    String nomeper;
    EditText campo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        final Button botao = (Button) findViewById(R.id.button);
        botao.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaLogin.this, TelaInicial.class);
                startActivity(intent);

            }
        });

    }

}