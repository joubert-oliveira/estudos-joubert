public abstract class
Produto implements Vendavel {

    // Atributos
    private String nome;
    private Integer codigo;
    private Double precoCusto;

    // Construtor
    public Produto(String nome, Integer codigo, Double precoCusto) {
        this.nome = nome;
        this.codigo = codigo;
        this.precoCusto = precoCusto;
    }

    // Métodos
    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", codigo=" + codigo +
                ", precoCusto=" + precoCusto +
                '}';
    }

    // Getters e Setters
    public Double getPrecoCusto() {
        return precoCusto;
    }


}
