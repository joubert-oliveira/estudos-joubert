public class Predio extends Imovel {

    // Atributos
    private Integer andar;

    // Construtor
    public Predio(Integer idade, String local, Double m2, Integer andar) {
        super(idade, local, m2);
        this.andar = andar;
    }

    // Métodos
    @Override
    public Double getValorImovel() {
        return getM2() * 1000.0;
    }

    // toString()
    @Override
    public String toString() {
        return "Predio{" +
                "andar=" + andar +
                ", valorImovel=" + getValorImovel() +
                "} " + super.toString();
    }
}
