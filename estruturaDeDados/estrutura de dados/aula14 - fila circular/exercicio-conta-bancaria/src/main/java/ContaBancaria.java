public class ContaBancaria {

    // Atributos
    private Integer numero;
    private Double saldo;

    // Construtor
    public ContaBancaria(Integer numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    // Métodos
    public Boolean debitar(Double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
            return false;
        }

        saldo -= valor;
        System.out.println(String.format("Saldo atual(pós débito): R$%.2f", saldo));
        return true;
    }

    public void depositar(Double valor) {
        saldo += valor;
        System.out.println(String.format("Saldo atual(pós depósito): R$%.2f", saldo));
    }

    // toString()
    @Override
    public String toString() {
        return String.format("\n----------Conta Bancária----------\n" +
                        "Número: %d\n" +
                        "Saldo: R$%.2f",
                numero, saldo);
    }

    // Getters e Setters
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
