import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        int[] vetor = new int[10];
        Scanner leitor = new Scanner(System.in);

        for(int i=0; i<vetor.length; i++){

            System.out.println("Digite o valor para vetor["+i+"]");
            vetor[i] = leitor.nextInt();

        }


        Integer media = Arrays.stream(vetor).sum()/ vetor.length;
        // -------------------------------------
        System.out.println("-".repeat(20));
        System.out.println("\nA média do vetor é: " + media);

        // -------------------------------------
        System.out.println("-".repeat(20));
        System.out.println("\nA média do vetor é(Usando Stream): " + Arrays.stream(vetor).average().getAsDouble());

        // -------------------------------------
        System.out.println("-".repeat(20));
        System.out.println("\nExibindo valores que estão acima da média: ");

        int[] vetorAuxiliar = Arrays.stream(vetor).filter(value -> value > media).toArray();

        for(int vetor2: vetorAuxiliar){

            System.out.println(vetor2);

        }

    }
}
