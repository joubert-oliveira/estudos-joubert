public class Coordenador extends Professor{

    //Atributos
    private Double quantHorasCoordenacaoPorSemana;
    private Double valorHoraCoordenacao;

    // Construtor
    public Coordenador(String nome, Double quantAulasPorSemana, Double valorHoraAula, Double quantHorasCoordenacaoPorSemana, Double valorHoraCoordenacao) {
        super(nome, quantAulasPorSemana, valorHoraAula);
        this.quantHorasCoordenacaoPorSemana = quantHorasCoordenacaoPorSemana;
        this.valorHoraCoordenacao = valorHoraCoordenacao;
    }

    // Métodos
    @Override
    public Double getValorBonus() {
        return (super.getQuantAulasPorSemana() * super.getValorHoraAula() * 4.5 * 0.15)
                + (quantHorasCoordenacaoPorSemana * valorHoraCoordenacao * 4.5 * 0.2);
    }

    // toString()

    @Override
    public String toString() {
        return "Coordenador{" +
                "quantHorasCoordenacaoPorSemana=" + quantHorasCoordenacaoPorSemana +
                ", valorHoraCoordenacao=" + valorHoraCoordenacao +
                ", valorBonus=" + getValorBonus() +
                "} " + super.toString();
    }
}
