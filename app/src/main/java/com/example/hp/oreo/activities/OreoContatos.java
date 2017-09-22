package com.example.hp.oreo.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hp.oreo.Adapter.FuncionarioAdapter;
import com.example.hp.oreo.BancoDados.ConfiguracaoFirebase;
import com.example.hp.oreo.R;
import com.example.hp.oreo.modelo.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class OreoContatos extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<Usuario> adapter;
    private ArrayList<Usuario> funcionarios;
    private DatabaseReference firebase;
    private ValueEventListener valueEventListenerFuncionario;
    private AlertDialog alerta;
    private Usuario funcionarioExcluir;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oreo_contatos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }


        });
        funcionarios = new ArrayList<>();
        listView = (ListView) findViewById(R.id.lvContatos);
        adapter = new FuncionarioAdapter(this, funcionarios);
        listView.setAdapter(adapter);

        firebase = ConfiguracaoFirebase.getFirebase().child("usuario");

        valueEventListenerFuncionario = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                funcionarios.clear();

                for (DataSnapshot dados : dataSnapshot.getChildren()) {
                    Usuario funcionarioNovo = dados.getValue(Usuario.class);

                    funcionarios.add(funcionarioNovo);
                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                funcionarioExcluir = adapter.getItem(i);

                //cria o gerador do alertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(OreoContatos.this);

                //Define o título
                builder.setTitle("Confirma exclusão?");

                //define uma mensagem
                builder.setMessage("Você deseja excluir - " + funcionarioExcluir.getNome().toString() + " - ?");

                //define botão sim
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        firebase = ConfiguracaoFirebase.getFirebase().child("addFuncionarios");

                        firebase.child(funcionarioExcluir.getNome().toString()).removeValue();

                        Toast.makeText(OreoContatos.this, "Exclusão efetuada!", Toast.LENGTH_LONG).show();
                    }
                });

                //define o botão não

                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(OreoContatos.this, "Exclusão Cancelada efetuada!", Toast.LENGTH_LONG).show();
                    }
                });

                //criar o alertdialog
                alerta = builder.create();

                //exibe alertdialog
                alerta.show();
            }
        });

    }




    @Override
    protected void onStop() {
        super.onStop();
        firebase.removeEventListener(valueEventListenerFuncionario);
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebase.addValueEventListener(valueEventListenerFuncionario);
    }
}



