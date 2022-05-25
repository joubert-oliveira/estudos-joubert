public abstract class Educadores {

    //Atributos
    private String nome;
    private Double quantAulasPorSemana;
    private Double valorHoraAula;

    // Construtor
    public Educadores(String nome, Double quantAulasPorSemana, Double valorHoraAula) {
        this.nome = nome;
        this.quantAulasPorSemana = quantAulasPorSemana;
        this.valorHoraAula = valorHoraAula;
    }

    // Métodos
    public abstract Double getValorBonus();

    @Override
    public String toString() {
        return "Educadores{" +
                "nome='" + nome + '\'' +
                ", quantAulasPorSemana=" + quantAulasPorSemana +
                ", valorHoraAula=" + valorHoraAula +
                ", valorBonus=" + getValorBonus() +
                '}';
    }

    // Getters e Setters
    public Double getQuantAulasPorSemana() {
        return quantAulasPorSemana;
    }

    public Double getValorHoraAula() {
        return valorHoraAula;
    }


}
