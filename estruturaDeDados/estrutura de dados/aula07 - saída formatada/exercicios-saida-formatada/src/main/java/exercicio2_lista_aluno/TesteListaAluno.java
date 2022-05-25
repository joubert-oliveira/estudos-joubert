package exercicio2_lista_aluno;

import java.util.Scanner;

public class TesteListaAluno {
    public static void main(String[] args) {

        Integer opcao = 0;

        Integer indice;

        Integer ra;
        String nome;
        Double nota;

        Boolean fim = false;

        Scanner leitor = new Scanner(System.in); // nextInt(), nextDouble()
        Scanner leitorNL = new Scanner(System.in); // nextLine()

        ListaObj<Aluno> lista = new ListaObj<>(10);

        while (!fim){
            System.out.println("MENU");
            System.out.println("1 - Adicionar um aluno");
            System.out.println("2 - Exibir a lista");
            System.out.println("3 - Exibir um aluno da lista");
            System.out.println("4 - Limpar a lista");
            System.out.println("5 - Buscar um aluno pelo RA");
            System.out.println("6 - Fim");
            opcao = leitor.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Digite o RA:");
                    ra = leitor.nextInt();
                    System.out.println("Digite o nome:");
                    nome = leitorNL.nextLine();
                    System.out.println("Digite a nota:");
                    nota = leitor.nextDouble();
                    Aluno aluno1 = new Aluno(ra, nome, nota);
                    lista.adiciona(aluno1);
                    break;
                case 2:
                    System.out.printf("%-10s %-30s %5s", "RA", "NOME", "NOTA\n");
                    lista.exibe();
                    break;
                case 3:
                    System.out.println("Digite o índice que deseja:");
                    indice = leitor.nextInt();
                    System.out.printf("%-10s %-30s %5s", "RA", "NOME", "NOTA\n");
                    lista.getElemento(indice);
                    System.out.println(lista.getElemento(indice));
                    break;
                case 4:
                    lista.limpa();
                    break;
                case 5:
                    System.out.println("Pesquise um RA:");
                    ra = leitor.nextInt();
                    Boolean validar = false;
                    System.out.printf("%-10s %-30s %5s", "RA", "NOME", "NOTA\n");
                    for (int i = 0; i < lista.getTamanho(); i++){
                        if (lista.getElemento(i).getRa().equals(ra)){
                            System.out.println(lista.getElemento(i));
                            validar = true;
                        }
                    }
                    if (!validar){
                        System.out.println("Aluno não encontrado!");
                    }
                    break;
                case 6:
                    fim = true;
                    break;
                default:
                    System.out.println("Opção Inválida");
            }

            }

        }
    }

