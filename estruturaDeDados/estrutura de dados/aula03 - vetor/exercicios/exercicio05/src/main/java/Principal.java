import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        String carros[] = new String[5];
        int rendimento[] = new int[5];
        int rendimentoMaior = 0;
        Scanner leitor = new Scanner(System.in);

        for(int i = 0; i< carros.length ; i++){

            System.out.println("Digite o nome do modelo do "+ (i+1) +"° Carro");
            carros[i] = leitor.next();

            System.out.println("Digite o rendimento do " + carros[i]);
            rendimento[i] = leitor.nextInt();
        }

        System.out.println("\n"+"-".repeat(20));

        for(int i = 0; i< carros.length; i++){

            System.out.println("O carro "+ carros[i] + " tem o rendimento igual à "+ rendimento[i]);

            if(rendimento[i] > rendimento[rendimentoMaior]){

                rendimentoMaior = i;

            }
        }

        System.out.println("-".repeat(20));

        System.out.println("O carro mais performático é "+ carros[rendimentoMaior]
                + " com o rendimento de "+ rendimento[rendimentoMaior]);
    }
}
