package exercicio1;

public class Teste {

    public static Boolean ehPalindromo(int[] v){
        Pilha pilha = new Pilha(v.length);

        // percorre o vetor, empilhando todos os elementos do vetor
        for (int i = 0; i < v.length; i++) {
            pilha.push(v[i]);
        }

        // verificando se é palindromo com cada elemento, percorrendo o vetor
        for (int i = 0; i < v.length; i++) {
            if (v[i] != pilha.pop()) {
                return false;
            }
        }
        return true;
    }

    public static Boolean ehPalindromoOtimizado(int[] v) {
        Pilha p = new Pilha(v.length/2);
        int i;

        // percorre metade do vetor, empilhando seus elementos
        for (i = 0; i < v.length/2; i++) {
            p.push(v[i]);
        }

        // se o tamanho do vetor v for ímpar, pulo o "elemento do meio"
        if (v.length % 2 != 0) {
            i++;
        }

        // percorre a 2a metade do vetor, comparando seus elementos com o pop() da pilha
        for ( ; i < v.length; i++) {
            if (v[i] != p.pop()) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        int[] vetor1 = { 3, 4, 4, 1};
        int[] vetor2 = { 10, 20, 30, 40};
        int[] vetor3 = {1, 2, 3, 2, 1};
        int[] vetor4 = {100, 200, 300, 200, 100};

        System.out.println("vetor1 é palíndromo? " + ehPalindromo(vetor1));
        System.out.println("vetor2 é palíndromo? " + ehPalindromo(vetor2));
        System.out.println("vetor3 é palíndromo? " + ehPalindromo(vetor3));
        System.out.println("vetor4 é palíndromo? " + ehPalindromo(vetor4));

        System.out.println("\nUsando o ehPalindromo otimizado");
        System.out.println("vetor1 é palíndromo? " + ehPalindromoOtimizado(vetor1));
        System.out.println("vetor2 é palíndromo? " + ehPalindromoOtimizado(vetor2));
        System.out.println("vetor3 é palíndromo? " + ehPalindromoOtimizado(vetor3));
        System.out.println("vetor4 é palíndromo? " + ehPalindromoOtimizado(vetor4));

    }
}
