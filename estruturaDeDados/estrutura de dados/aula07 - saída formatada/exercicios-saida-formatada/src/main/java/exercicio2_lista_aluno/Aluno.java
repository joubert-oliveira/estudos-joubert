package exercicio2_lista_aluno;

public class Aluno {

    // Atributos
    private Integer ra;
    private String nome;
    private Double nota;

    // Getters e Setters
    public Integer getRa() {
        return ra;
    }

    public void setRa(Integer ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    // Construtor
    public Aluno(Integer ra, String nome, Double nota) {
        this.ra = ra;
        this.nome = nome;
        this.nota = nota;
    }

    // Métodos

    // toString()
    @Override
    public String toString() {
        return String.format("%010d %-30s %05.2f\n", ra, nome, nota);
    }
}
