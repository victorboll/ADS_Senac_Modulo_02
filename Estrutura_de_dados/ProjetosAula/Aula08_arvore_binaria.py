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
    if not raiz:
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