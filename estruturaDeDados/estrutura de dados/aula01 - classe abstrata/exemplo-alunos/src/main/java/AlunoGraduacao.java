public class AlunoGraduacao extends Alunos{

    // Atributos
    private Double nota1;
    private Double nota2;

    // Construtor
    public AlunoGraduacao(Integer ra, String nome, Double nota1, Double nota2) {
        super(ra, nome);
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    // Métodos
    @Override
    public Double calculaMedia() {
        return (nota1 * 0.4) + (nota2 * 0.6);
    }

    @Override
    public String toString() {
        return "AlunoGraduacao{" +
                "nota1=" + nota1 +
                ", nota2=" + nota2 +
                ", média=" + calculaMedia() +
                "} " + super.toString();
    }
}
