from Arvore_Binaria import NodoArvoreBinaria, inserir_novo_nodo

"""
5. Verifique se uma árvore binária é balanceada.
"""

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
    return altura


def verificar_balanceada(raiz):
    if raiz is None:
        return True

    altura_esquerda = altura_arvore(raiz.esquerda)
    altura_direita = altura_arvore(raiz.direita)

    if (abs(altura_esquerda - altura_direita) <= 1 and verificar_balanceada(raiz.esquerda)
            and verificar_balanceada(raiz.direita)):
        return True

    return False

def verificar_balanceada_2(raiz):
    def _verificar_balanceada_e_altura(raiz):
        if raiz is None:
            return True, 0

        esquerda_balanceada, altura_esquerda = _verificar_balanceada_e_altura(raiz.esquerda)
        direita_balanceada, altura_direita = _verificar_balanceada_e_altura(raiz.direita)

        altura_atual = 1 + max(altura_esquerda, altura_direita)

        if not esquerda_balanceada or not direita_balanceada or abs(altura_esquerda - altura_direita) > 1:
            return False, altura_atual

        return True, altura_atual

    balanceada, _ = _verificar_balanceada_e_altura(raiz)
    return balanceada


arvore_balanceada = NodoArvoreBinaria(10)
inserir_novo_nodo(arvore_balanceada, 5)
inserir_novo_nodo(arvore_balanceada, 15)
inserir_novo_nodo(arvore_balanceada, 3)
inserir_novo_nodo(arvore_balanceada, 7)
inserir_novo_nodo(arvore_balanceada, 12)
inserir_novo_nodo(arvore_balanceada, 18)

# Árvore não balanceada
arvore_nao_balanceada = NodoArvoreBinaria(10)
inserir_novo_nodo(arvore_nao_balanceada, 5)
inserir_novo_nodo(arvore_nao_balanceada, 15)
inserir_novo_nodo(arvore_nao_balanceada, 3)
inserir_novo_nodo(arvore_nao_balanceada, 7)
inserir_novo_nodo(arvore_nao_balanceada, 12)
inserir_novo_nodo(arvore_nao_balanceada, 17)
inserir_novo_nodo(arvore_nao_balanceada, 20)
inserir_novo_nodo(arvore_nao_balanceada, 21)
inserir_novo_nodo(arvore_nao_balanceada, 2)
inserir_novo_nodo(arvore_nao_balanceada, 1)

# Verificando se as árvores são balanceadas
print("Árvore balanceada é balanceada?", verificar_balanceada(arvore_balanceada))  # Deve retornar True
print("Árvore não balanceada é balanceada?", verificar_balanceada(arvore_nao_balanceada))  # Deve retornar False
print("Árvore balanceada é balanceada?", verificar_balanceada(arvore_balanceada))  # Deve retornar True
print("Árvore não balanceada é balanceada?", verificar_balanceada(arvore_nao_balanceada))  # Deve retornar False

arvore_balanceada2 = NodoArvoreBinaria(10)
inserir_novo_nodo(arvore_balanceada2, 5)
inserir_novo_nodo(arvore_balanceada2, 15)
inserir_novo_nodo(arvore_balanceada2, 3)
inserir_novo_nodo(arvore_balanceada2, 7)
inserir_novo_nodo(arvore_balanceada2, 12)
inserir_novo_nodo(arvore_balanceada2, 18)

# Criando uma árvore não balanceada
arvore_nao_balanceada2 = NodoArvoreBinaria(10)
inserir_novo_nodo(arvore_nao_balanceada2, 25)
inserir_novo_nodo(arvore_nao_balanceada2, 15)
inserir_novo_nodo(arvore_nao_balanceada2, 35)
inserir_novo_nodo(arvore_nao_balanceada2, 75)
inserir_novo_nodo(arvore_nao_balanceada2, 125)
inserir_novo_nodo(arvore_nao_balanceada2, 175)
inserir_novo_nodo(arvore_nao_balanceada2, 20)
inserir_novo_nodo(arvore_nao_balanceada2, 250)

# Criando uma árvore pequena balanceada
arvore_pequena_balanceada = NodoArvoreBinaria(5)
inserir_novo_nodo(arvore_pequena_balanceada, 3)
inserir_novo_nodo(arvore_pequena_balanceada, 8)
inserir_novo_nodo(arvore_pequena_balanceada, 2)
inserir_novo_nodo(arvore_pequena_balanceada, 4)
inserir_novo_nodo(arvore_pequena_balanceada, 6)
inserir_novo_nodo(arvore_pequena_balanceada, 9)

# Verificando se as árvores são balanceadas
print("Árvore balanceada é balanceada?", verificar_balanceada(arvore_balanceada2))  # Deve retornar True
print("Árvore não balanceada é balanceada?", verificar_balanceada(arvore_nao_balanceada2))  # Deve retornar False
print("Árvore pequena balanceada é balanceada?", verificar_balanceada(arvore_pequena_balanceada))  # Deve retornar True
print("Árvore balanceada é balanceada?", verificar_balanceada_2(arvore_balanceada2))  # Deve retornar True
print("Árvore não balanceada é balanceada?", verificar_balanceada_2(arvore_nao_balanceada2))  # Deve retornar False
print("Árvore pequena balanceada é balanceada?", verificar_balanceada_2(arvore_pequena_balanceada))  # Deve retornar True