/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

import javax.swing.JOptionPane;

/**
 *
 * @author val
 */
public class FechaEntregaPasadaException extends RuntimeException {
    public FechaEntregaPasadaException() {
        super("Usted cuenta con un prestamo atrasado");
    }
}
