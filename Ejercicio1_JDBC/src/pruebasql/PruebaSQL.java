/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasql;

import java.util.Scanner;
import pruebasql.Servicio.fabricanteServicio;
import pruebasql.Servicio.menuServicio;
import pruebasql.Servicio.productoServicio;

/**
 *
 * @author nacho
 */
public class PruebaSQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        menuServicio menu = new menuServicio();
        Scanner leer = new Scanner(System.in);
        
        try {
//              System.out.println("Base de datos:");
//                System.out.println("------------------------------------------");
//                System.out.println("1. Mostrar productos \n"
//                        + "2. Mostrar nombre y precio de los productos  \n"
//                        + "3. Mostrar productos con precio entre 102 y 202 \n"
//                        + "4. Mostrar portatiles \n"
//                        + "5. Mostrar el producto mas barato \n"
//                        + "6. Ingresar un producto a la base de datos \n"
//                        + "7. Ingresar un fabricante a la base de datos  \n"
//                        + "8. Editar un producto a eleccion  \n"
//                        + "9. Mostrar fabricante  \n"
//                        + "10. Salir");
//            System.out.println("");
            menu.menu();
            

            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }

    }

}
