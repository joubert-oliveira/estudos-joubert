import java.util.Arrays;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        int[] vetor = new int[10];
        Scanner leitor = new Scanner(System.in);

        // -------------------------------------
        for(int i=0; i<vetor.length; i++){

            System.out.println("Digite o valor para vetor["+i+"]");
            vetor[i] = leitor.nextInt();

        }

        // -------------------------------------
        System.out.println("-".repeat(20));
        System.out.println("\nDigite um número qualquer: ");
        int numeroDigitado = leitor.nextInt();

        // -------------------------------------
        System.out.println("-".repeat(20));
        System.out.println("\nO número "+ numeroDigitado + " ocorre "+
                    Arrays.stream(vetor).filter(value -> value == numeroDigitado).count() + " vez(es)");

    }
}
