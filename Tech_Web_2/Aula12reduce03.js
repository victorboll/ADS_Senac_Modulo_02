var numeros = [1, 2, 3, 4, 5, 6]

const numerosParesMultiplicadosPorDoisEMultiplicados = numeros.filter(function(valor){
    return valor % 2 === 0
}).map(function(valor){
    return valor * 2
}).reduce(function(ac, valor){
    return ac * valor
});

console.log(numerosParesMultiplicadosPorDoisEMultiplicados)