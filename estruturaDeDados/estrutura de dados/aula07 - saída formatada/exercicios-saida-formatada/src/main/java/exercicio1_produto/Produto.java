package exercicio1_produto;

public class Produto {

    // Atributos
    private Integer codProduto;
    private String nome;
    private Double preco;
    private String avaliacao;
    private Integer quantidadeVendida;

    // Getters e Setters
    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    // Construtor
    public Produto(int codProduto, String nome, Double preco, String avaliacao) {
        this.codProduto = codProduto;
        this.nome = nome;
        this.preco = preco;
        this.avaliacao = avaliacao;
        this.quantidadeVendida = 0;
    }

    // Métodos
    public void comprar(int quantidadeComprada){
        quantidadeVendida += quantidadeComprada;
    }

    public Double calcularFaturamento(){
        return quantidadeVendida * preco;
    }

    // toString()
    @Override
    public String toString() {
        return String.format("%06d %-14s %7.2f %7s %14.3f\n", codProduto, nome, preco, avaliacao, calcularFaturamento());
    }
}
