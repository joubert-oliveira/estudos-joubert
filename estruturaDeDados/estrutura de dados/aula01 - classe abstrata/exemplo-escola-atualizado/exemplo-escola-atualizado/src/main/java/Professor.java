public class Professor extends Educadores{

    // Construtor
    public Professor(String nome, Double quantAulasPorSemana, Double valorHoraAula) {
        super(nome, quantAulasPorSemana, valorHoraAula);
    }

    // Métodos
    @Override
    public Double getValorBonus() {
        return getQuantAulasPorSemana() * getValorHoraAula() * 4.5 * 0.15;
    }

    // toString()
    @Override
    public String toString() {
        return "Professor{} " + super.toString();
    }
}
