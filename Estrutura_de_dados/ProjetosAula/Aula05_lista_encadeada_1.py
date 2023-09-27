class NodoLista:
    """Está classe representa o nodo de uma lista encadeada"""
    def __init__(self, dado=0, proximo_nodo=None):
        self.dado = dado
        self.proximo = proximo_nodo

    def __repr__(self): #Quando você der print na classe, essa informação abaixo é que vai aparecer
        return '%s --> %s' % (self.dado, self.proximo)


node01 = NodoLista(10)

print(node01)

class ListaEncadeada:
    """Esta classe representa uma lista encadeada"""
    def __int__(self, cabeca):
        self.cabeca = None

    def __repr__(self):
        return "[" + str(self.cabeca) + "]"

def insere_no_inicio(lista, novo_dado):
    # 1) Cria um novo nodo com o dado a ser armazenado.
    novo_nodo = NodoLista(novo_dado)

    # 2) Faz com que o novo nodo seja a cabeça da lista.
    novo_nodo.proximo = lista.cabeca

    # 3) Faz com que a cabeça da lista referencie o novo nodo
    lista.cabeca = novo_nodo


lista = ListaEncadeada()
print("Lista vazia: ", lista)

insere_no_inicio(lista, 5)
print("Lista contém um único elemento:", lista)

insere_no_inicio(lista, 10)
print("Inserindo um novo elemento:", lista)


def insere_depois(lista, nodo_anterior, novo_dado):
    assert nodo_anterior, "Nodo anterior precisa existir na lista."

    # Cria um novo nodo com o dado desejado.
    novo_nodo = NodoLista(novo_dado)

    # Daz o próximo do novo nodo ser o próximo do nodo anterior.
    novo_nodo.proximo = nodo_anterior.proximo

    # Faz com que o novo nodo seja o próximo do nodo anterior.
    nodo_anterior.proximo = novo_nodo

lista = ListaEncadeada()
print("Lista vazia:", lista)

insere_no_inicio(lista, 5)
print("Lista contém um único elemento: ", lista)

nodo_anterior = lista.cabeca
insere_depois(lista, nodo_anterior, 10)
print("Inserindo um novo elemento depois de um outro: ", lista)

lista = ListaEncadeada()
print("Lista vazia:", lista)

# A lista está vaiz, então lista.cabeça é None.
#A asserção produzirá um erro indicando isso.
insere_depois(lista, lista.cabeca, 10)
print("Inserindo um novo elemento:", lista)

def busca(lista, valor):
    corrente = lista.cabeca
    while corrente and corrente.dado != valor:
        corrente = corrente.proximo
    return corrente


lista = ListaEncadeada()
for i in range(8):
    insere_no_inicio(lista, 1)
print("Lista:", lista)

for i in range(8, -4, -2):
    elemento = busca(lista, i)
    if elemento:
        print("Elemento {0} presente na lista!".format(i))
    else:
        print("Elemento {0} não encontrado".format(i))


def remove(self, valor):
    assert self.cabeca, "Impossível remover o valor de lista vazia."

    # Nodo a ser removido é a cabeça da lista.
    if self.cabeca.dado == valor:
        self.cabeca = self.cabeca.proximo
    else:
        #Encontra a prosição do elemento a ser removido.
        anterior = None
        corrente = self.cabeca
        while corrente and corrente.dado != valor:
            anterior = None
            corrente = corrente.proximo
        #O nodo corrente é o nodo a ser removido.
        if corrente:
            anterior.proximo = corrente.proximo
        else:
            # O nodo corrente é a cauda da lista.
            anterior.proximo = None


lista = ListaEncadeada()
for i in range(5):
    insere_no_inicio(lista, 1)
print("Lista:", lista)

print("Removendo elementos:")
for i in range(5):
    remove(lista,i)
    print("Removendo o elemento {0}: {1}".format(i, lista))