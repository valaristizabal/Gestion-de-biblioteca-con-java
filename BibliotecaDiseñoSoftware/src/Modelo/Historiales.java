package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;


/**
 *
 * @author val
 */


public class Historiales {
    private int id;
    private LocalDate fecha;
    private LocalTime hora;
    private String nombreUsuario;
    private String accion;
    private int id_usuario;
   
//la tabla
    
    public Historiales(int id, LocalDate fecha, LocalTime hora, String nombreUsuario, String accion) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.nombreUsuario = nombreUsuario;
        this.accion = accion;

    }

//agregar
    public Historiales(int id, LocalDate fecha, LocalTime hora, String nombreUsuario, String accion, int id_usuario) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.nombreUsuario = nombreUsuario;
        this.accion = accion;
        this.id_usuario = id_usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

 
}
