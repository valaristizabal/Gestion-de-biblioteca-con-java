/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;



/**
 *
 * @author sotog
 */
public class CantidadSobrepasadaException extends RuntimeException {
    public CantidadSobrepasadaException() {
        super("La cantidad de libros que desea eliminar excede a la cantidad de libros totales");
    }
}
