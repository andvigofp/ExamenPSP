package org.andres_example.Examenes.ExamenJunio.Factorial;


import java.io.Serializable;

public class Factorial implements Serializable {
    private double numero;
    private double resultado;


    public Factorial(int numero) {
        super();
    }



    public Factorial(double numero) {
        super();
        this.numero = numero;
    }

    public double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Factorial{" +
                "numero=" + numero +
                "resultado" + resultado +
                '}';
    }
}

