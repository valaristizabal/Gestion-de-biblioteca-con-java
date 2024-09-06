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
public class CantidadDisponibleSobrepasadaException extends RuntimeException {
    public CantidadDisponibleSobrepasadaException() {
        JOptionPane.showMessageDialog(null, "No se puede prestar más este libro");
    }
}
