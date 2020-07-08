/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaimprentaunl;

/**
 * @author roberth
 */
public class Disenador extends Empleado {

    public Disenador(String nombre, String cedula, String email, double numeroH, double precioPorHora) {
        super(nombre, cedula, email, numeroH, precioPorHora);
    }

    public double sueldo() {
        double aux = getNumeroHoras() * getPrecioHora();
        return aux + getSUELDOFIJO();
    }

}
