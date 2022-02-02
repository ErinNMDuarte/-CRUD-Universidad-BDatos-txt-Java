package modelo;

import java.io.*;
import java.util.ArrayList;

public class Archivo {

    Usuario us = new Usuario();

    File archivo = new File("datos_estudiantes.dat");
    ObjectInputStream entrada;
    ObjectOutputStream salida;

    public void guardarArchivo(ArrayList<Usuario> lista, File archivo) {
        try {
            salida = new ObjectOutputStream(new FileOutputStream(archivo));
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            salida.writeObject(lista);
            salida.close();

        } catch (IOException e) {
            System.out.println("error al escribir en el archivo" + e);

        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Usuario> leerArchivo(File archivo) {
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            entrada = new ObjectInputStream(new FileInputStream(archivo));
            try {
                lista = (ArrayList<Usuario>) entrada.readObject();
            } catch (ClassNotFoundException ex) {
                System.out.println("error en lectura de datos"+ex);
            }
            entrada.close();

        } catch (IOException e) {
            System.out.println("error en lectura "+e);
        }
        return lista;
    }
public File getArchivo(){
    return archivo;
}

}   