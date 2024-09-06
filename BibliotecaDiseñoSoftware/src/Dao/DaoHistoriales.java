/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Modelo.Historiales;
import Modelo.Usuario;
import Singleton.DatabaseSingleton;
import interfaces.interfazHistorial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author sotog
 */
public class DaoHistoriales implements interfazHistorial {

    private Connection con;

    public DaoHistoriales() {
        con = DatabaseSingleton.getInstance().getConnection();
    }

    public void agregarRegistroHistorial(Historiales historial) throws SQLException {
      

        String query = "INSERT INTO historiales (id_historial,id_usuario, accion, fecha, hora) VALUES (?, ?, ?, ?,?)";

        try ( PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, historial.getId());
            statement.setInt(2, historial.getId_usuario());
            statement.setString(3, historial.getAccion());
            statement.setObject(4, historial.getFecha());
            statement.setObject(5, historial.getHora());

            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException();
        }
    }
    
    public String buscarNombreUsuarioPorCedula(int cedula) throws SQLException {
    String nombreUsuario = null;

    try {
        String query = "SELECT nombre FROM usuarios WHERE cedula = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, cedula);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            nombreUsuario = resultSet.getString("nombre");
        }

    } catch (SQLException ex) {
        throw new SQLException("Error al buscar el nombre del usuario por cédula");
    }

    return nombreUsuario;
}

    public Usuario buscarUsuarioPorCedula(int cedula) throws SQLException {
    Usuario usuario = null;

    try {
        String query = "SELECT * FROM usuarios WHERE cedula = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, cedula);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            int cedulaUsuario = resultSet.getInt("cedula");
            int edad = resultSet.getInt("edad");
            String telefono = resultSet.getString("telefono");
            String correo = resultSet.getString("correo");
            String contrasenia = resultSet.getString("contrasenia");

            usuario = new Usuario(nombre, cedulaUsuario, edad, telefono, correo, contrasenia);
        }

    } catch (SQLException ex) {
        throw new SQLException("Error al buscar usuario por cédula");
    }

    return usuario;
}


    public ArrayList<Historiales> listarHistorialCompleto() throws SQLException {
        ArrayList<Historiales> registros = new ArrayList<>();

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;

            String sql = "SELECT h.id_historial, h.id_usuario, h.accion, h.fecha, h.hora, u.nombre "
                    + "FROM historiales h "
                    + "INNER JOIN usuarios u ON h.id_usuario = u.cedula";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_historial");
                int idUsuario = rs.getInt("id_usuario");
                String accion = rs.getString("accion");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                LocalTime hora = LocalTime.parse(rs.getTime("hora").toString());
                String nombreUsuario = rs.getString("nombre");

                Historiales registro = new Historiales(id, fecha, hora, nombreUsuario, accion, idUsuario);
                registros.add(registro);
            }

        } catch (SQLException ex) {
            throw new SQLException();
        }

        return registros;
    }

    
    //listas para pdfs

    public ArrayList<Historiales> listaUsuariosCreados() throws SQLException {
        ArrayList<Historiales> registros = new ArrayList<>();

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
        String sql = "SELECT h.id_historial, h.id_usuario, h.accion, h.fecha, h.hora, u.nombre "
                + "FROM historiales h "
                + "INNER JOIN usuarios u ON h.id_usuario = u.cedula "
                + "WHERE h.accion LIKE '%Se registro una persona con cedula%'";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_historial");
                int idUsuario = rs.getInt("id_usuario");
                String accion = rs.getString("accion");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                LocalTime hora = LocalTime.parse(rs.getTime("hora").toString());
                String nombreUsuario = rs.getString("nombre");

                Historiales registro = new Historiales(id, fecha, hora, nombreUsuario, accion, idUsuario);
                registros.add(registro);
            }

        } catch (SQLException ex) {
            throw new SQLException();
        }

        return registros;
    }
    
    public ArrayList<Historiales> listaUsuariosModificados() throws SQLException {
        ArrayList<Historiales> registros = new ArrayList<>();

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
        String sql = "SELECT h.id_historial, h.id_usuario, h.accion, h.fecha, h.hora, u.nombre "
                + "FROM historiales h "
                + "INNER JOIN usuarios u ON h.id_usuario = u.cedula "
                + "WHERE h.accion LIKE '%Se modifico una persona con cedula%'";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_historial");
                int idUsuario = rs.getInt("id_usuario");
                String accion = rs.getString("accion");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                LocalTime hora = LocalTime.parse(rs.getTime("hora").toString());
                String nombreUsuario = rs.getString("nombre");

                Historiales registro = new Historiales(id, fecha, hora, nombreUsuario, accion, idUsuario);
                registros.add(registro);
            }

        } catch (SQLException ex) {
            throw new SQLException();
        }

        return registros;
    }
    
    public ArrayList<Historiales> listaUsuariosEliminados() throws SQLException {
        ArrayList<Historiales> registros = new ArrayList<>();

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
        String sql = "SELECT h.id_historial, h.id_usuario, h.accion, h.fecha, h.hora, u.nombre "
                + "FROM historiales h "
                + "INNER JOIN usuarios u ON h.id_usuario = u.cedula "
                + "WHERE h.accion LIKE '%Se elimino una persona con cedula%'";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_historial");
                int idUsuario = rs.getInt("id_usuario");
                String accion = rs.getString("accion");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                LocalTime hora = LocalTime.parse(rs.getTime("hora").toString());
                String nombreUsuario = rs.getString("nombre");

                Historiales registro = new Historiales(id, fecha, hora, nombreUsuario, accion, idUsuario);
                registros.add(registro);
            }

        } catch (SQLException ex) {
            throw new SQLException();
        }

        return registros;
    }
    
    public ArrayList<Historiales> listaUsuariosLogueados() throws SQLException {
        ArrayList<Historiales> registros = new ArrayList<>();

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
        String sql = "SELECT h.id_historial, h.id_usuario, h.accion, h.fecha, h.hora, u.nombre "
                + "FROM historiales h "
                + "INNER JOIN usuarios u ON h.id_usuario = u.cedula "
                + "WHERE h.accion LIKE '%Ingresó una persona con cedula%'";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_historial");
                int idUsuario = rs.getInt("id_usuario");
                String accion = rs.getString("accion");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                LocalTime hora = LocalTime.parse(rs.getTime("hora").toString());
                String nombreUsuario = rs.getString("nombre");

                Historiales registro = new Historiales(id, fecha, hora, nombreUsuario, accion, idUsuario);
                registros.add(registro);
            }

        } catch (SQLException ex) {
            throw new SQLException();
        }

        return registros;
    }
    
    //pdfs de los libros
    
    public ArrayList<Historiales> listaLibrosRegistrados() throws SQLException {
        ArrayList<Historiales> registros = new ArrayList<>();

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
        String sql = "SELECT h.id_historial, h.id_usuario, h.accion, h.fecha, h.hora, u.nombre "
                + "FROM historiales h "
                + "INNER JOIN usuarios u ON h.id_usuario = u.cedula "
                + "WHERE h.accion LIKE '%Se guardo un libro con id%'";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_historial");
                int idUsuario = rs.getInt("id_usuario");
                String accion = rs.getString("accion");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                LocalTime hora = LocalTime.parse(rs.getTime("hora").toString());
                String nombreUsuario = rs.getString("nombre");

                Historiales registro = new Historiales(id, fecha, hora, nombreUsuario, accion, idUsuario);
                registros.add(registro);
            }

        } catch (SQLException ex) {
            throw new SQLException();
        }

        return registros;
    }
    
        public ArrayList<Historiales> listaLibrosModificados() throws SQLException {
        ArrayList<Historiales> registros = new ArrayList<>();

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
        String sql = "SELECT h.id_historial, h.id_usuario, h.accion, h.fecha, h.hora, u.nombre "
                + "FROM historiales h "
                + "INNER JOIN usuarios u ON h.id_usuario = u.cedula "
                + "WHERE h.accion LIKE '%Se modifico un libro con id%'";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_historial");
                int idUsuario = rs.getInt("id_usuario");
                String accion = rs.getString("accion");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                LocalTime hora = LocalTime.parse(rs.getTime("hora").toString());
                String nombreUsuario = rs.getString("nombre");

                Historiales registro = new Historiales(id, fecha, hora, nombreUsuario, accion, idUsuario);
                registros.add(registro);
            }

        } catch (SQLException ex) {
            throw new SQLException();
        }

        return registros;
    }
    
        public ArrayList<Historiales> listaLibrosEliminados() throws SQLException {
        ArrayList<Historiales> registros = new ArrayList<>();

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
        String sql = "SELECT h.id_historial, h.id_usuario, h.accion, h.fecha, h.hora, u.nombre "
                + "FROM historiales h "
                + "INNER JOIN usuarios u ON h.id_usuario = u.cedula "
                + "WHERE h.accion LIKE '%Se elimino un libro con id%'";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id_historial");
                int idUsuario = rs.getInt("id_usuario");
                String accion = rs.getString("accion");
                LocalDate fecha = rs.getDate("fecha").toLocalDate();
                LocalTime hora = LocalTime.parse(rs.getTime("hora").toString());
                String nombreUsuario = rs.getString("nombre");

                Historiales registro = new Historiales(id, fecha, hora, nombreUsuario, accion, idUsuario);
                registros.add(registro);
            }

        } catch (SQLException ex) {
            throw new SQLException();
        }

        return registros;
    }
}
