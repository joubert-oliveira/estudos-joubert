package interfaceOrAbstract;

public class AppTeste {
    public static void main(String[] args) {
        Funcionario f1 = new Professor("Cleber", 7, 22.5);
        Funcionario f2 = new Professor("Pedro", 5, 44.5);
        Funcionario f3 = new Professor("Mateus", 4, 32.2);

        Funcionario c1 = new Coordenador("Amanda", 5, 59.0);
        Funcionario c2 = new Coordenador("Fátima", 3, 67.0);

        ControleBonus bonus = new ControleBonus();

        bonus.adicionaObjeto(f1);
        bonus.adicionaObjeto(f2);
        bonus.adicionaObjeto(f3);
        bonus.adicionaObjeto(c1);
        bonus.adicionaObjeto(c2);

        System.out.println("Funcionarios adicionados");

        System.out.println("\nExibindo lista\n");
        bonus.exibeTodos();


        System.out.println("\nBonus Total: " + bonus.calcularTotalBonuses());
    }
}
