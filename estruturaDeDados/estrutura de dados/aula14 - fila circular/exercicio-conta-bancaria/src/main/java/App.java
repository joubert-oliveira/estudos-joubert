import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // tipoOperacao = empilhadas para que possam se desfazer
        // agendada = enfileiradas para serem executadas posteriormente, não podendo ser desfeitas

        PilhaObj<Operacao> operacaoPilhaObj = new PilhaObj<>(10);
        FilaObj<Operacao> operacaoFilaObj = new FilaObj<>(10);

        int operaçoesRealizadas = 0; // contador de operações empilhadas

        ContaBancaria conta1 = new ContaBancaria(1211005, 100.00);
        ContaBancaria conta2 = new ContaBancaria(1211061, 500.00);

        boolean fim = false;

        System.out.println(conta1);
        System.out.println(conta2);

        while (!fim) {
            System.out.println("\n----------Menu----------\n" +
                    "1- Debitar valor\n" +
                    "2- Depositar valor\n" +
                    "3- Desfazer operação\n" +
                    "4- Agendar operação\n" +
                    "5- Executar operações agendadas\n" +
                    "6- Sair");

            Scanner leitor = new Scanner(System.in);
            Scanner leitorNL = new Scanner(System.in);
            int opcao = leitor.nextInt();

            switch (opcao) {
                case 1: // Debitar valor
                    System.out.println("Digite o número da conta e o valor a ser debitado: ");
                    int numeroConta = leitor.nextInt();
                    Double valorDebitado = leitor.nextDouble();

                    if (numeroConta == conta1.getNumero()) {
                        conta1.debitar(valorDebitado);

                        Operacao debito = new Operacao(conta1, "débito", valorDebitado);

                        try {
                            operacaoPilhaObj.push(debito);
                            //operacaoPilhaObj.exibe(); // está validado
                            operaçoesRealizadas++;
                            //System.out.println(operaçoesRealizadas); // está validado
                        } catch (IllegalStateException erro) {
                            System.out.println("Não foi possível realizar a operação: " + erro);
                        }
                    } else if (numeroConta == conta2.getNumero()) {
                        conta2.debitar(valorDebitado);

                        Operacao debito = new Operacao(conta2, "débito", valorDebitado);

                        try {
                            operacaoPilhaObj.push(debito);
                            //operacaoPilhaObj.exibe(); // está validado
                            operaçoesRealizadas++;
                            //System.out.println(operaçoesRealizadas); // está validado
                        } catch (IllegalStateException erro) {
                            System.out.println("Não foi possível realizar a operação: " + erro);
                        }
                    } else {
                        System.out.println("Digite uma conta válida!"); // está validado
                    }
                    break;
                case 2: // Depositar valor
                    System.out.println("Digite o número da conta e o valor a ser depositado: ");
                    numeroConta = leitor.nextInt();
                    Double valorDepositado = leitor.nextDouble();

                    if (numeroConta == conta1.getNumero()) {
                        conta1.depositar(valorDepositado);

                        Operacao deposito = new Operacao(conta1, "deposito", valorDepositado);

                        try {
                            operacaoPilhaObj.push(deposito);
                            //operacaoPilhaObj.exibe(); // está validado
                            operaçoesRealizadas++;
                            //System.out.println(operaçoesRealizadas); // está validado
                        } catch (IllegalStateException erro) {
                            System.out.println("Não foi possível realizar a operação: " + erro);
                        }
                    } else if (numeroConta == conta2.getNumero()) {
                        conta2.depositar(valorDepositado);

                        Operacao deposito = new Operacao(conta2, "deposito", valorDepositado);

                        try {
                            operacaoPilhaObj.push(deposito);
                            //operacaoPilhaObj.exibe(); // está validado
                            operaçoesRealizadas++;
                            //System.out.println(operaçoesRealizadas); // está validado
                        } catch (IllegalStateException erro) {
                            System.out.println("Não foi possível realizar a operação: " + erro);
                        }
                    } else {
                        System.out.println("Digite uma conta válida!"); // está validado
                    }
                    break;
                case 3: // Desfazer operação
                    System.out.println("Digite a quantidade de operações a serem desfeitas: ");
                    int qtdOperacoesDesfeitas = leitor.nextInt();

                    if (qtdOperacoesDesfeitas > operaçoesRealizadas || qtdOperacoesDesfeitas == 0) {
                        System.out.println("Quantidade inválida!"); // está validado
                    } else {
                        for (Integer i = 0; i < qtdOperacoesDesfeitas; i++) {
                            Operacao op = operacaoPilhaObj.pop();
                            if (("Depósito").equals(op.getTipoOperacao())) {
                                op.getObjConta().debitar(op.getValor());
                            } else if ("Débito".equals(op.getTipoOperacao())) {
                                op.getObjConta().depositar(op.getValor());
                            }
                        }
                        operaçoesRealizadas -= qtdOperacoesDesfeitas;
                        //System.out.println(operaçoesRealizadas); // está validado
                        //operacaoPilhaObj.exibe();
                    }
                    break;
                case 4:
                    System.out.println("Digite qual a operação, número da conta e o valor desejado: ");
                    String operacao = leitorNL.nextLine();
                    numeroConta = leitor.nextInt();
                    Double valorDesejado = leitor.nextDouble();

                    if (numeroConta == conta1.getNumero()) {
                        Operacao operacao1 = new Operacao(conta1, operacao, valorDesejado);

                        try {
                            operacaoFilaObj.insert(operacao1);
                            System.out.println("Operação Agendada");
                            //operacaoFilaObj.exibe(); // está validado
                        } catch (IllegalStateException erro) {
                            System.out.println("Não foi possível realizar a operação: " + erro);
                        }
                    } else if (numeroConta == conta2.getNumero()) {
                        Operacao operacao2 = new Operacao(conta2, operacao, valorDesejado);

                        try {
                            operacaoFilaObj.insert(operacao2);
                            System.out.println("Operação Agendada");
                            //operacaoFilaObj.exibe(); // está validado
                        } catch (IllegalStateException erro) {
                            System.out.println("Não foi possível realizar a operação: " + erro);
                        }
                    } else {
                        System.out.println("Digite as informações válidas!"); // está validado
                    }
                    break;
                case 5:
                    if (operacaoFilaObj.isEmpty()) {
                        System.out.println("Não há operações agendadas!"); // está validado
                    } else {
                        while (!operacaoFilaObj.isEmpty()) {
                            Operacao op = operacaoFilaObj.poll();

                            if ("Depósito".equals(op.getTipoOperacao())) {
                                op.getObjConta().depositar(op.getValor());
                            } else if ("Débito".equals(op.getTipoOperacao())) {
                                op.getObjConta().debitar(op.getValor());
                            }
                        }
                        //operacaoFilaObj.exibe(); // está validado
                    }
                    break;
                case 6:
                    fim = true; // está validado
                    System.out.println("Programa encerrado!");
                    break;
                default:
                    System.out.println("Opção inválida!"); // está validado
            }
        }
    }
}
