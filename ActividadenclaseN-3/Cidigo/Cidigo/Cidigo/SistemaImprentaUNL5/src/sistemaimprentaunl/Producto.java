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
public class Producto {

    private String nombreProducto;
    private double precio;
    private String codigoProducto;
    private double cantidad;
    private double stock;

    public Producto(String nombreProducto, double precio, double cantidad, double stock) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.stock = stock;
        this.setCodigoProducto();
    }

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the codigoProducto
     */
    public String getCodigoProducto() {
        return codigoProducto;
    }

    /**
     * @param codigoProducto the codigoProducto to set
     */
    public void setCodigoProducto() {
        String codigo = "UNLCProd00" + (int) (Math.random() * 100 + 1);
        System.out.println(codigo);
        this.codigoProducto = codigo;
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

    /**
     * @return the stock
     */
    public double getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(double stock) {
        this.stock = stock;
    }

    public void calcularExistencia() {

    }

    public void actualizarStock(double cantidadVendida) {
        this.stock = this.stock - cantidadVendida;
        System.out.println("Despues de una vente se ha actualizado el Stock");
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombreProducto='" + nombreProducto + '\'' +
                ", precio=" + precio +
                ", codigoProducto='" + codigoProducto + '\'' +
                ", cantidad=" + cantidad +
                ", stock=" + stock +
                '}';
    }
}
