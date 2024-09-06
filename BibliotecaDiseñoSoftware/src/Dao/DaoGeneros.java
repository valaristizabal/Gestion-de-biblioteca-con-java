/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;


import Modelo.Genero;
import Singleton.DatabaseSingleton;
import interfaces.interfazGenero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author val
 */
public class DaoGeneros implements interfazGenero{
private Connection con;
    public DaoGeneros() {
          con = DatabaseSingleton.getInstance().getConnection();
    }
    

    
    public void agregarGenero(Genero genero) throws SQLException {
        try {
            PreparedStatement ps = null;
         
            String sql = "INSERT INTO generos (nombre) VALUES (?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, genero.getNombre());
            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
    }

    public Genero buscarGenero(int id) throws SQLException {
        Genero generoEncontrado = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
    
        String where = " WHERE id = '" + id + "'";
        String sql = "SELECT * FROM generos" + where;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                generoEncontrado = new Genero(nombre);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }

        return generoEncontrado;
    }

    public int buscarIDGenero(String nombre) throws SQLException {
        int id = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
       
        String where = " WHERE nombre = '" + nombre + "'";
        String sql = "SELECT * FROM generos" + where;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
        return id;
    }
    
    public void editarGenero(int id, String nombre) throws SQLException {
        PreparedStatement ps = null;
      
        try {
            ps = con.prepareStatement("UPDATE generos SET nombre=? WHERE ID=?");
            ps.setString(1, nombre);
            ps.setInt(2, id);
            ps.execute();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
    }

    public void eliminarGenero(int id) throws SQLException {
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("DELETE FROM generos WHERE id= '" + id + "'");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
    }

        public ArrayList<Genero> listaGeneros() throws SQLException {
        ArrayList<Genero> generos = new ArrayList<>();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
   
            String sql = "SELECT * FROM generos";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                
                int id = rs.getInt("ID");
                String nombre = rs.getString("nombre");

                Genero genero = new Genero(nombre);
                generos.add(genero);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException();
        }
        
        return generos;
    }        
}
