public class DVD extends Produto{

    // Atributos
    private String gravadora;

    // Construtor
    public DVD(String nome, Integer codigo, Double precoCusto, String gravadora) {
        super(nome, codigo, precoCusto);
        this.gravadora = gravadora;
    }

    // Métodos
    @Override
    public Double getValorVenda() {
        return getPrecoCusto() * 1.20;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "gravadora='" + gravadora + '\'' +
                ", custo=" + getValorVenda() +
                "} " + super.toString();
    }
}
