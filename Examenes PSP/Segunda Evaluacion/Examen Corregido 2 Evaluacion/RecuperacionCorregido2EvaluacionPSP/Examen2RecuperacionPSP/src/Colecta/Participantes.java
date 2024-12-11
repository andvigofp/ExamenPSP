package Colecta;

import java.util.Random;

public class Participantes extends Thread{
    private Colecta colecta;
    private Random random;

    public Participantes(Colecta colecta) {
        this.colecta = colecta;
        this.random = new Random();
    }

    public void run() {
        while (true) {
            int tiempo = random.nextInt(6); // Entre 0 y 5 segundos
            int cantidad = random.nextInt(20) + 1; // Entre 1€ y 20€
            try {
                Thread.sleep(tiempo * 1000); // Convertir segundos a milisegundos
                synchronized (colecta) {
                    if (colecta.obtenerFondos() >= 2000) {
                        System.out.println("La colecta ha alcanzado la meta de 2000€. ¡Éxito!");
                        break; // Salir del bucle si ya se alcanzó la meta
                    }
                    colecta.agregarFondos(cantidad);
                    System.out.println("El participante aportó " + cantidad + "€.");
                    System.out.println("Fondos totales de la colecta: " + colecta.obtenerFondos() + "€.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}