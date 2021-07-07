package Views;

import java.util.Scanner;

public class Menu {
    public static Scanner dato = new Scanner(System.in);

    public static void menuEmpleado() {
        
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
                    Metodos.Empleado.getInstance().agregar();
                    break;
                case 2:
                    Metodos.Empleado.getInstance().eliminar();
                    break;
                case 3:
                    Metodos.Empleado.getInstance().modificar();
                    break;
                case 4:
                    Metodos.Empleado.getInstance().mostrar();
                    break;
                case 5:
                    Metodos.Empleado.getInstance().mayorEdad();
                    break;
                case 6:
                    Metodos.Empleado.getInstance().listaSueldos();
                    break;
                case 7:
                    Metodos.Empleado.getInstance().buscar(Metodos.Empleado.getInstance().buscarEmpleado());
                    break;
                case 8:
                    System.out.println("Saliendo del Administardor de Empleados");
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
            }
        }
    }
    
    public static void menuProyecto() {
        
        int op = 0;
        while (op != 10) {
            System.out.println("+========================================+");
            System.out.println("+============= MENU PROYECTO ============+");
            System.out.println("+========================================+");
            System.out.println("+  1. Agregar Proyecto                   +");
            System.out.println("+  2. Eliminar Proyecto                  +");
            System.out.println("+  3. Listar Proyectos                   +");
            System.out.println("+  4. Agregar Empleado a un Proyecto     +");
            System.out.println("+  5. Quitar Empleado del Proyecto       +");
            System.out.println("+  6. Listar Empleados del Proyecto      +");
            System.out.println("+  7. Cacular el Total de Montos         +");
            System.out.println("+  8. Calcular Monto por Empleado        +");
            System.out.println("+  9. Listar Proyectos por Rango (fecha) +");
            System.out.println("+  10. Volver                            +");
            System.out.println("+  Ingrese Opcion                        +");
            System.out.println("+----------------------------------------+");
            op = dato.nextInt();
            switch (op) {
                case 1:
                    Metodos.Proyecto.getInstance().agregar();
                    break;
                case 2:
                    Metodos.Proyecto.getInstance().eliminar();
                    break;
                case 3:
                    Metodos.Proyecto.getInstance().mostrar();
                    break;
                case 4:
                    Metodos.Proyecto.getInstance().agragarEmp();
                    break;
                case 5:
                    Metodos.Proyecto.getInstance().quitarEmp();
                    break;
                case 6:
                    Metodos.Proyecto.getInstance().mostrarEmpDelPro();
                    break;
                case 7:
                    Metodos.Proyecto.getInstance().montoTotal();
                    break;
                case 8:
                    Metodos.Proyecto.getInstance().calcularMontoIndividual();
                    break;
                case 9:
                    Metodos.Proyecto.getInstance().listaPorFecha();
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
