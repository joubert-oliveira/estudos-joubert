public class TestaTributo {
    public static void main(String[] args) {

        Alimento a = new Alimento(0001, "maçã", 10.50, 10);
        Perfume p = new Perfume(0002,"versace", 100.00, "doce");
        Servico s = new Servico("full stack", 300.00);
        Tributo t = new Tributo();

        t.adicionaTributavel(a);
        t.adicionaTributavel(p);
        t.adicionaTributavel(s);
        t.exibirTodos();
        System.out.printf("\nTotal dos tributos \nR$ %.2f reais", t.calculaTotalTributo());


    }
}
