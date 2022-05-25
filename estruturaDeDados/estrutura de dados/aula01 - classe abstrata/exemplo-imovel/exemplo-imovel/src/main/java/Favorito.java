import java.util.ArrayList;
import java.util.List;

public class Favorito {

    // Atributos
    private List<Imovel> listaImovel;

    // Construtor
    public Favorito() {
        this.listaImovel = new ArrayList<>();
    }

    // Métodos
    // Adiconar imovel
    public void adicionarImovel(Imovel i){
        listaImovel.add(i);
    }

    // Exibir todos os imoveis
    public void exibirTodos(){
        System.out.println("\nLista dos Imoveis Favoritos");
        for (Imovel i : listaImovel){
            System.out.println(i);
        }
    }

    // Total dos valores dos imoveis
    public Double calculaValorTotalImovel(){
        Double total = 0.0;
        for (Imovel i : listaImovel){
            total += i.getValorImovel();
        }
        return total;
    }

}
