public class App {
    public static void main(String[] args) {

        BrinquedoIngresso bI1 = new BrinquedoIngresso(0001, "Montanha-russa", 5, 10);
        BrinquedoAlugado bA1 = new BrinquedoAlugado(0002, "Bicicleta", 5, 10);
        Socio s1 = new Socio("Isaque Santos", 2000.0);
        ControleImposto cI = new ControleImposto();

        cI.adicionarTributavel(bI1);
        cI.adicionarTributavel(bA1);
        cI.adicionarTributavel(s1);
        cI.exibirTodosObjetosImpostos();
        System.out.printf("\nTotal dos Impostos \nR$ %.2f reais", cI.calculaTotalImpostos());

        
        /*Além das classes descritas no enunciado, pense numa possível classe adicional que também tenha que ser
        obrigada a ter esse método getValorImposto(). Escreva como comentário no main, que classe seria essa,
        aonde do diagrama ela se encaixaria e como seria o cálculo do seu imposto.
        Não precisa desenhar essa classe no diagrama, nem implementar o seu código.
         */

        /* A classe que adicionaria seria VendaBrinquedos, onde ela implementaria o método getValorImposto da classe interface Tributavel,
        podendo calcular seu imposto, sendo o calculo do imposto 5% do preço do brinquedo. Podendo tambem essa classe ser abstrata e ter
        as classes filhas como por exemplo a classe BichoDePelucia e a classe Unicornio onde implementaria os atributos e metodos da classe
        VendaBrinquedos por herança e o método getValorImposto especificado na classe interface Tributavel.
         */
    }
}
