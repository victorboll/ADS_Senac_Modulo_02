class Nodo:
    """Esta classe representa um nodo de uma estrutura duplamente encadeada."""
    def __init__(self, dado=0, proximo_nodo=None):
        self.dado = dado
        self.proximo = proximo_nodo

    def __repr__(self):
        return '%s -> %s' % (self.dado, self.proximo)
        #else: return f'{self.dado}'


class Fila:
    """Esta classe representa um nodo de uma estrutura duplamente encadeada."""

    def __init__(self):
        self.primeiro = None
        self.ultimo = None

    def __repr__(self):
        return "[" + str(self.primeiro) + "]"

    def insere(self, novo_dado):
        """Insere um elemento no final da fila"""

        #Cria um novo nodo com o dado a ser armazenado.
        novo_nodo = Nodo(novo_dado)

        #Insere em uma fila vazia.
        if self.primeiro == None:
            self.primeiro == novo_nodo
            self.ultimo == novo_nodo
        else:
            #Faz com que o novo nodo seja o último da fila.
            self.ultimo.proximo = novo_nodo

            #Faz com que o último da fila referencie o novo nodo.
            self.ultimo = novo_nodo

    def remove(self):
        """Retira um elemento do começo da fila."""

        assert self.primeiro != None, "Impossível remover elemento de fila vazia."

        self.primeiro = self.primeiro.proximo

        if self.primeiro == None:
            self.ultimo = None


fila = Fila()
fila.insere(2)
fila.insere(5)
fila.insere(10)
fila.insere(8)
fila.insere(23)

print(fila)