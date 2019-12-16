package adt5_ejemplo2a;

public class Alumno {
    
    private int id;
    private String nombre;
    private String apellidos;
    private int edad;

    public Alumno() {
    }

    public Alumno(int id, String nombre, String apellidos, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Alumno: id: " + id + " - Nombre y apellidos: " + nombre + " " + apellidos + " - Edad: " + edad;
    }
    
}
