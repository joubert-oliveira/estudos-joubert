import java.util.Scanner;

public class TestaCarrinho {
    public static void main(String[] args) {
        Integer opcao = 0;
        Scanner leitor = new Scanner(System.in); //next(), nextInt(), nextDouble()
        Scanner leitorNL = new Scanner(System.in); // nextLine()

        String nome;
        Integer codigo;
        Double precoCusto;

        // Livro
        // nome, codigo, precoCusto
        String autor;
        String isbn;

        //DVD
        // nome, codigo, precoCusto
        String gravadora;

        //Serviço
        String descricao;
        // codigo
        Integer quantHoras;
        Double valorHora;


        Boolean fim = false;
        Carrinho carro = new Carrinho();

        while (!fim){
            System.out.println("MENU");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Adicionar DVD");
            System.out.println("3 - Adicionar Serviço");
            System.out.println("4 - Exibir itens do carrinho");
            System.out.println("5 - Exibir total de venda");
            System.out.println("6 - Fim");
            opcao = leitor.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Digite o nome");
                    nome = leitorNL.nextLine();
                    System.out.println("Digite o código");
                    codigo = leitor.nextInt();
                    System.out.println("Digite o preço");
                    precoCusto = leitor.nextDouble();
                    System.out.println("Digite o autor");
                    autor = leitorNL.nextLine();
                    System.out.println("Digite o ISBN");
                    isbn = leitorNL.nextLine();
                    Livro livro1 = new Livro(nome, codigo, precoCusto, autor, isbn);
                    carro.adicionarVendavel(livro1);
                    break;
                case 2:
                    System.out.println("Digite o nome");
                    nome = leitorNL.nextLine();
                    System.out.println("Digite o código");
                    codigo = leitor.nextInt();
                    System.out.println("Digite o preço");
                    precoCusto = leitor.nextDouble();
                    System.out.println("Digite a gravadora");
                    gravadora = leitorNL.nextLine();
                    DVD dvd1 = new DVD(nome, codigo, precoCusto, gravadora);
                    carro.adicionarVendavel(dvd1);
                    break;
                case 3:
                    System.out.println("Digite a descrição");
                    descricao = leitorNL.nextLine();
                    System.out.println("Digite o código");
                    codigo = leitor.nextInt();
                    System.out.println("Digite a quantidade de horas");
                    quantHoras = leitor.nextInt();
                    System.out.println("Digite o valo da hora");
                    valorHora = leitor.nextDouble();
                    Servico serviço1 = new Servico(descricao, codigo, quantHoras, valorHora);
                    carro.adicionarVendavel(serviço1);
                    break;
                case 4:
                    carro.exibiItensCarrinho();
                    break;
                case 5:
                    System.out.println("Total de vendas");
                    System.out.println(carro.calculaTotalVenda());
                    break;
                case 6:
                    fim = true;
            }
        }
    }
}
