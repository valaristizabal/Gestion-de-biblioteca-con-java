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
public class LibroNoEncontradoException extends RuntimeException {

    public LibroNoEncontradoException() {
        JOptionPane.showMessageDialog(null, "No se encontro el libro", "Libro no encontrado", JOptionPane.WARNING_MESSAGE);
                
    }
    
    
}
