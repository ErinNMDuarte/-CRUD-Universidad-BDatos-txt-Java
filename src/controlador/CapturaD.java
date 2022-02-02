package controlador;

import java.util.ArrayList;
import modelo.Usuario;
import modelo.UsuarioCRUD;

public class CapturaD {

    UsuarioCRUD usuCrud = new UsuarioCRUD();
    Usuario us;

    public void capturaDatos(String nombre, String apellidos, String fechan, String correoI, String correoP, String programaA, Long ntCelular, Long ntFijo) {
        us = new Usuario(nombre, apellidos, fechan, correoI, correoP, programaA, ntCelular, ntFijo);
        usuCrud.ingresar(us);

    }

    public Usuario buscarDato(String corri) {
        us=new Usuario(corri);
        return usuCrud.buscar(us);

    }

    public void modificarDato(String correoI, String correoP, String programaA, Long ntCelular, Long ntFijo) {
        us = new Usuario(correoI, correoP, programaA, ntCelular, ntFijo);
        usuCrud.modificar(us);

    }

    public void eliminarDato(String corri) {
        us = new Usuario(corri);
        usuCrud.eliminar(us);
    }

    public ArrayList<Usuario> mostrarDatos() {
        return usuCrud.mostrar();
    }
}
