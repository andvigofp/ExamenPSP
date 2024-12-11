package Colecta;

public class Principal {
    public static void main(String[] args) {
        Colecta colecta = new Colecta();
        Participantes[] participantes = new Participantes[5];

        for (int i = 0; i < participantes.length; i++) {
            participantes[i] = new Participantes(colecta);
            participantes[i].start();
        }

        try {
            for (Participantes participante : participantes) {
                participante.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("La colecta ha finalizado.");
    }
}
