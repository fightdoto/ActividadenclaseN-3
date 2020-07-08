/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaimprentaunl;

import java.util.ArrayList;

/**
 *
 * @author roberth
 */
public class Venta implements InterfazDescuentos {

    private String codigoVenta;
    private String fecha;
    private double total;
    private ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    private Cliente cliente;
    private Pago pago;


    public Venta(String codigoVenta, String fecha, double total, ArrayList<Producto> producto) {
        this.codigoVenta = codigoVenta;
        this.fecha = fecha;
        this.total = total;
        this.listaProductos = producto;

    }

    public Venta(String codigoVenta, String fecha, double total, ArrayList<Producto> producto, Cliente cliente) {
        this.codigoVenta = codigoVenta;
        this.fecha = fecha;
        this.total = total;
        this.listaProductos = producto;
        this.cliente = cliente;
    }

    public Venta(String codigoVenta, String fecha, double total, ArrayList<Producto> producto, Cliente cliente, Pago pago) {
        this.codigoVenta = codigoVenta;
        this.fecha = fecha;
        this.total = total;
        this.listaProductos = producto;
        this.cliente = cliente;
        this.pago=pago;
    }

    /**
     * @return the codigoVenta
     */
    public String getCodigoVenta() {
        return codigoVenta;
    }

    /**
     * @param codigoVenta the codigoVenta to set
     */
    public void setCodigoVenta(String codigoVenta) {
        this.codigoVenta = codigoVenta;
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
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the listaProductos
     */
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    /**
     * @param listaProductos the listaProductos to set
     */
    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the pago
     */
    public Pago getPago() {
        return pago;
    }

    /**
     * @param pago the pago to set
     */
    public void setPago(Pago pago) {
        this.pago = pago;
    }

    @Override
    public void calcularDescuento() {
        if (this.total > 100) {
            System.out.println("Se realizará un descuento");
        } else {
            System.out.println("No tienes descuento");
        }

        if (this.listaProductos.isEmpty()) {
            System.out.println("No compras nada!!");
        } else {
            System.out.println("Aplica un descuento");
        }
        if (this.listaProductos.size() >= 2) {
            System.out.println("Has comprando 2 o mas productos Aplica un Descuento!!");
        } else {
            System.out.println("Tu has comprado menos de 2 productos");
        }
    }

    @Override
    public String toString() {
        return "Venta{" +
                "codigoVenta='" + codigoVenta + '\'' +
                ", fecha='" + fecha + '\'' +
                ", total=" + total +
                ", listaProductos=" + listaProductos +
                ", cliente=" + cliente +
                ", pago=" + pago +
                '}';
    }
}
