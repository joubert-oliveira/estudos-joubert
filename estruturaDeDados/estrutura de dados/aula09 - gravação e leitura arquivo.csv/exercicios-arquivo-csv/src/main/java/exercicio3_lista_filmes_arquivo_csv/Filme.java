package exercicio3_lista_filmes_arquivo_csv;

public class Filme {

    // Atributos
    private Integer idFilme;
    private String nome;
    private Double nota; // representa um valor de 0 a 10 atribuído pela crítica
    private String genero;
    private Integer idade; // representa a idade mínima para assistir o filme

    // Construtor
    public Filme(Integer idFilme, String nome, Double nota, String genero, Integer idade) {
        this.idFilme = idFilme;
        this.nome = nome;
        this.nota = nota;
        this.genero = genero;
        this.idade = idade;
    }

    // Getters e Setters
    public Integer getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Integer idFilme) {
        this.idFilme = idFilme;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    // Métodos

    // toString()
    @Override
    public String toString() {
        return String.format("%4d %-14s %5.2f %-10s %4d\n", idFilme, nome, nota, genero, idade);
    }
}
