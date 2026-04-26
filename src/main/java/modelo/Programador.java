/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Especializacion de empleado que almacena su lenguaje principal.
 * @author David
 */
public class Programador extends Empleado {

    private String lenguajePrincipal;

    public Programador(String lenguajePrincipal, String dni, String nombre, Salario salariobase) {
        super(dni, nombre, salariobase);
        this.lenguajePrincipal = lenguajePrincipal;
    }

    public String getLenguajePrincipal() {
        return lenguajePrincipal;
    }

    public void setLenguajePrincipal(String lenguajePrincipal) {
        this.lenguajePrincipal = lenguajePrincipal;
    }

    @Override
    public String toString() {
        return super.toString() + "Programador{" + "lenguajePrincipal=" + lenguajePrincipal + '}';
    }

}
