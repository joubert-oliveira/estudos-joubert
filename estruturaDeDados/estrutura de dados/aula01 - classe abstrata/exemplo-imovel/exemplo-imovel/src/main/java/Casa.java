public class Casa extends Imovel{

    // Atributos
    private String quintal;

    // Construtor
    public Casa(Integer idade, String local, Double m2, String quintal) {
        super(idade, local, m2);
        this.quintal = quintal;
    }

    // Métodos
    @Override
    public Double getValorImovel() {
        return getM2() * 1000.0;
    }

    // toString()
    @Override
    public String toString() {
        return "Casa{" +
                "quintal='" + quintal + '\'' +
                ", valorImovel=" + getValorImovel() +
                "} " + super.toString();
    }
}
