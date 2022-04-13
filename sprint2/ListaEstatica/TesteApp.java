public class TesteApp {

    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(5);

        lista.adiciona(10);
        lista.adiciona(20);
        lista.adiciona(30);
        lista.adiciona(40);
        lista.exibeTodos();

        System.out.println();

        lista.substitui(10,11);
        lista.substitui(20,21);
        lista.substitui(30,31);
        lista.substitui(40,41);
        lista.exibeTodos();

        System.out.println();

        lista.adicionaNoInicio(13);
        lista.exibeTodos();

    }
}