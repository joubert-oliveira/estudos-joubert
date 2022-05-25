public class FilaCircular {
    int tamanho, inicio, fim;
    String[] fila;

    // Construtor - Recebe a capacidade da fila (tamanho total do vetor)
    public FilaCircular(int capacidade) {
        // Cria o vetor para armazenar a fila e inicializa o tamanho
        fila = new String[capacidade];
        tamanho = 0;
        inicio = 0;
        fim = 0;
    }

    // Método isEmpty() - Retorna true se a fila está vazia e false caso contrário
    public boolean isEmpty() {
        return tamanho == 0;
    }

    // Método isFull() - Retorna true se a fila está cheia e false caso contrário
    public boolean isFull() {
        return tamanho >= fila.length;
    }

    // Método insert - Recebe informação a ser inserida na fila
    public void insert(String info) {
        if (isFull()) {
            throw new IllegalStateException("Fila Circular cheia!");
        } else {
            fila[fim] = info;
            fim = (fim + 1) % fila.length;
            tamanho++;
        }
    }

    // Método peek() - Retorna o primeiro da fila, sem remover
    public String peek() {
        return fila[inicio];
    }

    // Método poll() - Retorna o primeiro da fila, removendo-o
    public String poll() {
        String primeiroElemento = fila[inicio];
        if (!isEmpty()) {
            fila[inicio] = null;
            inicio = (inicio + 1) % fila.length;
            tamanho--;
        }
        return primeiroElemento;
    }

    // Método exibe() - exibe os elementos da fila
    public void exibe() {
        if (isEmpty()) {
            System.out.println("Fila Circular vazia!");
        } else {
            System.out.println("\n----------Fila----------\n");
            for (int i = 0, indice = inicio; i < tamanho; i++) {
                System.out.println(fila[indice]);
                indice = (indice + 1) % fila.length;
            }
            System.out.println("\n------------------------\n");
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getInicio() {
        return inicio;
    }

    public int getFim() {
        return fim;
    }

    // Cria um vetor e percorre a fila adicionando os elementos no vetor (
    // Retorna o vetor criado e não a fila
    public String[] getFila() {
        String[] vetor = new String[fila.length];
        int indiceVetor = 0;

        System.out.println("\n----------Fila----------\n");
        for (int i = 0, indice = inicio; i < tamanho; i++) {
            vetor[indiceVetor] = fila[indice];
            indice = indice + 1 % fila.length;
            indiceVetor++;
        }
        System.out.println("\n------------------------\n");

        return vetor;
    }
}
