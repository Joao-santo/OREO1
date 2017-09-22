package com.example.hp.oreo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.hp.oreo.BancoDados.BancoDados;


/**
 * Created by HP on 29/08/2017.
 */

public class CadastroDAO extends BancoDados {


    public CadastroDAO(Context context) {
        super(context);
    }

    public void inserir (int id, String nome, int cpf, String email, String endereco, int telefone, String setor, String funcao ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("1", id);
        values.put("nome", nome);
        values.put("cpf", cpf);
        values.put("email", email);
        values.put("endereco", endereco);
        values.put("telefone", telefone);
        values.put("funcao", funcao);
        db.insert("Cadastro", null, values);

    }

    public boolean remover ( String nome, int cpf){


        return false;
    }

    public void buscar ( String nome, int cpf){



    }

    public void buscarTodos (String nome, int cpf ){



    }

    public void atualizar (String nome, int cpf ){



    }
}
