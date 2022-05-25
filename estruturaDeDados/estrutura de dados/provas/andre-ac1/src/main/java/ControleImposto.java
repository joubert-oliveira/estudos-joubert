import java.util.ArrayList;
import java.util.List;

public class ControleImposto {

    // Atributos
    private List<Tributavel> listaTrib;

    // Construtor
    public ControleImposto() {
        this.listaTrib = new ArrayList<>();
    }

    // Métodos

    // adicionar tributavel na lista
    public void adicionarTributavel(Tributavel t){
        listaTrib.add(t);
    }

    // calcula total de impostos
    public Double calculaTotalImpostos(){
        Double total = 0.0;
        for (Tributavel t : listaTrib){
            total += t.getValorImposto();
        }
        return total;
    }

    // exibe todos os objetos que contém impostos
    public void exibirTodosObjetosImpostos(){
        System.out.println("\nLista dos itens tributáveis");
        for (Tributavel t : listaTrib){
            System.out.println(t);
        }
    }

}
