/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.DaoLibros;
import Modelo.Libro;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author val
 */
public class ControladorLibro {
    DaoLibros dao;

    public ControladorLibro() {
        dao = new DaoLibros();
    }
    
    public Libro buscarLibro(int id) throws SQLException{
        return dao.buscarLibro(id);
    }
    
    public void agregarLibro(Libro libro) throws SQLException{
        dao.agregarLibro(libro);
    }
    
    public void editarLibro(int id, String nombre, String autor, int anioPublicacion, int cantidadCopias, int ID_Genero) throws SQLException {
        dao.editarLibro(id, nombre, autor, anioPublicacion, cantidadCopias, ID_Genero);
    }
    
    public void eliminarLibro(int id) throws SQLException{
        dao.eliminarLibro(id);
    }
    
    public void eliminarLibroCantidad(int id, int cantidadIngresada, int cantidadTotal) throws SQLException {
        dao.eliminarLibroCantidad(id, cantidadIngresada, cantidadTotal);
    }
    
    public ArrayList<Libro> listaLibros () throws SQLException {
        return dao.listaLibros();
    }
    
    
}
