public class BrinquedoAlugado extends TipoBrinquedo {

    // Atributos
    private Integer valorHora;
    private Integer qtdHoraAlugado;

    // Construtor
    public BrinquedoAlugado(Integer codigo, String nome, Integer valorHora, Integer qtdHoraAlugado) {
        super(codigo, nome);
        this.valorHora = valorHora;
        this.qtdHoraAlugado = qtdHoraAlugado;
    }

    // Métodos
    @Override
    public Integer getRenda() {
        return valorHora * qtdHoraAlugado;
    }

    @Override
    public Double getValorImposto() {
        return getRenda() * 0.10;
    }

    @Override
    public String toString() {
        return "BrinquedoAlugado{" +
                "valorHora=" + valorHora +
                ", qtdHoraAlugado=" + qtdHoraAlugado +
                ", ValorImposto=" + getValorImposto() +
                "} " + super.toString();
    }
}
