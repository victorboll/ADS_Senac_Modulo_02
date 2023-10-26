var produtos = [
    {id : 1, descricao: "Smartphone", categoria:'Eletrônico'},
    {id : 2, descricao: "Notebook", categoria:'Eletrônico'},
    {id : 3, descricao: "Geladeira", categoria:'Eletrodomestico'},
    {id : 4, descricao: "Liquidificador", categoria:'Eletrodomestico'},
    {id : 5, descricao: "Air Fryer", categoria:'Eletrodomestico'}
]

function retornarEletronico(value){
    if(value.categoria == 'Eletrônico'){
        return true
    }
}

var produtosEletronicos = produtos.filter(retornarEletronico)

produtosEletronicos.forEach(produtoEletro => 
    {console.log(produtoEletro)
})

