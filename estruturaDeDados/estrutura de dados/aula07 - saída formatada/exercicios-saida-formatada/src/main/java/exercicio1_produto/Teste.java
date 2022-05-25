package exercicio1_produto;

public class Teste {
    public static void main(String[] args) {
        ListaObj<Produto> lista = new ListaObj<>(5);

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

        lista.adiciona(produto1);
        lista.adiciona(produto2);
        lista.adiciona(produto3);
        lista.adiciona(produto4);
        lista.adiciona(produto5);

        System.out.printf("%6s %-14s %7s %7s %14s\n", "CODIGO", "NOME", "PREÇO", "NOTA", "FATURAMENTO");

        lista.exibe();
    }
}
