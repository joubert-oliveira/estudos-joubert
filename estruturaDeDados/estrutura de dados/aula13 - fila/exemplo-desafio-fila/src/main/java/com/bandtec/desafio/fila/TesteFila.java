package com.bandtec.desafio.fila;

public class TesteFila {

    public static void main(String[] args) {

        // Cria um objeto Fila
        FilaString fila = new FilaString(5);

        // Insere elementos na fila
        fila.insert("A");
        fila.insert("B");
        fila.insert("C");
        fila.insert("D");
        fila.insert("E");
        fila.insert("F");

        // Exibe a fila
        fila.exibe();

        // Exibe o primeiro da fila, sem remover
        System.out.println("Primeiro da fila: " + fila.peek());

        // Exibe a fila
        fila.exibe();

        // Remove um elemento da fila
        System.out.println("Removeu da fila: " + fila.poll());

        fila.insert("F");

        // Exibe a fila
        fila.exibe();

        // Esvazia a fila, exibindo um a um
        while (!fila.isEmpty()) {
            System.out.println("Removeu: " + fila.poll());
        }

    }
}
