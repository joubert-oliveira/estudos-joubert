import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AppArquivoCsv {

    public static void gravaArquivoCsv(ListaObj<Cachorro> lista, String nomeArq) {
        FileWriter arq = null;  // arq é o obj que corresponde ao arquivo
        Formatter saida = null; // obj que será usado para escrever no arquivo
        nomeArq += ".csv";  // acrescenta a extensão .CSV ao nome do arquivo
        Boolean deuRuim = false;

        // Bloco try catch para abrir o arquivo
        try {
            arq = new FileWriter(nomeArq);
            // Se quiser que o conteúdo seja acrescentado ao final do arquivo,
            // teria que fazer:
            // arq = new FileWriter(nomeArq,true);
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        // Bloco try catch para gravar no arquivo
        try {
            // Percorro a lista de cachorros
            for (int i=0; i < lista.getTamanho(); i++) {
                // obtenho um objeto da lista de cada vez (do índice i)
                Cachorro dog = lista.getElemento(i);
                // gravo os dados desse objeto, separando cada campo por um ;
                saida.format("%d;%s;%s;%.2f\n",dog.getId(),dog.getNome(),
                                               dog.getPorte(),dog.getPeso());
            }
        }
        catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar o arquivo");
            deuRuim = true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

    public static void leExibeArquivoCsv (String nomeArq) {
        FileReader arq = null;  // objeto que representa o arquivo para leitura
        Scanner entrada = null; // objeto usado para ler do arquivo
        nomeArq += ".csv";      // acrescenta extensão .csv ao nome do arquivo
        Boolean deuRuim = false;

        // try catch para abrir o arquivo
        try {
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        }
        catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }

        // Bloco try catch para ler o arquivo
        try {
            // Exibe os títulos das colunas
            System.out.printf("%4s %-15s %-9s %4s\n","ID","NOME","PORTE","PESO" );
            while (entrada.hasNext()) {   // enqto não chegou o final do arquivo
                // lê cada campo do registro, como quando lemos do teclado
                Integer id = entrada.nextInt();
                String nome = entrada.next();   // next() aqui lê até o próximo ;
                String porte = entrada.next();
                Double peso = entrada.nextDouble();
                // exibo os dados em forma de colunas
                System.out.printf("%4d %-15s %-9s %4.2f\n",id,nome,porte,peso);
            }
        }
        catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            deuRuim = true;
        }
        catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            deuRuim = true;
        }
        finally {
            entrada.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }





    public static void main(String[] args) {
        ListaObj<Cachorro> listaDog = new ListaObj(7);

        listaDog.adiciona(new Cachorro(1,"Lara","Grande",15.0));
        listaDog.adiciona(new Cachorro(2,"Valentina","Pequeno",8.0));
        listaDog.adiciona(new Cachorro(3,"Neymar","Pequeno",5.0));
        listaDog.adiciona(new Cachorro(4,"Fantasma","Grande",30.0));
        listaDog.adiciona(new Cachorro(5,"Thor","Grande",40.0));
        // Exibe a lista
        listaDog.exibe();
        // grava o conteúdo da lista num arquivo CSV
        gravaArquivoCsv(listaDog,"dogs");
        // lê os dados do arquivo CSV e exibe na console
        leExibeArquivoCsv("dogs");
    }
}
