public class Banco {

    // Atributos
    PilhaObj<Operacao> pilhaOperacao = new PilhaObj(10);
    FilaObj<Operacao> filaOperacao = new FilaObj(10);

    // Contador de operações empilhadas
    Integer contadorOperacao = 0;

    // Métodos

    /* Método debitar - recebe o valor a ser debitado e o objeto conta bancária
       Se o débito ocorreu com sucesso, cria um objeto Operacao com os valores adequados
       e empilha a operação para poder ser desfeita. Atualiza contadorOperacao.
     */
    public void debitar(Double valor, ContaBancaria conta) {
        conta.debitar(valor);

        Operacao debito = new Operacao(conta, "Débito", valor);

        pilhaOperacao.push(debito);
        contadorOperacao++;
    }

    /* Método depositar - recebe o valor a ser debitado e o objeto conta bancária
       Executa o depósito, cria um objeto Operacao com os valores adequados
       e empilha a operação para poder ser desfeita. Atualiza contadorOperacao.
     */
    public void depositar(Double valor, ContaBancaria conta) {
        conta.depositar(valor);

        Operacao deposito = new Operacao(conta, "Depósito", valor);

        pilhaOperacao.push(deposito);
        contadorOperacao++;
    }

    /* Método desfazerOperacao - recebe a quantidade de operações a serem desfeitas
       Se essa quantidade for inválida, lança IllegalArgumentException
       Senão, "desfaz" a quantidade de operações passadas como argumento
       e atualiza o contadorOperacao
     */
    public void desfazerOperacao(Integer qtdOperacaoDesfeita) {
        if (qtdOperacaoDesfeita > contadorOperacao || qtdOperacaoDesfeita == 0) {
            throw new IllegalArgumentException("Quantidade inválida!");
        } else {
            for (int i = 0; i < qtdOperacaoDesfeita; i++) {
                Operacao op = pilhaOperacao.pop();

                if (("Débito").equals(op.getTipoOperacao())) {
                    op.getContaBancaria().depositar(op.getValor());
                } else if ("Depósito".equals(op.getTipoOperacao())) {
                    op.getContaBancaria().debitar(op.getValor());
                }
            }
            contadorOperacao -= qtdOperacaoDesfeita;
        }
    }


    /* Método agendarOperacao - recebe o tipo da operaçõa, o valor e o objeto conta bancária
       Se um dos argumentos for inválido, lança IllegalArgumentException.
       Senão, cria um objeto Operacao e insere esse objeto na fila.
    */
    public void agendarOperacao(String tipoOperacao, Double valor, ContaBancaria conta) {
        if (tipoOperacao != "Débito" && tipoOperacao != "Depósito"|| valor <= 0 || conta == null) {
            throw new IllegalArgumentException("Argumento inválido!");
        } else {
            Operacao agendar = new Operacao(conta, tipoOperacao, valor);
            filaOperacao.insert(agendar);
        }
    }

    /* Método executarOperacoesAgendadas
       Se não houver operações na fila, exibe mensagem de que não há operações agendadas.
       Senão, esvazia a fila, executando cada uma das operações agendadas.
    */
    public void executarOperacoesAgendadas() {
        if (filaOperacao.isEmpty()) {
            System.out.println("Não há operações agendadas!");
        } else {
            while (!filaOperacao.isEmpty()) {
                Operacao executar = filaOperacao.poll();

                if ("Depósito".equals(executar.getTipoOperacao())) {
                    executar.getContaBancaria().depositar(executar.getValor());
                } else if ("Débito".equals(executar.getTipoOperacao())) {
                    executar.getContaBancaria().debitar(executar.getValor());
                }
            }
        }
    }

    // Gettens
    public PilhaObj<Operacao> getPilhaOperacao() {
        return pilhaOperacao;
    }

    public FilaObj<Operacao> getFilaOperacao() {
        return filaOperacao;
    }

    public Integer getContadorOperacao() {
        return contadorOperacao;
    }
}
