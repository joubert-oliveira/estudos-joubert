public class Servico implements Vendavel{

    // Atributos
    private String descricao;
    private Integer codigo;
    private Integer quantHoras;
    private Double valorHora;

    // Construtor
    public Servico(String descricao, Integer codigo, Integer quantHoras, Double valorHora) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.quantHoras = quantHoras;
        this.valorHora = valorHora;
    }

    // Métodos
    @Override
    public Double getValorVenda() {
        return quantHoras * valorHora;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "descricao='" + descricao + '\'' +
                ", codigo=" + codigo +
                ", quantHoras=" + quantHoras +
                ", valorHora=" + valorHora +
                ", valorVenda=" + getValorVenda() +
                '}';
    }
}
