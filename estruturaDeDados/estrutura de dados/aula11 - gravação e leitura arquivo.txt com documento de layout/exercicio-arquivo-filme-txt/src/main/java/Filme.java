public class Filme {

    // Atributos
    private Integer id;
    private String nomeFilme;
    private Double nota;
    private String genero;
    private Integer idade;

    // Construtor
    public Filme(Integer id, String nomeFilme, Double nota, String genero, Integer idade) {
        this.id = id;
        this.nomeFilme = nomeFilme;
        this.nota = nota;
        this.genero = genero;
        this.idade = idade;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public Double getNota() {
        return nota;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    // toString()
    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", nomeFilme='" + nomeFilme + '\'' +
                ", nota=" + nota +
                ", genero='" + genero + '\'' +
                ", idade=" + idade +
                '}';
    }
}
