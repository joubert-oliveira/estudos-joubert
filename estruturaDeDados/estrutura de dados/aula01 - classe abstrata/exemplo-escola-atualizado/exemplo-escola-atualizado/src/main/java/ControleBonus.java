import java.util.ArrayList;
import java.util.List;

public class ControleBonus {

    // Atributos
    private List<Educadores> listaEducadores;

    // Construtor
    public ControleBonus() {
        this.listaEducadores = new ArrayList<>();
    }

    // Métodos
    // Adicionar educador na lista
    public void adicionarEducador(Educadores educador){
        listaEducadores.add(educador);
    }

    // Exibir todos da lista
    public void exibirTodos(){
        System.out.println("\nLista dos Funcionários Com Bônus");
        for (Educadores educador : listaEducadores){
            System.out.println(educador);
        }
    }

    // Total do bonus dos educadores
    public Double calculaTotalBonus(){
        Double total = 0.0;
        for (Educadores educador : listaEducadores){
            total += educador.getValorBonus();
        }
        return total;
    }



}
