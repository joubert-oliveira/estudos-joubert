public class Teste {

    public static void separaPositivoNegativoEmOrdem(int[] vetor){

        FilaObj<Integer> positivos = new FilaObj<>(vetor.length);
        FilaObj<Integer> negativos = new FilaObj<>(vetor.length);

        for (int i : vetor){
            if (i < 0){
                negativos.insert(i);
            }else {
                positivos.insert(i);
            }
        }

        System.out.print("[");
        while (!positivos.isEmpty()) {
            System.out.print(positivos.poll() + " ");
        }
        while (!negativos.isEmpty()) {
            System.out.print(negativos.poll() + " ");
        }
        System.out.print("]");
    }

    public static void separaPositivoNegativoOrdemDiferente(int[] vetor){

        FilaObj<Integer> positivos = new FilaObj<>(vetor.length);
        PilhaObj<Integer> negativos = new PilhaObj<>(vetor.length);

        for (int i : vetor){
            if (i < 0){
                negativos.push(i);
            }else {
                positivos.insert(i);
            }
        }

        System.out.print("[");
        while (!positivos.isEmpty()) {
            System.out.print(positivos.poll() + " ");
        }
        while (!negativos.isEmpty()) {
            System.out.print(negativos.pop() + " ");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {

        int[] vetor = {2,7,-3,-50,45,-4,30,-21,38};

        separaPositivoNegativoEmOrdem(vetor);
        System.out.println("\n");
        separaPositivoNegativoOrdemDiferente(vetor);

    }
}
