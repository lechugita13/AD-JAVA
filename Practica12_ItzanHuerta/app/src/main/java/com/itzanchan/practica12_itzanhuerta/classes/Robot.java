package com.itzanchan.practica12_itzanhuerta.classes;

import android.os.Parcel;
import android.os.Parcelable;

public class Robot implements Parcelable {

    public long id;
    public String nombre;
    public String material;
    public int anyo;
    public Tipo tipo;
    public double precio;
    public String descripcion;

    public Robot() {
    }

    public Robot(String nombre, String material, int anyo, Tipo tipo, double precio, String descripcion) {
        this.nombre = nombre;
        this.material = material;
        this.anyo = anyo;
        this.tipo = tipo;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public Robot(String nombre, String material, int anyo, Tipo tipo) {
        this.nombre = nombre;
        this.material = material;
        this.anyo = anyo;
        this.tipo = tipo;
    }

    protected Robot(Parcel in) {
        id = in.readLong();
        nombre = in.readString();
        material = in.readString();
        anyo = in.readInt();
        precio = in.readDouble();
        descripcion = in.readString();
        tipo = Tipo.values()[in.readInt()];
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(nombre);
        dest.writeString(material);
        dest.writeInt(anyo);
        dest.writeDouble(precio);
        dest.writeString(descripcion);
        dest.writeInt(tipo.ordinal());
    }
}
