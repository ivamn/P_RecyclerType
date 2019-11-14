package com.danito.p_recyclertype;

import android.graphics.Bitmap;

public class Dato {
    String textoCorto;
    String textoLargo;
    Bitmap foto;
    int tipo;

    public Dato(String textoCorto, String textoLargo, Bitmap foto, int tipo) {
        this.textoCorto = textoCorto;
        this.textoLargo = textoLargo;
        this.foto = foto;
        this.tipo = tipo;
    }

    public String getTextoCorto() {
        return textoCorto;
    }

    public void setTextoCorto(String textoCorto) {
        this.textoCorto = textoCorto;
    }

    public String getTextoLargo() {
        return textoLargo;
    }

    public void setTextoLargo(String textoLargo) {
        this.textoLargo = textoLargo;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
