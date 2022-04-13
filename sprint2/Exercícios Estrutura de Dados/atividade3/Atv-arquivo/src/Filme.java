public class Filme {
    private Integer idFilme;
    private String nome;
    private Double nota;
    private String genero;
    private Integer idade;

    public Filme(Integer idFilme, String nome, Double nota, String genero, Integer inteiro) {
        this.idFilme = idFilme;
        this.nome = nome;
        if (nota > 10){
            this.nota = 10.0;
        }else if (nota < 0){
            this.nota = 0.0;
        } else {
            this.nota = nota;
        }
        this.genero = genero;
        this.idade = inteiro;
    }

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

    public Integer getInteiro() {
        return idade;
    }

    public void setInteiro(Integer inteiro) {
        this.idade = inteiro;
    }

    @Override
    public String toString() {
        return String.format("%010d %-30s %5.2f %-15s %5d", this.idFilme, this.nome, this.nota, this.genero, this.idade);
    }
}
