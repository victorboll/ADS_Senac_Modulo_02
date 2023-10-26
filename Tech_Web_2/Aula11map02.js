const pessoas = [
    {nome: 'Luiz', idade : 23},
    {nome: 'Sara', idade : 18},
    {nome: 'Alberto', idade : 23},
    {nome: 'Carlos', idade : 14},
    {nome: 'Eduardo', idade : 32},
    {nome: 'Carla', idade : 45},
]

const nomes = pessoas.map(function(valor){
    return valor.nome
})
console.log(nomes)


const nomes_v2 = pessoas.map(valor => valor.nome);
console.log(nomes_v2)


const pessoasComId = pessoas.map(function(valor, indice){
    const newObj = { ...valor};
    newObj.id = indice
    return newObj
})

console.log(pessoasComId)
console.log(pessoas)