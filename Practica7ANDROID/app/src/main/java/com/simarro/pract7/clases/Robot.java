package com.simarro.pract7.clases;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Robot implements Serializable {

    private String dni;
    private String nombre;
    private char sexo;



    public Robot(String dni, String nombre, char sexo) {
        this.dni = dni;
        this.nombre = nombre;
        this.sexo = sexo;
    }

    protected Robot(Parcel in) {
        dni = in.readString();
        nombre = in.readString();
        sexo = (char) in.readInt();
    }



    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }


}
