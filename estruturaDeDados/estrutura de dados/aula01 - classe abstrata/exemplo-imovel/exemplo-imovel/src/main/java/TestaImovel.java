import java.sql.SQLOutput;

public class TestaImovel {
    public static void main(String[] args) {

        Predio predio1 = new Predio(10, "Bahia", 150.55, 18);
        Casa casa1 = new Casa(8, "São Paulo", 300.00, "Possui quintal com frutas e flores");
        Fazenda fazenda1 = new Fazenda(20, "Sorocaba", 575.50, "Possui cavalos, porcos e galinhas");

        Favorito listaFavoritos = new Favorito();

        listaFavoritos.adicionarImovel(predio1);
        listaFavoritos.adicionarImovel(casa1);
        listaFavoritos.adicionarImovel(fazenda1);
        listaFavoritos.exibirTodos();

        System.out.printf("\nTotal do valor dos Imoveis \nR$ %.2f reais", listaFavoritos.calculaValorTotalImovel());

    }
}
