package interfaceOrAbstract;

public class Professor extends Funcionario{

    private Integer qtdAulasSemana;
    private Double valorHoraAula;

    public Professor(String nome, Integer qtdAulasSemana, Double valorHoraAula) {
        super(nome);
        this.qtdAulasSemana = qtdAulasSemana;
        this.valorHoraAula = valorHoraAula;
    }

    public Integer getQtdAulasSemana() {
        return qtdAulasSemana;
    }

    public void setQtdAulasSemana(Integer qtdAulasSemana) {
        this.qtdAulasSemana = qtdAulasSemana;
    }

    public Double getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(Double valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }

    public Double getValorBonus() {
        return (qtdAulasSemana * valorHoraAula) * 4.5 * 0.15;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "qtdAulasSemana=" + qtdAulasSemana +
                ", valorHoraAula=" + valorHoraAula +
                ", Valor bonus=" + getValorBonus() +
                "} " + super.toString();
    }
}

