Exercícios - Classes Genéricas e aninhadas e enumerações


1. [1 ponto]Crie uma enumeração DiaDaSemana com sete valores entre DOMINGO e SABADO. Adicione um método ehDiaUtil() à classe Semana que retorna true se o valor em que for chamado estiver entre SEGUNDA e SEXTA e false, caso contrário.
 
2. [1 ponto]Escreva uma classe genérica Par que tem dois parâmetros de tipo - F e S - cada um representando o tipo do primeiro e segundo elemento do par, respectivamente. Adicione os métodos get e set ao primeiro e ao segundo elemento do par (Dica: o cabeçalho da classe deve ser public class Par<F, S >). Crie uma classe Main que instancie dois objetos da Classe Par. Os valores dos dois objetos devem ser de tipos diferentes


3. [3 pontos]Defina uma classe que contenha um método genérico capaz de efetuar a soma das área de arrays contendo apenas objetos dos tipos apresentados na figura abaixo:

                                       FormaGeometrica (area, perimetro, getArea(), getPerimetro())
                               /--------|                                |                       |------------------------------------\
                              /                                          |                                                             \
                             |                                           |                                                              |
                   Circulo (calcularArea(), calcularPerimetro())      Triangulo (calcularArea(), calcularPerimetro())       Retangulo (calcularArea(), calcularPerimetro())
                                                                                                                                 |
                                                                                                                                 |
                                                                                                                                 |
                                                                                                         Quadrado (calcularArea(), calcularPerimetro())
