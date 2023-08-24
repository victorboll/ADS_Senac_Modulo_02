/* Faça um algoritmo que efetue o cálculo da quantidade de litros de combustível gastos em uma viagem, sabendo-se que o carro faz 12 Km com um litro. Deverão ser fornecidos o tempo de gasto na viagem e a velocidade média. Utilizar as seguintes fórmulas: 
distância = tempo * velocidade   e   litros usados = distância / 12   
O algoritmo severá apresentar os valores da velocidade média, tempo gasto na viagem, distância percorrida e a quantidade de litros utilizados na viagem*/

var velocidadeMedia = 80;
var tempoMinuto = 180;
var tempoHora =  tempoMinuto / 60
var distancia = velocidadeMedia * tempoHora;
var litros =  distancia / 12
console.log(`Após percorrer uma distância de ${distancia.toFixed(1)} Km em ${tempoHora.toFixed(1)} horas, a ${velocidadeMedia.toFixed(1)} Km/h, o combustível gasto na viagem foi ${litros.toFixed(1)}`);
