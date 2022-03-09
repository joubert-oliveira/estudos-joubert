package interfaceOrAbstract;

public class Coordenador extends Funcionario {

    private Integer qtdHorasCoord;
    private Double valorHoraCoord;

    public Coordenador(String nome, Integer qtdHorasCoord, Double valorHoraCoord) {
        super(nome);
        this.qtdHorasCoord = qtdHorasCoord;
        this.valorHoraCoord = valorHoraCoord;
    }

    public Integer getQtdHorasCoord() {
        return qtdHorasCoord;
    }

    public void setQtdHorasCoord(Integer qtdHorasCoord) {
        this.qtdHorasCoord = qtdHorasCoord;
    }

    public Double getValorHoraCoord() {
        return valorHoraCoord;
    }

    public void setValorHoraCoord(Double valorHoraCoord) {
        this.valorHoraCoord = valorHoraCoord;
    }

    public Double getValorBonus() {
        return (qtdHorasCoord * valorHoraCoord) * 4.5 * 0.2;
    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "qtdHorasCoord=" + qtdHorasCoord +
                ", valorHoraCoord=" + valorHoraCoord +
                ", Valor Bonus=" + getValorBonus() +
                "} " + super.toString();
    }
}
