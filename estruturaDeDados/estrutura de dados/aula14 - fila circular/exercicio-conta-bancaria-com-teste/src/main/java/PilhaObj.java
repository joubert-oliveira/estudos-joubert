public class PilhaObj<T> {

    // Atributos
    private T[] pilha;
    private int topo;

    // Construtor
    public PilhaObj(int capacidade) {
        topo = -1;
        pilha = (T[]) new Object[capacidade];
    }

    // Métodos

    // Retorna true se a pilha estiver vazia e false caso contrário
    public Boolean isEmpty() {
        return topo == -1;
    }

    // Retorna true se a pilha estiver cheia e false caso contrário
    public Boolean isFull() {
        return topo == pilha.length - 1;
    }

    // Se a pilha estiver cheia, deve lançar IllegalStateException
    // Se a pilha não estiver cheia, empilha info
    public void push(T info) {
        if (isFull()) {
            throw new IllegalStateException("Pilha cheia!");
        } else {
            pilha[++topo] = info;
        }
    }

    // Desempilha e retorna o elemento do topo da pilha
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return pilha[topo--];
    }

    // Retorna o elemento do topo da pilha, sem desempilhar
    public T peek() {
        return pilha[topo];
    }

    // Exibe o conteúdo da pilha
    public void exibe() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia!");
        } else {
            for (int i = topo; i >= 0; i++) {
                System.out.println(pilha[i]);
            }
        }
    }

}