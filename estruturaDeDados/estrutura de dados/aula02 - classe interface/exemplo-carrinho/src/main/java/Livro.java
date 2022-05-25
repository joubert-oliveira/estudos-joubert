public class Livro extends Produto{

    // Atributos
    private String autor;
    private String isbn;

    // Construtor
    public Livro(String nome, Integer codigo, Double precoCusto, String autor, String isbn) {
        super(nome, codigo, precoCusto);
        this.autor = autor;
        this.isbn = isbn;
    }

    // Métodos
    @Override
    public Double getValorVenda() {
        return getPrecoCusto() * 1.10;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", custo=" + getValorVenda() +
                "} " + super.toString();
    }


}
