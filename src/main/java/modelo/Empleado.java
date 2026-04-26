/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Objects;

/**
 * Entidad base de empleado identificada de forma unica por DNI.
 * @author David
 */
public class Empleado {

    private String dni;
    private String nombre;
    private Salario salariobase;

    public Empleado(String dni, String nombre, Salario salariobase) {
        this.dni = dni;
        this.nombre = nombre;
        this.salariobase = salariobase;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Salario getSalariobase() {
        return salariobase;
    }

    public void setSalariobase(Salario salariobase) {
        this.salariobase = salariobase;
    }

    @Override
    public String toString() {
        return "Empleado{" + "dni=" + dni + ", nombre=" + nombre + ", salariobase=" + salariobase + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        // Dos empleados son iguales si comparten el mismo DNI.
        return Objects.equals(this.dni, other.dni);
    }

}
