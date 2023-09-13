class NodeLista:
    """Está classe representa o nodo de uma lista encadeada"""
    def __init__(self, dado=0, proximo_nodo=None):
        self.dado = dado
        self.proximo = proximo_nodo

    def __repr__(self): #Quando você der print na classe, essa informação abaixo é que vai aparecer
        return '%s --> %s' % (self.dado, self.proximo)

node01 = NodeLista(10)

print(node01)

class ListaEncadeada:
    """Esta classe representa uma lista encadeada"""
    def __int__(self):
        self.cabeca = None

    def __repr__(self):
        return "[" + str(self.cabeca) + "]"

