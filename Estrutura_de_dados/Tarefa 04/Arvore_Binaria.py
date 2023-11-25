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

def listar_nodos_em_ordem(raiz):
    if raiz is None:
        return

    listar_nodos_em_ordem(raiz.esquerda)

    print(raiz.valor)

    listar_nodos_em_ordem(raiz.direita)