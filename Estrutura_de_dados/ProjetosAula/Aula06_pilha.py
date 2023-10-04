class Nodo:
    """Esta classe representa um nodo de uma estrutura encadeada."""
    def __init__(self, dado=0, nodo_anterior=None):
        self.dado = dado
        self.anterior = nodo_anterior

    def __repr__(self):
        if self.anterior != None:
            return '%s -> %s' % (self.anterior, self.dado)
        else:
            return f'{self.dado}'


class Pilha:
    """Esta classe representa uma pilha usando uma estrutura encadeada."""

    def __init__(self):
        self.topo = None


    def __repr__(self):
        return "[" + str(self.topo) + " -> None]"


    def insere(self, novo_dado):
        """Insere um elemento no final da pilha"""

        #Cria um novo nodo com o dado a ser armazenado
        novo_nodo = Nodo(novo_dado)

        #Faz com que o anterior do novo nodo criado seja quem era o topo da pilha antes da inclusão desse novo nodo.
        novo_nodo.anterior = self.topo

        #Faz com que a cabeça da lista referencie o novo nodo.
        self.topo = novo_nodo

    def remove(self):
        """Remove o elemento que está no topo da pilha."""
        #Não precisa remover o topo antigo, porque como ninguém faz referência a ele, e ele não faz referência a ninguém, o garbage colector apaga ele da memória
        #Usar Try exept trás uma resposta mais bonitinha
        #try : self.topo = self.topo.anterior
        #except: print("Impossível remover valor da pilha vazia")
        assert self.topo, "Impossível remover valor da pilha vazia"

        self.topo = self.topo.anterior


        
        

    
stack = Pilha()
stack.insere(5)
stack.insere(7)
stack.insere(9)
stack.insere(1)
stack.insere(2)

print("Lista vazia: ", stack)

stack.remove()
stack.remove()
stack.remove()
stack.remove()
stack.remove()
stack.remove()
stack.remove()
stack.remove()
