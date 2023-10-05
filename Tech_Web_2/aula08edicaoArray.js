const shoppingCart = [];

function addItemToCart(item){
    shoppingCart.push(item)
}
function removeItemFromCart(item){
    const index = shoppingCart.indexOf(item); //Quando retorna index -1, é porque o item não foi encontrado
    if (index > -1){
        shoppingCart.splice(index,1);
    }
}


function showShoppingCart(){
    if(shoppingCart.length === 0){
        console.log('Carrinho vazio')
    }
    else{
        console.log('Itens no carrinho')
        for (var i=0; i < shoppingCart.length; i++){
                console.log(shoppingCart[i])
    }}
}


function eraseShoppingCart(){
    shoppingCart.splice(0,shoppingCart.length)
    // ou shoppingCart.length = 0;
}

addItemToCart('sopa')
addItemToCart('uvas')
addItemToCart('nozes')
addItemToCart('pão')
showShoppingCart()
eraseShoppingCart()
showShoppingCart()
addItemToCart('sopa')
addItemToCart('uvas')
addItemToCart('nozes')
addItemToCart('pão')
removeItemFromCart('uvas')
showShoppingCart()


