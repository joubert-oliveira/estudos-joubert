public class Operacao {

    // Atributos
    private ContaBancaria objConta;
    private String tipoOperacao;
    private Double valor;

    // Construtor
    public Operacao(ContaBancaria objConta, String tipoOperacao, Double valor) {
        this.objConta = objConta;
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
    }

    // toString()
    @Override
    public String toString() {
        return String.format("\n----------Operação----------\n" +
                        "Tipo de operação: %s\n" +
                        "Valor da operação: R$%.2f",
                tipoOperacao, valor);
    }

    // Getters e Setters
    public ContaBancaria getObjConta() {
        return objConta;
    }

    public void setObjConta(ContaBancaria objConta) {
        this.objConta = objConta;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
