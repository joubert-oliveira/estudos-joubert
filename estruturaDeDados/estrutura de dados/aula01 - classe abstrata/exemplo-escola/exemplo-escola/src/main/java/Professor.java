public class Professor extends FuncionarioComBonus{

    // Atributos
    private String nome;
    private Double quantAulasPorSemana;
    private Double valorHoraAula;

    // Construtor
    public Professor(String nome, Double quantAulasPorSemana, Double valorHoraAula) {
        this.nome = nome;
        this.quantAulasPorSemana = quantAulasPorSemana;
        this.valorHoraAula = valorHoraAula;
    }

    // Métodos
    @Override
    public Double getValorBonus() {
        return quantAulasPorSemana * valorHoraAula * 4.5 * 0.15;
    }

    // toString()
    @Override
    public String toString() {
        return "\nProfessor{" +
                "nome='" + nome + '\'' +
                ", quantAulasPorSemana=" + quantAulasPorSemana +
                ", valorHoraAula=" + valorHoraAula +
                ", valorBonus=" + getValorBonus() +
                "} " + super.toString();
    }
}
