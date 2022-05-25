package exercicio3_lista_filmes_arquivo_csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TesteFilme {

    // Gravar arquivo
    public static void gravaArquivoCsv(ListaObj<Filme> lista, String nomeArquivo){

        FileWriter arq = null; // arq é um objeto que corresponde ao arquivo
        Formatter saida = null; // saida é um objeto que será usado para escrever no arquivo

        nomeArquivo += ".csv";
        Boolean deuRuim = false;

        // Bloco try catch para abrir o arquivo
        try {
            arq = new FileWriter(nomeArquivo);
            saida = new Formatter(arq);
        }
        catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo" + erro.fillInStackTrace());
            System.exit(1);
        }

        // Bloco try catch para gravar no arquivo
        try {
            // Percorro a lista de cachorros
            for (int i = 0; i < lista.getTamanho(); i ++){
                Filme filmes = lista.getElemento(i);
                saida.format("%d;%s;%.2f;%s;%d\n", filmes.getIdFilme(), filmes.getNome(), filmes.getNota(), filmes.getGenero(), filmes.getIdade());
            }
        }
        catch (FormatterClosedException erro){
            System.out.println("Erro ao gravar o arquivo");
            deuRuim = true;
        }
        finally {
            saida.close();

            try {
                arq.close();
            }
            catch (IOException erro){
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim){
                System.exit(1);
            }
        }
    }

    // Ler o arquivo
    public static void leExibeArquivoCsv(String nomeArquivo){
        FileReader arq = null;
        Scanner entrada = null;

        nomeArquivo += ".csv";
        Boolean deuRuim = false;

        // Bloco try catch para abrir o arquivo
        try {
            arq = new FileReader(nomeArquivo);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        }
        catch (FileNotFoundException erro){
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }

        // Bloco try catch para ler o arquivo
        try {
            System.out.printf("%4s %-14s %5s %-10s %4s\n", "ID", "NOME", "NOTA", "GENERO", "IDADE");
            while (entrada.hasNext()){
                Integer idFilme = entrada.nextInt();
                String nome = entrada.next();
                Double nota = entrada.nextDouble();
                String genero = entrada.next();
                Integer idade = entrada.nextInt();
                System.out.printf("%4d %-14s %5.2f %-10s %4d\n", idFilme, nome, nota, genero, idade);
            }
        }
        catch (NoSuchElementException erro){
            System.out.println("Arquivo com problemas");
            deuRuim = true;
        }
        catch (IllegalStateException erro){
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        }
        finally {
            entrada.close();

            try {
                arq.close();
            }
            catch (IOException erro){
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim){
                System.exit(1);
            }
        }
    }
    public static void main(String[] args) {
        ListaObj<Filme> lista = new ListaObj<>(5);

        Integer idFilme;
        String nome;
        Double nota;
        String genero;
        Integer idade;

        Boolean sair = false;
        Integer opcao = 0;

        String arquivo;

        Scanner leitor = new Scanner(System.in); // nextInt(), nextDouble()
        Scanner leitorNL = new Scanner(System.in); // nextLine()

        while (!sair){
            System.out.println("MENU");
            System.out.println("1 - Adicionar um filme");
            System.out.println("2 - Exibir a lista");
            System.out.println("3 - Gravar a lista em arquivo CSV");
            System.out.println("4 - Ler e exibir um arquivo CSV");
            System.out.println("5 - Gravar em outro arquivo CSV apenas filmes que estão na lista, mas de um determinado gênero");
            System.out.println("6 - Sair");
            opcao = leitor.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Digite o id do filme:");
                    idFilme = leitor.nextInt();
                    System.out.println("Digite o nome do filme:");
                    nome = leitorNL.nextLine();
                    System.out.println("Digite a nota do filme:");
                    nota = leitor.nextDouble();
                    System.out.println("Digite o gênero do filme:");
                    genero = leitorNL.nextLine();
                    System.out.println("Digite a idade do filme:");
                    idade = leitor.nextInt();
                    Filme filme1 = new Filme(idFilme, nome, nota, genero, idade);
                    lista.adiciona(filme1);
                    break;
                case 2:
                    System.out.printf("%4s %-14s %5s %-10s %4s\n", "ID", "NOME", "NOTA", "GENERO", "IDADE");
                    for (int i = 0; i < lista.getTamanho(); i++) {
                        if (lista.getTamanho() == 0){
                            System.out.println("Lista está vazia");
                        }
                    }
                    lista.exibe();
                    break;
                case 3:
                    for (int i = 0; i < lista.getTamanho(); i++) {
                        if (lista == null){
                            System.out.println("Lista está vazia. Não há nada a gravar");
                        } else{
                            gravaArquivoCsv(lista, "filmes");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Digite o nome do arquivo CSV a ser lido:");
                    arquivo = leitorNL.nextLine();
                    leExibeArquivoCsv(arquivo);
                    break;
                case 5:
                        if (lista.getTamanho() == 0){
                            System.out.println("Lista está vazia. Não há nada a gravar");
                        } else{
                            System.out.println("Digite o nome do arquivo a ser gravado:");
                            arquivo = leitorNL.nextLine();
                            System.out.println("Digite o gênero desejado");
                            genero = leitorNL.nextLine();
                            ListaObj<Filme> listaGenero = new ListaObj<>(lista.getTamanho());
                            for (int j = 0; j < lista.getTamanho(); j++) {
                                if (lista.getElemento(j).getGenero().equals(genero)){
                                   listaGenero.adiciona(lista.getElemento(j));
                                }
                            }
                            if (listaGenero.getTamanho() == 0){
                                System.out.println("Não há filmes deste gênero na lista");
                            } else {
                                gravaArquivoCsv(listaGenero, arquivo);
                            }
                        }
                    break;
                case 6:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
