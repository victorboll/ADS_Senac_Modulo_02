const produtos = [ 
    { nome: 'Camiseta', quantidade: 10 }, 
    { nome: 'Calça', quantidade: 5 }, 
    { nome: 'Tênis', quantidade: 8 }, 
    { nome: 'Boné', quantidade: 3 }, 
    ]; 

const novaRemessa = [ 
    { nome: 'Camiseta', quantidade: 3 }, 
    { nome: 'Calça', quantidade: 2 }, 
    { nome: 'Tênis', quantidade: 5 }, 
    { nome: 'Meia', quantidade: 7 }, 
    ];

    /* Sua implementação da função atualizarEstoque aqui
    Você deve criar uma função chamada atualizarEstoque que recebe dois parâmetros: o array atual de produtos e uma nova remessa de produtos. 
    A função deve usar a função reduce para percorrer a nova remessa e atualizar o estoque de acordo com as seguintes regras:
    Se um produto da nova remessa já existe no estoque, a quantidade existente deve ser incrementada pela quantidade da nova remessa. 
    Se um produto não existe no estoque, ele deve ser adicionado ao array de produtos com a quantidade da nova remessa. 
    A função deve retornar um novo array de produtos atualizado.*/

    function atualizarEstoque(estoqueAtual, novaRemessa){
        const novoEstoque = [...estoqueAtual]
        for (let i of novaRemessa){
            if (novoEstoque.some(item => item.nome === i.nome)){
                novoEstoque.forEach(item => {if (item.nome === i.nome){
                    item.quantidade += i.quantidade
                }})
            } else {
                novoEstoque.push(i)
            }
        }
        return novoEstoque;
    }


const estoqueAtualizado = atualizarEstoque(produtos, novaRemessa); console.log(estoqueAtualizado); 

    