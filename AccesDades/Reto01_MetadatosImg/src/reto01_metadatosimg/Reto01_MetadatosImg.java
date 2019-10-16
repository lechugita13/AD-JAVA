/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto01_metadatosimg;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillem
 */
public class Reto01_MetadatosImg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            Scanner e = new Scanner(System.in);
            //String ruta;
            //System.out.println("Introdueix la ruta de la foto");
            File almacent = new File("D:\\SEGON DAM\\AD\\AD-JAVA\\Reto01_MetadatosImg\\Almacent");

            File img = new File("D:\\SEGON DAM\\AD\\AD-JAVA\\Reto01_MetadatosImg\\imgAProbar\\Londres.jpg");
           
           
            Metadata metadata = ImageMetadataReader.readMetadata(img);

            for (Directory directory : metadata.getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    System.out.format("[%s] - %s = %s",
                            directory.getName(), tag.getTagName(), tag.getDescription());
                    
                    
                }
                if (directory.hasErrors()) {
                    for (String error : directory.getErrors()) {
                        System.err.format("ERROR: %s", error);
                    }
                }
            }
            

        } catch (ImageProcessingException ex) {
            Logger.getLogger(Reto01_MetadatosImg.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Reto01_MetadatosImg.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
