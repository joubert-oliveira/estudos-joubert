public class ListaEstatica {

    private int numElem;
    private int[] vetor;

    public ListaEstatica(int tam) {
        this.numElem = 0;
        this.vetor = new int[tam];
    }

    public void adiciona(int element) {
        if (this.numElem <= vetor.length) {
            vetor[numElem] = element;
            numElem++;
            System.out.println("Número adicionado com sucesso");
        } else {
            System.out.println("Vetor cheio");
        }
    }

    public void exibeTodos() {
        if (numElem != 0) {
            for (int i = 0; i < numElem; i++) {
                System.out.println(vetor[i]);
            }
        } else {
            System.out.println("Vetor vazio");
        }
    }

    public int busca(int procura) {
        for (int i = 0; i < numElem; i++) {
            if (vetor[i] == procura) {
                System.out.println("item no índice " + i);
                return i;
            }
            System.out.println("Item não encontrado");
        }
        return -1;
    }

    public boolean removePeloIndice(int indice) {
        if (indice >= 0 && indice < numElem) {
            for (int i = indice; i < numElem - 1; i++) {
                vetor[i] = vetor[i + 1];
            }
            numElem--;
            return true;
        }
        return false;
    }

    public boolean removePelaBusca(int busca){
        return removePeloIndice(busca(busca)) ;
    }

    public boolean substitui(int valorAntigo, int valorNovo) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == valorAntigo) {
                vetor[i] = valorNovo;
                return true;
            }
        }
        System.out.println("Valor não encontrado");
        return false;
    }

    public int contaOcorrencias(int valor) {
        int contador = 0;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == valor) {
                contador++;
            }
        }
        return contador;
    }

    public boolean adicionaNoInicio(int valor) {
        if (vetor.length == numElem) {
            System.out.println("Lista cheia");
            return false;
        }
        for (int i = numElem - 1; i >= 0; i--) {
            vetor[i + 1] = vetor[i];
        }
        numElem++;
        vetor[0] = valor;
        return true;
    }

}

