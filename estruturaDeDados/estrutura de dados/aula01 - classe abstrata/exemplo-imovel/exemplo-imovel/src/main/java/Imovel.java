public abstract class Imovel {

    // Atributos
    private Integer idade;
    private String local;
    private Double m2;

    // Construtor
    public Imovel(Integer idade, String local, Double m2) {
        this.idade = idade;
        this.local = local;
        this.m2 = m2;
    }

    // Métodos
    public abstract Double getValorImovel();

    // toString()
    @Override
    public String toString() {
        return "Imovel{" +
                "idade=" + idade +
                ", local='" + local + '\'' +
                ", m2=" + m2 +
                '}';
    }

    // Getters
    public Double getM2() {
        return m2;
    }
}
