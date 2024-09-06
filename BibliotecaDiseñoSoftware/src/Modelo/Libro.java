/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author val
 */
public class Libro {
    private int id;
    private String nombre;
    private String autor;
    private int anioPublicacion;
    private int cantidadCopias;
    private int cantidadDisponible;
    private int cantidadPrestadas;
    private int idGenero;
    private String nombreGenero;

    //para métodos libro (agregar)
    public Libro(int id, String nombre, String autor, int anioPublicacion, int cantidadCopias, int idGenero) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.cantidadCopias = cantidadCopias;
        cantidadDisponible = cantidadCopias;
        cantidadPrestadas = cantidadPrestadas;
        this.idGenero = idGenero;
    }

    //para prestamos

    public Libro(int id, String nombre, String autor, int anioPublicacion, int cantidadCopias, int cantidadDisponible, int cantidadPrestadas, int idGenero) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.cantidadCopias = cantidadCopias;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadPrestadas = cantidadPrestadas;
        this.idGenero = idGenero;
    }
    
    
    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", nombre=" + nombre + ", autor=" + autor + ", anioPublicacion=" + anioPublicacion + ", cantidadCopias=" + cantidadCopias + ", cantidadDisponible=" + cantidadDisponible + ", cantidadPrestadas=" + cantidadPrestadas + ", idGenero=" + idGenero + ", nombreGenero=" + nombreGenero + '}';
    }

    //para la tabla
    public Libro(int id, String nombre, String autor, int anioPublicacion, int cantidadCopias, int cantidadDisponible, int cantidadPrestada, String nombreGenero) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.cantidadCopias = cantidadCopias;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadPrestadas = cantidadPrestada;
        this.nombreGenero = nombreGenero;
    }

//    public Libro(int id, String nombre, String autor, int anioPublicacion, int cantidadCopias) {
//        this.id = id;
//        this.nombre = nombre;
//        this.autor = autor;
//        this.anioPublicacion = anioPublicacion;
//        this.cantidadCopias = cantidadCopias;
//    }   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getCantidadCopias() {
        return cantidadCopias;
    }

    public void setCantidadCopias(int cantidadCopias) {
        this.cantidadCopias = cantidadCopias;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getCantidadPrestadas() {
        return cantidadPrestadas;
    }

    public void setCantidadPrestadas(int cantidadPrestadas) {
        this.cantidadPrestadas = cantidadPrestadas;
    }

    

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }
    
    
}
