public class TestaEscola {
    public static void main(String[] args) {

        Professor professor = new Professor("Célia", 10.0, 5.0);

        Coordenador coordenador = new Coordenador("Vera", 10.0, 5.0, 10.0, 5.0);

        ControleBonus controle = new ControleBonus();

        controle.adicionarEducador(professor);
        controle.adicionarEducador(coordenador);

        controle.exibirTodos();

        System.out.printf("\nTotal dos Bonus \nR$ %.2f reais", controle.calculaTotalBonus());


    }
}
