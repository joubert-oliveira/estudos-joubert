public class BrinquedoIngresso extends TipoBrinquedo {

    // Atributos
    private Integer valorIngresso;
    private Integer qtdIngressoVendido;

    // Construtor
    public BrinquedoIngresso(Integer codigo, String nome, Integer valorIngresso, Integer qtdIngressoVendido) {
        super(codigo, nome);
        this.valorIngresso = valorIngresso;
        this.qtdIngressoVendido = qtdIngressoVendido;
    }

    // Métodos
    @Override
    public Integer getRenda() {
        return valorIngresso * qtdIngressoVendido;
    }

    @Override
    public Double getValorImposto() {
        return getRenda() * 0.15;
    }

    @Override
    public String toString() {
        return "BrinquedoIngresso{" +
                "valorIngresso=" + valorIngresso +
                ", qtdIngressoVendido=" + qtdIngressoVendido +
                ", ValorImposto=" + getValorImposto() +
                "} " + super.toString();
    }
}
