from Arvore_Binaria import NodoArvoreBinaria, inserir_novo_nodo

"""4. Calcule a altura de uma BST."""

def armazenar_alturas_em_array_em_ordem(raiz, array, altura=-1):
    altura += 1

    if raiz is None:
        return

    armazenar_alturas_em_array_em_ordem(raiz.esquerda, array, altura)

    array.append(altura)

    armazenar_alturas_em_array_em_ordem(raiz.direita, array, altura)

def altura_arvore(raiz):
    array = []
    armazenar_alturas_em_array_em_ordem(raiz, array)
    altura = 0
    for i in array:
        if altura < i: altura = i
    print(altura)


raiz = NodoArvoreBinaria(10)
inserir_novo_nodo(raiz, 20)
inserir_novo_nodo(raiz, 30)

inserir_novo_nodo(raiz, 8)
inserir_novo_nodo(raiz, 9)
inserir_novo_nodo(raiz, 7)
inserir_novo_nodo(raiz, 5)
inserir_novo_nodo(raiz, 6)
inserir_novo_nodo(raiz, 1)
inserir_novo_nodo(raiz, 50)
inserir_novo_nodo(raiz, 40)
inserir_novo_nodo(raiz, 45)
inserir_novo_nodo(raiz, 60)
inserir_novo_nodo(raiz, 64)
inserir_novo_nodo(raiz, 100)

raiz2 = NodoArvoreBinaria(50)
raiz3 = NodoArvoreBinaria(50)
raiz4 = NodoArvoreBinaria(50)
raiz5 = NodoArvoreBinaria(40)
raiz6 = NodoArvoreBinaria(50)

for i in [10, 20, 30, 40, 60, 70, 80, 90, 100]:
    inserir_novo_nodo(raiz2, i)

for i in [10, 20, 30, 40, 60, 70, 80, 90, 100]:
    inserir_novo_nodo(raiz3, i)

for i in [20, 10, 40, 30, 70, 60, 90, 80, 100]:
    inserir_novo_nodo(raiz4, i)

for i in [10, 20, 30, 40, 60, 70, 80, 90, 100]:
    inserir_novo_nodo(raiz5, i)

for i in [20, 10, 40, 30, 70, 60, 90, 80, 100]:
    inserir_novo_nodo(raiz6, i)

array9 = []
armazenar_alturas_em_array_em_ordem(raiz, array9)
print(array9)

altura_arvore(raiz)
altura_arvore(raiz2)
altura_arvore(raiz3)
altura_arvore(raiz4)
altura_arvore(raiz5)
altura_arvore(raiz6)

raiz7 = NodoArvoreBinaria(50)
altura_arvore(raiz7)

def altura_arvore_2(raiz, altura=-1):
    if raiz is None:
        return altura

    altura += 1

    if altura_arvore_2(raiz.esquerda, altura) > altura_arvore_2(raiz.direita, altura):
        return altura_arvore_2(raiz.esquerda, altura)
    else:
        return altura_arvore_2(raiz.direita, altura)


print('-----------------')
print(altura_arvore_2(raiz))
print(altura_arvore_2(raiz2))
print(altura_arvore_2(raiz3))
print(altura_arvore_2(raiz4))
print(altura_arvore_2(raiz5))
print(altura_arvore_2(raiz6))
print(altura_arvore_2(raiz7))
