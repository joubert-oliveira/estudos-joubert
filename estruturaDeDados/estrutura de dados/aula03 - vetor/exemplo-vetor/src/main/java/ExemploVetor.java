import java.util.Scanner;

public class ExemploVetor {

    public static void exibeVetor(int[] v){
        for (int i=0; i < v.length; i++){
            System.out.print("v[" + i + "]= " + v[i] + "\t");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        // Criação de um objeto Leitor
        Scanner leitor = new Scanner(System.in);

        // Criação de um vetor, de inteiros, de tamanho 5
        int[] vetor = new int[5];

        // Criando um segundo vetor, com Lista de inicializadores
        // O vetor já "nasce" com os valores passados entre as chaves
        // Nesse caso, não é necessário usar o new
        int[] vet1 = {100, 200, 300, 400, 500, 600, 700};

        // Criando um terceiro vetor, de Strings, de tamanho 4
        String[] vet2 = new String[4];

        // Loop para preencher os valores do vetor
        for (int i=0; i < vetor.length; i++){
            vetor[i] = i * 10;
        }

        // Exibe o vetor
//        exibeVetor(vetor);

        // Exibe o vet1
//        exibeVetor(vet1);

        // Solicita que o usuário digite os valores para preencher o vetor
        for (int i = 0; i < vetor.length; i++){
            System.out.println("Digite o valor para vetor["+i+"]:");
            vetor[i] = leitor.nextInt();
        }

        // Exibe o vetor
//        exibeVetor(vetor);

        // Solicita que o usuário digite os valores para preencher o vet2
//        for (int i = 0; i < vet2.length; i++){
//            System.out.println("Digite o valor para vet2["+i+"]:");
//            vet2[i] = leitor.next();
//        }

        // Exibe o vetor
//        for (String nome : vet2){
//            System.out.print(nome + "\t");
//        }

        // 1° desafio
        // Criar um quarto vetor de Strings contendo os dias da semana;
        // "Domingo", "Segunda", "Terça", etc .....
        // Ficar num Loop até que o usuário digite um número entre 1 e 7
        // Exibir o dia da semana correspondente
        // Se o usuário digitar 1, exiba domingo, e assim por diante

//        String[] vet3 = {"Domingo", "Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sabado"};
//        Integer posicao;
//
//        do {
//            System.out.println("Digite um numero entre 1 a 7");
//            posicao = leitor.nextInt() - 1;
//        } while(posicao < 0 || posicao > 6);
//            System.out.println(vet3[posicao]);


        // 2° desafio: exibir a soma dos valores do vetor
        int soma = 0;
        for (int numero : vetor){
            soma += numero;
        }
        System.out.println("Soma dos valores do vetor: " + soma);

        // 3° desafio: exibir a quantidade de números pares do vetor
        int numerosPares = 0;
        int numerosImpares = 0;
        for (int i = 0; i < vetor.length; i ++){
            if (vetor[i] % 2 == 0){
                numerosPares ++;
            }
        }
        System.out.println("Quantidades de números pares no vetor: " + numerosPares);

        // Criando um 5° vetor de inteiros, sendo que o tamanho desse vetor será digitado pelo usuário
        int[] vet4;
        int tamanho;

        // Solicita que o usuário digite o tamanho do vetor vet4
        // Esse tamanho deve ser maior do que 3

        do {
            System.out.println("Digite um valor maior que 3");
            tamanho = leitor.nextInt();
        } while (tamanho <=3);

        // Criar o vetor vet4 com o tamanho digitado pelo usuário
        vet4 = new int[tamanho];

        // Solicita que o usuário digite os valores para preencher
        // o vetor vet4
        for (int i = 0; i < vet4.length; i++) {
            System.out.println("Digite o valor para vet4[" + i + "]:");
            vet4[i] = leitor.nextInt();
        }

        // Exibe o vetor
        exibeVetor(vet4);


    }
}

