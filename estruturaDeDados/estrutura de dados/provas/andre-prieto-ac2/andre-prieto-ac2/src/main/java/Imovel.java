public class Imovel {

    // Atributos
    private Integer cib; // código do imóvel registrado no município
    private String nome; // nome do imóvel
    private Integer idade; // idade do imóvel
    private String local; // local do imóvel
    private Integer m2; // metro quadrado do imóvel
    private Double valorM2; // valor do metro quadrado do imóvel

    // Construtor
    public Imovel(Integer cib, String nome, Integer idade, String local, Integer m2, Double valorM2) {
        this.cib = cib;
        this.nome = nome;
        this.idade = idade;
        this.local = local;
        this.m2 = m2;
        this.valorM2 = valorM2;
    }

    // Getters e Setters
    public Integer getCib() {
        return cib;
    }

    public void setCib(Integer cib) {
        this.cib = cib;
    }

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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getM2() {
        return m2;
    }

    public void setM2(Integer m2) {
        this.m2 = m2;
    }

    public Double getValorM2() {
        return valorM2;
    }

    public void setValorM2(Double valorM2) {
        this.valorM2 = valorM2;
    }

    // toString()
    @Override
    public String toString() {
        return String.format("%4d %-20s %5d %-14s %4d %11.2f\n", cib, nome, idade, local, m2, valorM2);
    }
}
