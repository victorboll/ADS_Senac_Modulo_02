/* Para fazer uma promoção, os comerciantes estão procurando aumentar suas vendas oferecendo desconto. 
Faça um algoritmo que possa receber um valor de um produto e escreva o novo valor tendo em vista que o sesconto foi de 9% */

var valor = 1;
var desconto = 9;
var valorDesconto = valor * desconto / 100;
var novoValor = valor * (100 - desconto)/100;
console.log(`Um produto de valor R$${valor.toFixed(2)}, após um desconto de ${desconto}% (Que seria o equivalente a R$${valorDesconto.toFixed(2)}), terá o valor de R$${novoValor.toFixed(2)}`);
