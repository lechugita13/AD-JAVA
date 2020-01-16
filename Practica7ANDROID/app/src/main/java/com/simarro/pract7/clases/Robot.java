package com.simarro.pract7.clases;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Robot implements Parcelable {

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

    public static final Creator<Robot> CREATOR = new Creator<Robot>() {
        @Override
        public Robot createFromParcel(Parcel in) {
            return new Robot(in);
        }

        @Override
        public Robot[] newArray(int size) {
            return new Robot[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(dni);
        parcel.writeString(nombre);
        parcel.writeInt((int) sexo);
    }
}
