package modelo;

import java.util.ArrayList;

public class UsuarioCRUD {

    Usuario us = new Usuario();
    ArrayList<Usuario> lista = new ArrayList<>();
    Archivo archivo = new Archivo();
    int c;


    public void ingresar(Usuario us) {
        lista.add(us);
        archivo.guardarArchivo(lista, archivo.getArchivo());

    }

   
    public Usuario buscar(Usuario us) {
        lista = archivo.leerArchivo(archivo.getArchivo());
        Usuario retorno = new Usuario();
        for (int i = 0; i < lista.size(); i++) {
            if (us.getCorreoi().equals(lista.get(i).getCorreoi())) {
                retorno = lista.get(i);
            }
        }
        return retorno;

    }

    public void modificar(Usuario us) {
        lista = archivo.leerArchivo(archivo.getArchivo());
        for (int i = 0; i < lista.size(); i++) {
            if (us.getCorreoi().equals(lista.get(i).getCorreoi())) {
                lista.get(i).setCorreop(us.getCorreop());
                lista.get(i).setNtcelular(us.getNtcelular());
                lista.get(i).setNtfijo(us.getNtfijo());
                lista.get(i).setProgramaa(us.getProgramaa());
            }
        }
        archivo.guardarArchivo(lista, archivo.getArchivo());
    }

    public void eliminar(Usuario us) {
        lista = archivo.leerArchivo(archivo.getArchivo());
        for (int i = 0; i < lista.size(); i++) {
            if (us.getCorreoi().equals(lista.get(i).getCorreoi())) {
                lista.remove(i);
            }
        }
        archivo.guardarArchivo(lista, archivo.getArchivo());
    }

    public ArrayList<Usuario> mostrar() {
        lista = archivo.leerArchivo(archivo.getArchivo());
        return lista;
    }

}
