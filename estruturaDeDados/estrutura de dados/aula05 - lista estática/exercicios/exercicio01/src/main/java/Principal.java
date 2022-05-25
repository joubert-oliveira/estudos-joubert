public class Principal {
    public static void main(String[] args) {

        ListaEstatica LT = new ListaEstatica(5);

        LT.adiciona(10);
        LT.adiciona(20);
        LT.adiciona(30);
        LT.adiciona(40);
        LT.adiciona(50);

        // -------------------------------------------------------------------
        // Não vai conseguir adicionar pois tá cheio o vetor.
        LT.adiciona(60);

        // -------------------------------------------------------------------
        // Exibindo o vetor
        System.out.println("\n"+"-".repeat(20));
        System.out.println("Vetor Cheio");
        LT.exibir();

        // -------------------------------------------------------------------
        // Removendo o indice 1(20) do vetor
        System.out.println("\n"+"-".repeat(20));
        System.out.println("Removendo o indice 1 (20) do vetor");
        System.out.println("Indice 1 foi removido? "+ LT.removePeloIndice(1));

        // -------------------------------------------------------------------
        // exibindo com o indice 1(20) já removido
        System.out.println("\n"+"-".repeat(20));
        System.out.println("Exibindo com o indice 1(20) já removido");
        LT.exibir();

        // -------------------------------------------------------------------
        // Removendo o 40 do vetor
        System.out.println("\n"+"-".repeat(20));
        System.out.println("Removendo o 40 do vetor");
        System.out.println("Número 40 foi removido? "+ LT.removeElemento(40));

        // -------------------------------------------------------------------
        // Exibindo com 40 já removido
        System.out.println("\n"+"-".repeat(20));
        System.out.println("Exibindo com 40 já removido");
        LT.exibir();

        // -------------------------------------------------------------------
        // Tentando remover o 40 de novo, entretanto ele não tem mais no vetor
        System.out.println("\n"+"-".repeat(20));
        System.out.println("Tentando remover o 40 de novo, entretanto ele não está mais no vetor");
        System.out.println("Número 40 foi removido? "+ LT.removeElemento(40));

        // -------------------------------------------------------------------
        // Exibindo o vetor
        System.out.println("\n"+"-".repeat(20));
        System.out.println("Exibindo o vetor.");
        LT.exibir();

        // -------------------------------------------------------------------
        // Adicionando o 40 de novo no vetor
        System.out.println("\nAdicionando o 40\n");
        LT.adiciona(40);

        // -------------------------------------------------------------------
        // Exibindo o vetor com o 40 de novo
        System.out.println("\n"+"-".repeat(20));
        System.out.println("Exibindo o vetor com o 40 adicionado de novo.");
        LT.exibir();

        // -------------------------------------------------------------------
        // Agora removendo o 40 de novo
        System.out.println("\n"+"-".repeat(20));
        System.out.println("Agora removendo o 40 de novo");
        System.out.println("Número 40 foi removido? "+ LT.removeElemento(40));

        // -------------------------------------------------------------------
        // Exibindo com 40 já removido
        System.out.println("\n"+"-".repeat(20));
        System.out.println("Exibindo com 40 já removido");
        LT.exibir();

        System.out.println("\nAdicionando 3 números no inicio do vetor, o 40, 60 e 70\n");
        LT.adicionarInicio(40);
        LT.adicionarInicio(60);
        LT.adicionarInicio(70);

        // -------------------------------------------------------------------
        // Vetor com o 40 e o 60, adicionados no inicio do vetor
        System.out.println("\n"+"-".repeat(20));
        System.out.println("Vetor com o 40 e o 60, adicionados no inicio do vetor");
        LT.exibir();

        // -------------------------------------------------------------------
        // Substituindo o 30, por 40.
        System.out.println("\n"+"-".repeat(20));
        System.out.println("Substituiu o elemento 30 por 40? "+
                    LT.substituirElemento(30, 40));

        // -------------------------------------------------------------------
        // Exibindo o vetor
        System.out.println("\n"+"-".repeat(20));
        System.out.println("Vetor com o 40 em vez do 30");
        LT.exibir();

        // -------------------------------------------------------------------
        // Mostrando quantas vezes que aparece o 40.
        System.out.println("\n"+"-".repeat(20));
        System.out.println("Aparece o 40 "+LT.contaOcorrencias(40)+" vezes");

        // -------------------------------------------------------------------
        // Limpando o vetor
        System.out.println("\n"+"-".repeat(20));
        System.out.println("Limpando o Vetor");
        LT.limpar();

        // Criando Objeto da classe Lista Ordenada.
        ListaEstaticaOrdenada LTOrdenada = new ListaEstaticaOrdenada(5);

        // Adicionando os números de forma desordenada
        LTOrdenada.adiciona(4);
        LTOrdenada.adiciona(30);
        LTOrdenada.adiciona(10);
        LTOrdenada.adiciona(20);
        LTOrdenada.adiciona(4);

        LTOrdenada.exibir();

    }
}
