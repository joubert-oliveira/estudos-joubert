import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilaPilhaTest {
  // Testando Fila
  @Test
  public void isFullTrueQuandoFilaPreenchida() {
    FilaObj<Integer> filaTest = new FilaObj(5);
    filaTest.insert(10);
    assertFalse(filaTest.isFull());
    filaTest.insert(20);
    assertFalse(filaTest.isFull());
    filaTest.insert(30);
    assertFalse(filaTest.isFull());
    filaTest.insert(40);
    assertFalse(filaTest.isFull());
    filaTest.insert(50);
    assertTrue(filaTest.isFull());
  }

  @Test
  public void isEmptyQuandoFilaVazia() {
    FilaObj<Integer> filaTest = new FilaObj(8);
    assertTrue(filaTest.isEmpty());
    filaTest.insert(10);
    filaTest.insert(20);
    filaTest.insert(30);
    filaTest.insert(40);
    filaTest.insert(50);
    filaTest.insert(60);
    filaTest.insert(70);
    assertFalse(filaTest.isEmpty());
    filaTest.poll();
    assertFalse(filaTest.isEmpty());
    filaTest.poll();
    assertFalse(filaTest.isEmpty());
    filaTest.poll();
    assertFalse(filaTest.isEmpty());
    filaTest.poll();
    assertFalse(filaTest.isEmpty());
    filaTest.poll();
    assertFalse(filaTest.isEmpty());
    filaTest.poll();
    assertFalse(filaTest.isEmpty());
    filaTest.poll();
    assertTrue(filaTest.isEmpty());
  }

  @Test
  public void peekQuandoFilaRetornaDez() {
    FilaObj<Integer> filaTest = new FilaObj(3);
    filaTest.insert(10);
    filaTest.insert(20);
    filaTest.insert(30);
    assertEquals(10, filaTest.peek());
  }

  @Test
  public void poolQuandoFilaRetornaDez() {
    FilaObj<Integer> filaTest = new FilaObj(3);
    filaTest.insert(10);
    filaTest.insert(20);
    filaTest.insert(30);
    assertEquals(10, filaTest.poll());
  }

  @Test
  public void poolQuandoFilaRetornaVinte() {
    FilaObj<Integer> filaTest = new FilaObj(3);
    filaTest.insert(10);
    filaTest.insert(20);
    filaTest.insert(30);
    assertEquals(10, filaTest.poll());
    assertEquals(20, filaTest.poll());
  }

  @Test
  public void insertLancaIllegalStateExceptionQuandoFilaCheia() {
    FilaObj<Integer> filaTest = new FilaObj(6);
    filaTest.insert(30);
    filaTest.insert(40);
    filaTest.insert(50);
    filaTest.insert(60);
    filaTest.insert(70);
    filaTest.insert(80);
    assertThrows(IllegalStateException.class, () -> filaTest.insert(90));
  }

  @Test
  public void insertQuandoFilaRetornaDez() {
    FilaObj<Integer> filaTest = new FilaObj(6);
    filaTest.insert(10);
    assertEquals(10, filaTest.peek());
    filaTest.insert(20);
    assertEquals(10, filaTest.peek());
    filaTest.insert(30);
    assertEquals(10, filaTest.peek());
    filaTest.insert(40);
    assertEquals(10, filaTest.peek());
  }

  // Testando Pilha
  @Test
  public void isFullTrueQuandoPilhaPreenchida() {
    PilhaObj<Integer> pilhaTest = new PilhaObj<>(5);
    pilhaTest.push(10);
    assertFalse(pilhaTest.isFull());
    pilhaTest.push(20);
    assertFalse(pilhaTest.isFull());
    pilhaTest.push(30);
    assertFalse(pilhaTest.isFull());
    pilhaTest.push(40);
    assertFalse(pilhaTest.isFull());
    pilhaTest.push(50);
    assertTrue(pilhaTest.isFull());
  }

  @Test
  public void isEmptyQuandoPilhaVazia() {
    PilhaObj<Integer> pilhaTest = new PilhaObj<>(8);
    assertTrue(pilhaTest.isEmpty());
    pilhaTest.push( 10);
    pilhaTest.push(20);
    pilhaTest.push(30);
    pilhaTest.push(40);
    pilhaTest.push(50);
    pilhaTest.push(60);
    pilhaTest.push(70);
    assertFalse(pilhaTest.isEmpty());
    pilhaTest.pop();
    assertFalse(pilhaTest.isEmpty());
    pilhaTest.pop();
    assertFalse(pilhaTest.isEmpty());
    pilhaTest.pop();
    assertFalse(pilhaTest.isEmpty());
    pilhaTest.pop();
    assertFalse(pilhaTest.isEmpty());
    pilhaTest.pop();
    assertFalse(pilhaTest.isEmpty());
    pilhaTest.pop();
    assertFalse(pilhaTest.isEmpty());
    pilhaTest.pop();
    assertTrue(pilhaTest.isEmpty());
  }

  @Test
  public void peekQuandoPilhaIndiceDoisRetornaTrinta() {
    PilhaObj<Integer> pilhaTest = new PilhaObj<>(6);
    pilhaTest.push(10);
    pilhaTest.push(20);
    pilhaTest.push(30);
    assertEquals(30, pilhaTest.peek());
  }

  @Test
  public void popQuandoPilhaRetornaTrinta() {
    PilhaObj<Integer> pilhaTest = new PilhaObj<>(6);
    pilhaTest.push(10);
    pilhaTest.push(20);
    pilhaTest.push(30);
    assertEquals(30, pilhaTest.pop());
  }

  @Test
  public void pushLancaIllegalStateExceptionQuandoPilhaCheia() {
    PilhaObj<Integer> pilhaTest = new PilhaObj<>(6);
    pilhaTest.push(30);
    pilhaTest.push(40);
    pilhaTest.push(50);
    pilhaTest.push(60);
    pilhaTest.push(70);
    pilhaTest.push(80);
    assertThrows(IllegalStateException.class, () -> pilhaTest.push(90));
  }

  @Test
  public void pushQuandoPilhaRetornaTrinta() {
    PilhaObj<Integer> pilhaTest = new PilhaObj<>(6);
    pilhaTest.push(10);
    assertEquals(10, pilhaTest.peek());
    pilhaTest.push(20);
    assertEquals(20, pilhaTest.peek());
    pilhaTest.push(30);
    assertEquals(30, pilhaTest.peek());
  }


  @Test
  public void desafio01() {
    int[] vetor = {2, 7, -3, -50, 45, -4, 30, -21, 38};
    int[] vetorOrdenado = {2, 7, 45, 30, 38, -3, -50, -4, -21};


    Exercicio desafio01 = new Exercicio();
    int[] vetorTeste = desafio01.separaPositivoNegativoEmOrdem(vetor);

    for (int i = 0; i < vetor.length; i++){
      assertEquals(vetorOrdenado[i], vetorTeste[i]);
    }
  }

  @Test
  public void desafio02() {
    int[] vetor = {2, 7, -3, -50, 45, -4, 30, -21, 38};
    int[] vetorOrdenado = {2, 7, 45, 30, 38, -21, -4, -50, -3};

    Exercicio desafio02 = new Exercicio();
    int[] vetorTeste = desafio02.separaPositivoNegativoOrdemDiferente(vetor);

    for (int i = 0; i < vetor.length; i++){
      assertEquals(vetorOrdenado[i], vetorTeste[i]);
    }
  }
}
