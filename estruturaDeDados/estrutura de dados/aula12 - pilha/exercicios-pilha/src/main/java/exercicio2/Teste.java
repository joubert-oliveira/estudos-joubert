package exercicio2;

public class Teste {
    public static void converteDecimalParaBinario(int numero) {
        Pilha resto = new Pilha((int) (Math.log(numero)/Math.log(2)) + 1);
        int numeroOriginal = numero;
        while(numero != 0) {
            // empilha o resto de numero por 2
            resto.push(numero % 2);
            // faz o numero ser igual a numero / 2
            numero /= 2;
        }

        System.out.print(numeroOriginal + " em binário é " );
        while (!resto.isEmpty()) {
            System.out.print(resto.pop());
        }
        System.out.println();
    }
    public static void main(String[] args) {

        converteDecimalParaBinario(34);
        converteDecimalParaBinario(32);
        converteDecimalParaBinario(1024);
        converteDecimalParaBinario(2);
    }
}
