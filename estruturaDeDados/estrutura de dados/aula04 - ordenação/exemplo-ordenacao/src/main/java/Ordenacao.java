public class Ordenacao {

    private int trocas = 0;
    int trocaSelection = 0;
    private int comparacoes = 0;

    public int getTrocas() {
        return trocas;
    }

    public int getComparacoes() {
        return comparacoes;
    }

    public void selectionSort(int[] vetor){

        for(int i = 0; i< vetor.length; i++){
            int menorValor = vetor[i];
            int indiceMenorValor = i;

            for(int j = i+1; j < vetor.length; j++){

                if(menorValor > vetor[j]){

                    menorValor = vetor[j];
                    indiceMenorValor = j;

                }
                comparacoes++;
            }
            int buffer = vetor[i];
            vetor[i] = menorValor;
            vetor[indiceMenorValor] = buffer;
            trocaSelection++;
        }

    }

    public int[] bubbleSort(int[] vetor){

        int tamanhoVetor = vetor.length;

        for(int i = 0; i != tamanhoVetor; tamanhoVetor--) {
            for (int j = 0; j < tamanhoVetor; j++) {

                if (j + 1 >= tamanhoVetor) {


                } else if (vetor[j] > vetor[j + 1]) {

                    int buffer = vetor[j];
                    int buffer2 = vetor[j + 1];

                    vetor[j] = buffer2;
                    vetor[j + 1] = buffer;
                    trocas++;
                }
            }
        }

        return vetor;
    }

}
