package org.andres_example.Examenes.ExamenJunio.Calculadora;

import java.io.Serializable;

public class Calculadora implements Serializable {
    private int operando1;
    private int operando2;
    private String operacion;
    private double resultado;

    public Calculadora() {
        super();
    }

    public Calculadora(int operando1, int operando2, String operacion) {
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operacion = operacion;
    }

    public int getOperando1() {
        return operando1;
    }

    public void setOperando1(int operando1) {
        this.operando1 = operando1;
    }

    public int getOperando2() {
        return operando2;
    }

    public void setOperando2(int operando2) {
        this.operando2 = operando2;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public void suma() {
        resultado = operando1 + operando2;
    }

    public void resta() {
        resultado = operando1 - operando2;
    }

    public void multiplciacion() {
        resultado= operando1 * operando2;
    }

    public boolean division() {
        if (operando1 !=0) {
            resultado = operando1 / operando2;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Calculadora{" +
                "operando1=" + operando1 +
                ", operando2=" + operando2 +
                ", operacion='" + operacion + '\'' +
                ", resultado=" + resultado +
                '}';
    }
}
