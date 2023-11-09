//Meu

produtos = ['geladeira', 'fogão', 'coifa']

const maiuscula = produtos.map(function(valor){
    primeiroChar = valor.charAt(0).toUpperCase()
    return  primeiroChar + valor.substring(1)
})

console.log(maiuscula)
console.log(produtos)



//{nome: x, sobrenome: y} retornar nome completo e colocar o id
nomes  = [
    {nome: 'Calor', sobrenome: "Cardoso"},
    {nome: 'Igor', sobrenome: "Ícaro"},
    {nome: 'Marcos', sobrenome: "Matoso"},
    {nome: 'Javier', sobrenome: "Justo"},
    {nome: 'Nair', sobrenome: "Nostradamu"},
]

const nomeCompleto = nomes.map(function(valor, indice){
    valor.id = indice
    return valor.nome + ' ' + valor.sobrenome
})

console.log(nomeCompleto)
console.log(nomes)


//Professor

produtos2 = ['geladeira', 'fogão', 'coifa']

function primeiraMaiuscula(palavra){
    return palavra.charAt(0).toUpperCase() + palavra.slice(1)
}

var listaEmMaiusculo = produtos2.map(primeiraMaiuscula);

console.log(listaEmMaiusculo)
console.log(produtos2)



nomes2  = [
    {nome: 'Calor', sobrenome: "Cardoso"},
    {nome: 'Igor', sobrenome: "Ícaro"},
    {nome: 'Marcos', sobrenome: "Matoso"},
    {nome: 'Javier', sobrenome: "Justo"},
    {nome: 'Nair', sobrenome: "Nostradamu"},
]

var novasPessoas = nomes2.map((valor, indice) => {
    let item = {}
    item.nomeCompleto = valor.nome + ' ' + valor.sobrenome;
    item.id = indice;
    return item
})

console.log(novasPessoas)