/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaimprentaunl;

/**
 * @author roberth
 */
public class Empleado extends Persona {

    private double numeroHoras;
    private double precioHora;
    private final double SUELDOFIJO;

    public Empleado(String nombre, String cedula, String email, double numeroH, double precioPorHora) {
        super(nombre, cedula, email);
        this.numeroHoras = numeroH;
        this.precioHora = precioPorHora;
        this.SUELDOFIJO = 450;
    }

    /**
     * @return the numeroHoras
     */
    public double getNumeroHoras() {
        return numeroHoras;
    }

    /**
     * @param numeroHoras the numeroHoras to set
     */
    public void setNumeroHoras(double numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    /**
     * @return the precioHora
     */
    public double getPrecioHora() {
        return precioHora;
    }

    /**
     * @param precioHora the precioHora to set
     */

    public void setPrecioHora(double precioHora) {
        this.precioHora = precioHora;
    }

    public double getSUELDOFIJO() {
        return SUELDOFIJO;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "numeroHoras=" + numeroHoras +
                ", precioHora=" + precioHora +
                ", SUELDOFIJO=" + SUELDOFIJO +
                '}';
    }
}
