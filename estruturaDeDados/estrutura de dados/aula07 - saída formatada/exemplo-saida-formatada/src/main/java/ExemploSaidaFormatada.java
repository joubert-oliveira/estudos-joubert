public class ExemploSaidaFormatada {
    public static void main(String[] args) {

        String nome1 = "João";
        String nome2 = "Maria Aparecida";
        int ra1 = 50000;
        int ra2 = 50001;
        double nota1 = 8.0;
        double nota2 = 7.5;


        System.out.printf("---------------------------------------\n");
        System.out.printf("%-7s %-7s %5s\n", "RA", "NOME", "NOTA");
        System.out.printf("%-7d %.7s %05.2f\n", ra1, nome1, nota1);
        System.out.printf("%-7d %.7s %5.2f\n", ra2, nome2, nota2);

    }
}
