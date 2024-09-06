/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.DaoHistoriales;
import Modelo.Historiales;
import Modelo.Libro;
import Modelo.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sotog
 */

public class ControladorHistorial {

    DaoHistoriales daoHistorial;

    public ControladorHistorial() {
        this.daoHistorial = new DaoHistoriales();
    }

    public void agregarRegistroHistorial(Historiales historial) throws SQLException {
        daoHistorial.agregarRegistroHistorial(historial);
    }

    public ArrayList<Historiales> listaH() throws SQLException {
        return daoHistorial.listarHistorialCompleto();
    }

    public String buscarNombreUsuarioPorCedula(int cedula) throws SQLException {
        return daoHistorial.buscarNombreUsuarioPorCedula(cedula);

    }

    public Usuario buscarUsuarioPorCedula(int cedula) throws SQLException {
        return daoHistorial.buscarUsuarioPorCedula(cedula);
    }

    public ArrayList<Historiales> listaUsuariosCreados() throws SQLException {
        return daoHistorial.listaUsuariosCreados();
    }
    
    public ArrayList<Historiales> listaUsuariosModificados() throws SQLException {
       return daoHistorial.listaUsuariosModificados();
    }
    
    public ArrayList<Historiales> listaUsuariosEliminados() throws SQLException {
        return daoHistorial.listaUsuariosEliminados();
    }
    
    public ArrayList<Historiales> listaUsuariosLogueados() throws SQLException {
        return daoHistorial.listaUsuariosLogueados();
    }
    
    public ArrayList<Historiales> listaLibrosRegistrados() throws SQLException {
        return daoHistorial.listaLibrosRegistrados();
    }
    
    public ArrayList<Historiales> listaLibrosModificados() throws SQLException {
        return daoHistorial.listaLibrosModificados();
    }
    
    public ArrayList<Historiales> listaLibrosEliminados() throws SQLException {
        return daoHistorial.listaLibrosEliminados();
    }
}
