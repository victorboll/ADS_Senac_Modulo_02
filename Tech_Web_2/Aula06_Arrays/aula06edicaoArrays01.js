var frutas = ["Manga","Banana","Laranja","Uva"]

frutas[4] = "Jambo" //Coloca na posição 4
frutas[3] = "Caqui" //Tria quem está na posição 3 (Uva), e coloca um novo valor (Caqui)

frutas.push("Abacaxi") //Coloca no final da lista

console.log(frutas)

frutas.pop() //Retira o último elemento do array

console.log(frutas)

frutas.shift() //Retira o primeiro elemento do array

console.log(frutas)

frutas.unshift("Morango") //Coloca um elemento na primeira posição do array

console.log(frutas)

frutas.splice(2, 1) //Arranca 1 elemento a partir da posição 2 (posição 2 incluso)

console.log(frutas)

frutas.splice(2,2,"Melancia","Tangerina","Tangerina") //Arranca 2 elemento a partir da posição 2 (posição 2 incluso), e coloca "Melancia" e "Tangerina" no local
// Você pode colocar 0 no segundo parâmetro, não tirar ninguém, e só adicionar novos valores

console.log(frutas)

var posicao = frutas.indexOf("Tangerina") //Retorna a posição da "Tangerina" na lista. Ele só pega a primeira entrada de Tangerina na lista

console.log(posicao)

for (var i=0; i < frutas.length; i++){
    console.log(frutas[i])
}

frutas.forEach(function(x){ //Função anônima
    console.log(x)
} )
