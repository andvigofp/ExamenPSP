import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hijo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numero1,  suma=0;



        do {

            System.out.println("Dime el primer número 1:");
            numero1 = Integer.parseInt(br.readLine());

            if (numero1 ==0) {
                System.out.println("Ha salido correctamnete ");
                break;
            }


                suma +=numero1;


            System.out.println("La suma de los números es: " + suma);

        }while (numero1 !=0);


    }
}
