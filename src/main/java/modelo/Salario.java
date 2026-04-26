/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Representa el detalle salarial de un empleado.
 * @author David
 */
public class Salario {

    private double salarioBase;
    private double complementos;

    public Salario(double salarioBase, double complementos) {
        this.salarioBase = salarioBase;
        this.complementos = complementos;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getComplementos() {
        return complementos;
    }

    public void setComplementos(double complementos) {
        this.complementos = complementos;
    }

    /**
     * Calcula el salario total como base + complementos.
     *
     * @return salario total
     */
    public double calcularSalarioTotal() {
        return salarioBase + complementos;
    }

    @Override
    public String toString() {
        return "Salario{" + "salarioBase=" + salarioBase + ", complementos=" + complementos + '}';
    }

}
