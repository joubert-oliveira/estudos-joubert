import java.util.Arrays;

public class ListaEstatica {
    int [] vetor;
    int indice = 0;

    public ListaEstatica(int tam) {
        vetor = new int[tam];
    }

    public void adiciona(int num){

        if(indice == vetor.length){

            System.out.println("Lista cheia, não foi possivel adicionar o "+ num);

        }else{

            vetor[indice] = num;
            indice++;

        }
    }

    public void exibir(){

        StringBuilder str = new StringBuilder();

        str.append("[");
        for(int i = 0; i < indice; i++){
            str.append(vetor[i]);

            if(!(i+1 >= indice)){

                str.append(" ,");

            }
        }
        str.append("]");

        System.out.println(str);

    }

    public int buscar(int num){

        for(int i = 0; i < indice; i++){

            if(vetor[i] == num){

                return i;

            }

        }
        return -1;
    }

    public boolean removePeloIndice(int indiceEscolhido){

        if(!(indiceEscolhido > 0 && indiceEscolhido < vetor.length)){

            System.out.println("Indice inválido");

        }else{

            retirarElemento(indiceEscolhido);

            return true;
        }
        return false;
    }

    public boolean removeElemento(int elemento){

        return removePeloIndice(buscar(elemento));

    }

    public boolean substituirElemento(int elementoAntigo, int elementoNovo){

        int indiceProvisorio = buscar(elementoAntigo);

        if(indiceProvisorio !=-1){

            vetor[indiceProvisorio] = elementoNovo;

            return true;
        }

        return false;

    }

    public int contaOcorrencias(int elemento){

        int cont = 0;

        for(int i =0; i < indice; i++){

            if(vetor[i] == elemento){

                cont++;

            }
        }

        return cont;
    }

    public boolean adicionarInicio(int num){

        boolean retorno = false;

        if(indice == vetor.length){

            System.out.println("Lista cheia, não foi possivel adicionar o "+ num);

        }else{

            int [] vetorProvisorio = new int[indice];

            for(int i = 0; i < indice; i++){

                vetorProvisorio[i] = vetor[i];

            }

            indice++;

            vetor = new int[vetor.length];
            vetor[0] = num;


            for(int i = 1; i < indice; i++){

                    vetor[i] = vetorProvisorio[i-1];
            }

            retorno = true;

        }
        return retorno;
    }

    public void limpar(){

        indice = 0;
        System.out.println("Vetor Limpo com sucesso.");

    }

    private void retirarElemento(int indiceElemento){

        for(int i = indiceElemento ; i < indice ; i++){

            if((i+1) < indice) {

                int buffer = vetor[i];
                vetor[i] = vetor[i + 1];
                vetor[i+1] = buffer;

            }
        }
        indice--;

    }
}
