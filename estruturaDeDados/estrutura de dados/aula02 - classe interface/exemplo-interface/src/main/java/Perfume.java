public class Perfume extends Produto{

    // Atributos
    private String fragancia;

    // Construtor
    public Perfume(Integer codigo, String descricao, Double preco, String fragancia) {
        super(codigo, descricao, preco);
        this.fragancia = fragancia;
    }

    // Métodos
    @Override
    public Double getValorTributo() {
        return getPreco() * 0.27;
    }

    @Override
    public String toString() {
        return "Perfume{" +
                "fragancia='" + fragancia + '\'' +
                ", tributo=" + getValorTributo() +
                "} " + super.toString();
    }
}
