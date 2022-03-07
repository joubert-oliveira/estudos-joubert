package vacinaInterfaceOrAbstract;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class AppTeste {
    public static void main(String[] args) {
        Pessoa enf1 = new Enfermeiro("Patricia", 32, false, "7654745", 5000.0);
        Pessoa enf2 = new Enfermeiro("Amanda", 28, false, "7214895", 4000.0);
        Pessoa pac1 = new Paciente("Joubert", 21, false, "Rinite");
        Pessoa pac2 = new Paciente("Lucas", 21, false, "Sinusite");

        System.out.println("Informações dos objetos:");
        System.out.println(enf1);
        System.out.println(enf2);
        System.out.println(pac1);
        System.out.println(pac2);
        System.out.println();

        System.out.println("Invocando o método vacinar():");
        enf1.vacinar("Astrazeneca");
        enf2.vacinar("Janssen");
        pac1.vacinar("Janssen");
        pac2.vacinar("Pfizer");
        System.out.println();

        ControleVacina vacina = new ControleVacina();

        System.out.println("Invocando o método adicionaVacinado():");
        vacina.adicionaVacinado(enf1);
        vacina.adicionaVacinado(enf2);
        vacina.adicionaVacinado(pac1);
        vacina.adicionaVacinado(pac2);

        System.out.println("\nLista de vacinados: ");
        vacina.exibeVacinados();


    }
}
