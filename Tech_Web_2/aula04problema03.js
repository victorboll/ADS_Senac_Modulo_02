/* Faça um algoritmo utilizando a classe date do Javascript para descobrir qual o dia da semana de hoje */
const date = new Date(); 

const weekday= date.getDay(); 

switch(weekday){
    case 0 || 6:
        console.log("Final de semana");
        break;

    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
        console.log("Dia de semana");
        break;

    default:
        console.log("Final de semana");    
}

switch(true){
    case 0 || 6:
        console.log("Final de semana");
        break;
        
    case weekday > 0 || weekday < 6:
        console.log("Dia de semana");
        break;

    default:
        console.log("Final de semana");    
    }