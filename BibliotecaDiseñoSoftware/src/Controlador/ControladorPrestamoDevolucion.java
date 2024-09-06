/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.DaoPrestamosDevoluciones;
import Modelo.PrestamoDevolucion;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author val
 */
public class ControladorPrestamoDevolucion {

    DaoPrestamosDevoluciones dao;

    public ControladorPrestamoDevolucion() {
        dao = new DaoPrestamosDevoluciones();
    }

    public void generarPrestamo(PrestamoDevolucion prestamo) throws SQLException {
        dao.generarPrestamo(prestamo);
    }

    public PrestamoDevolucion buscarPrestamo(int id) throws SQLException {
        return dao.buscarPrestamo(id);
    }

    public void devolverPrestamo(PrestamoDevolucion prestamo) throws SQLException {
        dao.devolverLibro(prestamo);
    }
    
    public String buscarFechaDevuelto(int id) throws SQLException {
        return dao.buscarFechaDevuelto(id);
    }

    public ArrayList<PrestamoDevolucion> listaPrestamosDevoluciones(int cedula) throws SQLException {
        return dao.listaPrestamosDevoluciones(cedula);
    }

    //para los reportes
    public ArrayList<PrestamoDevolucion> listaPrestamosDevolucionesGenerales(String estado) throws SQLException {
        return dao.listaPrestamosDevolucionesGenerales(estado);
    }

    public ArrayList<PrestamoDevolucion> listaPrestamosDevolucionesPorUsuario(int cedula, String estado) throws SQLException {
        return dao.listaPrestamosDevolucionesPorUsuario(cedula, estado);
    }
}
