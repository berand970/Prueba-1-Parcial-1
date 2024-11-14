/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivo;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author andru
 */
public class FileTest {

    public static void main(String[] args) {
        MyFile file = new MyFile();
        String path = "";
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        while (true) {
            System.out.println("\n1.Set Archivo/Folder");
            System.out.println("2.Ver informacion");
            System.out.println("3.Crear un Archivo");
            System.out.println("4.Crear un Folder");
            System.out.println("5.Borrar");
            System.out.println("6.DIR");
            System.out.println("7.Tree");
            System.out.println("8.Escribir en Documento");
            System.out.println("9.Leer Documento");
            System.out.println("0.Salir           ");
            System.out.println("Escoja una opcion.");
            try {
                int op = leer.nextInt();

                if (op == 1) {
                    System.out.println("\n SET ARCHIVO/ FOLDER  ");
                    String direc = leer.next();
                    file.setFile(direc);
                    path = direc;
                }

                if (op == 2) {
                    System.out.println("\n VER INFORMACION ");
                    file.info();
                }
                if (op == 3) {
                    System.out.println("\n CREAR ARCHIVO ");
                    if (file.crearFile()) {
                        System.out.println("Archivo creado!");
                    } else {
                        System.out.println("Archivo no creado!");
                    }

                }
                if (op == 4) {
                    System.out.println("\n CREAR FOLDER ");
                    if (file.crearFolder()) {
                        System.out.println("Folder creado!");
                    } else {
                        System.out.println("Folder no creado!");
                    }
                }
                if (op == 5) {
                    System.out.println("\n BORRAR ");
                    if (file.borrar(path)) {
                        System.out.println("Se borro!");
                    } else {
                        System.out.println("No se borro!");
                    }
                }
                if (op == 6) {
                    System.out.println(" DIR ");
                    file.dir();
                }
                if (op == 7) {
                    System.out.println(" TREE ");
                    file.tree();
                }
                if(op == 8) {
                    System.out.println("Escribir");
                    System.out.println("1. Version1: Reescribir (BufferedWriter)");
                    System.out.println("2. Version2: Anadir Inf. (FileWriter)");
                    int e = leer.nextInt();
                    if(e==1){
                    file.ReescribirBuffered();
                    }
                    if(e==2){
                    file.AñadirFileWriter();
                    }
                     
                }
                
                
                
                 if(op == 9) {
                    System.out.println("Escribir");
                    System.out.println("1. Version1: Leer (BufferedReader)");
                    System.out.println("2. Version2: Leer (FileReader)");
                    int l = leer.nextInt();
                    if(l==1){
                    file.LeerBufferedReader();
                    if(l==2){
                    file.LeerFileReader();
                    }
                    }
                }
                
                
                
                
                if (op == 0) {
                    System.exit(0);
                }

            } catch (InputMismatchException e) {
                System.out.println("Ingrese una opcion valida!");
                leer.next();
            } catch (NullPointerException e) {
                System.out.println("Favor seleccionar opcion 1 !");
            } catch (IOException e) {
                System.out.println("ERROR" + e.getMessage());
            }
        }
    }

}
