/*Faça um algoritimo que você vai ler 3 notas (definir 3 variáveis) de um aluno, calcule e escreva a média final deste aluno. 
Considerar que a média é ponderada e que o peso das notas é 2, 3 e 5. Fórmula final vai ser (n1*2 + n2*3 + n3*5)/10 */

var n1 = 10;
var n2 = 7;
var n3 = 3;
var mediafinal = 0;
mediafinal = (n1 * 2 + n2 * 3 + n3 * 5)/10;
console.log(`Se a nota do aluno na primeira prova foi ${n1}, na segunda prova foi ${n2} e na terceira prova foi ${n3}, sua média final será ${mediafinal}.`);
