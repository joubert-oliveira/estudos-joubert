import java.util.Arrays;

public class Principal {

    public static void main(String[] args) {

        Ordenacao ma = new Ordenacao();

        int vetor[] = {7, 4 ,9, 3, 2, 6, 8, 1, 5, 10};
        int vetor2[] = {7, 4 ,9, 3, 2, 6, 8, 1, 5, 10};

        System.out.println("\n"+"-".repeat(20));
        System.out.println("Ordenação usando o Selection Sort\n\n"+
                "Vetor antes de ser ordenado: "+
                Arrays.toString(vetor));

        ma.selectionSort(vetor);

        System.out.println("\nVetor depois de usar o método selectionSort: "+
                Arrays.toString(vetor)+
                "\n\nNúmero de comparações feitas: "+ma.getComparacoes() +
                "\nNúmero de trocas feitas: "+ma.trocaSelection);


        System.out.println("\n"+"-".repeat(20));
        System.out.println("Ordenação usando o Bubble Sort\n\n"+
                "Vetor antes de ser ordenado: "+
                Arrays.toString(vetor2)+
                "\nVetor depois de usar o método bubbleSort: "+
                Arrays.toString(ma.bubbleSort(vetor2))+
                "\n\nNúmero de trocas feitas: "+ma.getTrocas());
    }
}
