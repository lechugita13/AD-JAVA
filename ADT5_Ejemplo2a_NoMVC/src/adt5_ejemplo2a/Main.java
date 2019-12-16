package adt5_ejemplo2a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.exit;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        int opcion = -1;
        ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        while (opcion != 5) {
            mostrarMenu();

            opcion = Integer.parseInt(stdin.readLine());

            // AltaUsuario
            if (opcion == 1) {
                System.out.println("************************************");

                int idAux = pedirId(stdin);
                String nombreAux = pedirNombre(stdin);
                String apellidosAux = pedirApellidos(stdin);
                int edadAux = pedirEdad(stdin);

                Alumno alumno = new Alumno(idAux, nombreAux, apellidosAux, edadAux);
                listaAlumnos.add(alumno);

            } // Fin AltaUsuario

            // ModificacionUsuario
            if (opcion == 2) {

                System.out.println("************************************");
                System.out.println("Indique el id del alumno a modificar: ");
                int idAux = Integer.parseInt(stdin.readLine());
                Alumno alumno = null;

                for (int i = 0; i < listaAlumnos.size(); i++) {
                    if (listaAlumnos.get(i).getId() == idAux) {
                        alumno = listaAlumnos.get(i);
                    }
                }

                if (alumno != null) {
                    String nombreAux = pedirNombre(stdin);
                    String apellidosAux = pedirApellidos(stdin);
                    int edadAux = pedirEdad(stdin);

                    alumno.setNombre(nombreAux);
                    alumno.setApellidos(apellidosAux);
                    alumno.setEdad(edadAux);

                    // No haria falta hacerlo pero para despues explicar el MVC
                    // si fuera de base de datos si que tendriamos q hacerlo
                    int j = 0;
                    boolean enc = false;
                    while ((j < listaAlumnos.size()) && (enc == false)) {
                        if (listaAlumnos.get(j).getId() == alumno.getId()) {
                            listaAlumnos.set(j, alumno);
                            enc = true;
                        } else {
                            j++;
                        }
                    }
                    System.out.println("Alumno modificado correctamente.\n");
                }

            }// Fin ModificacionUsuario

            // BorrarUsuario
            if (opcion == 3) {
                System.out.println("************************************");
                System.out.println("Indique el id del alumno a borrar: ");
                int idAux = Integer.parseInt(stdin.readLine());

                for (int i = 0; i < listaAlumnos.size(); i++) {
                    if (listaAlumnos.get(i).getId() == idAux) {
                        listaAlumnos.remove(i);
                        System.out.println("Alumno borrado correctamente.\n");
                        break;
                    }
                }
            } // Fin BorrarUsuario

            // ListarUsuarios
            if (opcion == 4) {
                for (int i = 0; i < listaAlumnos.size(); i++) {
                    System.out.println(listaAlumnos.get(i));
                }
            } // Fin ListarUsuarios

            // Salir 
            if (opcion == 5) {
                exit(0);
            } // Fin Salir

        }// fin del while

    } // Fin del main

    private static void mostrarMenu() {
        System.out.println("1.- Alta de usuario en el sistema.");
        System.out.println("2.- Modficación usuario sistema.");
        System.out.println("3.- Borrar usuario sistema.");
        System.out.println("4.- Listar usuarios.");
        System.out.println("5.- Salir");
    }

    private static int pedirId(BufferedReader stdin) throws IOException {
        System.out.println("Indique el id del alumno:");
        int idAux = Integer.parseInt(stdin.readLine());
        return idAux;
    }

    private static String pedirNombre(BufferedReader stdin) throws IOException {
        System.out.println("Indique el nombre del alumno:");
        String nombreAux = stdin.readLine();
        return nombreAux;
    }

    private static String pedirApellidos(BufferedReader stdin) throws IOException {
        System.out.println("Indique los apellidos del alumno:");
        String apellidosAux = stdin.readLine();
        return apellidosAux;
    }

    private static int pedirEdad(BufferedReader stdin) throws IOException {
        System.out.println("Indique la edad del alumno:");
        int edadAux = Integer.parseInt(stdin.readLine());
        return edadAux;
    }

}
