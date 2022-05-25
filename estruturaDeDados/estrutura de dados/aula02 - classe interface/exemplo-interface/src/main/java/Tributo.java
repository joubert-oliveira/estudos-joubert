import java.util.ArrayList;
import java.util.List;

public class Tributo {

    // Atributos
    private List<Tributavel> listaTrib;

    // Construtor
    public Tributo() {
        this.listaTrib = new ArrayList<>();
    }

    // Métodos
    public void adicionaTributavel(Tributavel t){
        listaTrib.add(t);
    }

    public Double calculaTotalTributo(){
        Double total = 0.0;
        for (Tributavel t : listaTrib){
            total += t.getValorTributo();
        }
        return total;
    }

    public void exibirTodos(){
        System.out.println("\nLista dos itens tributáveis");
        for (Tributavel t : listaTrib){
            System.out.println(t);
        }
    }
}
