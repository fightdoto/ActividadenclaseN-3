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
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        productosStrock(listaProductos);

        ArrayList<Venta> listadoVentasRealizadas = new ArrayList<Venta>();
        realizarVenta(listadoVentasRealizadas, listaProductos);

        String salida = "";
        for (int i = 0; i < listadoVentasRealizadas.size(); i++) {
            salida += (listadoVentasRealizadas.get(i).getPago() instanceof Efectivo) ? listadoVentasRealizadas.get(i).getCliente().getNombre() : "";
        }

//
//        Secretaria s = new Secretaria("Almudena", "1105964844", "almudena@gmail.com", 2, 5);
//        System.out.println("Secretaria " + s.getNombre() + ":");
//        System.out.println("sueldo: " + s.sueldo());
//        Disenador d = new Disenador("Jean", "1105964444", "jean@gmail.com", 2, 5.7);
//        System.out.println("Diseñador " + d.getNombre() + ":");
//        System.out.println("sueldo: " + d.sueldo());


    }

    public static String input(String msg) {
        return JOptionPane.showInputDialog(null, msg).toLowerCase().trim();
    }

    public static void productosStrock(ArrayList<Producto> listaProductos) {
        listaProductos.add(new Producto("resma de hojas", 3, 0, 50));
        listaProductos.add(new Producto("tinta", 10, 0, 50));
        listaProductos.add(new Producto("lapices", 0.90, 0, 50));
        listaProductos.add(new Producto("borradores", 0.50, 0, 50));
        listaProductos.add(new Producto("revista digital UNL", 10, 0, 50));
    }

    public static void realizarVenta(ArrayList<Venta> listadoVentas, ArrayList<Producto> listaProductos) {

        int nuevo_c = -1;
        int numventas = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Ingrese el numero de ventas a realizar"));
        for (int j = 0; j < numventas; j++) {
            String cedula = input("Ingrese la cedula del Ciente");
            ArrayList<Producto> listaDeseos = listaDeseosCliente(listaProductos);
            if (listadoVentas.size() > 0) {

                for (int i = 0; i < listadoVentas.size(); i++) {
                    if (cedula.equals(listadoVentas.get(i).getCliente().getCedula())) {
                        JOptionPane.showMessageDialog(null, "Cliente Encontrado:\n" +
                                listadoVentas.get(i).getCliente().getNombre() + "\n" +
                                listadoVentas.get(i).getCliente().getCedula()
                        );
                        listadoVentas.get(i).getCliente().setConcurrencia(
                                listadoVentas.get(i).getCliente().getConcurrencia() + 1
                        );
                        nuevo_c = i;
                        break;
                    }
                }
                if (nuevo_c == -1) {
                    Venta venta = new Venta(codVenta(),
                            fechaActual(),
                            totalSinDescuento(listaDeseos),
                            listaDeseos,
                            new Cliente(input("Ingrese Nombre del Cliente"),
                                    cedula,
                                    input("Ingresa email del cliente"))
                    );
                    metodoPago(venta,
                            totalSinDescuento(listaDeseos) - listadoVentas.get(nuevo_c).getCliente().getDescuento());
                    listadoVentas.add(venta);
                } else {

                    if (listadoVentas.get(nuevo_c).getCliente().getConcurrencia() > 3) {
                        listadoVentas.get(nuevo_c).getCliente().setDescuento(totalSinDescuento(listaDeseos) * 0.05);
                    }
                    Venta venta = new Venta(codVenta(), fechaActual(), totalSinDescuento(listaDeseos), listaDeseos,
                            listadoVentas.get(nuevo_c).getCliente()
                    );
                    metodoPago(venta,
                            totalSinDescuento(listaDeseos) - listadoVentas.get(nuevo_c).getCliente().getDescuento());
                    listadoVentas.add(venta);
                }
            } else {

                Venta venta = new Venta(codVenta(),
                        fechaActual(),
                        totalSinDescuento(listaDeseos),
                        listaDeseos,
                        new Cliente(input("Ingrese Nombre del Cliente"),
                                cedula,
                                input("Ingresa email del cliente"))
                );
                metodoPago(venta,
                        totalSinDescuento(listaDeseos));
                listadoVentas.add(venta);
            }
        }
    }

    public static ArrayList<Producto> listaDeseosCliente(ArrayList<Producto> listaProductos) {
        ArrayList<Producto> listaDeseos = new ArrayList<>();
        boolean bucle = true;
        while (bucle) {
            int num_productos = Integer.parseInt(JOptionPane.showInputDialog(null, "1.Ingresar producto \n2.salir"));
            switch (num_productos) {
                case 1:
                    String nombre_producto = input("Ingresa nombre producto");
                    boolean aux = false;
                    for (int j = 0; j < listaProductos.size(); j++) {
                        if (nombre_producto.equals(listaProductos.get(j).getNombreProducto())) {
                            JOptionPane.showMessageDialog(null, "Producto " + listaProductos.get(j).getNombreProducto() + ":\n" +
                                    listaProductos.get(j).getStock() + "\n" +
                                    listaProductos.get(j).getPrecio());
                            int cant = Integer.parseInt(JOptionPane.showInputDialog("Ingresa cantidad del producto"));
                            double stock = listaProductos.get(j).getStock();
                            if (cant <= stock) {
                                double aux1 = stock - cant;
                                listaProductos.get(j).setStock(aux1);
                                Producto p = listaProductos.get(j);
                                p.setCantidad(cant);
                                listaDeseos.add(p);
                                JOptionPane.showMessageDialog(null, "Elemto Ingresado en la lsita de deseos");
                            } else {
                                JOptionPane.showMessageDialog(null, "Stock sobrepasados");
                            }
                            break;
                        } else {
                            aux = true;
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
        return listaDeseos;
    }

    public static String fechaActual() {
        int anio = Calendar.getInstance().get(Calendar.YEAR);
//        System.out.println("Año:" + anio);
        int mes = Calendar.getInstance().get(Calendar.MONTH);
        mes += 1;
//        System.out.println("Mes:" + mes);
        int dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
//        System.out.println("Día:" + dia);
        return Integer.toString(anio) + "-" + Integer.toString(mes) + " -" + Integer.toString(dia);
//        System.out.println("Fecha Actual:" + fechaActual);
    }

    public static String codVenta() {
        return "Factura 001-001-" + (int) (Math.random() * 100 + 1);
    }

    public static double totalSinDescuento(ArrayList<Producto> listaDeseo) {
        double total = 0;
        for (int i = 0; i < listaDeseo.size(); i++) {
            total += listaDeseo.get(i).getCantidad() * listaDeseo.get(i).getPrecio();
        }
        return total;
    }

    public static void metodoPago(Venta venta, double catidad) {
        switch (input("Desea pagar en efectivo o por transferencia: ")) {
            case "efectivo":
                Efectivo efectivo = new Efectivo("Cp1", fechaActual(), catidad);
                venta.setPago(efectivo);
                JOptionPane.showMessageDialog(null,
                        "Efectivo: " + efectivo.getCantidad()
                );
                break;
            case "transferencia":
                double recargo = catidad + (catidad * 0.03);
                Pago pa = new Transferencia("CTrans1", fechaActual(), recargo);
                venta.setPago(pa);
                JOptionPane.showMessageDialog(null,
                        "Transacción: " + pa.getCantidad()
                );
                break;
        }
    }
}

