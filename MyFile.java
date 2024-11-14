/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author andru
 */
public class MyFile {
   
    private File mifile = null;
    
    void setFile(String direccion){
        mifile = new File(direccion);
    }
    
    void info(){
        if (mifile.exists()){
            System.out.println("\nNombre: " + mifile.getName() + 
                                "\nPath: " + mifile.getPath() +
                                "\nAbsoluta: " + mifile.getAbsolutePath() +
                                "\nBytes: " + mifile.length()+
                                "\nModificado en : " + new Date(mifile.lastModified()) + 
                                "\nPadre: " + mifile.getAbsoluteFile().getParentFile().getName());
            if (mifile.isFile()){
                System.out.println("Es una archivo!");
            }else if(mifile.isDirectory()){
                System.out.println("Es un folder!");
            }
            System.out.println("-+-+-+-+-+-+-+-+-+--+-+-+-+-+-+-+-+-");
        } else {
            System.out.println("No existe!");
        }
    }

    boolean crearFile() throws IOException {
        return mifile.createNewFile();
    }

    boolean crearFolder() {
        return mifile.mkdirs();
    }

    boolean borrar(String folderPath) {
        File folder = new File(folderPath);  

        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    borrar(file.getPath());
                }
            }
        }
        return folder.delete();  
    }
    
    void dir(){
        if (mifile.isDirectory()){
            System.out.println("Directorio de : " + mifile.getAbsolutePath());
            System.out.println("");
            //contadores
            int cArchi = 0 , cdir = 0 , tbytes = 0;
            for (File child : mifile.listFiles()){
                if (!child.isHidden()){
                    //ultima modificacion
                    Date ult = new Date(child.lastModified());
                    System.out.print(ult + "\t ");
                    //si es file o folder
                    if (child.isDirectory()){
                        cdir++;
                        System.out.print("<DIR>\t\t");
                    }else{
                        //File
                        cArchi++;
                        tbytes+= child.length();
                        System.out.print("    \t" + child.length() + "\t");
                    }
                    //mostrar los objetos
                    System.out.println(child.getName());
                }
            }
            System.out.println(cArchi + " archivos\t" + tbytes + " bytes");
            System.out.println(cdir + " dirs\t");
        }
    }
    private void tree(File dir, String tab){
        if (dir.isDirectory()){
            System.out.println(tab+dir.getName());
            for (File child :  dir.listFiles()) {
                if (!child.isHidden()){
                    tree(child,tab+" -- ");
                }
            }
        }
    }
    void tree(){
        tree(mifile," - ");
    }
    
    
    
    
   void ReescribirBuffered(){
        if (mifile != null && mifile.isFile()) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(mifile, false))) {
            System.out.println("Ingrese el contenido a escribir en el archivo");
            Scanner scanner = new Scanner(System.in);
            String contenido = scanner.nextLine();
            writer.write(contenido);
            System.out.println("Contenido escrito con exito");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo " + e.getMessage());
        }
    } else {
        System.out.println("El archivo especificado no es valido para reescribir");
    }
    }
    
   
   
   
    void AñadirFileWriter() {
    // Verificar si mifile es un archivo válido
    if (mifile != null && mifile.isFile()) {
        try {
            // Crear un objeto FileWriter con "true" para añadir contenido
            FileWriter writer = new FileWriter(mifile, true);
            
            System.out.println("Ingrese el contenido a añadir en el archivo (Presione Enter para finalizar):");
            Scanner scanner = new Scanner(System.in);
            String contenido = scanner.nextLine();
            
            // Añadir el contenido al archivo
            writer.write(contenido + "\n"); // Agregamos un salto de línea para separar entradas
            writer.close(); // Cerrar el FileWriter
            
            System.out.println("Contenido añadido exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    } else {
        System.out.println("El archivo especificado no es válido para añadir contenido.");
    }
}
    
   void LeerBufferedReader() {
    if (mifile != null && mifile.isFile()) {
        try {
            FileReader fr = new FileReader(mifile);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            System.out.println("Contenido del archivo (usando BufferedReader):");

            // Leemos línea por línea hasta el final del archivo
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
            System.out.println("Lectura completada.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    } else {
        System.out.println("El archivo especificado no es válido para leer.");
    }
}
    
    
    void LeerFileReader() {
    // Verificamos si mifile es un archivo válido
    if (mifile != null && mifile.isFile()) {
        try {
            FileReader reader = new FileReader(mifile);
            int caracter;
            System.out.println("Contenido del archivo (usando FileReader):");
            
            // Leemos carácter por carácter hasta el final del archivo
            while ((caracter = reader.read()) != -1) {
                System.out.print((char) caracter);
            }
            
            reader.close(); // Cerramos el FileReader
            System.out.println("\nLectura completada.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    } else {
        System.out.println("El archivo especificado no es válido para leer.");
    }
}



    
    
    
    

}


