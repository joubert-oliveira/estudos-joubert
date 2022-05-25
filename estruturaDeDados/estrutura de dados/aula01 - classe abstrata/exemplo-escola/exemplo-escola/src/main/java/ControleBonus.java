import java.util.ArrayList;
import java.util.List;

public class ControleBonus {

    // Atributos
    private List<FuncionarioComBonus> listaFuncBonus;

    // Construtor
    public ControleBonus() {
        this.listaFuncBonus = new ArrayList<>();
    }

    // Métodos
    public void adicionarFuncionario(FuncionarioComBonus f){
        listaFuncBonus.add(f);
    }

    public void exibirTodos(){
        System.out.println("\nLista dos Funcionários Com Bônus");
        for (FuncionarioComBonus f : listaFuncBonus){
            System.out.println(f);
        }
    }

    public Double calculaTotalBonus(){
        Double total = 0.0;
        for (FuncionarioComBonus f : listaFuncBonus){
            total += f.getValorBonus();
        }
        return total;
    }




}
