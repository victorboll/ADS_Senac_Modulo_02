const readline = require('readline'); /*Eu quero usar o módulo readline do node, e o readline está representado pela variável readline (tem que ser esse nome). É como se fosse um import*/

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

var bebidaPreco = 0
var adicionado = 0

rl.question("Qual a bebida você deseja?\nCafé\nChá\nChocolate\n",(bebidaEscolhida) =>{
    switch(bebidaEscolhida){
        case 'café':
            bebidaPreco += 2.0;
            break;
        case 'chá':
            bebidaPreco += 1.5;
            break;
        case 'chocolate':
            bebidaPreco += 2.50;
            break;
        default:
            console.log("Essa opção não é válida");
            rl.close();
            return;
    }
})

rl.question("Você gostaria de adicionar açúcar? (sim ou não)",(leite) =>{
    
})