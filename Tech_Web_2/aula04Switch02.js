/*Uma empresa deseja fazer palestras separadas com assuntos diversos para cada tipo de funcionário. Nesse sentido: 
Se o funcionário é da área de TI e é gerente, deve ir para a sala 404;
Se o funcionário é da área de TI e é desenvolvedor back end, deve ir para a sala 403;
Se o funcipário é da área de TI e é Desenvolvedor front end, ele deve ir para a sala 402;
Se o funcioário pe da área de Suporte e é de redes, deve ir para a sala 401;
Se o funcioário não for de nenhuma das áreas citadas, ele deve ir para a sala 400 */

let area = 'TI'
let cargo = 'Desenvolvedor front end';

switch((area+cargo).toLocaleLowerCase()){
    case 'tigerente':
        console.log("Você deve ir para a sala 404");
        break;
    case 'tidesenvolvedor back end':
        console.log("Você deve ir para a sala 403");
        break;
    case 'tidesenvolvedor front end':
        console.log("Você deve ir para a sala 402");
        break;
    case 'suporteredes':
        console.log("Você deve ir para a sala 401");
        break;
    default:
        console.log("Você deve ir para a sala 400");    
}