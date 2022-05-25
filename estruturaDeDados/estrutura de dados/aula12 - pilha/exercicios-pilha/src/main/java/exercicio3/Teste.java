package exercicio3;

public class Teste {
    public static void main(String[] args) {
        PilhaObj<String> pilha = new PilhaObj(5);
        pilha.push("10");
        pilha.push("20");
        pilha.push("30");
        pilha.push("40");
        pilha.push("50");

        pilha.exibe();

        while (!pilha.isEmpty()) {
            System.out.println("Desempilhou: " + pilha.pop());
        }
    }
}
