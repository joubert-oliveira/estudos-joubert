public abstract class TipoBrinquedo implements Tributavel {

    // Atributos
    private Integer codigo;
    private String nome;

    // Construtor
    public TipoBrinquedo(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    // Métodos
    public Integer getRenda(){
        return null;
    }

    @Override
    public String toString() {
        return "TipoBrinquedo{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", Renda=" + getRenda() +
                '}';
    }
}
