const produtos = [ 
    { nome: 'Camiseta', preco: 30 },
    { nome: 'Calça', preco: 50 }, 
    { nome: 'Tênis', preco: 80 }, 
    { nome: 'Boné', preco: 20 }, 
    ]; 

const taxaDeAumento = 1.25; // Aumento de 10% 

/*A função deve usar a função map para percorrer o array de produtos e atualizar o preço 
de cada produto de acordo com a taxa fornecida. O preço de cada produto deve ser
multiplicado pela taxa de aumento (em decimal). */

function atualizarPrecos(produtos,taxaDeAumento){
    const precosAtualizados = produtos.map(produto => 
        ({ ...produto, preco: (produto.preco * taxaDeAumento).toFixed(2) }));
    return precosAtualizados
}


const precosAtualizados = atualizarPrecos(produtos, taxaDeAumento); 
console.log(precosAtualizados); 
    




    