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