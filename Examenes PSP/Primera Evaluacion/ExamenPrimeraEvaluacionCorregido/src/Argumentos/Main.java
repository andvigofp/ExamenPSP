package Argumentos;

public class Main {
    public static void main(String[] args) {
        // Verifica si no se reciben argumentos
        if (args.length == 0) {
            System.out.println("No se ha recibido ningún valor.");
            System.exit(1);
        }

        // Verifica si se reciben más de 5 argumentos
        if (args.length > 5) {
            System.out.println("Demasiados argumentos.");
            System.exit(2);
        }

        int numero = 0;

        // Intenta convertir el primer argumento en un número entero
        try {
            numero = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("El primer argumento debe ser un número entero.");
            System.exit(3);
        }

        // Verifica si el número es mayor que 5
        if (numero > 5) {
            System.out.println("El número ingresado es mayor que 5.");
            System.exit(4);
        }

        // Calcula la "media" como la división de la longitud de los argumentos entre el número
        int media = 0;
        if (numero != 0) {
            media = args.length / numero;
            System.out.println("La media es: " + media);
        } else {
            System.out.println("No se puede dividir por cero.");
            System.exit(5);
        }

        // Verifica si hay más de 2 argumentos
        if (args.length > 2) {
            System.out.println("Hay más de dos argumentos.");
            System.exit(6);
        }

        // Si todo es correcto, termina con código de éxito
        System.exit(0);
    }
}

