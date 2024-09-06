/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author val
 */
public class PrestamoDevolucion {

    public static final String PRESTADO = "Prestado";
    public static final String DEVUELTO = "Devuelto";

    private String estado;
    private int id;
    private int detallesLibro;
    private LocalDate fechaPrestamoActual;//Fecha actual
    private LocalDate fechaVencimiento;//Que dia devuelvo
    private LocalDate fechaEntrega; //día en el que se devolvió el libro
    private int cedulaUsuario;  

    public PrestamoDevolucion(int detallesLibro, LocalDate fechaPrestamoActual, LocalDate fechaVencimiento, int cedulaUsuario) {
        estado = PRESTADO;
        this.detallesLibro = detallesLibro;
        this.fechaPrestamoActual = fechaPrestamoActual;
        this.fechaVencimiento = fechaVencimiento;
        fechaEntrega = null;
        this.cedulaUsuario = cedulaUsuario;
    }

    //constructor para cargar los datos de la tabla devolución
    public PrestamoDevolucion(String estado, int id, int detallesLibro, LocalDate fechaPrestamoActual, LocalDate fechaVencimiento, int cedulaUsuario) {
        this.estado = estado;
        this.id = id;
        this.detallesLibro = detallesLibro;
        this.fechaPrestamoActual = fechaPrestamoActual;
        this.fechaVencimiento = fechaVencimiento;
        this.cedulaUsuario = cedulaUsuario;
    }    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDetallesLibro() {
        return detallesLibro;
    }

    public void setDetallesLibro(int detallesLibro) {
        this.detallesLibro = detallesLibro;
    }

    public LocalDate getFechaPrestamoActual() {
        return fechaPrestamoActual;
    }

    public void setFechaPrestamoActual(LocalDate fechaPrestamoActual) {
        this.fechaPrestamoActual = fechaPrestamoActual;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(int cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }
}
