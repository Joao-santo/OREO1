package com.example.hp.oreo.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.hp.oreo.BancoDados.ConfiguracaoFirebase;
import com.example.hp.oreo.Helper.Base64Custon;
import com.example.hp.oreo.Helper.Preferencias;
import com.example.hp.oreo.R;
import com.example.hp.oreo.modelo.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

public class OreoCadastro extends AppCompatActivity {

    private EditText edtCadNome,  edtCadSenha, edtCadCpf, edtCadFuncao,
            edtCadSetor,edtCadConfirmarSenha, edtCadEmail ;

    private RadioButton rbFeminino, rbMasculino;
    private Button btnGravar;
    private Usuario usuario;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oreo_cadastro);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        edtCadNome = (EditText) findViewById(R.id.edtCadNome);
        edtCadCpf = (EditText) findViewById(R.id.edtCadCpf);
        edtCadEmail = (EditText) findViewById(R.id.edtCadEmail);
        edtCadFuncao = (EditText) findViewById(R.id.edtCadFuncao);
        edtCadSetor = (EditText) findViewById(R.id.edtCadSetor);
        edtCadSenha = (EditText) findViewById(R.id.edtCadSenha);
        edtCadConfirmarSenha = (EditText) findViewById(R.id.edtCadConfirmarSenha);
        rbFeminino = (RadioButton) findViewById(R.id.rbFeminino);
        rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);


        btnGravar = (Button) findViewById(R.id.btnGravar);
        btnGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (edtCadSenha.getText().toString().equals(edtCadConfirmarSenha.getText().toString())){
                    usuario = new Usuario();
                    usuario.setNome(edtCadNome.getText().toString());
                    usuario.setFuncao(edtCadFuncao.getText().toString());
                    usuario.setSetor(edtCadSetor.getText().toString());
                    usuario.setCpf(edtCadCpf.getText().toString());
                    usuario.setEmail(edtCadEmail.getText().toString());
                    usuario.setSenha(edtCadSenha.getText().toString());


                    if (rbFeminino.isChecked()){
                        usuario.setSexo("Feminino");
                    }else {
                        usuario.setSexo("Masculino");
                    }

                    cadastrarUsuario();

                }else {
                    Toast.makeText(OreoCadastro.this, "As senhas devem ser iguais", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    private void cadastrarUsuario(){

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(OreoCadastro.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(OreoCadastro.this, "Usuario Cadastrado com sucesso", Toast.LENGTH_LONG).show();

                    String identificadorUsuario = Base64Custon.codificarBase64(usuario.getEmail());

                    FirebaseUser usuarioFirebase = task.getResult().getUser();
                    usuario.setId(identificadorUsuario);
                    usuario.salvar();

                    Preferencias preferencias = new Preferencias(OreoCadastro.this);
                    preferencias.salvarUsuarioPreferencias(identificadorUsuario, usuario.getNome());

                    abrirLoginUsusario();

                }else {

                    String erroExcecao = "";

                    try {
                        throw task.getException();

                    }catch (FirebaseAuthWeakPasswordException e){
                        erroExcecao = "Digite uma senha mais forte, contendo no minimo 8 caracteres ciom nymeros e letras";

                    }catch (FirebaseAuthInvalidCredentialsException e){
                        erroExcecao = "O E-mail digitado esta errado";

                    }catch (FirebaseAuthUserCollisionException e){
                        erroExcecao = "Esse E-mail ja esta cadastradp no sistema";

                    }catch (Exception e){
                        erroExcecao = "Erro ao efetuar cadastro ";

                        e.printStackTrace();
                    }
                    Toast.makeText(OreoCadastro.this, "Erro: "+ erroExcecao, Toast.LENGTH_LONG).show();

                }

            }
        });

    }

    public void abrirLoginUsusario(){
        Intent intent = new Intent(OreoCadastro.this, OreoLogin.class);

        startActivity(intent);
        finish();
    }

}
