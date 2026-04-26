/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorEmpleados;
import java.net.http.WebSocket;
import util.EntradaDatos;
import modelo.*;

/**
 * Vista por consola: presenta menu y delega la logica al controlador.
 * @author David
 */
public class VistaConsola {

    private ControladorEmpleados controlador;

    /**
     * Inicializa la vista y crea el controlador principal.
     */
    public VistaConsola() {
        this.controlador = new ControladorEmpleados();
    }

    /**
     * Punto de entrada de la aplicacion de consola.
     */
    public static void main(String[] args) {
        VistaConsola vista = new VistaConsola();
        vista.mostrarMenu();
    }

    /**
     * Bucle principal del menu hasta que el usuario elige salir.
     */
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN ---");
            System.out.println("1. Alta ");
            System.out.println("2. Listar ");
            System.out.println("3. Buscar ");
            System.out.println("4. Modificar ");
            System.out.println("5. Eliminar ");
            System.out.println("0. Salir");
            opcion = EntradaDatos.leerEntero("Seleccione opción", 0, 5);

            switch (opcion) {
                case 1 ->
                    menuAlta();
                case 2 ->
                    listar();
                case 3 ->
                    buscar();
                case 4 ->
                    modificar();
                case 5 ->
                    eliminar();
            }
        } while (opcion != 0);

    }

    /**
     * Solicita datos y registra un nuevo empleado.
     */
    private void menuAlta() {
        String dni = EntradaDatos.leerString("Introduce DNI");
        if (controlador.obtenerEmpleadoPorDni(dni) != null) {
            System.out.println("Empleado con este dni ya existe");
        }

        String nombre = EntradaDatos.leerString("Introduce nombre del Empleado");

        double salarioBase = EntradaDatos.leerDouble("Introduce salario base", 1200, 4000);
        double complementos = EntradaDatos.leerDouble("Introduce complementos", 0, 2000);
        Salario s = new Salario(salarioBase, complementos);

        int tipo = EntradaDatos.leerEntero("1: Programador | 2:Dieñador", 1, 2);
        if (tipo == 1) {
            String lenguajeProgramacion = EntradaDatos.leerString("Introduce lenguaje de programacion");
            controlador.alatEmpleado(new Programador(lenguajeProgramacion, dni, nombre, s));

        } else {
            String herramientaDisenio = EntradaDatos.leerString("Introduce herramienta de diseño");
            controlador.alatEmpleado(new Diseñador(herramientaDisenio, dni, nombre, s));
        }

    }

    /**
     * Muestra todos los empleados almacenados.
     */
    private void listar() {
        if (controlador.listaEmpleados().isEmpty()) {
            System.out.println("No hay empleados");
        }

        for (Empleado e : controlador.listaEmpleados()) {
            System.out.println(e);
        }

    }

    /**
     * Busca y muestra un empleado por DNI.
     */
    private void buscar() {
        String dni = EntradaDatos.leerString("DNI a buscar");
        Empleado e = controlador.obtenerEmpleadoPorDni(dni);
        if (e != null) {
            System.out.println(e);
        } else {
            System.out.println("No encontrado.");
        }
    }

    /**
     * Elimina un empleado por DNI.
     */
    private void eliminar() {
        String dni = EntradaDatos.leerString("DNI a eliminar");
        if (controlador.eliminarEmpleado(dni)) {
            System.out.println("Eliminado con éxito.");
        } else {
            System.out.println("No se encontró el modelo.");
        }
    }

    /**
     * Actualiza los datos de un empleado existente.
     */
    private void modificar() {
        String dni = EntradaDatos.leerString("DNI del empleado a modificar");
        Empleado e = controlador.obtenerEmpleadoPorDni(dni);

        if (e == null) {
            System.out.println("No encontrado.");
            return;
        }

        System.out.println("Modificando a: " + e.getNombre());
        e.setNombre(EntradaDatos.leerString("Nuevo Nombre"));
        e.getSalariobase().setSalarioBase(EntradaDatos.leerDouble("Nuevo Salario Base", 1200, 4000));
        e.getSalariobase().setComplementos(EntradaDatos.leerDouble("Nuevos Complementos", 0, 2000));

        if (e instanceof Programador p) {
            p.setLenguajePrincipal(EntradaDatos.leerString("Nuevo Lenguaje"));
        } else if (e instanceof Diseñador d) {
            d.setHerramientaDisenio(EntradaDatos.leerString("Nueva Herramienta"));
        }
        System.out.println("Datos actualizados.");
    }

}
