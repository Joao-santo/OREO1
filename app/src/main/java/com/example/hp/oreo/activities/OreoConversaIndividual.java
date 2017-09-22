package com.example.hp.oreo.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.example.hp.oreo.R;

public class OreoConversaIndividual extends AppCompatActivity {

    private Button btVoltar;
    private QuickContactBadge imagem;
    private TextView contatoConversa;
    private SearchView pesquisarPalavra;
    private ListView lvMensagemIndividual;
    private Button btnAnexo, btnEnviarMensagem;
    private EditText edtMensagemDigitada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oreo_contatos);

        btVoltar = (Button) findViewById(R.id.btnConectar);
        imagem = (QuickContactBadge) findViewById(R.id.quickContactBadge);
        contatoConversa = (TextView) findViewById(R.id.txtNome);
        lvMensagemIndividual = (ListView) findViewById(R.id.lvMensagemIndividual);
        btnAnexo = (Button) findViewById(R.id.btnAnexo);
        btnEnviarMensagem = (Button) findViewById(R.id.btnEnviarMensagem);
        edtMensagemDigitada = (EditText) findViewById(R.id.edtMensagemDigitada);

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),OreoConversas.class);
                startActivity(i);
            }
        });

        btnEnviarMensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),OreoConversas.class);
                startActivity(i);
            }
        });

        btnAnexo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),OreoConversas.class);
                startActivity(i);
            }
        });

    }
}


