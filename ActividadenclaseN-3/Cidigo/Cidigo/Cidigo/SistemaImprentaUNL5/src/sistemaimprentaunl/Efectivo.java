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
public class Efectivo extends Pago {

    public Efectivo(String codigoPago, String fecha, double cantidad) {
        super(codigoPago, fecha, cantidad);
    }
    
    @Override
    public void cancelarPago() {
        System.out.println("Si paga en Efectivo se considera un descuento ESTOY EN CLASE EFECTIVO");
        
    }
    

}
