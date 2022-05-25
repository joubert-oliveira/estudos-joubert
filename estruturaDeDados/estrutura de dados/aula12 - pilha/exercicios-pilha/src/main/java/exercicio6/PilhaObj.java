package exercicio6;

public class PilhaObj<T> {

    // Atributos
    private T[] pilha;
    private int topo;

    // Construtor
    public PilhaObj(int capacidade) {
        pilha = (T[]) new Object[capacidade];
        topo = -1;
    }

    // Métodos
    public Boolean isEmpty() {
        return topo == -1;
    }

    public Boolean isFull() {
        return topo == pilha.length-1;
    }

    public void push(T info) {
        if (isFull()) {
            System.out.println("Pilha cheia!");
        }
        else {
            pilha[++topo] = info;
        }
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return pilha[topo--];
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return pilha[topo];
    }

    public void exibe() {
        if (isEmpty()) {
            System.out.println("Pilha vazia");
        }
        else {
            for (int i = topo; i >= 0; i--) {
                System.out.println(pilha[i]);
            }
        }
    }

    public void multiPush(PilhaObj<T> aux){

        while (!aux.isEmpty()){

            if(topo + aux.topo < pilha.length-1){

                pilha[++topo] = aux.pop();

            }else{

                System.out.println("A pilha encheu!");
                return;

            }

        }

    }

    public PilhaObj<T> multiPop (int n){

        PilhaObj pilhaAuxiliar = new PilhaObj<T>(n);

        if(n > pilha.length){

            return null;

        }

        while (n != 0){

            pilhaAuxiliar.push(pilha[topo--]);
            n--;

        }

        return pilhaAuxiliar;

    }

    public T removeIndice(int n){

        PilhaObj<T> p = new PilhaObj<T>(n);

        p = multiPop(n);

        T teste = pop();

        multiPush(p);

        return teste;

    }

}
