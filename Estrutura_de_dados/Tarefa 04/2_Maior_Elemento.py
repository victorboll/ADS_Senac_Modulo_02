from Arvore_Binaria import NodoArvoreBinaria, inserir_novo_nodo

"""2. Encontre o maior elemento em uma BST."""
def maior_elemento(raiz):
    if raiz.direita == None:
        print(f'O maior elemento é {raiz.valor}')
    else:
        maior_elemento(raiz.direita)


raiz = NodoArvoreBinaria(10)
inserir_novo_nodo(raiz, 20)
inserir_novo_nodo(raiz, 30)

inserir_novo_nodo(raiz, 8)
inserir_novo_nodo(raiz, 9)
inserir_novo_nodo(raiz, 7)
inserir_novo_nodo(raiz, 5)
inserir_novo_nodo(raiz, 6)
inserir_novo_nodo(raiz, 1)

maior_elemento(raiz)
inserir_novo_nodo(raiz, 50)
maior_elemento(raiz)
inserir_novo_nodo(raiz, 40)
maior_elemento(raiz)
inserir_novo_nodo(raiz, 45)
maior_elemento(raiz)
inserir_novo_nodo(raiz, 60)
maior_elemento(raiz)
inserir_novo_nodo(raiz, 64)
maior_elemento(raiz)
inserir_novo_nodo(raiz, 100)
maior_elemento(raiz)