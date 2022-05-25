package exercicio2_lista_aluno_arquivo_csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TesteListaAluno {

    // Gravar arquivo
    public static void gravaArquivoCsv(ListaObj<Aluno> lista, String nomeArquivo){

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
            // Percorro a lista de Alunos
            for (int i = 0; i < lista.getTamanho(); i ++){
                Aluno alunos = lista.getElemento(i);
                saida.format("%d;%s;%.2f\n", alunos.getRa(), alunos.getNome(), alunos.getNota());
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
            System.out.printf("%-10s %-30s %5s\n", "RA", "NOME", "NOTA");
            while (entrada.hasNext()){
                Integer ra = entrada.nextInt();
                String nome = entrada.next();
                Double nota = entrada.nextDouble();
                System.out.printf("%010d %-30s %05.2f\n", ra, nome, nota);
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

        Integer opcao = 0;

        Integer indice;

        Integer ra;
        String nome;
        Double nota;

        Boolean fim = false;

        Scanner leitor = new Scanner(System.in); // nextInt(), nextDouble()
        Scanner leitorNL = new Scanner(System.in); // nextLine()

        ListaObj<Aluno> lista = new ListaObj<>(10);

        while (!fim){
            System.out.println("MENU");
            System.out.println("1 - Adicionar um aluno");
            System.out.println("2 - Exibir a lista");
            System.out.println("3 - Exibir um aluno da lista");
            System.out.println("4 - Limpar a lista");
            System.out.println("5 - Buscar um aluno pelo RA");
            System.out.println("6 - Gravar a lista num arquivo csv");
            System.out.println("7 - Ler e exibir o arquivo csv");
            System.out.println("8 - Fim");
            opcao = leitor.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Digite o RA:");
                    ra = leitor.nextInt();
                    System.out.println("Digite o nome:");
                    nome = leitorNL.nextLine();
                    System.out.println("Digite a nota:");
                    nota = leitor.nextDouble();
                    Aluno aluno1 = new Aluno(ra, nome, nota);
                    lista.adiciona(aluno1);
                    break;
                case 2:
                    System.out.printf("%-10s %-30s %5s", "RA", "NOME", "NOTA\n");
                    lista.exibe();
                    break;
                case 3:
                    System.out.println("Digite o índice que deseja:");
                    indice = leitor.nextInt();
                    System.out.printf("%-10s %-30s %5s", "RA", "NOME", "NOTA\n");
                    lista.getElemento(indice);
                    System.out.println(lista.getElemento(indice));
                    break;
                case 4:
                    lista.limpa();
                    break;
                case 5:
                    System.out.println("Pesquise um RA:");
                    ra = leitor.nextInt();
                    Boolean validar = false;
                    System.out.printf("%-10s %-30s %5s", "RA", "NOME", "NOTA\n");
                    for (int i = 0; i < lista.getTamanho(); i++){
                        if (lista.getElemento(i).getRa().equals(ra)){
                            System.out.println(lista.getElemento(i));
                            validar = true;
                        }
                    }
                    if (!validar){
                        System.out.println("Aluno não encontrado!");
                    }
                    break;
                case 6:
                    for (int i = 0; i < lista.getTamanho(); i++) {
                        if (lista == null){
                            System.out.println("Lista está vazia. Não há nada a gravar");
                        } else {
                            gravaArquivoCsv(lista, "alunos");
                        }
                    }
                    break;
                case 7:
                    leExibeArquivoCsv("alunos");
                    break;
                case 8:
                    fim = true;
                    break;
                default:
                    System.out.println("Opção Inválida");
            }

            }

        }
    }

