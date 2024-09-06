/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Excepciones.AnioSobrepasadoException;
import Excepciones.CantidadSobrepasadaException;
import Modelo.Libro;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author val
 */
public interface interfazLibro {

    void agregarLibro(Libro libro) throws SQLException, AnioSobrepasadoException;

    Libro buscarLibro(int ID) throws SQLException;

    void editarLibro(int id, String nombre, String autor, int anioPublicacion, int cantidadCopias, int ID_Genero) throws SQLException, AnioSobrepasadoException;

    void eliminarLibro(int id) throws SQLException;

    void eliminarLibroCantidad(int id, int cantidadIngresada, int cantidadTotal) throws SQLException, CantidadSobrepasadaException;

    ArrayList<Libro> listaLibros() throws SQLException;
}
