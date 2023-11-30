var valorTotal = [0, 0]
var valorProduto = [50.00, 30.00]
var qtd = [0, 0]

function adicionarItem(item){
    var quantidade = document.getElementById('quantidade' + item) //se o parâmetro for zero vai ficar quantidade0
    var total = document.getElementById('total' + item)
    qtd[item] += 1
    valorTotal[item] = Number.parseFloat(qtd[item] * valorProduto[item]);
    quantidade.innerHTML = qtd[item];
    total.innerHTML = valorTotal[item].toFixed(2);
    valorCompra()
}

function removerItem(item){
    if(qtd[item] > 0){
        var quantidade = document.getElementById('quantidade' + item) //se o parâmetro for zero vai ficar quantidade0
        var total = document.getElementById('total' + item)
        qtd[item] -= 1
        valorTotal[item] = Number.parseFloat(qtd[item] * valorProduto[item]);
        quantidade.innerHTML = qtd[item];
        total.innerHTML = valorTotal[item].toFixed(2);}
        valorCompra()
}

function valorCompra(){
    var valorTotalCompra = document.getElementById('valorTotalCompra');
    var valor = 0
    for(var i = 0; i < valorTotal.length; i++){
        valor += valorTotal[i]
    }

    valorTotalCompra.innerHTML = valor.toFixed(2)
}

function removerProduto(produto){
    var pai = document.getElementById('carrinho')
    var filho = document.getElementById('produto' + produto)
    if (confirm('Deseja excluir o produto do carrinho?')){
        valorTotal[produto] -= (valorProduto[produto] * qtd[produto])
        qtd[produto] = 0
        pai.removeChild(filho)
        valorCompra()
    }
 
}