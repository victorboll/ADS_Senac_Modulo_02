class NodoArvoreBinaria:
    def __init__(self, valor=None, direita=None, esquerda=None):
        self.valor = valor
        self.direita = direita
        self.esquerda = esquerda

    def __repr__(self):
        return f'{self.esquerda and self.esquerda.valor} <- {self.valor} -> {self.direita and self.direita.valor}'


def inserir_novo_nodo(raiz, valor):
    if raiz == None:
        return
    elif raiz.valor > valor:
        if raiz.esquerda == None:
            raiz.esquerda = NodoArvoreBinaria(valor)
        else:
            inserir_novo_nodo(raiz.esquerda, valor)
    elif raiz.valor < valor:
        if raiz.direita == None:
            raiz.direita = NodoArvoreBinaria(valor)
        else:
            inserir_novo_nodo(raiz.direita, valor)


raiz = NodoArvoreBinaria(10)
inserir_novo_nodo(raiz, 20)
inserir_novo_nodo(raiz, 30)

print(raiz)
print(raiz.direita)

"""1. Encontre o menor elemento em uma BST."""
def menor_elemento(raiz):
    if raiz.esquerda == None:
        print(f'O menor elemento é {raiz.valor}')
    else:
        menor_elemento(raiz.esquerda)


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


"""2. Encontre o maior elemento em uma BST."""
def maior_elemento(raiz):
    if raiz.direita == None:
        print(f'O maior elemento é {raiz.valor}')
    else:
        maior_elemento(raiz.direita)


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


"""3. Verifique se duas árvores binárias são idênticas."""
def listar_nodos_em_ordem(raiz):
    if raiz is None:
        return

    listar_nodos_em_ordem(raiz.esquerda)

    print(raiz.valor)

    listar_nodos_em_ordem(raiz.direita)


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


"""4. Calcule a altura de uma BST."""

def armazenar_alturas_em_array_em_ordem(raiz, array, altura=-1):
    altura += 1

    if raiz is None:
        return

    armazenar_alturas_em_array_em_ordem(raiz.esquerda, array, altura)

    array.append(altura)

    armazenar_alturas_em_array_em_ordem(raiz.direita, array, altura)


array9 = []
armazenar_alturas_em_array_em_ordem(raiz, array9)
print(array9)

def altura_arvore(raiz):
    array = []
    armazenar_alturas_em_array_em_ordem(raiz, array)
    altura = 0
    for i in array:
        if altura < i: altura = i
    print(altura)


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