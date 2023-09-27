class Nodo:
    """Esta classe representa um nodo de uma estrutura encadeada."""
    def __init__(self, dado=0, nodo_anterior=None):
        self.dado = dado
        self.anterior = nodo_anterior

    def __repr__(self):
        return '%s -> %s' % (self.anterior, self.dado)


class Pilha:
    """Esta classe representa uma pilha usando uma estrutura encadeada."""

    def __init__(self):
        self.topo = None

    def __repr__(self):
        return "[" + str(self.topo) + "]"

    def insere(self, novo_dado):
        """Insere um elemento no final da pilha"""

        #Cria um novo nodo com o dado a ser armazenado
        novo_nodo = Nodo(novo_dado)

        #Faz com que o anterior do novo nodo criado seja quem era o topo da pilha antes da inclusão desse novo nodo.
        novo_nodo.anterior = self.topo

        #Faz com que a cabeça da lista referencie o novo nodo.
        self.topo = novo_nodo

stack = Pilha()
stack.insere(5)
stack.insere(7)

print("Lista vazia: ", stack)