/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasql.Persistencia;

import java.util.ArrayList;
import java.util.Collection;
import pruebasql.Entidad.Fabricante;

/**
 *
 * @author nacho
 */
public class fabricanteDAO extends DAO {

    public fabricanteDAO() {
    }

    public void guardarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el fabricante");
            }
            String sql = "INSERT INTO Fabricante (codigo, nombre) "
                    + "VALUES ( " + fabricante.getCodigo() + " , '" + fabricante.getNombre() + "' ); ";

            System.out.println(sql);
            impactarBase(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el fabricante que desea modificar");
            }
            String sql = "UPDATE fabricante SET "
                    + " codigo = '" + fabricante.getCodigo() + "' , nombre = '" + fabricante.getNombre()
                    + " WHERE codigo = " + fabricante.getCodigo() + "";
            impactarBase(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarFabricante(int codigo) throws Exception {
        try {
            String sql = "DELETE FROM Fabricante WHERE codigo = " + codigo + "";
            impactarBase(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Fabricante buscarFabricantePorCodigo(int codigo) throws Exception {
        try {
            String sql = "SELECT * FROM Fabricante WHERE codigo = " + codigo + "";
            consultarBase(sql);
            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt("codigo"));
                fabricante.setNombre(resultado.getString("nombre"));

            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Fabricante> listarFabricantes() throws Exception {
        try {
            String sql = "SELECT * FROM Fabricante ";
            consultarBase(sql);
            Fabricante fabricante = null;
            Collection<Fabricante> fabricantes = new ArrayList();
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt("codigo"));
                fabricante.setNombre(resultado.getString("nombre"));
//                Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
//                mascota.setUsuario(usuario);
                fabricantes.add(fabricante);
            }
            desconectarBase();
            return fabricantes;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

}
