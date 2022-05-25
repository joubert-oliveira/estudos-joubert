import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        int vetor[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // --------------------------------------------
        System.out.println("Digite o dia que deseja: ");
        int dia = leitor.nextInt();

        // --------------------------------------------
        System.out.println("Digite o número do mês que deseja: ");
        int mes = leitor.nextInt();


        // Usando a classe LocalDate
        // --------------------------------------------
//        LocalDate comeco = LocalDate.of(2022, 1, 1);
//        LocalDate fim = LocalDate.of(2022, mes, dia);
//        long days = ChronoUnit.DAYS.between(comeco, fim);

//        System.out.println("\nO dia " + dia + "/" + mes + " corresponde ao dia " +(days+1) + " do ano ");
        // --------------------------------------------

        // Usando o vetor
        // --------------------------------------------
        while(dia > vetor[mes-1]){

            System.out.println("O dia que você digitou não consta no mês, digite novamente: ");
            dia = leitor.nextInt();

        }

        int soma = dia;

        for(int i = 0; i<(mes-1) ;i++){

            soma+=vetor[i];

        }

        System.out.println("\nO dia " + dia + "/" + mes + " corresponde ao dia " +(soma) + " do ano ");

    }
}
