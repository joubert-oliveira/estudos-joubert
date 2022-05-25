public class Coordenador extends FuncionarioComBonus{

    // Atributos
    private String nome;
    private Double quantHorasCoordenacaoPorSemana;
    private Double ValorHoraCoordenacao;

    // Construtor
    public Coordenador(String nome, Double quantHorasCoordenacaoPorSemana, Double valorHoraCoordenacao) {
        this.nome = nome;
        this.quantHorasCoordenacaoPorSemana = quantHorasCoordenacaoPorSemana;
        this.ValorHoraCoordenacao = valorHoraCoordenacao;
    }

    // Métodos
    @Override
    public Double getValorBonus() {
        return quantHorasCoordenacaoPorSemana * ValorHoraCoordenacao * 4.5 * 0.2;
    }

    // toString()
    @Override
    public String toString() {
        return "\nCoordenador{" +
                "nome='" + nome + '\'' +
                ", quantHorasCoordenacaoPorSemana=" + quantHorasCoordenacaoPorSemana +
                ", ValorHoraCoordenacao=" + ValorHoraCoordenacao +
                ", valorBonus=" + getValorBonus() +
                "} " + super.toString();
    }
}
