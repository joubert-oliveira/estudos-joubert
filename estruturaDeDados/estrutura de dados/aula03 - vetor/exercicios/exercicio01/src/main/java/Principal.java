import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        int[] vetor = new int[7];

        // -------------------------------------
        for(int i=0; i<vetor.length; i++){

            System.out.println("Digite o valor para vetor["+i+"]");
            vetor[i] = leitor.nextInt();

        }

        // -------------------------------------
        System.out.println("-".repeat(20));
        System.out.println("\nExibindo na ordem normal");
        for(int i=0; i<vetor.length; i++){

            System.out.println("Vetor["+i+"]=" + vetor[i]);

        }

        // -------------------------------------
        System.out.println("-".repeat(20));
        System.out.println("\nExibindo na ordem inversa");
        for(int i = vetor.length-1; i >= 0; i--){

            System.out.println("Vetor["+i+"]=" + vetor[i]);

        }
    }
}
