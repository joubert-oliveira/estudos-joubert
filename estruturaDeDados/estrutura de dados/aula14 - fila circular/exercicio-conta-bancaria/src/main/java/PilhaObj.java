public class PilhaObj<T> {

    private T[] pilha;
    private int topo;

    public PilhaObj(int capacidade) {
        topo = -1;
        pilha = (T[]) new Object[capacidade];
    }

    public Boolean isEmpty() {
        return topo == -1;
    }

    public Boolean isFull() {
        return topo == pilha.length - 1;
    }

    public void push(T info) {
        if (isFull()) {
            throw new IllegalStateException("Pilha cheia!");
        } else {
            pilha[++topo] = info;
        }
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia!");
            return null;
        }
        return pilha[topo--];
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia!");
            return null;
        }
        return pilha[topo];
    }

    public void exibe() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia!");
        } else {
            for (int i = topo; i >= 0; i--) {
                System.out.println(pilha[i]);
            }
        }
    }

}
