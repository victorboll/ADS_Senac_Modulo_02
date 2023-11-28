from Arvore_Binaria import NodoArvoreBinaria, inserir_novo_nodo

"""6. Determine se uma árvore é simétrica."""

def armazenar_alturas_em_array_em_ordem(raiz, array, altura=-1):
    altura += 1

    if raiz is None:
        return

    armazenar_alturas_em_array_em_ordem(raiz.esquerda, array, altura)

    array.append(altura)

    armazenar_alturas_em_array_em_ordem(raiz.direita, array, altura)

def inverter_array(array):
    for i in range(len(array)//2):
        array[i], array[len(array)-1-i] = array[len(array)-1-i], array[i]

def verificar_simetria(raiz):
    direita=[]
    esquerda=[]
    armazenar_alturas_em_array_em_ordem(raiz.esquerda, esquerda)
    armazenar_alturas_em_array_em_ordem(raiz.direita, direita)
    inverter_array(direita)
    print(direita)
    print(esquerda)
    if direita == esquerda:
        print('iguais')
    else:
        print('diferentes')


array = [4, 3, 4, 2, 1, 2, 0, 1, 2, 4, 5, 3, 4, 5, 6]
print(array)
inverter_array(array)
print(array)

raiz = NodoArvoreBinaria(50)
verificar_simetria(raiz)
inserir_novo_nodo(raiz, 2)
verificar_simetria(raiz)
inserir_novo_nodo(raiz, 60)
verificar_simetria(raiz)
inserir_novo_nodo(raiz, 61)
verificar_simetria(raiz)
inserir_novo_nodo(raiz, 1)
verificar_simetria(raiz)
inserir_novo_nodo(raiz, 55)
verificar_simetria(raiz)
inserir_novo_nodo(raiz, 54)
verificar_simetria(raiz)
inserir_novo_nodo(raiz, 3)
verificar_simetria(raiz)
inserir_novo_nodo(raiz, 4)
verificar_simetria(raiz)

print('---------------------------')

raiz2 = NodoArvoreBinaria(50)
inserir_novo_nodo(raiz2, 1)
inserir_novo_nodo(raiz2, 2)
inserir_novo_nodo(raiz2, 3)
inserir_novo_nodo(raiz2, 4)
inserir_novo_nodo(raiz2, 54)
inserir_novo_nodo(raiz2, 55)
inserir_novo_nodo(raiz2, 60)
inserir_novo_nodo(raiz2, 61)
verificar_simetria(raiz2)

print('---------------------------')

raiz3 = NodoArvoreBinaria(50)
inserir_novo_nodo(raiz3, 1)
inserir_novo_nodo(raiz3, 2)
inserir_novo_nodo(raiz3, 3)
inserir_novo_nodo(raiz3, 4)
inserir_novo_nodo(raiz3, 61)
inserir_novo_nodo(raiz3, 60)
inserir_novo_nodo(raiz3, 55)
inserir_novo_nodo(raiz3, 54)
verificar_simetria(raiz3)

print('---------------------------')

raiz4 = NodoArvoreBinaria(50)
inserir_novo_nodo(raiz4, 1)
inserir_novo_nodo(raiz4, 2)
inserir_novo_nodo(raiz4, 3)
inserir_novo_nodo(raiz4, 4)
inserir_novo_nodo(raiz4, 54)
inserir_novo_nodo(raiz4, 60)
inserir_novo_nodo(raiz4, 55)
inserir_novo_nodo(raiz4, 61)
verificar_simetria(raiz4)

print('---------------------------')

raiz5 = NodoArvoreBinaria(50)
inserir_novo_nodo(raiz5, 1)
inserir_novo_nodo(raiz5, 2)
inserir_novo_nodo(raiz5, 3)
inserir_novo_nodo(raiz5, 4)
inserir_novo_nodo(raiz5, 54)
inserir_novo_nodo(raiz4, 60)
inserir_novo_nodo(raiz4, 55)
inserir_novo_nodo(raiz4, 61)
verificar_simetria(raiz4)