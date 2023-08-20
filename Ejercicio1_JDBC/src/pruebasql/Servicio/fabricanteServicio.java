/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasql.Servicio;

import java.util.Collection;
import java.util.Scanner;
import pruebasql.Entidad.Fabricante;
import pruebasql.Entidad.Producto;
import pruebasql.Persistencia.fabricanteDAO;

/**
 *
 * @author nacho
 */
public class fabricanteServicio {

    Scanner leer = new Scanner(System.in);
    private fabricanteDAO dao;

    public fabricanteServicio() {
        this.dao = new fabricanteDAO();
    }

//g) Ingresar un fabricante a la base de datos
    public void ingresarFabricante() {

        System.out.println("***Ingresa un fabricante NUEVO a la base de datos ***\n");
        try {
            boolean cond = true;
            Fabricante fabricante = new Fabricante();
            Collection<Fabricante> fabricantesAux = dao.listarFabricantes();

            //INGRESA CODIGO
            do {
                cond = true;
                System.out.println("Ingrese el codigo");

                int codigo = leer.nextInt();

                for (Fabricante aux : fabricantesAux) {
                    if (codigo == aux.getCodigo()) {
                        cond = false;
                        break;
                    }
                }
                if (cond) {
                    fabricante.setCodigo(codigo);
                } else {
                    System.out.println("El codigo ya existe - debe ingresar un codigo nuevo");
                }

            } while (!cond);

            //INGRESA NOMBRE 
            do {
                cond = true;
                System.out.println("Ingrese nombre del fabricante nuevo");

                String nombre = leer.next();

                for (Fabricante aux : fabricantesAux) {
                    if (aux.getNombre().equalsIgnoreCase(nombre)) {
                        cond = false;
                        break;
                    }
                }
                if (cond) {
                    fabricante.setNombre(nombre);

                } else {
                    System.out.println("El producto ya esxite ");
                }

            } while (!cond);

            dao.guardarFabricante(fabricante);

        } catch (Exception e) {
        }

    }

    public void imprimirFabricante() throws Exception {

        try {

            dao.listarFabricantes();
            Collection<Fabricante> fabricantes = listarFabricante();

            //Imprimimos los productos
            if (fabricantes.isEmpty()) {
                throw new Exception("No existen fabricantes para imprimir, salame");
            } else {
                for (Fabricante aux : fabricantes) {
                    System.out.println(aux.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Fabricante> listarFabricante() throws Exception {

        try {
            //String sql = "Select * from producto";
            Collection<Fabricante> fabricantes = dao.listarFabricantes();

            return fabricantes;
        } catch (Exception e) {
            throw e;
        }
    }

 
    
}
