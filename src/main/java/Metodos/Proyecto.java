package Metodos;

import Controller.EmpleadoJpaController;
import Controller.ProyectoJpaController;
import Controller.exceptions.NonexistentEntityException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Proyecto {

    public static ProyectoJpaController cProyecto = new ProyectoJpaController();
    public static EmpleadoJpaController cEmpleado = new EmpleadoJpaController();
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static Scanner dato = new Scanner(System.in);

    private Proyecto() {
    }

    private static Proyecto miInstancia;

    public static Proyecto getInstance() {
        if (miInstancia == null) {
            miInstancia = new Proyecto();
        }
        return miInstancia;
    }

    public void agregar() {
        try {
            System.out.println("+=============================+");
            System.out.println("+ Agregando un Nuevo Proyecto +");
            System.out.println("+=============================+");
            Model.Proyecto pro = new Model.Proyecto();
            System.out.println("Ingrese el Codigo del Proyecto: ");
            pro.setCodigoPro(dato.nextInt());
            dato.nextLine();
            System.out.println("Ingrese el Nombre del Proyecto: ");
            pro.setNombre(dato.nextLine());
            System.out.println("Ingrese Fecha de Inio del Proyecto (dia/mes/año):");
            String fech = dato.nextLine();
            Date fecha1 = sdf.parse(fech);
            pro.setFechaInicio(fecha1);
            System.out.println("Ingrese Fecha de Cierre del Proyecto (dia/mes/año):");
            String fec = dato.nextLine();
            Date fecha2 = sdf.parse(fec);
            pro.setFechaFin(fecha2);
            System.out.println("Ingrese el Presupuesto del Proyecto:");
            pro.setMonto(dato.nextFloat());
            cProyecto.create(pro);
            System.out.println("Proyecto Creado Exitosamente");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void eliminar() {
        List<Model.Proyecto> pro = cProyecto.findProyectoEntities();
        int buscar, aux = 0, enc;
        try {
            mostrar();
            System.out.println("+===========================================+");
            System.out.println("+ Ingrese el Codigo del Proyecto a Eliminar +");
            System.out.println("+===========================================+");
            buscar = dato.nextInt();
            for (Model.Proyecto proyecto : pro) {
                enc = proyecto.getCodigoPro();
                if (enc == buscar) {
                    aux++;
                    cProyecto.destroy(buscar);
                    System.out.println("Proyecto Eliminado Exitosamente");
                }
            }
            if (aux == 0) {
                System.out.println("El Proyecto con el Codigo " + buscar + " no ha Sido Encontrados");
            }
        } catch (NonexistentEntityException e) {
            e.getMessage();
        }
    }

    public void modificar() {
        try {
            System.out.println("+=========================+");
            System.out.println("+ Modificando un Proyecto +");
            System.out.println("+=========================+");
            Model.Proyecto pro = new Model.Proyecto();
            mostrar();
            System.out.println("En caso de que el codigo del proyecto no coinsida con ninguno se creara uno nuevo ");
            System.out.println("Ingrese el Nuevo Codigo del Proyecto: ");
            pro.setCodigoPro(dato.nextInt());
            dato.nextLine();
            System.out.println("Ingrese el Nuevo Nombre del Proyecto: ");
            pro.setNombre(dato.nextLine());
            dato.nextLine();
            System.out.println("Ingrese la Nueva Fecha de Inio del Proyecto (dia/mes/año):");
            String fech = dato.nextLine();
            Date fecha1 = sdf.parse(fech);
            pro.setFechaInicio(fecha1);
            System.out.println("Ingrese la Nueva Fecha de Cierre del Proyecto (dia/mes/año):");
            String fec = dato.nextLine();
            Date fecha2 = sdf.parse(fec);
            pro.setFechaFin(fecha2);
            System.out.println("Ingrese el Nuevo Presupuesto del Proyecto:");
            pro.setMonto(dato.nextFloat());
            cProyecto.edit(pro);
            System.out.println("Proyecto Modificado Exitosamente");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void buscar() {
        List<Model.Proyecto> pro = cProyecto.findProyectoEntities();
        int buscar, aux = 0, enc;
        try {
            System.out.println("+=========================================+");
            System.out.println("+ Ingrese el Codigo del Proyecto a Buscar +");
            System.out.println("+=========================================+");
            buscar = dato.nextInt();
            for (Model.Proyecto proyecto : pro) {
                enc = proyecto.getCodigoPro();
                if (enc == buscar) {
                    aux++;
                    cProyecto.findProyecto(buscar);
                }
            }
            if (aux == 0) {
                System.out.println("El Proyecto con el Codigo " + buscar + " no ha Sido Encontrados");
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void mostrar() {
        List<Model.Proyecto> pro = cProyecto.findProyectoEntities();
        System.out.println("+----------------------------------------------------------------------------------+");
        System.out.println("+                               Lista de Proyectos                                 +");
        System.out.println("+----------------------------------------------------------------------------------+");
        System.out.println("+Total de Proyectos                                                              " + pro.size() + " +");
        System.out.println("+----------------------------------------------------------------------------------+");
        System.out.println("| Cod. Proyecto |       Nombre        | Fecha de Inicio | Fecha de Fin |   Monto   |");
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

    public void agragarEmp() {
        List<Model.Proyecto> pro = cProyecto.findProyectoEntities();
        List<Model.Empleado> emp = cEmpleado.findEmpleadoEntities();
        int cod1, cod2, bus1, bus2, aux1 = 0, aux2 = 0;
        mostrar();
        System.out.println("+================================================================+");
        System.out.println("+ Ingrese el Codigo del Proyecto al que Desea Agregar un Miembro +");
        System.out.println("+================================================================+");
        cod1 = dato.nextInt();
        for (Model.Proyecto proyecto : pro) {
            bus1 = proyecto.getCodigoPro();
            if (cod1 == bus1) {
                aux1++;
                mostrarEmpleados();
                System.out.println("+========================================================================================+");
                System.out.println("+ Ingrese el Nro de Legajo al que Desea Agregar al Proyecto | " + proyecto.getNombre() + "  +");
                System.out.println("+========================================================================================+");
                cod2 = dato.nextInt();
                for (Model.Empleado empleado : emp) {
                    bus2 = empleado.getNroDeLegajo();
                    if (cod2 == bus2) {
                        aux2++;
                        empleado.setNroDeLegajo(cod2);
                        empleado.setCodigoPro(cod1);
                        try {
                            cEmpleado.edit(empleado);
                            System.out.println("El Empleado/a: " + empleado.getNombreYapellido() + " Ha Sido Agregada al Proyecto :" + proyecto.getNombre() + " Exitosante");
                        } catch (Exception ex) {
                            Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                if (aux2 == 0) {
                    System.out.println("El Empleado con el Nro de Legajo " + cod2 + " no ha sido Encotrado");
                }
            }
        }
        if (aux1 == 0) {
            System.out.println("El Proyecto con el Codigo " + cod1 + " no ha sido Encotrado");
        }
    }

    public void quitarEmp() {
        List<Model.Proyecto> pro = cProyecto.findProyectoEntities();
        List<Model.Empleado> emp = cEmpleado.findEmpleadoEntities();
        int cod1, cod2, bus1, bus2, aux1 = 0, aux2 = 0;
        mostrar();
        System.out.println("+================================================================+");
        System.out.println(" Ingrese el Codigo del Proyecto al que Desea Eliminar un Miembro +");
        System.out.println("+================================================================+");
        cod1 = dato.nextInt();
        for (Model.Proyecto proyecto : pro) {
            bus1 = proyecto.getCodigoPro();
            if (cod1 == bus1) {
                aux1++;
                mostrarEmpleados();
                System.out.println("+============================================================================================+");
                System.out.println("+ Ingrese el Nro de Legajo al que Desea Eliminar del Proyecto | " + proyecto.getNombre() + "   +");
                System.out.println("+============================================================================================+");
                cod2 = dato.nextInt();
                for (Model.Empleado empleado : emp) {
                    bus2 = empleado.getNroDeLegajo();
                    if (cod2 == bus2) {
                        aux2++;
                        empleado.setNroDeLegajo(cod2);
                        empleado.setCodigoPro(0);
                        try {
                            cEmpleado.edit(empleado);
                            System.out.println("El Empleado/a: " + empleado.getNombreYapellido() + " Ha Sido Eliminado del Proyecto :" + proyecto.getNombre() + "Exitosante");
                        } catch (Exception ex) {
                            Logger.getLogger(Proyecto.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                if (aux2 == 0) {
                    System.out.println("El Empleado con el Nro de Legajo " + cod2 + " no ha sido Encotrado");
                }
            }
        }
        if (aux1 == 0) {
            System.out.println("El Proyecto con el Codigo " + cod1 + " no ha sido Encotrado");
        }
    }

    public void mostrarEmpleados() {
        Metodos.Empleado.getInstance().mostrar();
    }

    ArrayList<Model.Empleado> lstEmp = new ArrayList<Model.Empleado>();

    public void mostrarEmpDelPro() {
        Model.Empleado emp = new Model.Empleado();
        List<Model.Empleado> empl = cEmpleado.findEmpleadoEntities();
        List<Model.Proyecto> pro = cProyecto.findProyectoEntities();
        lstEmp = new ArrayList<Model.Empleado>();
        int buscar, enc, buscar2, enc2, aux = 0;
        String nom;
        try {
            mostrar();
            System.out.println("+=======================================================+");
            System.out.println("+ Ingrese el Codigo del Proyecto para ver a sus Miembros +");
            System.out.println("+=======================================================+");
            buscar = dato.nextInt();
            for (Model.Proyecto proyecto : pro) {
                enc2 = proyecto.getCodigoPro();
                if (enc2 == buscar) {
                    aux++;
                    nom = proyecto.getNombre();
                    System.out.println("Nombre del Proyecto: " + nom);
                    for (Model.Empleado empleado : empl) {
                        enc = empleado.getCodigoPro();
                        buscar2 = empleado.getNroDeLegajo();
                        if (enc == buscar) {
                            emp = cEmpleado.findEmpleado(buscar2);
                            lstEmp.add(emp);
                        }
                    }
                }
            }
            if (aux == 0) {
                System.out.println("El Proyecto con el Codigo " + buscar + " no ha sido Encotrado");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("+----------------------------------+");
        System.out.println("+       Empleados Encontrados      +");
        System.out.println("+----------------------------------+");
        System.out.println("| N° de Legajo | Nombre y Apellido |");
        System.out.println("+----------------------------------+");
        for (int i = 0; i < lstEmp.size(); i++) {
            System.out.printf("|    %-9s | %-17s \n",
                    lstEmp.get(i).getNroDeLegajo(),
                    lstEmp.get(i).getNombreYapellido() + "        |");
        }
        System.out.println("+----------------------------------+");
    }

    public void montoTotal() {
        List<Model.Proyecto> pro = cProyecto.findProyectoEntities();
        float suma = 0;
        for (Model.Proyecto proyecto : pro) {
            suma = suma + proyecto.getMonto();
        }
        System.out.println("EL presupuesto total de los Proyectos es de: $" + suma);
    }

    public void calcularMontoIndividual() {
        Model.Empleado emp = new Model.Empleado();
        List<Model.Empleado> empl = cEmpleado.findEmpleadoEntities();
        List<Model.Proyecto> pro = cProyecto.findProyectoEntities();
        lstEmp = new ArrayList<Model.Empleado>();
        int buscar, enc, aux = 0, buscar2, enc2, aux1 = 0;
        float suma = 0, mon, res = 0;
        String nom;
        try {
            mostrar();
            System.out.println("+======================================================================+");
            System.out.println("+ Ingrese el Codigo del Proyecto para ver cuanto recieben sus miembros +");
            System.out.println("+======================================================================+");
            buscar = dato.nextInt();
            for (Model.Proyecto proyecto : pro) {
                enc2 = proyecto.getCodigoPro();
                if (enc2 == buscar) {
                    aux1++;
                    mon = proyecto.getMonto();
                    nom = proyecto.getNombre();
                    System.out.println("Nombre del Proyecto: " + nom + "\nTiene un Presupuesto de : " + mon);
                    for (Model.Empleado empleado : empl) {
                        enc = empleado.getCodigoPro();
                        buscar2 = empleado.getNroDeLegajo();
                        if (enc == buscar) {
                            aux = aux + 1;
                            suma = suma + mon;
                            res = mon / aux;
                        }
                    }
                }
            }
            if (aux1 == 0) {
                System.out.println("El Proyecto con el Codigo " + buscar + " no ha sido Encotrado");
            } else {
                System.out.println("Numero de Participantes: " + aux);
                System.out.println("EL Monto Total por Participantes es de: $" + res);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    ArrayList<Model.Proyecto> lstPro1 = new ArrayList<Model.Proyecto>();

    public void listaPorFechaInicio() {
        Model.Proyecto pro = new Model.Proyecto();
        List<Model.Proyecto> proy = cProyecto.findProyectoEntities();
        lstPro1 = new ArrayList<Model.Proyecto>();
        int aux, aux1 = 0;
        String busfech1, busfech2;
        Date enc, fecha1, fecha2;
        try {
            dato.nextLine();
            System.out.println("Ingrese las Fechas de Forma Acendente (de menor a mayor)");
            System.out.println("+====================================+");
            System.out.println("+ Ingrese la 1er Fecha (dia/mes/año) +");
            System.out.println("+====================================+");
            busfech1 = dato.nextLine();
            fecha1 = sdf.parse(busfech1);
            System.out.println("+====================================+");
            System.out.println("+ Ingrese la 2da Fecha (dia/mes/año) +");
            System.out.println("+====================================+");
            busfech2 = dato.nextLine();
            fecha2 = sdf.parse(busfech2);
            for (Model.Proyecto proyecto : proy) {
                enc = proyecto.getFechaInicio();
                if (enc.compareTo(fecha1) >= 0 && enc.compareTo(fecha2) <= 0) {
                    aux1++;
                    aux = proyecto.getCodigoPro();
                    pro = cProyecto.findProyecto(aux);
                    lstPro1.add(pro);
                }
            }
            if (aux1 == 0) {
                System.out.println("Ningun Proyecto a sido Encontrdo en el Rango de Fechas Ingresadas");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("+----------------------------------------------------------------------------------+");
        System.out.println("+             Lista de Proyectos Por Fechas de Inicio                              +");
        System.out.println("+----------------------------------------------------------------------------------+");;
        System.out.println("| Cod. Producto |       Nombre        | Fecha de Inicio | Fecha de Fin |   Monto   |");
        System.out.println("+----------------------------------------------------------------------------------+");
        for (int i = 0; i < lstPro1.size(); i++) {
            System.out.printf("|     %-9s | %-17s |   %-13s |   %-10s | %-10s \n",
                    lstPro1.get(i).getCodigoPro(),
                    lstPro1.get(i).getNombre(),
                    sdf.format(lstPro1.get(i).getFechaInicio()),
                    sdf.format(lstPro1.get(i).getFechaFin()),
                    lstPro1.get(i).getMonto()
                    + "   |");
        }
        System.out.println("+----------------------------------------------------------------------------------+");
    }

    ArrayList<Model.Proyecto> lstPro2 = new ArrayList<Model.Proyecto>();

    public void listaPorFechaFin() {
        Model.Proyecto pro = new Model.Proyecto();
        List<Model.Proyecto> proy = cProyecto.findProyectoEntities();
        lstPro2 = new ArrayList<Model.Proyecto>();
        int aux, aux1 = 0;
        String busfech1, busfech2;
        Date enc, fecha1, fecha2;
        try {
            dato.nextLine();
            System.out.println("Ingrese las Fechas de Forma Acendente (de menor a mayor)");
            System.out.println("+====================================+");
            System.out.println("+ Ingrese la 1er Fecha (dia/mes/año) +");
            System.out.println("+====================================+");
            busfech1 = dato.nextLine();
            fecha1 = sdf.parse(busfech1);
            System.out.println("+====================================+");
            System.out.println("+ Ingrese la 2da Fecha (dia/mes/año) +");
            System.out.println("+====================================+");
            busfech2 = dato.nextLine();
            fecha2 = sdf.parse(busfech2);
            for (Model.Proyecto proyecto : proy) {
                enc = proyecto.getFechaFin();
                if (enc.compareTo(fecha1) >= 0 && enc.compareTo(fecha2) <= 0) {
                    aux1++;
                    aux = proyecto.getCodigoPro();
                    pro = cProyecto.findProyecto(aux);
                    lstPro2.add(pro);
                }
            }
            if (aux1 == 0) {
                System.out.println("Ningun Proyecto a sido Encontrdo en el Rango de Fechas Imgrsadas");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("+----------------------------------------------------------------------------------+");
        System.out.println("+               Lista de Proyectos Por Fechas de Cierre                            +");
        System.out.println("+----------------------------------------------------------------------------------+");;
        System.out.println("| Cod. Producto |       Nombre        | Fecha de Inicio | Fecha de Fin |   Monto   |");
        System.out.println("+----------------------------------------------------------------------------------+");
        for (int i = 0; i < lstPro2.size(); i++) {
            System.out.printf("|     %-9s | %-17s |   %-13s |   %-10s | %-10s \n",
                    lstPro2.get(i).getCodigoPro(),
                    lstPro2.get(i).getNombre(),
                    sdf.format(lstPro2.get(i).getFechaInicio()),
                    sdf.format(lstPro2.get(i).getFechaFin()),
                    lstPro2.get(i).getMonto()
                    + "   |");
        }
        System.out.println("+----------------------------------------------------------------------------------+");
    }

    public void listaPorFecha() {
        int res;
        System.out.println("+===========================================+");
        System.out.println(" + De que Froma Desea Listar los Proyectos? +");
        System.out.println("+===========================================+");
        System.out.println("+ 1. Por Fecha de Inicio                    +");
        System.out.println("+ 2. Por Fecha de Cierre                    +");
        System.out.println("+ Eliga una Opcion                          +");
        System.out.println("+===========================================+");
        res = dato.nextInt();
        if (res == 1) {
            listaPorFechaInicio();
        } else if (res == 2) {
            listaPorFechaFin();
        } else {
            System.out.println("Opcion no Valida");
        }
    }

}
