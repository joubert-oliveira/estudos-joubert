package sptech.projeto04.entidade;

public class Linha {

    private String nomeIda;
    private String nomeVolta;
    private Double extensao;
    private Integer veiculos;
    private Boolean funciona24h;

    public String getNomeIda() {
        return nomeIda;
    }

    public void setNomeIda(String nomeIda) {
        this.nomeIda = nomeIda;
    }

    public String getNomeVolta() {
        return nomeVolta;
    }

    public void setNomeVolta(String nomeVolta) {
        this.nomeVolta = nomeVolta;
    }

    public Double getExtensao() {
        return extensao;
    }

    public void setExtensao(Double extensao) {
        this.extensao = extensao;
    }

    public Integer getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Integer veiculos) {
        this.veiculos = veiculos;
    }

    public Boolean getFunciona24h() {
        return funciona24h;
    }

    public void setFunciona24h(Boolean funciona24h) {
        this.funciona24h = funciona24h;
    }
}
