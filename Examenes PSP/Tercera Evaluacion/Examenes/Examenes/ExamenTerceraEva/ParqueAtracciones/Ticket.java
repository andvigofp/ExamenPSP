package org.andres_example.Examenes.ExamenTerceraEva.ParqueAtracciones;

import java.io.Serializable;

public class Ticket implements Serializable {
    private String nombre;
    private int numeroEntradas;
    private int tipoEntrada;

    public Ticket() {
        super();
    }

    public Ticket(String nombre, int numeroEntradas, int tipoEntrada) {
        super();
        this.nombre = nombre;
        this.numeroEntradas = numeroEntradas;
        this.tipoEntrada = tipoEntrada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroEntradas() {
        return numeroEntradas;
    }

    public void setNumeroEntradas(int numeroEntradas) {
        this.numeroEntradas = numeroEntradas;
    }

    public int getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(int tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "nombre='" + nombre + '\'' +
                ", numeroEntradas=" + numeroEntradas +
                ", tipoEntrada=" + tipoEntrada +
                '}';
    }
}
