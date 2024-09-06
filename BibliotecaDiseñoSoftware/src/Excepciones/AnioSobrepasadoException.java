/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

import javax.swing.JOptionPane;

/**
 *
 * @author sotog
 */
public class AnioSobrepasadoException extends RuntimeException {
    public AnioSobrepasadoException() {
        super("El año ingresado sobrepasa al año actual");
    }
}
