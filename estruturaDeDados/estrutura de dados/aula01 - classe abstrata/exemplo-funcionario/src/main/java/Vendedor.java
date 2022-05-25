public class Vendedor extends Funcionario{

    // Atributos

    private Double vendas;
    private Double taxa;

    // Construtor

    public Vendedor(String cpf, String nome, Double vendas, Double taxa) {
        super(cpf, nome);
        this.vendas = vendas;
        this.taxa = taxa;
    }

    // Métodos

    @Override
    public Double calcSalario() {
        return vendas * taxa;
    }

    // toString()

    @Override
    public String toString() {
        return "Vendedor{" +
                "vendas=" + vendas +
                ", taxa=" + taxa +
                ", salario=" + calcSalario() +
                "} " + super.toString();
    }
}
