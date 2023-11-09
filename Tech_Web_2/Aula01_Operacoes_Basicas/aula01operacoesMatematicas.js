/* O custo de um carro novo ao consumidor é a soma do  custo de fábrica com a porcentagem do distribuidor e dos impostos (aplicados ao custo de fábrica).
   Supondo que o percentual do distribuidor seja de 28% e os impostos de 45%, escrever um algoritmo para ler o custo de fábrica de um carro, 
   calcular e esrever o custo final ao consumidor */

   var custoFabrica = 40000;
   var porcentagemDistribuidor = custoFabrica*0.28;
   var impostos =  custoFabrica*0.45;
   var custoTotal = custoFabrica + porcentagemDistribuidor + impostos;
   console.log(`Levando em consideração um custo de fábrica de ${custoFabrica.toFixed(2)}, o custo de um carro novo para o consumidor seria R$${custoTotal.toFixed(2)}. O imposto seria R$${impostos.toFixed(2)}, e a porcentagem do distribuidor é R$${porcentagemDistribuidor.toFixed(2)}.`)