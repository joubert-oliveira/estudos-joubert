public class FilaObj<T> {

    // Atributos
    private int tamanho;
    private T[] fila;

    // Construtor
    public FilaObj(int capacidade) {
        tamanho = 0;
        fila = (T[]) new Object[capacidade];
    }

    // Métodos

    // Retorna true se a fila está vazia e false caso contrário
    public boolean isEmpty() {
        return tamanho == 0;
    }

    // Retorna true se a fila está cheia e false caso contrário
    public boolean isFull() {
        return tamanho == fila.length;
    }

    // Se a fila não estiver cheia, insere info na fila
    // Se a fila estiver cheia, deve lançar IllegalStateException
    public void insert(T info) {
        if (isFull()) {
            throw new IllegalStateException("Fila cheia!");
        } else {
            fila[tamanho++] = info;
        }
    }

    // Retorna o primeiro da fila
    public T peek() {
        return fila[0];
    }

    // Remove e retorna o primerio elemento da fila
    // Antes de retorna, se a fila não estiver vazia, deve fazer a fila "andar"
    public T poll() {
        T primeiroElemnto = peek();

        if (!isEmpty()) {
            for (int i = 0; i < tamanho - 1; i++) {
                fila[i] = fila[i + 1];
            }
            fila[tamanho - 1] = null;
            tamanho--;
        }
        return primeiroElemnto;
    }

    // Exibe os elementos da fila
    public void exibe() {
        if (isEmpty()) {
            System.out.println("Fila vazia!");
        } else {
            System.out.println("\n Elementos da fila");
            for (int i = 0; i < tamanho - 1; i++) {
                System.out.println(fila[i]);
            }
        }
    }

    // Retorna o vetor fila
    public T[] getFila() {
        return fila;
    }
}