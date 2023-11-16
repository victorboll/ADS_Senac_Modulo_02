class NodoArvore:
    def __init__(self, chave=None, esquerda=None, direita=None):
        self.chave = chave
        self.esquerda = esquerda
        self.direita = direita

    def __repr__(self):
        return f'{self.esquerda and self.esquerda.chave} <- {self.chave} -> {self.direita and self.direita.chave}'
        """No caso ele vai retornar somente se existir o self esquerda, e aí ele vai retornar o valor que está 
        dentro do atributo chave"""


raiz = NodoArvore(3)
raiz.esquerda = NodoArvore(5)
raiz.direita = NodoArvore(1)
print("Árvore: ", raiz)

def em_ordem(raiz):
    if not raiz: #Para quando for None, ele não faz as ações, ele termina a recursão se o "ramo" deu none.
        return

    #Visita filho da esquerda.
    em_ordem(raiz.esquerda)

    #Visita nodo corrente.
    print(raiz.chave)

    #Visita filho direita.
    em_ordem(raiz.direita)


raiz2 = NodoArvore(40)

raiz2.esquerda = NodoArvore(20)
raiz2.direita = NodoArvore(60)

raiz2.direita.esquerda = NodoArvore(50)
raiz2.direita.direita = NodoArvore(70)
raiz2.esquerda.esquerda = NodoArvore(10)
raiz2.esquerda.direita = NodoArvore(30)

em_ordem(raiz2)

print("Árvore: ", raiz2)
print("Árvore: ", raiz2.direita)
print("Árvore: ", raiz2.esquerda)
print("Árvore: ", raiz2.esquerda.esquerda)


def pre_ordem(raiz):
    if not raiz:
        return

    print(raiz.chave)

    pre_ordem(raiz.esquerda)

    pre_ordem(raiz.direita)


def pos_ordem(raiz):
    if not raiz:
        return

    pos_ordem(raiz.esquerda)

    pos_ordem(raiz.direita)

    print(raiz.chave)

print()
pre_ordem(raiz2)
print()
pos_ordem(raiz2)


def insere(raiz, nodo):
    """Insere um nodo em uma árvore binária de pesquisa."""
    #Nodo deve ser inserido na raiz.
    if raiz is None:
        raiz = nodo

    #Nodo deve ser inserido na subárvore direita
    elif raiz.chave < nodo.chave:
        if raiz.direita is None:
            raiz.direita = nodo
        else:
            insere(raiz.direita, nodo)

    #Nodo deve ser inserido na subárvore esquerda
    else:
        if raiz.esquerda is None:
            raiz.esquerda = nodo
        else:
            insere(raiz.esquerda, nodo)


array = (1, 3, 7, 0, 5, 2, 4, 9, 8)
raiz3 = NodoArvore(-1)
for i in array:
    nodo = NodoArvore(i)
    insere(raiz3, nodo)

em_ordem(raiz3)
print(raiz3)


def busca(raiz, chave):
    """Procura por uma chave em uma árvore binária de pesquisa"""
    # Trata o caso que a chave procurada não está presente.
    if raiz is None:
        return None

    # A chave procurada está na raiz da árvore.
    elif raiz.chave == chave:
        return raiz

    #A chave procurada é maior que a da raiz.
    elif raiz.chave < chave:
        return busca(raiz.direita, chave)

    #A chave procurada é menor que a da raiz.
    elif raiz.chave > chave:
        return busca(raiz.esquerda, chave)


#Cria uma árvore binária para testar a função busca:
raiz4 = NodoArvore(40)
for chave in [20, 60, 50, 70, 10, 30]:
    nodo = NodoArvore(chave)
    insere(raiz, nodo)

#Procura por valores na árvore.
for chave in [-50, 10, 30, 70, 100]:
    resultado = busca(raiz, chave)
    if resultado:
        print("Busca pela chave {}: Sucesso!".format(chave))
    else:
        print("Busca pela chave {}: Falha!".format(chave))