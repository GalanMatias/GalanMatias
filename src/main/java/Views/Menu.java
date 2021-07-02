package Views;

import java.util.Scanner;

public class Menu {
    public static Scanner dato = new Scanner(System.in);

    public static void menuEmpleado() {
        Metodos.Empleado emp = new Metodos.Empleado();
        int opcion = 0;
        while (opcion != 8) {
            System.out.println("+========================================+");
            System.out.println("+============= MENU EMPLEADO ============+");
            System.out.println("+========================================+");
            System.out.println("+  1. Agregar Empleado                   +");
            System.out.println("+  2. Eliminar Empleado                  +");
            System.out.println("+  3. Modificar Empleado                 +");
            System.out.println("+  4. Listar Empleados                   +");
            System.out.println("+  5. Mostrar el Empleado de Mayor Edad  +");
            System.out.println("+  6. Listar Empleados (Sueldo)          +");
            System.out.println("+  7. Buscar Empleado (DNI)              +");
            System.out.println("+  8. Volver                             +");
            System.out.println("+  Ingrese Opcion                        +");
            System.out.println("+----------------------------------------+");
            opcion = dato.nextInt();
            switch (opcion) {
                case 1:
                    emp.agregar();
                    break;
                case 2:
                    emp.eliminar();
                    break;
                case 3:
                    emp.modificar();
                    break;
                case 4:
                    emp.mostrar();
                    break;
                case 5:
                    emp.mayorEdad();
                    break;
                case 6:
                    emp.listaSueldos();
                    break;
                case 7:
                    emp.buscar(emp.buscarEmpleado());
                case 8:
                    System.out.println("Saliendo del Administardor de Empleados");
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
            }
        }
    }
    
    public static void menuProyecto() {
        Metodos.Proyecto pro = new Metodos.Proyecto();
        int op = 0;
        while (op != 10) {
            System.out.println("+========================================+");
            System.out.println("+============= MENU PROYECTO ============+");
            System.out.println("+========================================+");
            System.out.println("+  1. Agregar Proyecto                   +");
            System.out.println("+  2. Eliminar Proyecto                  +");
            System.out.println("+  3. Listar Proyectos                   +");
            System.out.println("+  4. Agregar Empleado al Proyecto       +");
            System.out.println("+  5. Quitar Empleado del Proyecto       +");
            System.out.println("+  6. Listar Datos del Proyecto          +");
            System.out.println("+  7. Cacular el Total de Montos         +");
            System.out.println("+  8. Calcular Monto por Empleado        +");
            System.out.println("+  9. Listar Proyectos por Rango (fecha) +");
            System.out.println("+  10. Volver                            +");
            System.out.println("+  Ingrese Opcion                        +");
            System.out.println("+----------------------------------------+");
            op = dato.nextInt();
            switch (op) {
                case 1:
                    pro.agregar();
                    break;
                case 2:
                    pro.eliminar();
                    break;
                case 3:
                    pro.mostrar();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    pro.montoTotal();
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    System.out.println("Saliendo del Administardor de Proyectos");
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
            }
        }
    }

}
