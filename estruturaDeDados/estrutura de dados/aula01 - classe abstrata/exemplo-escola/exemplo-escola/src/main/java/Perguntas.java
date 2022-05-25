public class Perguntas {

    // Pergunta: qual seria a melhor forma: classe abstrata ou interface? Justifique.

    /*
       para mim, a classe abstrata foi mais apropriada para a resolução desse exercício,
       pois na classe mãe "Funcionário" eu coloquei o método getValorBonus e as classes filhas
       "Professor" e "Coordenador" herdaram esse método, podendo cada classe fazer a conta do seu jeito.

       Se fosse, interface, teria que ter uma outra classe, juntando todas as classes, como se fosse
       uma pirâmide, como por exemplo no exercício anterior.

                            Vendavel ----------- Carrinho
                            /      \
                           /        \
                          /          \
                      Produto      Serviço
                        /   \
                       /     \
                      /       \
                   Livro      DVD

       Ou seja, a interface faz permitir estabelecer um “contrato” entre as classes,
       forçando que elas implementem os métodos definidos na classe interface, nesse exemplo
       seria a classe Vendavel.
       No exercício proposto, como a classe funcionarios tem as classes professor e coordenador
       elas são relacionadas através da herança, então utilizam seus métodos proposto.
     */

    // Pergunta: é necessário ter 2 List ou apenas um?

    /*
       è necessário ter somente um List, pois os professores e coordenadores são funcionários
       e recebem bônus, os outros funcionários nao foram explicitos para serem criados, entao
       na lista estaram os professores e coordenadores junto com os seus bônus.
     */

    // Pergunta: O polimorfismo está presente nesse sistema? Justifique

    /*
       Sim, está presente pois foi utilizados métodos reescritos, ou seja, as classes herdeiras
       utilizam as assinaturas da mãe, no caso do exercício, foi utilizado método
       getValorBonus da classe mãe "Funcionarios" nas classes filhas "Professor" e "Coordenador".
     */
}
