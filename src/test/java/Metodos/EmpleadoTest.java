/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Model.Empleado;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alumno
 */
public class EmpleadoTest {
    
    public EmpleadoTest() {
    }

//    @Test
//    public void testCalcularEdad() {
//        try {
//            System.out.println("calcularEdad");
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            String fechaIng = "02/08/1999";
//            Date fecha = sdf.parse(fechaIng);
//            //Empleado instance = null;
//            int expResult = 21;
//            int result = Metodos.Empleado.getInstance().calcularEdad(fecha);
//            assertEquals(expResult, result);
//            // TODO review the generated test code and remove the default call to fail.
//            fail("The test case is a prototype.");
//        } catch (ParseException ex) {
//            Logger.getLogger(EmpleadoTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    @Test
    public void testCalcularEdad1() {
        try {
            System.out.println("Calcular Edad");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaIng = "2/8/1999";
            Date fecha = sdf.parse(fechaIng);
            Empleado instance = new Empleado();
            int expResult = 21;
//            int result = 21;
//            assertEquals(result, expResult);
            // TODO review the generated test code and remove the default call to fail.
 //           fail("The test case is a prototype.");
        } catch (ParseException ex) {
            Logger.getLogger(EmpleadoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testCalcularEdad2() {
        try {
            System.out.println("Calcular Edad");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaIng = "3/4/1996";
            Date fecha = sdf.parse(fechaIng);
            Empleado instance = new Empleado();
            int expResult = 25;
//            int result = 21;
//            assertEquals(result, expResult);
            // TODO review the generated test code and remove the default call to fail.
 //           fail("The test case is a prototype.");
        } catch (ParseException ex) {
            Logger.getLogger(EmpleadoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
