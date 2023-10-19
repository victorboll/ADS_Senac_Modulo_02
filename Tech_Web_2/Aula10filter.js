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
    return valor > 3;
})
console.log(result)

//------------------------------------------------------------------------------------------------------------

const pessoas = [
    {nome: 'Luiz', idade: 62},
    {nome: 'FABIO', idade: 39},
    {nome: 'Mara', idade: 25},
    {nome: 'Lucas', idade: 19},
    {nome: 'Alberto', idade: 23},
]



const pessoasComNome = pessoas.filter(function(valor){
    console.log(valor.nome)
})
console.log(pessoasComNome)



const pessoasComNomeGrande = pessoas.filter(function(valor){
    return valor.nome.length >= 5
})
console.log(pessoasComNomeGrande)



const pessoasComNomeMenor = pessoas.filter(obj => obj.nome.length <= 4);
console.log(pessoasComNomeMenor)



const nomeTerminaComO = pessoas.filter(obj => {
    return obj.nome.toLocaleLowerCase().endsWith('o')
})
console.log(nomeTerminaComO)