import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        String[] nomes = new String[10];
        Scanner leitor = new Scanner(System.in);

        // -------------------------------------
        for(int i = 0; i < nomes.length; i++){

            System.out.println("Digite o "+i+1+"° nome: ");
            nomes[i] = leitor.next();

        }

        // -------------------------------------
        System.out.println("-".repeat(20));
        System.out.println("\nAgora digite um nome que deseja procurar: ");
        String nomeDigitado = leitor.next();

        String msg = "Nome não encontrado";

        for(int i = 0; i < nomes.length; i++){

            if(nomes[i].equalsIgnoreCase(nomeDigitado)){

                msg = "Nome encontrado no indice "+ i +" Do vetor";
                break;

            }
        }

        System.out.println(msg);

    }
}
