import java.io.*;

public class Padre {
    public static void main(String[] args) {
        File directorio = new File(".\\out\\production\\Sumar");
        ProcessBuilder pb = new ProcessBuilder("java","Hijo");
        pb.directory(directorio);

        try {
            Process p = pb.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            PrintWriter writer = new PrintWriter(new FileWriter("fichero.txt"));

            String line="";

            while ((line = br.readLine())!=null) {
                System.out.println(line);
                writer.println(line);
            }
            br.close();
            writer.close();

            int exitval = p.waitFor();

            System.out.println("valor de salida " + exitval);
        } catch (IOException  | InterruptedException e) {
            e.printStackTrace();
        }
        }
    }

