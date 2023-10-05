/* Faça um algoritmo que leia um número inteiro e que imprima o seu sucessor e seu antecessor*/

var numero = 10;
var maior = numero + 1;
var menor = numero - 1;
console.log(`O antecessor do número ${numero}, é o número ${menor}, e o sucessor é o número ${maior}`)
console.log(`O antecessor do número ${numero}, é o número ${numero-1}, e o sucessor é o número ${numero+1}`)
//console.log(`O antecessor do número ${numero}, é o número ${--numero}, e o sucessor é o número ${++numero}`)

/* console.log(`O antecessor do número ${numero}, é o número ${--numero}, e o sucessor é o número ${++numero}`)
Não pode fazer dessa maneira, porque quando você usa o ++ ou o --, você modifica a variável, ia acabar ficando 
"O antecessor do número 10, é o número 9, e o sucessor é o número 10" */