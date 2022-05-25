public class TesteAluno {
    public static void main(String[] args) {

        AlunoFundamental af = new AlunoFundamental(0001, "André", 5.0, 5.0, 5.0, 5.0);

        AlunoGraduacao ag = new AlunoGraduacao(0002, "Brenda", 5.0, 5.0);

        AlunoPos ap = new AlunoPos(0003, "Paulo", 5.0, 5.0, 10.0);

//        System.out.println(af);
//        System.out.println(ag);
//        System.out.println(ap);

        Escola e = new Escola("Sptech");

        e.adicionaAluno(af);
        e.adicionaAluno(ag);
        e.adicionaAluno(ap);

        e.exibeTodos();
        e.exibeAlunoGraduacao();
        e.exibeAprovados();
        e.buscaAluno(0001);
    }
}
