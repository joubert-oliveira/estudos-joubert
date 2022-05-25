package exercicio2_lista_aluno_arquivo_csv;

public class ListaObj <T> {


    // Atributos
    private T[] vetor;        // Vetor onde será armazenada a lista
    private int nroElem;        // tem dupla função: representa qtos elementos foram adicionados
    // e tb o índice de onde será adicionado o próximo elemento

    // Construtor
    // Recebe como argumento o tamanho máximo do vetor
    public ListaObj(int tamanho) {
        vetor = (T[]) new Object[tamanho];   // Cria o vetor
        nroElem = 0;                // Zera nroElem
    }

    // Métodos

    /* Método adiciona - recebe o elemento a ser adicionado na lista
       Se a lista estiver cheia, exibe uma mensagem
     */
    public void adiciona(T elemento) {
        if (nroElem >= vetor.length) {
            System.out.println("Lista está cheia");
        }
        else {
            vetor[nroElem++] = elemento;
        }
    }

    /* Método exibe - exibe os elementos da lista */
    public void exibe() {
        if (nroElem == 0) {
            System.out.println("\nA lista está vazia.");
        }
        else {
//            System.out.println("\nElementos da lista:");
            for (int i = 0; i < nroElem; i++){
                System.out.print(vetor[i]);
            }
            System.out.println();
        }
    }

    /* Método busca - recebe o elemento a ser procurado na lista
       Retorna o índice do elemento, se for encontrado
       Retorna -1 se não encontrou
     */
    public int busca(int elementoBuscado) {
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i].equals(elementoBuscado)) {   // se encontrou
                return i;                        // retorna seu índice
            }
        }
        return -1;    // não encontrou, retorna -1
    }

    /* Método removePeloIndice - recebe o índice do elemento a ser removida
       Se o índice for inválido, retorna false
       Se removeu, retorna true
     */
    public boolean removePeloIndice (int indice) {
        if (indice < 0 || indice >= nroElem) {
            System.out.println("\nÍndice inválido!");
            return false;
        }
        // Loop para "deslocar para a esquerda" os elementos do vetor
        // sobrescrevendo o elemento removido
        for (int i = indice; i < nroElem - 1; i++) {
            vetor[i] = vetor[i+1];
        }
        nroElem--;          // decrementa nroElem
        return true;
    }

    /* Método removeElemento - recebe um elemento a ser removido
       Utiliza os métodos busca e removePeloIndice
       Retorna false, se não encontrou o elemento
       Retorna true, se encontrou e removeu o elemento
     */
    public boolean removeElemento(int elementoARemover) {
        return removePeloIndice(busca(elementoARemover));
    }

    /*
    parte 2 do exercicio

    ver o PDF "ED-05-Exercicio-Lista Estatica"
     */

    public int getTamanho(){
        return nroElem;
    }

    public T getElemento(int indice){
        for (int i = 0; i < nroElem; i++) {
            if (indice < 0 || indice >= nroElem) {   // se encontrou
                return null;                        // retorna seu índice
            }
        }
        return vetor[indice];
    }

    public void limpa(){
        nroElem = 0;
        System.out.println("Lista vazia");
    }



}


