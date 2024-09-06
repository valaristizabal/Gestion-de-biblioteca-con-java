/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Modelo.Genero;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author val
 */
public interface interfazGenero {
    void agregarGenero(Genero genero) throws SQLException;

    Genero buscarGenero(int id) throws SQLException;

    int buscarIDGenero(String nombre) throws SQLException;

    void editarGenero(int id, String nombre) throws SQLException;

    void eliminarGenero(int id) throws SQLException;

    ArrayList<Genero> listaGeneros() throws SQLException;
}
