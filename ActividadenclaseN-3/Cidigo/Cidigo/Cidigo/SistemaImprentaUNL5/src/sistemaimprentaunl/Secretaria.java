/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaimprentaunl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 * @author roberth
 */
public class Secretaria extends Empleado {

    public Secretaria(String nombre, String cedula, String email, double numeroH, double precioPorHora) {
        super(nombre, cedula, email, numeroH, precioPorHora);
    }

    public double sueldo() {
        double aux = getNumeroHoras() * getPrecioHora();
        return (aux > getSUELDOFIJO()) ? getSUELDOFIJO() : aux;
    }

}
