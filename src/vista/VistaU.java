package vista;

import controlador.CapturaD;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Usuario;
import modelo.UsuarioCRUD;

public class VistaU {

    ArrayList<Usuario> lista = new ArrayList<>();
    UsuarioCRUD usucrud;
    Scanner cap = new Scanner(System.in);
    CapturaD cd = new CapturaD();
    ArrayList<Usuario> datos = new ArrayList<>();
    Usuario us = new Usuario();
    int dato, c;
    String nombre, apellidos, fechan, correoI, correoP, programaA, corri;
    Long ntCelular, ntFijo;

    public VistaU() {
        this.usucrud = new UsuarioCRUD();
    }

    public void menuprincipal() {

        do {
            String menu = "INSTITUTO LA FLORESTA\n"
                    + "Seleccione tarea a realizar:\n"
                    + "1. Ingresar estudiante\n"
                    + "2. Buscar estudiante\n"
                    + "3. Modificar estudiante\n"
                    + "4. Eliminar Estudiante\n"
                    + "5. Ver directorio de estudiantes\n"
                    + "6. Salir\n"
                    + "Opci�n:\n";
                    
            System.out.println(menu);
            try {
                dato = cap.nextInt();
            } catch (Exception e) {
                dato = 0;
            }
            switch (dato) {
                case 1:
                    System.out.print("\n");
                    System.out.println("Ingresar estudiante");
                    cap.nextLine();
                    System.out.print("Ingresar nombres:\n");
                    System.out.print("\n");
                    nombre = cap.nextLine();
                    System.out.print("Ingresar apellidos:\n");
                    System.out.print("\n");
                    apellidos = cap.nextLine();
                    System.out.println("Ingresar fecha de nacimiento (YYYY-MM-DD):\n");
                    fechan = cap.next();
                    System.out.println("Ingresar correo institucional:\n");
                    correoI = cap.next();
                    System.out.println("Ingresar correo personal:\n");
                    correoP = cap.next();
                    System.out.println("Ingresar n�mero de celular:\n");
                    ntCelular = cap.nextLong();
                    cap.nextLine();
                    System.out.println("Ingresar n�mero fijo:\n");
                    ntFijo = Long.parseLong(cap.nextLine());

                    System.out.println("Ingresar programa:\n");
                    programaA = cap.nextLine();

                    cd.capturaDatos(nombre, apellidos, fechan, correoI, correoP, programaA, ntCelular, ntFijo);

                    System.out.println("Se agreg� el estudiante\n");
                    break;
                case 2:
                    System.out.print("\n");
                    System.out.println("Buscar estudiante");
                    System.out.print("Ingresar correo institucional:\n");
                    System.out.print("\n");
                    corri = cap.next();
                    System.out.print("\n");
                    System.out.print("Informaci�n del estudiante\n");
                    Usuario respuesta = cd.buscarDato(corri);
                    System.out.println("Nombres: " + respuesta.getNombre1()
                            + "\nApellidos: " + respuesta.getApellidos1()
                            + "\nFecha nacimiento: " + respuesta.getFechaN()
                            + "\nCorreo institucional: " + respuesta.getCorreoi()
                            + "\nCorreo personal: " + respuesta.getCorreop()
                            + "\nN�mero de tel�fono celular: " + respuesta.getNtcelular()
                            + "\nN�mero de tel�fono fijo: " + respuesta.getNtfijo()
                            + "\nPrograma acad�mico: " + respuesta.getProgramaa());
                    System.out.print("\n");
           
                    break;
                case 3:
                    System.out.print("\n");
                    System.out.println("Modificar estudiante");
                    System.out.print("Ingresar correo institucional:\n");
                    System.out.print("\n");
                    correoI = cap.next();
                    System.out.print("Ingresar correo personal:\n");
                    System.out.print("\n");
                    correoP = cap.next();
                    System.out.print("Ingresar n�mero de celular:");
                    System.out.print("\n");
                    ntCelular = cap.nextLong();
                    System.out.print("Ingresar n�mero fijo:");
                    System.out.print("\n");
                    ntFijo = cap.nextLong();
                    System.out.print("Ingresar programa:");
                    System.out.print("\n");
                    programaA = cap.next();
                    cd.modificarDato(correoI, correoP, programaA, ntCelular, ntFijo);
                    System.out.print("Se modific� el estudiante \n");
                    System.out.print("\n");
                    break;

                case 4:
                    System.out.print("\n");
                    System.out.println("Eliminar estudiante");
                    System.out.print("Ingresar correo institucional:\n");
                    System.out.print("\n");
                    corri = cap.next();
                    cd.eliminarDato(corri);
                    System.out.print("Se elimin� el estudiante\n");
                    System.out.print("\n");
                    break;

                case 5:
                    System.out.print("\n");
                    System.out.println("El directorio de los estudiantes\n");
                    datos = cd.mostrarDatos();
                    for (Usuario us : datos) {
                        System.out.print(us);
                        System.out.print("\n");
                    }
                    break;
            }
        } while (dato != 6);
        System.out.print("\n");
        System.out.println("Hasta pronto");

    }

}
