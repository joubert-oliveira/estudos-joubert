import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TesteArquivoTxt {

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
    public static void gravaArquivoTxt(List<Aluno> lista, String nomeArq){
        int contaRegistroCorpo = 0;

        // Monta o registro de header
        String header = "00NOTA20221";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";
        // Grava o registro de header
        gravaRegistro(header, nomeArq);

        // Monta e grava os registros de corpo (ou de detalhe)
        String corpo;
        for (Aluno a : lista){
            corpo = "02";
            corpo += String.format("%-5.5s", a.getCurso());
            corpo += String.format("%-8.8s", a.getRa());
            corpo += String.format("%-50.50s", a.getNomeAluno());
            corpo += String.format("%-40.40s", a.getNomeDisciplina());
            corpo += String.format("%05.2f", a.getMediaFinal());
            corpo += String.format("%03d", a.getQuantidadeFaltas());
            // Grava o registro de corpo
            gravaRegistro(corpo, nomeArq);
            contaRegistroCorpo ++;
        }

        // Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%010d", contaRegistroCorpo);
        // Grava o registro de trailer
        gravaRegistro(trailer, nomeArq);
    }

    // Ler o arquivo
    public static void leArquivoTxt(String nomeArq){
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String ra, curso, nomeAluno, disciplina;
        Double media;
        Integer quantidadeFalta;
        int contaRegistroDadosLido = 0;
        int quantidadeRegistradoDadoGravado;

        List<Aluno> listaLida = new ArrayList<>();

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
                // 00NOTA20221
                tipoRegistro = registro.substring(0, 2);
                if (tipoRegistro.equals("00")){
                    System.out.println("É um registro de header");
                    System.out.println("Tipo do arquivo: " + registro.substring(2, 6));
                    System.out.println("Ano e Semestre: " + registro.substring(6, 11));
                    System.out.println("Data e Hora: " + registro.substring(11, 30));
                    System.out.println("Versão do documento de layout: " + registro.substring(30, 32));
                }
                else if (tipoRegistro.equals("01")){
                    System.out.println("É um registro de trailer");
                    quantidadeRegistradoDadoGravado = Integer.valueOf(registro.substring(2, 12));
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
                    curso = registro.substring(2, 7).trim();
                    ra = registro.substring(7, 15).trim();
                    nomeAluno =  registro.substring(15, 65).trim();
                    disciplina = registro.substring(65, 105).trim();
                    media = Double.valueOf(registro.substring(105, 110).replace(',', '.'));
                    quantidadeFalta =  Integer.valueOf(registro.substring(110, 113));
                    contaRegistroDadosLido ++;

                    // se for importar essas informações no banco de dados
                    // pode-se criar um obj Aluno com esses dados
                    // e fazer repository.save(obj);

                    // No nosso caso, vamos criar um objeto Aluno e adicionar esse objeto para a lista listaLida
                    listaLida.add(new Aluno(ra, nomeAluno, curso, disciplina, media, quantidadeFalta));
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
        for (Aluno a : listaLida){
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        List<Aluno> lista = new ArrayList<>();

        lista.add(new Aluno("01211061", "Isaque Silva", "ADS", "Estrutura de Dados", 9.0, 5 ));
        lista.add(new Aluno("01211005", "André Prieto", "ADS", "Programação WEB", 7.5, 8));
        lista.add(new Aluno("02211000", "Pedro Bochelli", "CCO", "Cálculo Computacional", 7.0, 15));
        lista.add(new Aluno("04211030", "José Teixeira", "REDES", "Segurança", 8.0, 7));

        for (Aluno a : lista){
            System.out.println(a);
        }

//        gravaArquivoTxt(lista, "aluno.txt");
        leArquivoTxt("aluno.txt");
    }
}
