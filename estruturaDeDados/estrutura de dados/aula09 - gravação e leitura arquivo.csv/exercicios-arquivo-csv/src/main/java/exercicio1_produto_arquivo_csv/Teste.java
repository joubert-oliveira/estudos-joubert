package exercicio1_produto_arquivo_csv;

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
    public static void gravaArquivoCsv(ListaObj<Produto> lista, String nomeArquivo){

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
            // Percorro a lista de Produtos
            for (int i = 0; i < lista.getTamanho(); i ++){
                Produto xxx = lista.getElemento(i);
                saida.format("%d;%s;%.2f;%s;%.2f\n", xxx.getCodProduto(), xxx.getNome(), xxx.getPreco(), xxx.getAvaliacao(), xxx.calcularFaturamento());
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
            System.out.printf("%6s %-14s %7s %7s %14s\n", "CODIGO", "NOME", "PREÇO", "NOTA", "FATURAMENTO");
            while (entrada.hasNext()){
                Integer codProduto = entrada.nextInt();
                String nome = entrada.next();
                Double preco = entrada.nextDouble();
                String avaliacao = entrada.next();
                Double faturamento = entrada.nextDouble();
                System.out.printf("%6d %-14s %7.2f %7s %14.2f\n", codProduto, nome, preco, avaliacao, faturamento);
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
        ListaObj<Produto> listaProdutos = new ListaObj<>(5);

        Produto produto1 = new Produto(123, "Celular", 1200.00, "*****");
        Produto produto2 = new Produto(9999, "Notebook", 2000.00, "****");
        Produto produto3 = new Produto(63727, "Impressora", 500.00, "**");
        Produto produto4 = new Produto(3, "Caixa de som", 3000.00, "***");
        Produto produto5 = new Produto(33, "Fone de Ouvido", 200.00, "*");

        produto1.comprar(1);
        produto2.comprar(1);
        produto3.comprar(1);
        produto4.comprar(2);
        produto5.comprar(5);

        listaProdutos.adiciona(produto1);
        listaProdutos.adiciona(produto2);
        listaProdutos.adiciona(produto3);
        listaProdutos.adiciona(produto4);
        listaProdutos.adiciona(produto5);

        System.out.printf("%6s %-14s %7s %7s %14s\n", "CODIGO", "NOME", "PREÇO", "NOTA", "FATURAMENTO");
        listaProdutos.exibe();

        gravaArquivoCsv(listaProdutos, "produtos");
        leExibeArquivoCsv("produtos");
    }
}
