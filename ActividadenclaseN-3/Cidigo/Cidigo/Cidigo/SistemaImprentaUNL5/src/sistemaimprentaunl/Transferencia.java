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
public class Transferencia extends Pago{

    public Transferencia(String codigoPago, String fecha, double cantidad) {
        super(codigoPago, fecha, cantidad);
    }
    

    @Override
    public void cancelarPago() {
        System.out.println("Pagas con tranferencia y no aplica descuento, CLASE TRANSFENCIA");
    }
    
}
