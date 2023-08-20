/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasql.Servicio;

import java.util.Collection;
import java.util.Scanner;
import pruebasql.Entidad.Producto;
import pruebasql.Persistencia.DAO;
import pruebasql.Persistencia.productoDAO;

/**
 *
 * @author nacho
 */
public class productoServicio {

    Scanner leer = new Scanner(System.in);
    private productoDAO dao;

    public productoServicio() {
        this.dao = new productoDAO();
    }

    //a) Lista el nombre de todos los productos que hay en la tabla producto.
    public Collection<Producto> listarProducto() throws Exception {

        try {
            //String sql = "Select * from producto";
            Collection<Producto> productos = dao.listarProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProducto() throws Exception {

        try {

            //Listamos los productos
            //String sql = "Select * from producto";
            dao.listarProductos();
            Collection<Producto> productos = listarProducto();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir, salame");
            } else {
                for (Producto aux : productos) {
                    System.out.println(aux.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    //b) Lista los nombres y los precios de todos los productos de la tabla producto.
    public void mostrarNombreyPrecio() throws Exception {

        try {
            Collection<Producto> productos = listarProducto();

            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto aux : productos) {
                    System.out.println("Nombre = " + aux.getNombre() + "," + " Precio = $" + aux.getPrecio());
                }
            }
        } catch (Exception e) {
        }

    }

    //c) Listar aquellos productos que su precio esté entre 120 y 202.
    public void mostrarPrecio() throws Exception {

        try {

            Collection<Producto> productos = listarProducto();

            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir, salame");
            } else {
                for (Producto aux : productos) {
                    if (aux.getPrecio() >= 120 && aux.getPrecio() <= 202) {
                        System.out.println(aux.toString());
                    }
                }
            }

        } catch (Exception e) {
        }

    }

    //d) Buscar y listar todos los Portátiles de la tabla producto.
    public void mostrarPortatil() throws Exception {

        try {

            Collection<Producto> productos = listarProducto();

            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir, salame");
            } else {
                for (Producto aux : productos) {
                    if (aux.getNombre().contains("Portátil")) {
                        System.out.println(aux.toString());
                    }
                }
            }

        } catch (Exception e) {
        }

    }

    //e) Listar el nombre y el precio del producto más barato.
    public void mostrarPrecioBarato() throws Exception {

        try {

            Collection<Producto> productos = dao.mostrarBarato();

            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir, salame");
            } else {
                for (Producto aux : productos) {

                    System.out.println(aux.toString());

                }
            }

        } catch (Exception e) {
        }

    }

    //f) Ingresar un producto a la base de datos.
    public void ingresarProducto() throws Exception {

        System.out.println("***Ingresa un producto NUEVO a la base de datos ***\n");
        try {
            boolean cond = true;
            Producto pd = new Producto();
            Collection<Producto> productos = dao.listarProductos();

            //INGRESA CODIGO
            do {
                cond = true;
                System.out.println("Ingrese el codigo");

                int codigo = leer.nextInt();

                for (Producto aux : productos) {
                    if (codigo == aux.getCodigo()) {
                        cond = false;
                        break;
                    }
                }
                if (cond) {
                    pd.setCodigo(codigo);
                } else {
                    System.out.println("El codigo ya existe - debe ingresar un codigo nuevo");
                }

            } while (!cond);

            //INGRSA NOMBRE PRODUCTO
            do {
                cond = true;
                System.out.println("Ingrese nombre del producto Nuevo");

                String nombre = leer.next();

                for (Producto aux : productos) {
                    if (aux.getNombre().equalsIgnoreCase(nombre)) {
                        cond = false;
                        break;
                    }
                }
                if (cond) {
                    pd.setNombre(nombre);

                } else {
                    System.out.println("El producto ya esxite ");
                }

            } while (!cond);

            //INGRESA PRECIO
            System.out.println("Ingrese el precio");
            pd.setPrecio(leer.nextDouble());

            //INGRESA CODIGO FABRICANTE
            do {
                cond = false;
                System.out.println("Ingrese el codigo de fabricante de 1 a 9");

                int codigo_fabricante = leer.nextInt();

                for (Producto aux : productos) {
                    if (codigo_fabricante == aux.getCodigoFabricante()) {
                        cond = true;

                        break;
                    }
                }
                if (cond) {
                    pd.setCodigoFabricante(codigo_fabricante);

                } else {
                    System.out.println("Debe ingrsar un codigo de fabricante existente de 1 a 9");
                }

            } while (!cond);

            dao.guardarProducto(pd);

        } catch (Exception e) {
            throw e;
        }

    }

    // h) Editar un producto con datos a elección.
    public void modificarProducto() throws Exception {

        System.out.println("***Modifica un PRODUCTO a eleccion***\n");

        try {
            Collection<Producto> productos = dao.listarProductos();
            String op;
            boolean cond = false;
            System.out.println("Ingrese de que manera desea modificar el producto");

            System.out.println("1- CODIGO");
            System.out.println("2- NOMBRE");
            op = leer.next();

            //     if (op.equalsIgnoreCase("1")) {
            if (op.equalsIgnoreCase("1") || op.equalsIgnoreCase("2")) {

                System.out.println((op.equalsIgnoreCase("1")) ? "Ingrese el codigo a buscar" : "Ingrese el nombre a buscar");

                if (op.equalsIgnoreCase("1")) {
                    int codigo = leer.nextInt();
//                    dao.eliminarProducto(codigo);
                    for (Producto aux : productos) {
                        if (aux.getCodigo() == codigo) {
                            cond = true;
                        }
                        if (cond) {
                            System.out.println("Ingrese el nuevo codigo del producto");
                            aux.setCodigo(leer.nextInt());
                            System.out.println("Ingrese nombre");
                            aux.setNombre(leer.next());
                            System.out.println("Ingrese precio ");
                            aux.setPrecio(leer.nextDouble());
                            System.out.println("Ingrese codigo de fabricante");
                            aux.setCodigoFabricante(leer.nextInt());
                            dao.modificarProducto(aux);
//                            dao.guardarProducto(aux);
                            break;
//                        }else{
//                            throw new Exception("No se encontro el producto");
                        }
                    }
                } else if (op.equalsIgnoreCase("2")) {

                    String nombre = leer.next();

                    for (Producto aux : productos) {
                        if (aux.getNombre().equalsIgnoreCase(nombre)) {
                            cond = true;
                            dao.eliminarProducto(aux.getCodigo());
                        }
                        if (cond) {
                            System.out.println("Ingrese codigo");
                            aux.setCodigo(leer.nextInt());
                            System.out.println("Ingrese nombre");
                            aux.setNombre(leer.next());
                            System.out.println("Ingrese precio ");
                            aux.setPrecio(leer.nextDouble());
                            System.out.println("Ingrese codigo de fabricante");
                            aux.setCodigoFabricante(leer.nextInt());
                            dao.modificarProducto(aux);
                            dao.guardarProducto(aux);
                        }
                    }

                }
            }

        } catch (Exception e) {
            throw e;
        }

    }
}
