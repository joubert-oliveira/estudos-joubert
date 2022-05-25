package exercicio4;

import java.util.Scanner;

public class Teste {
        public static void main(String[] args) {

            Scanner leitor = new Scanner(System.in);

            System.out.println("Digite a frase que deseja inverter: ");
            String frase = leitor.nextLine();

            PilhaObj<Character> pilhaObj = new PilhaObj<Character>(frase.length());

            for(int i =0 ; i < frase.length(); i++){

                pilhaObj.push(frase.charAt(i));

            }

            System.out.println("Exibindo a lista invertida");

            while(!pilhaObj.isEmpty()){

                System.out.print(pilhaObj.pop());

            }
    }
}
