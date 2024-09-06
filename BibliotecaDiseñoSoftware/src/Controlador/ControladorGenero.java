/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.DaoGeneros;
import Modelo.Genero;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author val
 */
public class ControladorGenero {
    DaoGeneros dao;

    public ControladorGenero() {
        dao = new DaoGeneros();
    }
    
    public void agregarGenero(Genero genero) throws SQLException{
        dao.agregarGenero(genero);
    }
    
    public Genero buscarGenero(int id) throws SQLException{
        return dao.buscarGenero(id);
    }
    
    public int buscarIDGenero(String nombre) throws SQLException{
        return dao.buscarIDGenero(nombre);
    }
    
    public void editarGenero(int id, String nombre) throws SQLException{
        dao.editarGenero(id, nombre);
    }
    
    public void eliminarGenero(int id) throws SQLException{
        dao.eliminarGenero(id);
    }
    
    public ArrayList<Genero> listaGeneros() throws SQLException{
        return dao.listaGeneros();
    }
}
