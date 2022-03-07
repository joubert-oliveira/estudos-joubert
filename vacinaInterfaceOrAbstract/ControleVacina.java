package vacinaInterfaceOrAbstract;

import java.util.ArrayList;
import java.util.List;

public class ControleVacina {
    private List<Pessoa> listPessoas;

    public ControleVacina() {
        listPessoas = new ArrayList<>();
    }

    public void adicionaVacinado(Pessoa pessoa) {
        if (pessoa.getVacinado() == true) {
            listPessoas.add(pessoa);
            System.out.println(pessoa.getNome() + " foi adicionado(a) a lista de vacinados!");
        } else {
            System.out.println("Não foi possível adicionar " + pessoa.getNome() + " a lista de vacinados, " +
                    "pois ele(a) ainda não está vacinado(a)!");
        }
    }

    public void exibeVacinados() {
        for (Pessoa pessoa : listPessoas) {
            System.out.println(pessoa);
        }
    }

    @Override
    public String toString() {
        return "ControleVacina{" +
                "listPessoas=" + listPessoas +
                '}';
    }
}

