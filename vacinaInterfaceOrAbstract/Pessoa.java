package vacinaInterfaceOrAbstract;

public abstract class Pessoa {
    private String nome;
    private Integer idade;
    private Boolean isVacinado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Boolean getVacinado() {
        return isVacinado;
    }

    public void setVacinado(Boolean vacinado) {
        isVacinado = vacinado;
    }

    public Pessoa(String nome, Integer idade, Boolean isVacinado) {
        this.nome = nome;
        this.idade = idade;
        this.isVacinado = isVacinado;
    }

    public abstract void vacinar(String tipoVacina);

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", isVacinado=" + isVacinado +
                '}';
    }
}
