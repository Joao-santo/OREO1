package com.example.hp.oreo.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hp.oreo.R;

public class OreoPrimeiroAcesso extends AppCompatActivity {

    private EditText edtPrimeiroAcessoCpf;
    private EditText edtPrimeiroAcessoSenha;
    private EditText edtPrimeiroAcessoConfirmaSenha;
    private Button btConfirma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oreo_primeiro_acesso);

        edtPrimeiroAcessoCpf = (EditText) findViewById(R.id.edtPrimeiroAcessoCpf);
        edtPrimeiroAcessoSenha = (EditText) findViewById(R.id.edtPrimeiroAcessoSenha);
        edtPrimeiroAcessoConfirmaSenha = (EditText) findViewById(R.id.edtPrimeiroAcessoConfirmaSenha);
        btConfirma = (Button) findViewById(R.id.btnConfirma);

        btConfirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(getApplicationContext(), OreoConversas.class);
            }
        });

    }
}
