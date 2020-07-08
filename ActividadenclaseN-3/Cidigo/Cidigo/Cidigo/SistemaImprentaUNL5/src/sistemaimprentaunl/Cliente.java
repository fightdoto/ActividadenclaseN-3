/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaimprentaunl;

/**
 * @author roberth
 */
public class Cliente extends Persona {

    private double descuento;
    private double deuda;
    private boolean prom;
    private int concurrencia;

    public Cliente(String nombre, String cedula, String email) {
        super(nombre, cedula, email);
    }

    public Cliente(String nombre, String cedula, String email, double descuento, double deuda) {
        super(nombre, cedula, email);
        this.descuento = descuento;
        this.deuda = deuda;
        this.setConcurrencia(0);
    }

    /**
     * @return the descuento
     */
    public double getDescuento() {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    /**
     * @return the deuda
     */
    public double getDeuda() {
        return deuda;
    }

    /**
     * @param deuda the deuda to set
     */
    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

    public int getConcurrencia() {
        return concurrencia;
    }

    public void setConcurrencia(int concurrencia) {
        this.concurrencia = concurrencia;
    }

    public boolean isProm() {
        return prom;
    }

    public void setProm(boolean prom) {
        this.prom = prom;
    }
}
