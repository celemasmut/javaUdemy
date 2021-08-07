package udemy.Archivos;

import java.io.*;

public class ManejoArchivo {

    public static void crearArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        try{
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println(" Se ha creado el archivo");
        }catch (FileNotFoundException ex){
            ex.printStackTrace(System.out);
        }
    }

    public static void escribirArchivo(String nombreArchivo, String contenidoDeArchivo){
        File archivo = new File(nombreArchivo);
        try{
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(contenidoDeArchivo);
            salida.close();
            System.out.println("Se ha esccrito en al archivo");
        }catch (FileNotFoundException ex){
            ex.printStackTrace(System.out);
        }
    }

    public static void agregarContenidoAlArchivo(String nombreArchivo, String contenidoDeArchivo){
        File archivo = new File(nombreArchivo);
        try{
            PrintWriter salida = new PrintWriter(new FileWriter(archivo,true));// parametro true da el ok para agregar sin sobreescribir
            salida.println(contenidoDeArchivo);
            salida.close();
            System.out.println("Se ha agregado en al archivo");
        }catch (FileNotFoundException ex){
            ex.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void leerArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();
            while (lectura != null){
                System.out.println(lectura);
                lectura = entrada.readLine();//se pasa al siguiente linea
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

}
