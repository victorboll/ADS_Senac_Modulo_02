from Arvore_Binaria import NodoArvoreBinaria, inserir_novo_nodo

"""3. Verifique se duas árvores binárias são idênticas."""

def armazenar_arvore_em_array_em_ordem(raiz, array):
    if raiz is None:
        return
    armazenar_arvore_em_array_em_ordem(raiz.esquerda, array)

    array.append(raiz.valor)

    armazenar_arvore_em_array_em_ordem(raiz.direita, array)

def armazenar_arvore_em_array_pre_ordem(raiz, array):
    if raiz is None:
        return

    array.append(raiz.valor)

    armazenar_arvore_em_array_pre_ordem(raiz.esquerda, array)

    armazenar_arvore_em_array_pre_ordem(raiz.direita, array)

def armazenar_arvore_em_array_pos_ordem(raiz, array):
    if raiz is None:
        return
    armazenar_arvore_em_array_pos_ordem(raiz.esquerda, array)

    armazenar_arvore_em_array_pos_ordem(raiz.direita, array)

    array.append(raiz.valor)

def comparar_arvores(raiz1, raiz2):
    array1 = []
    array2 = []
    armazenar_arvore_em_array_em_ordem(raiz1, array1)
    armazenar_arvore_em_array_em_ordem(raiz2, array2)
    armazenar_arvore_em_array_pre_ordem(raiz1, array1)
    armazenar_arvore_em_array_pre_ordem(raiz2, array2)
    armazenar_arvore_em_array_pos_ordem(raiz1, array1)
    armazenar_arvore_em_array_pos_ordem(raiz2, array2)
    if array1 == array2:
        return True
    else:
        return False


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

print(comparar_arvores(raiz2, raiz3))
print(comparar_arvores(raiz2, raiz4))
print(comparar_arvores(raiz2, raiz5))
print(comparar_arvores(raiz2, raiz6))
print(comparar_arvores(raiz4, raiz6))
