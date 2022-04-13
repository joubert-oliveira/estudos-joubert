import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListObj<Filme> lista = new ListObj(5);
        GerenciadorArquivos gerenciadorArquivos = new GerenciadorArquivos();

        Boolean condicao = true;
        Scanner leitorNum = new Scanner(System.in);
        Scanner leitorString = new Scanner(System.in);
        int escolha = -1;

        do {
            System.out.println("Escolha uma opção \n" +
                    "1 - Adicionar um filme \n" +
                    "2 - Exibir a lista \n" +
                    "3 - Gerar um arquivo (CSV) \n" +
                    "4 - Ler o arquivo (CSV) \n" +
                    "5 - Gravar apenas um genero (CSV) \n" +
                    "6 - Sair \n");
            escolha = leitorNum.nextInt();
            switch (escolha){
                case 1:
                    System.out.println("Digite o id do filme");
                    int id = leitorNum.nextInt();
                    System.out.println("Digite o nome do filme");
                    String nome = leitorString.next();
                    System.out.println("Digite a nota do filme?");
                    Double nota = leitorNum.nextDouble();
                    System.out.println("Digite o genero do filme?");
                    String genero = leitorString.next();
                    System.out.println("Digite a idade do filme?");
                    Integer idade = leitorString.nextInt();
                    lista.adicionar(new Filme(id,nome, nota, genero, idade));
                    break;
                case 2:
                    System.out.println("Exibindo a lista");
                    System.out.printf("%10s %-30s %5s %-15s %5s\n",
                            "ID", "NOME",  "NOTA", "GENERO", "IDADE");
                    lista.exibir();
                    break;
                case 3:
                    if (lista.getTamanho() == 0){
                        System.out.println("Não ha nada na lista para ser gravado");
                    }else {
                        System.out.println("Digite o nome do arquivo");
                        String nomeArq = leitorString.next();
                        System.out.println("Gravando em um CSV");
                        gerenciadorArquivos.gravaArquivoCsv(lista, nomeArq);
                    }
                    break;
                case 4:
                    System.out.println("Lendo arquivo");
                    System.out.println("Digite o nome do arquivo para ser lido");
                    String nomeArqLeitura = leitorString.next();
                    gerenciadorArquivos.exibeArquivoCsv(nomeArqLeitura);
                    break;
                case 5:
                    if (lista.getTamanho() == 0){
                        System.out.println("Não ha nada na lista para ser gravado");
                    }else {
                        System.out.println("Digite o genero");
                        String generoFiltro = leitorString.next();
                        int countGenero = lista.filmesPorGenero(generoFiltro);

                        if (countGenero == 0) {
                            System.out.println("Não foi encontrado nem um filme com esse genero");
                        }else {
                            System.out.println("Digite o nome do arquivo");
                            String nomeArqComGen = leitorString.next();
                            System.out.println("Gravando no arquivo os " + countGenero + " filmes do genero " + generoFiltro);
                            gerenciadorArquivos.gravaArquivoCsvPorGenero(lista, nomeArqComGen, generoFiltro);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Finalizando!");
                    condicao = false;
                    break;
                default:
                    System.out.println("Digite um valor correto");
                    break;
            }
        } while (condicao);
    }

}
