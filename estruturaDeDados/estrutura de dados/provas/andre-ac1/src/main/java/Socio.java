public class Socio implements Tributavel{

    // Atributos
    private String nome;
    private Double honorario;

    // Construtor
    public Socio(String nome, Double honorario) {
        this.nome = nome;
        this.honorario = honorario;
    }

    // Métodos
    @Override
    public Double getValorImposto() {
        return honorario * 0.25;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "nome='" + nome + '\'' +
                ", honorario=" + honorario +
                ", ValorImposto=" + getValorImposto() +
                '}';
    }
}
