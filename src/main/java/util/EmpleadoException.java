/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package util;

/**
 * Excepcion de negocio para operaciones relacionadas con empleados.
 * @author David
 */
public class EmpleadoException extends Exception {

    /**
     * Creates a new instance of <code>EmpleadosException</code> without detail
     * message.
     */
    public EmpleadoException() {
    }

    /**
     * Constructs an instance of <code>EmpleadosException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EmpleadoException(String msg) {
        super(msg);
    }
}
