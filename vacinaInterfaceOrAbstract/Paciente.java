package vacinaInterfaceOrAbstract;

public class Paciente extends Pessoa{
    private String sintoma;

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public Paciente(String nome, Integer idade, Boolean isVacinado, String sintoma) {
        super(nome, idade, isVacinado);
        this.sintoma = sintoma;
    }

    public void vacinar(String tipoVacina) {
        if (tipoVacina.equalsIgnoreCase("CoronaVac") ||
                tipoVacina.equalsIgnoreCase("Janssen")) {
            setVacinado(true);
            String frase = String.format("%s foi vacinado(a)!", getNome());
            System.out.println(frase);
        } else {
            String frase = String.format("Não foi possível vacinar %s com %s, pois pacientes só estão " +
                    "aptos a tomar CoronaVac ou Janssen!", getNome(), tipoVacina);
            System.out.println(frase);
            setVacinado(false);
        }
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "sintoma='" + sintoma + '\'' +
                ", vacinado? " + ((getVacinado() == true) ? "Sim" : "Não") +
                "} " + super.toString();
    }
}
