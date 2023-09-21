//Compass, Renegade, Outlander, Tracker e um Duster
//Compraram Tracker, diminuiu estoque. Adicionou Onix ao estoque
//Tirou Compass do estoque. Cliente comprou Outlander e deu em troca Pajero TR4
//Colocou no estoque Tiggo 7. Tirou Duster do estoque

var carros = ['Compass','Renegade','Outlander','Tracker','Duster']
console.log(carros)

carros.splice(carros.indexOf("Tracker"),1)
console.log(carros)

carros.push("Onix")
console.log(carros)

carros.splice(carros.indexOf("Compass"),1)
console.log(carros)

carros.splice(carros.indexOf("Outlander"),1,"Pajero TR4")
console.log(carros)

carros.push("Tiggo 7")
console.log(carros)

carros.splice(carros.indexOf("Duster"),1)
console.log(carros)
