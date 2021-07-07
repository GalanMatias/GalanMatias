package Views;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Views.Menu menu = new Menu();
        Scanner dato = new Scanner(System.in);

        int opcion = 0;
        while (opcion != 3) {
            System.out.println("+====================+");
            System.out.println("+======= MENU =======+");
            System.out.println("+====================+");
            System.out.println("+  1. Empleados      +");
            System.out.println("+  2. Proyectos      +");
            System.out.println("+  3. Salir          +");
            System.out.println("+  Ingrese Opcion    +");
            System.out.println("+--------------------+");
            opcion = dato.nextInt();
            switch (opcion) {
                case 1:
                    menu.menuEmpleado();
                    break;
                case 2:
                    menu.menuProyecto();
                    break;
                case 3:
                    System.out.println("Fin del Programa");
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
            }
        }
        /**
         * Las Excepciones mas Encontradas son:
         * InputMismatchException ---> Se produce cunado intento agregar un valor de tipo String a una variable de tipo int mediante el Scanner
         *  no puede reslverla xq me guardaba el error y no me dejaba ahcer mas operaciones
         * NullPointerException ---> Se produce cuando intento utilizar una referencia que no señala ninguna ubicacion en memoria "arraylist, list, etc"
         * Exception  ---> es donde deriva las excenpiones
         * 
         * Patron de diseño implementado Singleton
         *  Realizo una sola instancia de Metodos.Proyecto y Metodos.Empleado en la clase munu
        **/
    }

}
