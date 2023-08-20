/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasql.Servicio;

import java.util.Scanner;

/**
 *
 * @author nacho
 */
public class menuServicio {

    productoServicio ps = new productoServicio();
    fabricanteServicio fs = new fabricanteServicio();
    Scanner leer = new Scanner(System.in);

    public void menu() {
       
        try {
            int opc = 0;
            do {
                System.out.println("Base de datos:");
                System.out.println("------------------------------------------");
                System.out.println("1. Mostrar productos \n"
                        + "2. Mostrar nombre y precio de los productos  \n"
                        + "3. Mostrar productos con precio entre 102 y 202 \n"
                        + "4. Mostrar portatiles \n"
                        + "5. Mostrar el producto mas barato \n"
                        + "6. Ingresar un producto a la base de datos \n"
                        + "7. Ingresar un fabricante a la base de datos  \n"
                        + "8. Editar un producto a eleccion  \n"
                        + "9. Mostrar fabricante  \n"
                        + "10. Salir");
                System.out.println("");
                
                opc = leer.nextInt();
                
                switch (opc) {
                    case 1:
                        ps.imprimirProducto();
                        System.out.println("");
                        break;

                    case 2:
                        ps.mostrarNombreyPrecio();
                        System.out.println("");
                        break;

                    case 3:
                        ps.mostrarPrecio();
                        System.out.println("");
                        break;
                    case 4:
                        ps.mostrarPortatil();
                        System.out.println("");
                        break;

                    case 5:
                        ps.mostrarPrecioBarato();
                        System.out.println("");
                        break;

                    case 6:
                        ps.ingresarProducto();
                        System.out.println("");
                        break;

                    case 7:
                        fs.ingresarFabricante();
                        System.out.println("");
                        break;

                    case 8:

                        ps.modificarProducto();
                        System.out.println("");
                        break;

                    case 9:
                        fs.imprimirFabricante();
                        break;
                    case 10:
                        System.out.println("Saliendo...");
                    default:
                        throw new AssertionError();
                }

            } while (opc != 10);

        } catch (Exception e) {
        }
    }
}
