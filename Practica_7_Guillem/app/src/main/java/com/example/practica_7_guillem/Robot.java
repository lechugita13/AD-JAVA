package com.example.practica_7_guillem;

import android.os.Parcel;
import android.os.Parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class Robot implements Parcelable {

    private int id;
    private String nombre;
    private String material;
    private int anyo;
    private String tipo;
    private double precio;
    private String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static Creator<Robot> getCREATOR() {
        return CREATOR;
    }

    public Robot(int id, String nombre, String material, int anyo, String tipo, double precio, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.material = material;
        this.anyo = anyo;
        this.tipo = tipo;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    protected Robot(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
        material = in.readString();
        anyo = in.readInt();
        tipo = in.readString();
        precio = in.readDouble();
        descripcion = in.readString();
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
        dest.writeInt(id);
        dest.writeString(nombre);
        dest.writeString(material);
        dest.writeInt(anyo);
        dest.writeString(tipo);
        dest.writeDouble(precio);
        dest.writeString(descripcion);
    }
}
