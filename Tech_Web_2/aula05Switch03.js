/**
* Você está escrevendo um programa para uma cafeteria que calcula o custo total do pedido de um cliente com base na bebida e quaisquer complementos que escolherem.
* Cada bebida tem um preço base e cada complemento tem um custo adicional.
* O programa deve solicitar ao cliente que informe sua escolha de bebida e complementos e, em seguida, exibir o custo total do pedido.
* Aqui estão os preços base para cada bebida:
* Café: R$2,00
* Chá: R$1,50
* Chocolate Quente: R$2,50
* Aqui estão as opções de complementos e seus custos adicionais:
* Leite: R$0,50
* Açúcar: R$0,25
* Chantilly: R$1,00
*/

var bebida = 'Café'
var complemento = 'Leite'
var totalPedido = 0

switch(bebida.toLocaleLowerCase()){
    case 'café':
        totalPedido += 2;
        break;
    case 'chá':
        totalPedido += 1.5;
        break;
    case 'chocolate quente':
        totalPedido += 2.50;
        break;
}
switch(complemento.toLocaleLowerCase()){
    case 'leite':
        totalPedido += 0.5
        break
    case 'açúcar':
        totalPedido += 0.25
        break
    case 'chantilly':
        totalPedido += 1
        break
}

console.log(totalPedido)
