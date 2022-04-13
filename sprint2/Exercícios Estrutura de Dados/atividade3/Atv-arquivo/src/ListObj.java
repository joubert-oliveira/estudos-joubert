public class ListObj<T> {
    private T[] vetor;
    private int numElem;

    public ListObj(int lengt){
        vetor = (T[]) new Object[lengt];
        numElem = 0;
    }


    public void adicionar(T obj){
        if (numElem >= vetor.length){
            System.out.println("Vetor cheio");
        } else {
            vetor[numElem++] = obj;
        }
    }

    public void exibir() {
        if (numElem == 0){
            System.out.println("Lista vazia");
        } else {
            for (int i = 0; i < numElem; i++){
                System.out.println(vetor[i]);
            }
        }
    }

    public int buscarObj(T objBuscado){
        for (int i = 0; i < numElem; i++){
            if (vetor[i].equals(objBuscado)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removePeloIndice (int indice){
        if (indice < 0 || indice >= numElem) {
            System.out.println("\nIndice invalido!");
            return false;
        }
        for (int i = indice; i < numElem; i++){
            vetor[i] = vetor[i+1];
        }

        numElem--;
        return true;
    }

    public Boolean removerObj (T objRemover) {return removePeloIndice(buscarObj(objRemover));}

    public int getTamanho() { return numElem; }

    public T getObj( int indice) {
        if (indice < 0 || indice >= numElem) {
            return null;
        }else {
            return vetor[indice];
        }
    }

    public void limpar() {numElem = 0;}

    public int filmesPorGenero(String genero) {
        int contador = 0;
        for (int i = 0; i < numElem; i++){
            if (vetor[i] instanceof Filme){
                if (((Filme) vetor[i]).getGenero().equalsIgnoreCase(genero))
                    contador++;
            }
        }
        return contador;
    }
}
