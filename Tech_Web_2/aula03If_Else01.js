/* Construa um algoritmo que leia dois números e efetue a adição. 
Caso o valor somado seja maior que 20, este deverá ser apresentado 
somando-se a ele mais 8; caso o valor somado seja menor ou igual a 20,
este deverá ser apresentado subtraindo-se 5. */

var a = 23
var b = 10
var adicao = a + b
if(adicao>20){
    adicao += 8
}
else{
    adicao -= 5
}

console.log(adicao)