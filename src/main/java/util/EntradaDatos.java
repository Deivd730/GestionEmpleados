/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author David
 */
import java.util.Scanner;

import java.util.Scanner;

public class EntradaDatos {

    private static Scanner sc = new Scanner(System.in);

    /**
     * Lee un texto por consola y obliga a que no quede vacio.
     */
    public static String leerString(String mensaje) {
        String cadena;
        while (true) {
            System.out.print(mensaje + ": ");
            cadena = sc.nextLine().trim();
            if (cadena.isEmpty()) {
                System.out.println("Error: El texto no puede estar vacío.");
            } else {
                return cadena;
            }
        }
    }

    /**
     * Lee un numero decimal dentro del rango indicado.
     */
    public static double leerDouble(String mensaje, double minimo, double maximo) {
        if (minimo > maximo) {
            throw new IllegalArgumentException("Error: El minimo no puede ser mayor que el maximo.");
        }

        double numero;
        while (true) {
            System.out.print(mensaje + " (" + minimo + " - " + maximo + "): ");
            try {
                numero = Double.parseDouble(sc.nextLine());
                if (numero < minimo || numero > maximo) {
                    System.out.println("Error: El numero debe estar entre " + minimo + " y " + maximo + ".");
                } else {
                    return numero;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Introduzca un número decimal válido.");
            }
        }
    }

    /**
     * Lee un numero entero dentro del rango indicado.
     */
    public static int leerEntero(String mensaje, int minimo, int maximo) {
        if (minimo > maximo) {
            throw new IllegalArgumentException("Error: El minimo no puede ser mayor que el maximo.");
        }

        int numero;
        while (true) {
            System.out.print(mensaje + " (" + minimo + " - " + maximo + "): ");
            try {
                numero = Integer.parseInt(sc.nextLine());
                if (numero < minimo || numero > maximo) {
                    System.out.println("Error: El numero debe estar entre " + minimo + " y " + maximo + ".");
                } else {
                    return numero;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Introduzca un número entero válido.");
            }
        }
    }
}
