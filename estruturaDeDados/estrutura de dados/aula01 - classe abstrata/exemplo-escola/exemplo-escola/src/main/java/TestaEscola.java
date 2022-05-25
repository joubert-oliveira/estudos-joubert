public class TestaEscola {
    public static void main(String[] args) {

        Professor p = new Professor("Célia", 7.0, 9.0);
        Professor p1 = new Professor("Leonardo", 4.0, 10.0);
        Professor p2 = new Professor("Diego", 9.0, 5.0);

        Coordenador c = new Coordenador("Vera", 10.0, 5.0);
        Coordenador c1 = new Coordenador("Alessandro", 3.0, 9.0);
        Coordenador c2 = new Coordenador("Gerson", 5.0, 8.0);

        ControleBonus b = new ControleBonus();

        // Adicionar na lista
        b.adicionarFuncionario(p);
        b.adicionarFuncionario(p1);
        b.adicionarFuncionario(p2);
        b.adicionarFuncionario(c);
        b.adicionarFuncionario(c1);
        b.adicionarFuncionario(c2);

        // Exibi a lista toda
        b.exibirTodos();

        // Exiba o total de bonus
        System.out.printf("\nTotal dos Bonus \nR$ %.2f reais", b.calculaTotalBonus());
    }
}
