/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author val
 */
public class Usuario {
    ArrayList<Historiales> listaHistoriales;
    
    private String nombre;
    private int cedula;
    private int edad;
    private String telefono;
    private String correo;
    private String contrasenia;

    public Usuario(String nombre, int cedula, int edad, String telefono, String correo, String contrasenia) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasenia = contrasenia;
        listaHistoriales = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public ArrayList<Historiales> getListaHistoriales() {
        return listaHistoriales;
    }

    public void setListaHistoriales(ArrayList<Historiales> listaHistoriales) {
        this.listaHistoriales = listaHistoriales;
    }        
}
