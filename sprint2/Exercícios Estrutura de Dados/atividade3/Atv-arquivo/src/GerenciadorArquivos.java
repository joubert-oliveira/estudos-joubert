import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GerenciadorArquivos<T> {

    public void gravaArquivoCsv(ListObj<Filme> lista, String nomeArq) {
        FileWriter arq = null;
        Formatter saida = null;
        nomeArq += ".csv";
        Boolean deuRuim = false;

        try {
            arq = new FileWriter(nomeArq);
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.out.println("\nErro ao abrir o arquivo");
            System.exit(1);
        }

        try {
            for (int i=0; i < lista.getTamanho(); i++) {
                Filme filme = lista.getObj(i);
                saida.format("%d;%s;%.2f;%s;%d\n", filme.getIdFilme(), filme.getNome(),
                        filme.getNota(), filme.getGenero(), filme.getInteiro());
            }
        }
        catch (FormatterClosedException erro) {
            System.out.println("\nErro ao gravar no arquivo");
            deuRuim = true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("\nErro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public void exibeArquivoCsv (String nomeArq) {
        FileReader arq = null;
        Scanner entrada = null;
        nomeArq += ".csv";
        Boolean deuRuim = false;

        try {
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        }
        catch (FileNotFoundException erro) {
            System.out.println("\nArquivo não encontrado");
            System.exit(1);
        }

        try {
            System.out.printf("%10s %-30s %5s %-15s %5s\n",
                    "ID", "NOME",  "NOTA", "GENERO", "IDADE");
            while (entrada.hasNext()) {
                Integer id = entrada.nextInt();
                String nome = entrada.next();
                Double nota = entrada.nextDouble();
                String genero = entrada.next();
                Integer idade = entrada.nextInt();
                System.out.printf("%010d %-30s %5.2f %-15s %5d\n", id, nome, nota, genero, idade);
            }
        }
        catch (NoSuchElementException erro) {
            System.out.println("\nArquivo com problemas");
            deuRuim = true;
        }
        catch (IllegalStateException erro) {
            System.out.println("\nErro na leitura do arquivo");
            deuRuim = true;
        }
        finally {
            entrada.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("\nErro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public void gravaArquivoCsvPorGenero(ListObj<Filme> lista, String nomeArq, String genero) {
        FileWriter arq = null;
        Formatter saida = null;
        nomeArq += ".csv";
        Boolean deuRuim = false;

        try {
            arq = new FileWriter(nomeArq);
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.out.println("\nErro ao abrir o arquivo");
            System.exit(1);
        }

        try {
            for (int i=0; i < lista.getTamanho(); i++) {
                if (lista.getObj(i).getGenero().equalsIgnoreCase(genero)){
                    Filme filme = lista.getObj(i);
                    saida.format("%d;%s;%.2f;%s;%d\n", filme.getIdFilme(), filme.getNome(),
                            filme.getNota(), filme.getGenero(), filme.getInteiro());
                }
            }
        }
        catch (FormatterClosedException erro) {
            System.out.println("\nErro ao gravar no arquivo");
            deuRuim = true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("\nErro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }
}
