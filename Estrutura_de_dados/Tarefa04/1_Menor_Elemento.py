from Arvore_Binaria import NodoArvoreBinaria, inserir_novo_nodo

"""1. Encontre o menor elemento em uma BST."""
def menor_elemento(raiz):
    if raiz.esquerda == None:
        print(f'O menor elemento é {raiz.valor}')
    else:
        menor_elemento(raiz.esquerda)


raiz = NodoArvoreBinaria(10)
inserir_novo_nodo(raiz, 20)
inserir_novo_nodo(raiz, 30)

menor_elemento(raiz)
inserir_novo_nodo(raiz, 8)
menor_elemento(raiz)
inserir_novo_nodo(raiz, 9)
menor_elemento(raiz)
inserir_novo_nodo(raiz, 7)
menor_elemento(raiz)
inserir_novo_nodo(raiz, 5)
menor_elemento(raiz)
inserir_novo_nodo(raiz, 6)
menor_elemento(raiz)
inserir_novo_nodo(raiz, 1)
menor_elemento(raiz)