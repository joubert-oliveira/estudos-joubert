package exercicio3_lista_filmes_arquivo_csv;

public class Enunciado {
    /*
Crie um projeto chamado lista-filme.

a) Crie uma classe chamada Filme.

Esta classe terá os atributos idFilme (inteiro), nome (String), nota (double), genero (String),
idade (inteiro), sendo que nota representa um valor de 0 a 10 atribuído pela crítica, e idade representa
a idade mínima para assistir o filme. Os atributos devem ser encapsulados e a classe
deve fornecer os getters e os setters.

Implemente também o construtor que recebe os valores dos atributos e inicializa os atributos.

Implemente o toString que exibe os valores dos atributos

b) Copie para esse projeto a classe ListaObj

c) Crie uma classe chamada TesteFilme. Configure para que essa classe tenha o método main.

Crie um objeto de ListaObj chamado lista para ser uma lista de Filme.

Fique num loop, enquanto o usuário não escolher a opção Sair

Exiba o menu de opções e peça que o usuário escolha uma das opções:

1. Adicionar um filme
2. Exibir a lista
3. Gravar a lista em arquivo CSV
4. Ler e exibir um arquivo CSV
5. Gravar em outro arquivo CSV apenas filmes que estão na lista, mas de um determinado gênero
6. Sair

Leia a opção digitada pelo usuário

Utilizando switch case, execute a opção escolhida pelo usuário, conforme instruções abaixo:

Opção 1: Solicite que o usuário digite os valores dos atributos de Filme e leia os valores digitados.
Crie um objeto Filme com esses valores. Adicione esse objeto à lista.

Opção 2: Se a lista estiver vazia, exibe a mensagem "Lista está vazia", senão, exiba os dados de
cada filme que está na lista.

Opção 3: Verifique se a lista está vazia e nesse caso, exiba a mensagem “Lista está vazia.
Não há nada a gravar”. Senão, grave num arquivo filme.csv os dados de cada filme que está na lista.

Opção 4: Solicite que o usuário digite o nome do arquivo a ser lido. Leia o nome do arquivo.
Leia o arquivo desejado e exiba os dados de cada filme, com cada atributo em uma coluna separada.
(não se esqueça dos títulos das colunas)

Opção 5: Verifique se a lista está vazia e nesse caso, exiba a mensagem “Lista está vazia.
Não há nada a gravar”. Senão, solicite que o usuário digite o nome do
arquivo a ser gravado e o gênero desejado.
Leia o nome do arquivo e o gênero. Grave nesse arquivo apenas os filmes que estão na
lista e que são do gênero desejado. Se não houver na lista filmes desse gênero,
exiba a mensagem “Não há filmes deste gênero na lista”.

Opção 6: Sinalize que é o fim do loop.

Exiba também opção inválida, caso a opção digitada seja diferente de 1 a 6.
     */
}
