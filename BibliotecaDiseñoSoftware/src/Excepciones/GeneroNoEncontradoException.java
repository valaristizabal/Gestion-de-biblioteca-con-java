/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author val
 */
public class GeneroNoEncontradoException extends RuntimeException{
    public GeneroNoEncontradoException() {
        super("El genero no se encontró");
    }
}
