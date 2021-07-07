package Metodos;

import Controller.EmpleadoJpaController;
import Controller.exceptions.NonexistentEntityException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Empleado {

    public static EmpleadoJpaController cEmpleado = new EmpleadoJpaController();
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static Scanner dato = new Scanner(System.in);

    private Empleado() {
    }

    private static Empleado miInstancia;

    public static Empleado getInstance() {
        if (miInstancia == null) {
            miInstancia = new Empleado();
        }
        return miInstancia;
    }

    public void agregar() {
        try {
            System.out.println("+=============================+");
            System.out.println("+ Agregando un Nuevo Empleado +");
            System.out.println("+=============================+");
            Model.Empleado emp = new Model.Empleado();
            System.out.println("Ingrese el Nro de Legajo: ");
            emp.setNroDeLegajo(dato.nextInt());
            dato.nextLine();
            System.out.println("Ingrese el Nombre y Apellido: ");
            emp.setNombreYapellido(dato.nextLine());
            System.out.println("Ingrese el DNI:");
            emp.setDni(dato.nextInt());
            dato.nextLine();
            System.out.println("Ingrese Fecha de Nacimiento (dia/mes/año):");
            String fech = dato.nextLine();
            Date fecha = sdf.parse(fech);
            emp.setFechaNac(fecha);
            System.out.println("Ingrese Sueldo Basico:");
            emp.setSueldo(dato.nextFloat());
            cEmpleado.create(emp);
            System.out.println("Empledo Creado Exitosamente");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void eliminar() {
        List<Model.Empleado> empl = cEmpleado.findEmpleadoEntities();
        int buscar, aux = 0, enc;
        try {
            mostrar();
            System.out.println("+========================================+");
            System.out.println("+ Ingrese el DNI del Empleado a Eliminar +");
            System.out.println("+========================================+");
            buscar = dato.nextInt();
            for (Model.Empleado empleado : empl) {
                enc = empleado.getDni();
                if (enc == buscar) {
                    aux = empleado.getNroDeLegajo();
                    cEmpleado.destroy(aux);
                    System.out.println("Empleado Eliminado Correctmente");
                }
            }
            if (aux == 0) {
                System.out.println("El Empleados con DNI " + buscar + " no ha Sido Encontrados");
            }
        } catch (NonexistentEntityException e) {
            e.getMessage();
        }
    }

    public void modificar() {
        try {
            System.out.println("+=========================+");
            System.out.println("+ Modificando un Empleado +");
            System.out.println("+=========================+");
            mostrar();
            Model.Empleado emp = new Model.Empleado();
            System.out.println("En caso de que el Nro de Legajo no coinsida con ninguno se creara uno nuevo ");
            System.out.println("Ingrese el Nuevo Nro de Legajo: ");
            emp.setNroDeLegajo(dato.nextInt());
            dato.nextLine();
            System.out.println("Ingrese Nuevo Nombre y Apellido: ");
            emp.setNombreYapellido(dato.nextLine());
            System.out.println("Ingrese Nuevo DNI:");
            emp.setDni(dato.nextInt());
            dato.nextLine();
            System.out.println("Ingrese Nueva Fecha de Nacimiento (dia/mes/año):");
            String fech = dato.nextLine();
            Date fecha = sdf.parse(fech);
            emp.setFechaNac(fecha);
            System.out.println("Ingrese Nuevo Sueldo :");
            emp.setSueldo(dato.nextFloat());
            cEmpleado.edit(emp);
            System.out.println("Empleado Modificado Exitosamente");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public int calcularEdad(Date fechaIng) {
        String fecha_nac = sdf.format(fechaIng);
        Date fechaActual = new Date();
        String hoy = sdf.format(fechaActual);
        String[] dat1 = fecha_nac.split("/");
        String[] dat2 = hoy.split("/");
        int año = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
        int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
        if (mes < 0) {
            año--;
        } else if (mes == 0) {
            int dia = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
            if (dia > 0) {
                año--;
            }
        }
        return año;
    }

    public void mostrar() {
        List<Model.Empleado> emp = cEmpleado.findEmpleadoEntities();
        System.out.println("+-------------------------------------------------------------------------------------------+");
        System.out.println("+                                   Lista de Empleados                                      +");
        System.out.println("+-------------------------------------------------------------------------------------------+");
        System.out.println("+Total de Empleados                                                                       " + emp.size() + " +");
        System.out.println("+-------------------------------------------------------------------------------------------+");
        System.out.println("| N° de Legajo | Nombre y Apellido |    DNI    | Fecha de Nacimiento | Sueldo Basico | Edad |");
        System.out.println("+-------------------------------------------------------------------------------------------+");
        Collections.sort(emp);
        for (Model.Empleado empleado : emp) {
            System.out.printf("|    %-9s | %-17s | %-9s | %-19s | %-13s | %-4s\n",
                    empleado.getNroDeLegajo(),
                    empleado.getNombreYapellido(),
                    empleado.getDni(),
                    sdf.format(empleado.getFechaNac()),
                    empleado.getSueldo(),
                    calcularEdad(empleado.getFechaNac()) + "   |");
        }
        System.out.println("+-------------------------------------------------------------------------------------------+");
    }

    public Model.Empleado buscarEmpleado() {
        Model.Empleado emp = new Model.Empleado();
        List<Model.Empleado> empl = cEmpleado.findEmpleadoEntities();
        int buscar, aux = 0, enc;
        try {
            System.out.println("+======================================+");
            System.out.println("+ Ingrese el DNI del Empleado a Buscar +");
            System.out.println("+======================================+");
            buscar = dato.nextInt();
            for (Model.Empleado empleado : empl) {
                enc = empleado.getDni();
                if (enc == buscar) {
                    aux = empleado.getNroDeLegajo();
                    emp = cEmpleado.findEmpleado(aux);
                }
            }
            if (aux == 0) {
                System.out.println("El Empleados con DNI " + buscar + " no ha Sido Encontrados");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return emp;
    }

    public void buscar(Model.Empleado emp) {
        try {
            System.out.println("+-------------------------------------------------------------------------------------------+");
            System.out.println("+                                   Empleado Encontrado                                     +");
            System.out.println("+-------------------------------------------------------------------------------------------+");
            System.out.println("| N° de Legajo | Nombre y Apellido |    DNI    | Fecha de Nacimiento | Sueldo Basico | Edad |");
            System.out.println("+-------------------------------------------------------------------------------------------+");
            System.out.printf("|    %-9s | %-17s | %-9s | %-19s | %-13s | %-4s\n",
                    emp.getNroDeLegajo(),
                    emp.getNombreYapellido(),
                    emp.getDni(),
                    sdf.format(emp.getFechaNac()),
                    emp.getSueldo(),
                    calcularEdad(emp.getFechaNac()) + "   |");
            System.out.println("+-------------------------------------------------------------------------------------------+");
        } catch (NullPointerException ex) {
            ex.getMessage();
        }
    }

    ArrayList<Model.Empleado> lstEmp = new ArrayList<Model.Empleado>();

    public void listaSueldos() {
        Model.Empleado emp = new Model.Empleado();
        List<Model.Empleado> empl = cEmpleado.findEmpleadoEntities();
        lstEmp = new ArrayList<Model.Empleado>();
        float buscar, enc;
        int aux, aux1 = 0;
        try {
            System.out.println("+=============================+");
            System.out.println("+ Ingrese el Sueldo a Superar +");
            System.out.println("+=============================+");
            buscar = dato.nextFloat();
            for (Model.Empleado empleado : empl) {
                enc = empleado.getSueldo();
                if (enc >= buscar) {
                    aux1++;
                    aux = empleado.getNroDeLegajo();
                    emp = cEmpleado.findEmpleado(aux);
                    lstEmp.add(emp);
                }
            }
            if (aux1 == 0) {
                System.out.println("Empleados con un sueldo igual o mayor a " + buscar + " no Encontrados");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("+-------------------------------------------------------------------------------------------+");
        System.out.println("+                                  Empleados Encontrados                                    +");
        System.out.println("+-------------------------------------------------------------------------------------------+");
        System.out.println("| N° de Legajo | Nombre y Apellido |    DNI    | Fecha de Nacimiento | Sueldo Basico | Edad |");
        System.out.println("+-------------------------------------------------------------------------------------------+");
        for (int i = 0; i < lstEmp.size(); i++) {
            System.out.printf("|    %-9s | %-17s | %-9s | %-19s | %-13s | %-4s\n",/*| %-4s*/
                    lstEmp.get(i).getNroDeLegajo(),
                    lstEmp.get(i).getNombreYapellido(),
                    lstEmp.get(i).getDni(),
                    sdf.format(lstEmp.get(i).getFechaNac()),
                    lstEmp.get(i).getSueldo(),
                    calcularEdad(lstEmp.get(i).getFechaNac()) + "   |");
        }
        System.out.println("+-------------------------------------------------------------------------------------------+");
    }

    ArrayList<Integer> edades = new ArrayList<Integer>();
    ArrayList<Model.Empleado> edad = new ArrayList<Model.Empleado>();

    public void mayorEdad() {
        List<Model.Empleado> emp = cEmpleado.findEmpleadoEntities();
        Model.Empleado empl = new Model.Empleado();
        edades = new ArrayList<Integer>();
        edad = new ArrayList<Model.Empleado>();
        int buscar, mos, aux, bus;
        try {
            for (Model.Empleado empleado : emp) {
                buscar = calcularEdad(empleado.getFechaNac());
                edades.add(buscar);
            }
            mos = Collections.max(edades);
            for (Model.Empleado empleado : emp) {
                aux = calcularEdad(empleado.getFechaNac());
                if (mos == aux) {
                    bus = empleado.getNroDeLegajo();
                    empl = cEmpleado.findEmpleado(bus);
                    edad.add(empl);
                }
            }
        } catch (Exception ex) {
            ex.getMessage();
        }

        System.out.println("+-------------------------------------------------------------------------------------------+");
        System.out.println("+                                Empleados de Mayor Edad                                    +");
        System.out.println("+-------------------------------------------------------------------------------------------+");
        System.out.println("| N° de Legajo | Nombre y Apellido |    DNI    | Fecha de Nacimiento | Sueldo Basico | Edad |");
        System.out.println("+-------------------------------------------------------------------------------------------+");
        for (int i = 0; i < edad.size(); i++) {
            System.out.printf("|    %-9s | %-17s | %-9s | %-19s | %-13s | %-4s\n",/*| %-4s*/
                    edad.get(i).getNroDeLegajo(),
                    edad.get(i).getNombreYapellido(),
                    edad.get(i).getDni(),
                    sdf.format(edad.get(i).getFechaNac()),
                    edad.get(i).getSueldo(),
                    calcularEdad(edad.get(i).getFechaNac()) + "   |");
        }
        System.out.println("+-------------------------------------------------------------------------------------------+");
    }
}
