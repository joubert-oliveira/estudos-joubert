import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Teste {

    // Gravar arquivo
    public static void gravaArquivoCsv(ListaObj<Imovel> lista, String nomeArquivo){

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
                Imovel imoveis = lista.getElemento(i);
                saida.format("%d;%s;%d;%s;%d;%.2f\n", imoveis.getCib(), imoveis.getNome(), imoveis.getIdade(), imoveis.getLocal(), imoveis.getM2(), imoveis.getValorM2());
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
            System.out.printf("%4s %-20s %5s %-14s %4s %11s\n", "CIB", "NOME", "IDADE", "LOCAL", "M2", "VALOR-M2");
            while (entrada.hasNext()){
                Integer cib = entrada.nextInt();
                String nome = entrada.next();
                Integer idade = entrada.nextInt();
                String local = entrada.next();
                Integer m2 = entrada.nextInt();
                Double valorM2 = entrada.nextDouble();
                System.out.printf("%4d %-20s %5d %-14s %4d %11.2f\n", cib, nome, idade, local, m2, valorM2);

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
        ListaObj<Imovel> listaImovel =new ListaObj<>(5);

        Integer cib;
        String nome;
        Integer idade;
        String local;
        Integer m2;
        Double valorM2;

        Scanner leitor = new Scanner(System.in); // nextInt(), nextDouble()
        Scanner leitorNL = new Scanner(System.in); // nextLine()

        boolean fim = false;
        Integer opcao = 0; //opções do menu
        Integer indice; // case 4
        String arquivo; // nome do arquivo case 5 e 6

        while (!fim){
            System.out.println("MENU");
            System.out.println("1 - Adicionar um imóvel");
            System.out.println("2 - Exibir a lista");
            System.out.println("3 - Alterar o valor do imóvel");
            System.out.println("4 - Adicionar um imóvel em um determinado índice");
            System.out.println("5 - Gravar a lista em arquivo CSV");
            System.out.println("6 - Ler e exibir um arquivo CSV");
            System.out.println("7 - Fim");
            opcao = leitor.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Digite o código do imóvel:");
                    cib = leitor.nextInt();
                    System.out.println("Digite o nome do imóvel:");
                    nome = leitorNL.nextLine();
                    System.out.println("Digite a idade do imóvel:");
                    idade = leitor.nextInt();
                    System.out.println("Digite o local do imóvel:");
                    local = leitorNL.nextLine();
                    System.out.println("Digite o m2 do imóvel:");
                    m2 = leitor.nextInt();
                    System.out.println("Digite o valor do m2 do imóvel:");
                    valorM2 = leitor.nextDouble();
                    Imovel imovel = new Imovel(cib, nome, idade, local, m2, valorM2);
                    listaImovel.adiciona(imovel);
                    break;
                case 2:
                    System.out.printf("%4s %-20s %5s %-14s %4s %11s\n", "CIB", "NOME", "IDADE", "LOCAL", "M2", "VALOR DO M2");
                    listaImovel.exibe();
                    break;
                case 3:
                    System.out.println("Digite o código do imóvel:");
                    cib = leitor.nextInt();
                    System.out.println("Digite o novo valor do m2 do imóvel:");
                    valorM2 = leitor.nextDouble();

                    Boolean validar = false;
                    System.out.printf("%4s %-20s %5s %-14s %4s %11s\n", "CIB", "NOME", "IDADE", "LOCAL", "M2", "VALOR DO M2");
                    for (int i = 0; i < listaImovel.getTamanho(); i++) {
                        if (listaImovel.getElemento(i).getCib().equals(cib)){
                            listaImovel.getElemento(i).setValorM2(valorM2);
                            listaImovel.exibe();
                            validar = true;
                        }
                    }
                    if (!validar){
                        System.out.println("Código do imóvel não encontrado!");
                    }
                    break;
                case 4:
                    System.out.println("Digite o índice desejado:");
                    indice = leitor.nextInt();
                    listaImovel.adicionaPeloIndice(indice, new Imovel(111, "Prédio", 1, "São Paulo", 90, 50.00));
                    System.out.printf("%4s %-20s %5s %-14s %4s %11s\n", "CIB", "NOME", "IDADE", "LOCAL", "M2", "VALOR DO M2");
                    listaImovel.exibe();
                    break;
                case 5:
                    System.out.println("Digite o nome do arquivo csv a ser gravado:");
                    arquivo = leitorNL.nextLine();
                    gravaArquivoCsv(listaImovel, arquivo);
                    break;
                case 6:
                    System.out.println("Digite o nome do arquivo csv a ser lido:");
                    arquivo = leitorNL.nextLine();
                    leExibeArquivoCsv(arquivo);
                    break;
                case 7:
                    fim = true;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}
