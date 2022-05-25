public class Fazenda extends Imovel{

    // Atributos
    private String celeiro;

    // Construtor
    public Fazenda(Integer idade, String local, Double m2, String celeiro) {
        super(idade, local, m2);
        this.celeiro = celeiro;
    }

    // Métodos
    @Override
    public Double getValorImovel() {
        return getM2() * 1000.0;
    }

    // toString()
    @Override
    public String toString() {
        return "Fazenda{" +
                "celeiro='" + celeiro + '\'' +
                ", valorImovel=" + getValorImovel() +
                "} " + super.toString();
    }
}
