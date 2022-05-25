public class App {

    public static void main(String[] args) {
        // Só para relembrar que a classe abstrata não é instanciável
        // Não posso fazer new de uma classe abstrata
        // Funcionario f = new Funcionario ("12345", "Fulano da Silva");

        // Funcionario
        Engenheiro e = new Engenheiro("12345", "Claudio Sousa", 15000.0);

        Vendedor v = new Vendedor("67890", "Mickey", 30000.0, 0.10);

        Horista h = new Horista("45678", "Pateta", 40, 100.0);

        System.out.println(e);
        System.out.println(v);
        System.out.println(h);

        Empresa sptech = new Empresa();
        sptech.adicionaFunc(e);
        sptech.adicionaFunc(v);
        sptech.adicionaFunc(h);

        sptech.exibeTodos();
        sptech.exibeTotalSalario();
        sptech.exibeHorista();
        sptech.buscaFunc("12345");
    }
}
