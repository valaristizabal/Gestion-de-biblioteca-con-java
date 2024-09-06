/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.DaoUsuarios;
import Modelo.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author val
 */
public class ControladorUsuario {
    DaoUsuarios dao;
    public ControladorUsuario() {
        dao = new DaoUsuarios();
    }
    
    public Usuario buscarUsuarioCorreo(String correo) throws SQLException{
        return dao.buscarUsuarioCorreo(correo);
    }
    
    public Usuario buscarUsuarioCedula(int cedula) throws SQLException{
        return dao.buscarUsuarioCedula(cedula);
    }

    public void agregarUsuario(Usuario usario) throws SQLException{
        dao.agregarUsuario(usario);
    }
    
    public void editarUsuario(String nombre, int cedula, int edad, String telefono, String correo, String contrasenia) throws SQLException {
        dao.editarUsuario(nombre, cedula, edad, telefono, correo, contrasenia);
    }
    
    public void eliminarUsuario(int cedula) throws SQLException{
        dao.eliminarUsuario(cedula);
    }
    
    public ArrayList<Usuario> listaUsuarios() throws SQLException {
        return dao.listaUsuarios();
    }
}
