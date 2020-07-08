/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaimprentaunl;

/**
 *
 * @author roberth
 */
public abstract class Pago {

    private String codigoPago;
    private String fecha;
    private double cantidad;

    public Pago(String codigoPago, String fecha, double cantidad) {
        this.codigoPago = codigoPago;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public void cancelarPago() {
        System.out.println("Esta es la forma de pago CLASE PADRE PAGO");
    }

    /**
     * @return the codigoPago
     */
    public String getCodigoPago() {
        return codigoPago;
    }

    /**
     * @param codigoPago the codigoPago to set
     */
    public void setCodigoPago(String codigoPago) {
        this.codigoPago = codigoPago;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the cantidad
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

}
