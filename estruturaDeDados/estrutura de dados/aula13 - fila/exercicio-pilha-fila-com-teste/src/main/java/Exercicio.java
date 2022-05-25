public class Exercicio {
  public int[] separaPositivoNegativoEmOrdem(int[] v) {

    FilaObj<Integer> positivos = new FilaObj<>(v.length);
    FilaObj<Integer> negativos = new FilaObj<>(v.length);

    int indice = 0;
    int[] vetorSeparado = new int[v.length];

    for (int i : v){
      if (i < 0){
        negativos.insert(i);
      }else {
        positivos.insert(i);
      }
    }

    while (!positivos.isEmpty()) {
      vetorSeparado[indice] = positivos.poll();
      indice++;
    }
    while (!negativos.isEmpty()) {
      vetorSeparado[indice] = negativos.poll();
      indice++;
    }

    return vetorSeparado;
  }

  public int[] separaPositivoNegativoOrdemDiferente(int[] v) {
    FilaObj<Integer> positivos = new FilaObj<>(v.length);
    PilhaObj<Integer> negativos = new PilhaObj<>(v.length);

    int indice = 0;
    int[] vetorSeparado = new int[v.length];

    for (int i : v){
      if (i < 0){
        negativos.push(i);
      }else {
        positivos.insert(i);
      }
    }

    while (!positivos.isEmpty()) {
      vetorSeparado[indice] = positivos.poll();
      indice++;
    }
    while (!negativos.isEmpty()) {
      vetorSeparado[indice] = negativos.pop();
      indice++;
    }

    return vetorSeparado;
  }
}
