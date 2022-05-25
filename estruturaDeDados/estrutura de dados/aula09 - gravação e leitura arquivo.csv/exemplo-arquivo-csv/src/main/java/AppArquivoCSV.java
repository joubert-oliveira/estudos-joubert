import javax.security.auth.callback.CallbackHandler;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AppArquivoCSV{

    // Gravar arquivo
    public static void gravaArquivoCsv(ListaObj<Cachorro> lista, String nomeArquivo){

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
                Cachorro dog = lista.getElemento(i);
                saida.format("%d;%s;%s;%.2f\n", dog.getId(), dog.getNome(), dog.getPorte(), dog.getPeso());
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
            System.out.printf("%4s %-15s %-9s %5s\n", "ID", "NOME", "PORTE", "PESO");
            while (entrada.hasNext()){
                Integer id = entrada.nextInt();
                String nome = entrada.next();
                String porte = entrada.next();
                Double peso = entrada.nextDouble();
                System.out.printf("%4d %-15s %-9s %5.2f\n", id, nome, porte, peso);
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
        ListaObj<Cachorro> listaDog = new ListaObj<>(7);

        listaDog.adiciona(new Cachorro(1,"Lara", "Grande", 15.0));
        listaDog.adiciona(new Cachorro(2,"Valentina", "Pequeno", 8.0));
        listaDog.adiciona(new Cachorro(3,"Neymar", "Pequeno", 5.0));
        listaDog.adiciona(new Cachorro(4,"Fantasma", "Grande", 30.0));
        listaDog.adiciona(new Cachorro(5,"Thor", "Grande", 40.0));

        listaDog.exibe();

        gravaArquivoCsv(listaDog, "dogs");
        leExibeArquivoCsv("dogs");
    }
}
