/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaimprentaunl;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author roberth
 */
public class SistemaImprentaUNL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("*****SISTEMA IMPRENTA UNL");

        ArrayList<Producto> listaProducto = new ArrayList<Producto>();
        listaProducto.add(new Producto("resma de hojas", 3, 0, 50));
        listaProducto.add(new Producto("tinta", 10, 0, 50));
        listaProducto.add(new Producto("lapices", 0.90, 0, 50));
        listaProducto.add(new Producto("borradores", 0.50, 0, 50));
        listaProducto.add(new Producto("revista digital UNL", 10, 0, 50));

        ArrayList<Venta> listadoVentasRealizadas = new ArrayList<Venta>();


        int num_clientes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de clientes a facturar"));
        ArrayList<Cliente> clientes = new ArrayList<>();
        Cliente cliente = null;
        for (int i = 0; i < num_clientes; i++) {
            String cedula = JOptionPane.showInputDialog("Ingresa tu cedula");
            if (i > 0) {
                boolean nuevo_c = false;
                for (int j = 0; j < clientes.size(); j++) {
                    if (cedula.equals(clientes.get(j).getCedula())) {
                        clientes.get(j).setConcurrencia(clientes.get(j).getConcurrencia() + 1);
                        JOptionPane.showMessageDialog(null, "cliente: \n" + clientes.get(j).getNombre());
                        break;
                    } else {
                        nuevo_c = true;
                    }
                }
                if (nuevo_c) {
                    cliente = new Cliente(JOptionPane.showInputDialog("Ingrese Nombre del Cliente"), cedula, JOptionPane.showInputDialog("Ingresa email Cliente"));
                }
            } else {
                cliente = new Cliente(JOptionPane.showInputDialog("Ingrese Nombre del Cliente"), cedula, JOptionPane.showInputDialog("Ingresa email Cliente"));
            }
            ArrayList<Producto> listaProductos_deseos = new ArrayList<Producto>();
            boolean bucle = true;
            while (bucle) {
                int num_productos = Integer.parseInt(JOptionPane.showInputDialog(null, "1.Ingresar producto \n2.salir  :"));
                switch (num_productos) {
                    case 1:
                        String nombre_producto = JOptionPane.showInputDialog("Ingresa nombre producto");
                        boolean aux = false;
                        for (int j = 0; j < listaProducto.size(); j++) {
                            if (nombre_producto.equals(listaProducto.get(j).getNombreProducto())) {
                                JOptionPane.showMessageDialog(null, "Producto " + listaProducto.get(j).getNombreProducto() + ":\n" +
                                        listaProducto.get(j).getStock() + "\n" +
                                        listaProducto.get(j).getPrecio());
                                int num = Integer.parseInt(JOptionPane.showInputDialog("Ingresa cantidad del producto"));

                                listaProducto.get(j).setStock(listaProducto.get(j).getStock() - num);
                                aux = true;
                                Producto p = listaProducto.get(j);
                                p.setCantidad(num);
                                listaProductos_deseos.add(p);
                                break;
                            }
                        }
                        if (!aux) {
                            JOptionPane.showMessageDialog(null, "Producto no registrado");
                        }
                        break;
                    case 2:
                        bucle = false;
                        break;
                }
            }
            double total = 0;
            for (int j = 0; j < listaProductos_deseos.size(); j++) {
                total += listaProductos_deseos.get(j).getPrecio() * listaProductos_deseos.get(j).getCantidad();
            }
            int anio = Calendar.getInstance().get(Calendar.YEAR);
            System.out.println("Año:" + anio);

            int mes = Calendar.getInstance().get(Calendar.MONTH);
            mes += 1;
            System.out.println("Mes:" + mes);

            int dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
            System.out.println("Día:" + dia);

            String fechaActual = Integer.toString(anio) + "-" + Integer.toString(mes) + " -" + Integer.toString(dia);
            System.out.println("Fecha Actual:" + fechaActual);

            String CodVenta = "Factura 001-001-" + (int) (Math.random() * 100 + 1);
            if ((cliente.getConcurrencia() < 3)) {
                cliente.setDescuento(total * 0.05);
            } else {
                cliente.setDescuento(0);
            }
            clientes.add(cliente);
            Venta venta = new Venta(CodVenta, fechaActual, total - cliente.getDescuento(), listaProductos_deseos, cliente);

            switch (JOptionPane.showInputDialog(null, "Desea pagar en efectivo o por transferencia: ")) {
                case "efectivo":
                    Efectivo efectivo = new Efectivo("Cp1", fechaActual, total - (cliente.getDescuento()));
                    venta.setPago(efectivo);
                    JOptionPane.showMessageDialog(null,
                            efectivo.getCantidad()
                    );
                    break;
                case "transferencia":
                    double interes = total + (total * 0.03);
                    Pago pa = new Transferencia("CTrans1", fechaActual, interes);
                    venta.setPago(pa);
                    JOptionPane.showMessageDialog(null,
                            pa.getCantidad()
                    );
                    break;
            }
            listadoVentasRealizadas.add(venta);
            System.out.println(venta);
        }
        String salida = "";
        salida = "";
        for (int i = 0; i < clientes.size(); i++) {
            salida += (listadoVentasRealizadas.get(i).getPago() instanceof Efectivo) ? clientes.get(i).getNombre() : "";
        }
        JOptionPane.showMessageDialog(null, "Los clientes que pagaron en efectivo son:\n" +
                salida);

        Secretaria s = new Secretaria("Almudena", "1105964844", "almudena@gmail.com", 2, 5);
        System.out.println("Secretaria " + s.getNombre() + ":");
        System.out.println("sueldo: "+s.sueldo());
        Disenador d = new Disenador("Jean", "1105964444", "jean@gmail.com", 2, 5.7);
        System.out.println("Diseñador " + d.getNombre() + ":");
        System.out.println("sueldo: "+d.sueldo());


    }

}

