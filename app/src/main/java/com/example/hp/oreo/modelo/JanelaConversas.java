package com.example.hp.oreo.modelo;

import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by HP on 29/08/2017.
 */

public class JanelaConversas {

    private  int id;
    private EditText mensagem;
    private ImageButton icone;
    private EditText nome;
    private EditText data;
    private EditText audio;
    private EditText imagem;
    private EditText video;

    public void janelaConversas( int id){


    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMensagem(EditText mensagem) {
        this.mensagem = mensagem;
    }

    public void setIcone(ImageButton icone) {
        this.icone = icone;
    }

    public void setNome(EditText nome) {
        this.nome = nome;
    }

    public void setData(EditText data) {
        this.data = data;
    }

    public void setAudio(EditText audio) {
        this.audio = audio;
    }

    public void setImagem(EditText imagem) {
        this.imagem = imagem;
    }

    public void setVideo(EditText video) {
        this.video = video;
    }

    public int getId() {
        return id;
    }

    public EditText getMensagem() {
        return mensagem;
    }

    public ImageButton getIcone() {
        return icone;
    }

    public EditText getNome() {
        return nome;
    }

    public EditText getData() {
        return data;
    }

    public EditText getAudio() {
        return audio;
    }

    public EditText getImagem() {
        return imagem;
    }

    public EditText getVideo() {
        return video;
    }
}
