/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Especializacion de empleado que guarda su herramienta de disenio principal.
 * @author David
 */
public class Diseñador extends Empleado {

    private String herramientaDisenio;

    public Diseñador(String herramientaDisenio, String dni, String nombre, Salario salariobase) {
        super(dni, nombre, salariobase);
        this.herramientaDisenio = herramientaDisenio;
    }

    public String getHerramientaDisenio() {
        return herramientaDisenio;
    }

    public void setHerramientaDisenio(String herramientaDisenio) {
        this.herramientaDisenio = herramientaDisenio;
    }

    @Override
    public String toString() {
        return super.toString() + "Dise\u00f1ador{" + "herramientaDisenio=" + herramientaDisenio + '}';
    }

}
