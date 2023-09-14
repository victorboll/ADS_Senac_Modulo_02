var bebidaPreco = 0
var adicionado = 0
const bebidaEscolida = prompt("Qual a bebida você deseja?\nCafé\nChá\nChocolate").toLowerCase();

switch(bebidaEscolida){
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
        alert("Essa opção não é válida");
}

const leite = prompt("Você gostaria de adicionar leite? (sim ou não)").toLowerCase();
if(leite === "sim"){
    adicionado += 0.5;
}

const acucar = prompt("Você gostaria de adicionar açúcar? (sim ou não)").toLowerCase();
if(acucar === "sim"){
    adicionado += 0.25;
}

const chantilly = prompt("Você gostaria de adicionar chantilly? (sim ou não)").toLowerCase();
if(chantilly === "sim"){
    adicionado += 1;
}

const totalPreco = bebidaPreco + adicionado;

alert(`O valor final da sua compra é: R$${totalPreco.toFixed(2)}`);