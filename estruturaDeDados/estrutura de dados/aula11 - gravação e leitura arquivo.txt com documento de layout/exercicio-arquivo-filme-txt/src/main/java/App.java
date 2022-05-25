import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class App {

    // Gravar Registro
    public static void gravaRegistro(String registro, String nomeArq){
        BufferedWriter saida = null;

        // Bloco try catch para abrir o arquivo
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        }
        catch (IOException erro){
            System.out.println("Erro na abertura do arquivo: " + erro);
        }

        // Bloco try catch para gravar no arquivo
        try {
            saida.append(registro + "\n");
            saida.close();
        }
        catch (IOException erro){
            System.out.println("Erro na gravação do arquivo: " + erro);
        }
    }

    // Grava Arquivo
    public static void gravaArquivoTxt(List<Filme> lista, String nomeArq){
        int contaRegistroCorpo = 0;

        // Monta o registro de header
        String header = "00FILME";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";
        // Grava o registro de header
        gravaRegistro(header, nomeArq);

        // Monta e grava os registros de corpo (ou de detalhe)
        String corpo;
        for (Filme f : lista){
            corpo = "02";
            corpo += String.format("%08d", f.getId());
            corpo += String.format("%-25.25s", f.getNomeFilme());
            corpo += String.format("%04.1f", f.getNota());
            corpo += String.format("%-18.18s", f.getGenero());
            corpo += String.format("%02d", f.getIdade());
            // Grava o registro de corpo
            gravaRegistro(corpo, nomeArq);
            contaRegistroCorpo ++;
        }

        // Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%05d", contaRegistroCorpo);
        // Grava o registro de trailer
        gravaRegistro(trailer, nomeArq);
    }

    // Ler o arquivo
    public static void leArquivoTxt(String nomeArq){
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String nomeFilme, genero;
        Double nota;
        Integer id, idade;
        int contaRegistroDadosLido = 0;
        int quantidadeRegistradoDadoGravado;

        List<Filme> listaLida = new ArrayList<>();

        // Bloco try catch para abrir o arquivo
        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        }
        catch (IOException erro){
            System.out.println("Erro na abertura do arquivo: " + erro);
        }

        // Leitura do arquivo
        try {
            // Le o primeiro registro do arquivo
            registro = entrada.readLine();

            while (registro != null){ // enquanto não for o final do arquivo
                // obtem os 2 primeiros caracteres do registro
                // 012
                // 00FILME
                tipoRegistro = registro.substring(0, 2);
                if (tipoRegistro.equals("00")){
                    System.out.println("É um registro de header");
                    System.out.println("Tipo do arquivo: " + registro.substring(2, 7));
                    System.out.println("Data e Hora: " + registro.substring(7, 26));
                    System.out.println("Versão do documento de layout: " + registro.substring(26, 28));
                }
                else if (tipoRegistro.equals("01")){
                    System.out.println("É um registro de trailer");
                    quantidadeRegistradoDadoGravado = Integer.valueOf(registro.substring(2, 7));
                    if (contaRegistroDadosLido == quantidadeRegistradoDadoGravado){
                        System.out.println("Quantidade de registros lidos compatível com a quantidade registros gravados");
                    }
                    else {
                        System.out.println("Quantidade de registros lidos incompatível com a quantidade registros gravados");
                    }
                }
                else if (tipoRegistro.equals("02")){
                    System.out.println("É um registro de corpo");
                    // trim() elimina os brancos à direita da String
                    id = Integer.valueOf(registro.substring(2, 10));
                    nomeFilme = registro.substring(10, 35).trim();
                    nota =  Double.valueOf(registro.substring(35, 39).replace(',', '.'));
                    genero = registro.substring(39, 57).trim();
                    idade = Integer.valueOf(registro.substring(57, 59));
                    contaRegistroDadosLido ++;

                    // se for importar essas informações no banco de dados
                    // pode-se criar um obj Filme com esses dados
                    // e fazer repository.save(obj);

                    // No nosso caso, vamos criar um objeto Aluno e adicionar esse objeto para a lista listaLida
                    listaLida.add(new Filme(id, nomeFilme, nota, genero, idade));
                }
                else {
                    System.out.println("Tipo de registro inválido");
                }
                // Le o próximo registro
                registro = entrada.readLine();
            }
            entrada.close();
        }
        catch (IOException erro){
            System.out.println("Erro ao ler arquivo: " + erro);
        }

        // Aqui também seria possível fazer repository.saveAll(listaLida);
        // para salvar todo o conteúdo da lista no banco de dados
        System.out.println("\nLista lida do arquivo:");
        for (Filme f : listaLida){
            System.out.println(f);
        }
    }

    public static void main(String[] args) {
        List<Filme> lista = new ArrayList<>();

        lista.add(new Filme(01, "Titanic", 9.9, "Romance", 25));
        lista.add(new Filme(02, "Como eu era antes de você", 10.0, "Romance", 6));
        lista.add(new Filme(03, "A cinco passos de você", 9.9, "Drama", 3));
        lista.add(new Filme(04, "365 days", 9.9, "Drama", 2));

        for (Filme f : lista){
            System.out.println(f);
        }

        gravaArquivoTxt(lista, "filmes.txt");
        leArquivoTxt("filmes.txt");
    }
}
