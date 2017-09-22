package com.example.hp.oreo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hp.oreo.BancoDados.BancoDados;
import com.example.hp.oreo.modelo.JanelaConversas;

/**
 * Created by HP on 01/09/2017.
 */

public class JanelaConversasDAO extends BancoDados {

    private BancoDados helper;


    public JanelaConversasDAO(Context context) {
        super(context);
    }

    public void enviarMensagem (String mensagem, int id){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("1", id);
        values.put("mensagem", mensagem);
        db.insert("", null, values);


    }
    public void enviarAudio ( String mensagem, int id ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("1", id);
        values.put("mensagem", mensagem);
        db.insert("", null, values);


    }

    public void enviarDocumento (String mensagem, int id ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("1", id);
        values.put("mensagem", mensagem);
        db.insert("", null, values);


    }

    public void enviarImagem (String mensagem, int id ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("1", id);
        values.put("mensagem", mensagem);
        db.insert("", null, values);


    }

    public void enviarVideo (String mensagem, int id  ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("1", id);
        values.put("mensagem", mensagem);
        db.insert("", null, values);


    }

    public JanelaConversas buscarPalavra ( int id){


        JanelaConversas mensagem = null;
        SQLiteDatabase db = helper.getWritableDatabase();

        String sql = "SELECT _id, nome FROM turma WHERE id = ? ";
        String[] filtros = new String[1];
        filtros[0] = id+"";

        Cursor cursor = db.rawQuery(sql, filtros);
        if (cursor.moveToFirst()){
            int idJanela = cursor.getInt(0);
            String procuraPalavra = cursor.getString(1);

            mensagem = new JanelaConversas();

        }
        return mensagem;


    }

    public void idConversa ( ){


    }

}
