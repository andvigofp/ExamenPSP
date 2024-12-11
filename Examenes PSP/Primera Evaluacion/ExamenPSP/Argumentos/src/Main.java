public class Main {
    public static void main(String[] args) {
        if (args.length==0) {
            System.out.println("No se ha recivido ningún valor: ");
            System.exit(1);
        }

        if (args.length>5) {
            System.out.println("Demasiado argumentos: ");
            System.exit(2);
        }

        int numero=0;
        try {
            numero=Integer.parseInt(args[0]);
        }catch (Exception e) {
            e.printStackTrace();
        }

        if (numero>5) {
            System.out.println("Demasiado Argumentos");
        }else {
            int media=0;
            media=args.length/numero;
            System.out.println(media);
            System.exit(0);
        }
        

        if (args.length>2) {
            System.out.println("Hay varios argumentos que son enteros");
            System.exit(4);
        }
    }

}