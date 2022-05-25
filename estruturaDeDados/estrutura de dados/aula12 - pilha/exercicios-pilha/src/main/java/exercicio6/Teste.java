package exercicio6;

public class Teste {
    public static void main(String[] args) {

        PilhaObj<Livro> pilha = new PilhaObj<>(5);
        PilhaObj<Livro> auxiliar = new PilhaObj<>(2);

        pilha.push(new Livro("Harry potter", "J.K Rowling"));
        pilha.push(new Livro("A culpa é das Estrelas", "John green"));
        pilha.push(new Livro("Percy Jackson", "Rick Riordan"));
        pilha.push(new Livro("O Homem mais inteligente do mundo", "Augusto Cury"));

        // Exibindo a pilha com todos os livros adicionados
        System.out.println("\n"+ "-".repeat(20));
        System.out.println("Exibindo a pilha com todos os livros adicionados" + "\n");
        pilha.exibe();

        // Tirar o livro do John Green
        System.out.println("\n"+ "-".repeat(20));
        System.out.println("Tirando o livro do John Green" + "\n");
        System.out.println(pilha.removeIndice(2));

        // Exibindo a pilha sem o livro do John Green
        System.out.println("\n"+ "-".repeat(20));
        System.out.println("Exibindo a pilha sem o livro do John Green" + "\n");
        pilha.exibe();

    }
}
