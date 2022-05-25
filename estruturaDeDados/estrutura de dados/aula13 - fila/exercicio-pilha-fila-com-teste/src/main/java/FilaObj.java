public class FilaObj<T> {

    private int tamanho;
    private T[] fila;

    public FilaObj(int capacidade) {
        tamanho = 0;
        fila =(T[]) new Object[capacidade];
    }
    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == fila.length;
    }

    public void insert(T info) {
        if (isFull()){
            throw new IllegalStateException("Fila cheia!");
        } else{
            fila[tamanho++] = info;
        }
    }

    public T peek() {
        if (isEmpty()){
            return null;
        } else{
            return fila[0];
        }
    }

    public T poll() {
        T primeiroElemento = peek();

        if (!isEmpty()){
            for (int i = 0; i < tamanho - 1; i++) {
                fila[i] = fila[i+1];
            }
            fila[tamanho -1] = null;
            tamanho--;
        }
       return primeiroElemento;
    }

    public void exibe() {
        if (isEmpty()){
            System.out.println("A fila está vazia!");
        } else{
            System.out.println("\nElementos da fila:");
            for (int i = 0; i < tamanho -1; i++) {
                System.out.println(fila[i]);
            }
        }
    }

    public T[] getFila() {
        return fila;
    }
}
