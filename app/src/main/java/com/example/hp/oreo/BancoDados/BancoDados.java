package com.example.hp.oreo.BancoDados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HP on 03/09/2017.
 */

public class BancoDados extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "oreo.sqlite";
    private static final int VERSAO_BANCO = 1;



    public BancoDados(Context context) {

        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE cadastro ( _id INTEGER PRIMARY KEY, ");
        sb.append("                      cpf TEXT, ");
        sb.append("                      nome TEXT, ");
        sb.append("                      funcao TEXT, ");
        sb.append("                      setor TEXT); ");

        db.execSQL(db.toString());

        sb = new StringBuilder();
        sb.append("CREATE TABLE contatos ( _id INTEGER PRIMARY KEY, ");
        sb.append("grupo_setor TEXT, ");
        sb.append("nome TEXT, ");
        sb.append("apelido TEXT, ");
        sb.append("setor TEXT, ");
        sb.append("icone TEXT, ");
        sb.append("conversa arquivada TEXT); ");
        db.execSQL(sb.toString());

        sb = new StringBuilder();
        sb.append("CREATE TABLE janelaConversas ( _id INTEGER PRIMARY KEY, ");
        sb.append("mensagem TEXT,");
        sb.append("nome TEXT, ");
        sb.append("apelido TEXT, ");
        sb.append("setor TEXT, ");
        sb.append("icone TEXT, ");
        sb.append("audio TEXT,");
        sb.append("midia TEXT, ");
        sb.append("documento TEXT); ");
        db.execSQL(sb.toString());



        sb = new StringBuilder();
        sb.append("CREATE TABLE tabelaConversas ( _id INTEGER PRIMARY KEY, ");
        sb.append("ultima_Conversa TEXT, ");
        sb.append("icone TEXT, ");
        sb.append("nome TEXT, ");
        sb.append("apelido TEXT, ");
        sb.append("setor TEXT, ");
        sb.append("data DATE, ");
        sb.append("previa TEXT); ");
        db.execSQL(sb.toString());

        sb = new StringBuilder();


        sb = new StringBuilder();
        sb.append("CREATE TABLE login ( _id INTEGER PRIMARY KEY, ");
        sb.append("                      nome TEXT, ");
        sb.append("                      cpf TEXT); ");
        db.execSQL(sb.toString());

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}


