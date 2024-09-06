/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Modelo.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author val
 */
public interface interfazUsuario {

    void agregarUsuario(Usuario usuario) throws SQLException;

    Usuario buscarUsuarioCorreo(String correo) throws SQLException;

    Usuario buscarUsuarioCedula(int cedula) throws SQLException;

    void editarUsuario(String nombre, int cedula, int edad, String telefono, String correo, String contrasenia) throws SQLException;

    void eliminarUsuario(int cedula) throws SQLException;

    String obtenerNombreUsuario(int cedula) throws SQLException;

    ArrayList<Usuario> listaUsuarios() throws SQLException;
}
