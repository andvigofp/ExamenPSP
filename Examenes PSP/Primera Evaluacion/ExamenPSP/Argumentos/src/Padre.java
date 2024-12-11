import java.io.*;

public class Padre {
    public static void main(String[] args) throws IOException, InterruptedException {
        File directorio = new File(".\\out\\production\\Argumentos");
        ProcessBuilder pb = new ProcessBuilder("java", "Main","-2");
        pb.directory(directorio);

        Process p = pb.start();
        InputStreamReader er = new InputStreamReader(p.getErrorStream());
        BufferedReader br = new BufferedReader(er);


        String line =null;
        while ((line = br.readLine())!=null) {
            System.out.println(line);
        }

        int exitval = p.waitFor();
        System.out.println("valor de salida " + exitval);

        switch (exitval) {
            case (1):
                System.out.println("TODO CORRECTO...");
                break;
            case (5):
                System.out.println("Demasiados Argumentos...");
                break;
            case (0):
                System.out.println("El Argumento no es entero...");
                break;
            case(4):
                System.out.println("Hay Varios argumentos no son enteros...");
                break;
        }

        br.close();
        System.out.println("Valor de Salida " + exitval);
    }
}
