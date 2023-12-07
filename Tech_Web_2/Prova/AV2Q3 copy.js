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


    function atualizarEstoque(produtos, novaRemessa) {
        novaRemessa.forEach((novoProduto) => {
            let produtoExistente = false;
    
            produtos.forEach((produto) => {
                if (novoProduto.nome === produto.nome) {
                    produto.quantidade += novoProduto.quantidade;
                    produtoExistente = true;
                }
            });
    
            if (!produtoExistente) {
                produtos.push(novoProduto);
            }
        });
    
        return produtos; // Retorna o array de produtos atualizado
    }


const estoqueAtualizado = atualizarEstoque(produtos, novaRemessa); 
console.log(estoqueAtualizado); 

    