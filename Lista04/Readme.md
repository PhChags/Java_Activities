[3 pontos]1 - Escreva um programa que crie uma lista de compras com nomes de produtos (tipo String) que serão informados pelo usuário. A lista de compras não poderá ter elementos repetidos. Implemente também o método imprimirListaDeCompras() que imprime os produtos informados em ordem alfabética. Faça uma classe principal que implemente o método main e que adicione diversos produtos a sua lista de compras, alguns deles repetidos, e, em seguida, imprima essa lista.
Dica: Pesquise sobre Collections.sort() e o método contains da classe ArrayList.

[4 pontos] 2 - Implemente um programa processador de boletos. O objetivo desse processador é verificar todos os boletos e, caso o valor da soma de todos os boletos seja maior ou igual que o valor da fatura, então essa fatura deverá ser considerada como paga.
Uma fatura contém data, valor total e nome do cliente. Um boleto contém código do boleto, data, e valor pago.
O processador de boletos, ao receber um ArrayList de boletos, deve então, para cada boleto, criar um “pagamento” associado a essa fatura. Esse pagamento contém o valor pago, a data, e o tipo do pagamento efetuado (que nesse caso é “BOLETO”).
Como dito anteriormente, caso a soma de todos os boletos iguale ou ultrapasse o valor da fatura, a mesma deve ser marcada como “PAGA”.
Exemplos de processamento:
• Fatura de 1.500,00 com 3 boletos no valor de 500,00, 400,00 e 600,00: fatura marcada como PAGA, e três pagamentos do tipo BOLETO criados
• Fatura de 1.500,00 com 3 boletos no valor de 1000,00, 500,00 e 250,00: fatura marcada como PAGA, e três pagamentos do tipo BOLETO criados
• Fatura de 2.000,00 com 2 boletos no valor de 500,00 e 400,00: fatura não marcada como PAGA, e dois pagamentos do tipo BOLETO criados

[3 pontos] 3 - Escreva um programa de agenda de compromissos. Nesse programa, o usuário poderá informar sua lista de compromissos em que cada compromisso contém título, descrição, local e data. O programa deverá permitir que o usuário imprima todos os compromissos de um determinado dia. Além disso, o usuário poderá escolher se deseja imprimir a data em formato extenso ou não e, ainda, poderá escolher imprimir em português ou inglês. Dica: Pesquise sobre as classes Calendar, DataFormat e Locale.

