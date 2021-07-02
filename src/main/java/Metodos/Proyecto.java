package Metodos;

import Controller.EmpleadoJpaController;
import Controller.ProyectoJpaController;
import Controller.exceptions.NonexistentEntityException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Proyecto {
    public static ProyectoJpaController cProyecto = new ProyectoJpaController();
    public static EmpleadoJpaController cEmpleado = new EmpleadoJpaController();
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static Scanner dato = new Scanner(System.in);

    public void agregar() {
        try {
            Model.Proyecto pro = new Model.Proyecto();
            System.out.println("Ingrese el Codigo del Proyecto: ");
            pro.setCodigoPro(dato.nextInt());
            dato.nextLine();
            System.out.println("Ingrese el Nombre del Proyecto: ");
            pro.setNombre(dato.nextLine());
            System.out.println("Ingrese Fecha de Inio del Proyecto (dd/mm/yyyy):");
            String fech = dato.nextLine();
            Date fecha1 = sdf.parse(fech);
            pro.setFechaInicio(fecha1);
            System.out.println("Ingrese Fecha de Cierre del Proyecto (dd/mm/yyyy):");
            String fec = dato.nextLine();
            Date fecha2 = sdf.parse(fec);
            pro.setFechaFin(fecha2);
            System.out.println("Ingrese el Presupuesto del Proyecto:");
            pro.setMonto(dato.nextFloat());
            cProyecto.create(pro);
        } catch (Exception e) {
            System.out.println("Error en: " + e.getMessage());
        }
    }

    public void eliminar() {
        try {
            mostrar();
            System.out.println("Ingrese el Codigo del Proyecto a Eliminar: ");
            int cod = dato.nextInt();
            cProyecto.destroy(cod);
        } catch (NonexistentEntityException e) {
            System.out.println("Error en: " + e.getMessage());
        }
    }

    public void modificar() {
        try {
            Model.Proyecto pro = new Model.Proyecto();
            mostrar();
            System.out.println("En caso de que el codigo del proyecto no coinsida con ninguno se creara uno nuevo ");
            System.out.println("Ingrese el Nuevo Codigo del Proyecto: ");
            pro.setCodigoPro(dato.nextInt());
            dato.nextLine();
            System.out.println("Ingrese el Nuevo Nombre del Proyecto: ");
            pro.setNombre(dato.nextLine());
            dato.nextLine();
            System.out.println("Ingrese la Nueva Fecha de Inio del Proyecto (dd/mm/yyyy):");
            String fech = dato.nextLine();
            Date fecha1 = sdf.parse(fech);
            pro.setFechaInicio(fecha1);
            System.out.println("Ingrese la Nueva Fecha de Cierre del Proyecto (dd/mm/yyyy):");
            String fec = dato.nextLine();
            Date fecha2 = sdf.parse(fec);
            pro.setFechaFin(fecha2);
            System.out.println("Ingrese el Nuevo Presupuesto del Proyecto:");
            pro.setMonto(dato.nextFloat());
            cProyecto.edit(pro);
        } catch (Exception e) {
            System.out.println("Error en: " + e.getMessage());
        }
    }

    public void buscar() {
        try {
            System.out.println("Ingrese el DNI del Empleado a Buscar: ");
            int buscar = dato.nextInt();
            cProyecto.findProyecto(buscar);
        } catch (Exception e) {
            System.out.println("Error en: " + e.getMessage());
        }
    } 

    public void mostrar() {
        List<Model.Proyecto> pro = cProyecto.findProyectoEntities();
        System.out.println("+----------------------------------------------------------------------------------+");
        System.out.println("+                               Lista de Proyectos                                 +");
        System.out.println("+----------------------------------------------------------------------------------+");        
        System.out.println("+Total de Proyectos                                                              " + pro.size() + " +");
        System.out.println("+----------------------------------------------------------------------------------+");
        System.out.println("| Cod. Producto |       Nombre        | Fecha de Inicio | Fecha de Fin |   Monto   |");
        System.out.println("+----------------------------------------------------------------------------------+");
        for (Model.Proyecto proyecto : pro) {
            System.out.printf("|     %-9s | %-17s |   %-13s |   %-10s | %-10s \n",
                    proyecto.getCodigoPro(),
                    proyecto.getNombre(),
                    sdf.format(proyecto.getFechaInicio()),
                    sdf.format(proyecto.getFechaFin()),
                    proyecto.getMonto()
                     + "   |");
        }
        System.out.println("+----------------------------------------------------------------------------------+");
    }
    
    public void agragarEmp(){
        List<Model.Proyecto> pro = cProyecto.findProyectoEntities();
        //Model.Proyecto proyecto = new Model.Proyecto();
        mostrar();
        System.out.println("Ingrese el Codigo del Proyecto al que Desea Agregar Miembros: ");
        int cod1 = dato.nextInt();
        Metodos.Empleado emp = new Metodos.Empleado();
        emp.mostrar();
        System.out.println("Ingrese el Nro de Legajo al que Desea Agregar al Proyecto ");
        int cod2 = dato.nextInt();
        for (Model.Proyecto proyecto : pro) {
            
        }
    }
    public void quitarEmp(){
    
    }
    
    public void montoTotal(){
        List<Model.Proyecto> pro = cProyecto.findProyectoEntities();
        float suma = 0;
        for (Model.Proyecto proyecto : pro) {
            suma = suma + proyecto.getMonto(); 
        }
        System.out.println("EL Monto Total de los Proyectos es de: $" + suma);
    }
    
}
