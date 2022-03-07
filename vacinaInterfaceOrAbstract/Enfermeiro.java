package vacinaInterfaceOrAbstract;

public class Enfermeiro extends Pessoa{
    private String coren;
    private Double salario;

    public Enfermeiro(String nome, Integer idade, Boolean isVacinado, String coren, Double salario) {
        super(nome, idade, isVacinado);
        this.coren = coren;
        this.salario = salario;
    }

    public String getCoren() {
        return coren;
    }

    public void setCoren(String coren) {
        this.coren = coren;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void vacinar(String tipoVacina) {
        if (tipoVacina.equalsIgnoreCase("Astrazeneca") ||
                tipoVacina.equalsIgnoreCase("Pfizer")) {
            setVacinado(true);
            String frase = String.format("%s foi vacinado(a)!", getNome());
            System.out.println(frase);
        } else {
            String frase = String.format("Não foi possível vacinar %s com %s, pois enfermeiros só estão " +
                    "aptos a tomar Astrazeneca ou Pfizer!", getNome(), tipoVacina);
            System.out.println(frase);
            setVacinado(false);
        }
    }


    @Override
    public String toString() {
        return "Enfermeiro{" +
                "coren='" + coren + '\'' +
                ", salario=" + salario +
                ", vacinado? " + ((getVacinado() == true) ? "Sim" : "Não") +
                "} " + super.toString();
    }
}
