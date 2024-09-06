/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Modelo.Historiales;
import Modelo.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author val
 */
public interface interfazHistorial {

    void agregarRegistroHistorial(Historiales historial) throws SQLException;

    String buscarNombreUsuarioPorCedula(int cedula) throws SQLException;

    Usuario buscarUsuarioPorCedula(int cedula) throws SQLException;

    ArrayList<Historiales> listarHistorialCompleto() throws SQLException;
}
