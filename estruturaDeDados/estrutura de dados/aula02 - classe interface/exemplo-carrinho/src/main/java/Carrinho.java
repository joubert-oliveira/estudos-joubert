import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    // Atributos
    private List<Vendavel> cart;

    // Construtor
    public Carrinho() {
        cart = new ArrayList<Vendavel>();
    }

    // Métodos
    public void adicionarVendavel(Vendavel v){
        cart.add(v);
    }

    public Double calculaTotalVenda(){
        Double total = 0.0;
        for (Vendavel c : cart){
            total += c.getValorVenda();
        }
        return total;
    }

    public void exibiItensCarrinho(){
        System.out.println("\nLista das Vendas");
        for (Vendavel c : cart){
            System.out.println(c);
        }
    }
}
