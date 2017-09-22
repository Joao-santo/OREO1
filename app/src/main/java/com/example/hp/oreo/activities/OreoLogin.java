package com.example.hp.oreo.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.oreo.BancoDados.ConfiguracaoFirebase;
import com.example.hp.oreo.R;
import com.example.hp.oreo.modelo.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class OreoLogin extends AppCompatActivity {

    private EditText edtEmail, edtSenha ;
    private TextView txtSenhaEsquecida;
    private Button btnConectar;
    private FirebaseAuth autenticacao;
    private Usuario usuarios;
    private ImageView ivlogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oreo_login);



        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtSenha = (EditText) findViewById(R.id.edtSenha);


        btnConectar = (Button) findViewById(R.id.btnConectar);

       // verificaUsuarioLogado();


        btnConectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtEmail.getText().toString().equals("") && !edtSenha.getText().toString().equals("")){

                    usuarios = new Usuario();
                    usuarios.setEmail(edtEmail.getText().toString());
                    usuarios.setSenha(edtSenha.getText().toString());

                    validarLogin();

                }else {
                    Toast.makeText(OreoLogin.this, "Preencha os campos de Email e Senha", Toast.LENGTH_LONG).show();
                }

            }
        });

        txtSenhaEsquecida = (TextView) findViewById(R.id.txtSenhaEsquecida);
        txtSenhaEsquecida.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                abreCadastroUsuario();
            }
        });

    }

    private void validarLogin(){

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(usuarios.getEmail(), usuarios.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){

                    abrirTelaPrincipal();

                    Toast.makeText(OreoLogin.this, "Login efetuado com sucesso", Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(OreoLogin.this, "Usuario ou senha INVALIDO", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
    public void abrirTelaPrincipal(){

        Intent intentAbrirTelaPrincipal = new Intent(OreoLogin.this, OreoConversas.class);
        startActivity(intentAbrirTelaPrincipal);

    }
    public void abreCadastroUsuario(){

        Intent intent = new Intent(OreoLogin.this, OreoCadastro.class);
        startActivity(intent);
    }
    private void verificaUsuarioLogado(){

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        if (autenticacao.getCurrentUser() !=null){

            abrirTelaPrincipal();

        }else{
            Intent intent = new Intent(OreoLogin.this, OreoLogin.class);
            startActivity(intent);
            finish();


        }
    }


}