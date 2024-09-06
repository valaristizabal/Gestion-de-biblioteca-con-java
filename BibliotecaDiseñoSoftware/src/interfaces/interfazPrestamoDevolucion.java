/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Excepciones.CantidadDisponibleSobrepasadaException;
import Modelo.Libro;
import Modelo.PrestamoDevolucion;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author val
 */
public interface interfazPrestamoDevolucion {

    PrestamoDevolucion buscarPrestamo(int id) throws SQLException;

    void generarPrestamo(PrestamoDevolucion prestamo) throws SQLException, CantidadDisponibleSobrepasadaException;

    void devolverLibro(PrestamoDevolucion prestamo) throws SQLException;

    ArrayList<PrestamoDevolucion> listaPrestamosDevoluciones(int cedula) throws SQLException;

    Libro buscarLibro(int ID) throws SQLException;

    String buscarFechaDevuelto(int id) throws SQLException;

    ArrayList<PrestamoDevolucion> listaPrestamosDevolucionesGenerales(String estado) throws SQLException;

    ArrayList<PrestamoDevolucion> listaPrestamosDevolucionesPorUsuario(int cedula, String estado) throws SQLException; 
}
