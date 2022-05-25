import java.util.Arrays;

public class ListaEstaticaOrdenada extends ListaEstatica{

    public ListaEstaticaOrdenada(int tam) {
        super(tam);
    }

    @Override
    public void adiciona(int num) {

        int comparacoes = 0;
        int inciceProvisorio = 0;

        if(indice == vetor.length){

            System.out.println("Lista cheia, não foi possivel adicionar o "+ num);
            return;
        }

        if(indice == 0){

            vetor[indice] = num;
            indice++;
            return;

        }

        if(num <= vetor[0]){

            adicionarInicio(num);
            return;
        }

        for(int i =1; i < indice; i++){

            if(vetor[i] > num){

                inciceProvisorio = i;
                break;

            }else{

                comparacoes++;

            }
        }


        if(comparacoes == indice-1){

            vetor[indice++] = num;
            return;

        }

        int [] vetorProvisorio = new int[vetor.length];

        for(int i = inciceProvisorio; i < indice; i++){

            vetorProvisorio[i] = vetor[i];

        }

        indice++;

        vetor[inciceProvisorio] = num;

        for(int i = inciceProvisorio+1; i < indice; i++){

            vetor[i] = vetorProvisorio[i-1];
        }

    }
}
