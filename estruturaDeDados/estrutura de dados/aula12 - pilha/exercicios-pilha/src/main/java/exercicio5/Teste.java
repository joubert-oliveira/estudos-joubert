package exercicio5;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        TestePalindromo t = new TestePalindromo();

        System.out.println("Digite uma frase para verificar se é palindroma ou não: ");
        String fraseDigitada = leitor.nextLine();

        if((t.ehPalindromo(fraseDigitada))){

            System.out.println("'"+fraseDigitada+"' é palindroma");

        }else{

            System.out.println("'"+fraseDigitada+"' não é palindroma");


        }

    }
}
