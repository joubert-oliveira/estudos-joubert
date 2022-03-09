package interfaceOrAbstract;

import java.util.ArrayList;
import java.util.List;

public class ControleBonus {
    private List<Funcionario> listaBonuses;

    public ControleBonus() {
        listaBonuses = new ArrayList<>();
    }

    public void adicionaObjeto(Funcionario funcionario) {
        listaBonuses.add(funcionario);
    }

    public void exibeTodos() {
        for (Funcionario funcionario : listaBonuses) {
            System.out.println(funcionario);
        }
    }

    public Double calcularTotalBonuses() {
        Double total = 0.0;

        for (Funcionario funcionario : listaBonuses) {
            total += funcionario.getValorBonus();
        }

        return total;
    }

    @Override
    public String toString() {
        return "ControleBonus{" +
                "listaBonuses=" + listaBonuses +
                '}';
    }
}
