package com.example.hp.oreo.modelo;

import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by HP on 29/08/2017.
 */

public class TabelaConversas {


    private String nome;
    private ImageButton icone;
    private EditText previa;
    private EditText data;

    public TabelaConversas(String nome, ImageButton icone, EditText previa, EditText data) {
        this.nome = nome;
        this.icone = icone;
        this.previa = previa;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ImageButton getIcone() {
        return icone;
    }

    public void setIcone(ImageButton icone) {
        this.icone = icone;
    }

    public EditText getPrevia() {
        return previa;
    }

    public void setPrevia(EditText previa) {
        this.previa = previa;
    }

    public EditText getData() {
        return data;
    }

    public void setData(EditText data) {
        this.data = data;
    }

  }

