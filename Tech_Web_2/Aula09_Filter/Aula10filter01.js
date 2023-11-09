var numeros = [1,2,3,4,5,6,7,8,9,10]



var resultado = numeros.filter(item => item % 2 != 0)
console.log(resultado)



var numerosFiltrados = numeros.filter(
    function(item){
        return item > 5
    }
)
console.log(numerosFiltrados)



function buscarValores(valor){
    return valor < 5
}
var numerosEncontrados = numeros.filter(buscarValores);
console.log(numerosEncontrados)



var result = numeros.filter((valor) =>{
    return valor > 6;
})
console.log(result)