public class Aluno {

    // Atributos
    private String ra;
    private String nomeAluno;
    private String curso;
    private String nomeDisciplina;
    private Double mediaFinal;
    private Integer quantidadeFaltas;

    // Construtor
    public Aluno(String ra, String nomeAluno, String curso, String nomeDisciplina, Double mediaFinal, Integer quantidadeFaltas) {
        this.ra = ra;
        this.nomeAluno = nomeAluno;
        this.curso = curso;
        this.nomeDisciplina = nomeDisciplina;
        this.mediaFinal = mediaFinal;
        this.quantidadeFaltas = quantidadeFaltas;
    }

    // Getters e Setters
    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public Double getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(Double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    public Integer getQuantidadeFaltas() {
        return quantidadeFaltas;
    }

    public void setQuantidadeFaltas(Integer quantidadeFaltas) {
        this.quantidadeFaltas = quantidadeFaltas;
    }

    // toString()

    @Override
    public String toString() {
        return "Aluno{" +
                "ra='" + ra + '\'' +
                ", nomeAluno='" + nomeAluno + '\'' +
                ", curso='" + curso + '\'' +
                ", nomeDisciplina='" + nomeDisciplina + '\'' +
                ", mediaFinal=" + mediaFinal +
                ", quantidadeFaltas=" + quantidadeFaltas +
                '}';
    }
}
