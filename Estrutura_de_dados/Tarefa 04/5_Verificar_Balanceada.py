from Arvore_Binaria import NodoArvoreBinaria, inserir_novo_nodo

"""
5. Verifique se uma árvore binária é balanceada.
"""

def verificar_balanceada(raiz):
    if raiz.direta is None and raiz.esquerda is None:
        return True
    elif raiz.direita is None and