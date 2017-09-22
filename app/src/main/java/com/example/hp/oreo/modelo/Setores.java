package com.example.hp.oreo.modelo;

import android.widget.EditText;

/**
 * Created by HP on 03/09/2017.
 */

public class Setores {

    private int id;
    private EditText nomeSetor;

    public Setores(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public EditText getNomeSetor() {
        return nomeSetor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomeSetor(EditText nomeSetor) {
        this.nomeSetor = nomeSetor;
    }
}
