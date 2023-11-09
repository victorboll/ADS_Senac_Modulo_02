/* Escreva um algoritmo para ler o salário mensal atual de um funcionario e o percentual de reajust.Calcular e escrever o valor do novo salário */
var salario = 5000.5;
var reajuste = 10;
console.log(`O reajuste de ${reajuste}% em um salário de R$${salario.toFixed(2)}, vai gerar um novo salário de R$${(salario*=(1+reajuste/100)).toFixed(2)}`);