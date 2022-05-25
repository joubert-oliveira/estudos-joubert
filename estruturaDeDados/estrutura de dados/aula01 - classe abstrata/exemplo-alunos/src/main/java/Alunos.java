public abstract class Alunos {

    // Atributos
    private Integer ra;
    private String nome;

    // Construtor
    public Alunos(Integer ra, String nome) {
        this.ra = ra;
        this.nome = nome;
    }

    // Métodos
    public abstract Double calculaMedia();

    @Override
    public String toString() {
        return "Alunos{" +
                "ra=" + ra +
                ", nome='" + nome + '\'' +
                '}';
    }

    // Getter ra
    public Integer getRa() {
        return ra;
    }
}
