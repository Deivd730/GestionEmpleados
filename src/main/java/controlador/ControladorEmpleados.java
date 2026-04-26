/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.*;
import java.util.ArrayList;

/**
 * Gestiona la coleccion en memoria de empleados y las operaciones CRUD basicas.
 * @author David
 */
public class ControladorEmpleados {

    private ArrayList<Empleado> listaEmpleados;

    public ControladorEmpleados() {
        this.listaEmpleados = new ArrayList<>();

    }

    /**
     * Busca un empleado por DNI ignorando mayusculas/minusculas.
     *
     * @param dni DNI a buscar
     * @return empleado encontrado o null si no existe
     */
    public Empleado obtenerEmpleadoPorDni(String dni) {
        for (Empleado e : listaEmpleados) {
            if (e.getDni().equalsIgnoreCase(dni)) {
                return e;
            }

        }
        return null;
    }

    /**
     * Da de alta un empleado solo si su DNI no existe previamente.
     *
     * @param m empleado a registrar
     * @return true si se inserta, false si ya existia
     */
    public boolean alatEmpleado(Empleado m) {
        if (obtenerEmpleadoPorDni(m.getDni()) == null) {
            listaEmpleados.add(m);
            return true;
        }

        return false;
    }

    /**
     * Devuelve la lista interna de empleados.
     *
     * @return lista de empleados
     */
    public ArrayList<Empleado> listaEmpleados() {
        return listaEmpleados;
    }

    /**
     * Elimina un empleado por DNI.
     *
     * @param dni DNI del empleado
     * @return true si se elimina, false si no existe
     */
    public boolean eliminarEmpleado(String dni) {
        Empleado m = obtenerEmpleadoPorDni(dni);
        if (m != null) {
            listaEmpleados.remove(m);

        }
        return false;
    }

}
