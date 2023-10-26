const numeros = [5, 3, 2, 7, 12, 32, 65, 12]
const numerosDobrados = numeros.map(function(valor){
    return valor * 2
} )
console.log(numerosDobrados)

const numerosTriplicados = numeros.map( valor => valor * 3)
console.log(numerosTriplicados)

const indice = numeros.map(function(valor,indice){
    return indice
})
console.log(indice)