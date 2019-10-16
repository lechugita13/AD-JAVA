/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializarficheros;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillem
 */
public class SerializarFicheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Vehiculo> listaVechiculo = new ArrayList<>();
        boolean bandera = true;
        String marca = "";
        String modeloCoche = "";
        String matricula = "";
        int potencia = 0;
        String color = "";
        do {

            ObjectOutputStream oos = null;
            try {
                menu();
                Scanner e = new Scanner(System.in);
                int opc = e.nextInt();
                switch (opc) {
                    case 1:
                        System.out.println("Introduce la marca del coche: ");
                        marca = e.next();
                        System.out.println("Introduce el modelo del coche: ");
                        modeloCoche = e.next();
                        System.out.println("Introduce la matricula: ");
                        matricula = e.next();
                        System.out.println("Introduce la potencia: ");
                        potencia = e.nextInt();
                        System.out.println("Introduce el color: ");
                        color = e.next();
                        Vehiculo v1 = new Vehiculo(marca, modeloCoche, matricula, potencia, color);
                        insertarVehiculo(listaVechiculo, v1);
                        break;
                    case 2:
                        visualizarVehiculo(listaVechiculo);
                        break;
                    case 3:
                        File fichero = new File("vehiculo.bin");
                        
                        
                        for (int i = 0; i < listaVechiculo.size(); i++) {
                            Object get = listaVechiculo.get(i);
                            if (fichero.length()==0) {
                                oos = new ObjectOutputStream(new FileOutputStream(fichero));
                                oos.writeObject(get);
                            }else{
                                oos= new Append(new FileOutputStream(fichero,true));
                                oos.writeObject(get);
                            }
                          
                        }
                        oos.close();
                        bandera = false;
                        break;
                    default:
                        throw new AssertionError();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SerializarFicheros.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SerializarFicheros.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        } while (bandera);

    }

    public static void menu() {

        System.out.println("Opcion 1.- Insertar vehiculo");
        System.out.println("Opcion 2.- Visualizar vehiculo");
        System.out.println("Opcion 3.- Salir");
    }

    public static void insertarVehiculo(ArrayList listaVehiculo, Vehiculo v1) {

        listaVehiculo.add(v1);
    }

    public static void visualizarVehiculo(ArrayList listaVechiculo) {
        ObjectInputStream ois = null;
        try {
           File fichero = new File("vehiculo.bin");
            ois = new ObjectInputStream(new FileInputStream(fichero));
            Object aux = ois.readObject();
            if (!fichero.exists()) {
                try {
                    fichero.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(SerializarFicheros.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                

                while (aux != null) {
                    if (aux instanceof Vehiculo) {
                        System.out.println(aux.toString());  // Se escribe en pantalla el objeto
                    }
                    aux = ois.readObject();
                    
                }
                ois.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SerializarFicheros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EOFException ex){
            
        }catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(SerializarFicheros.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }

    }

