"""1. Implemente uma fila dinâmica contendo todas as funcionalidades de uma fila padrão. Para isso, resolvar:
–Crie um nó padrão da fila.
–Crie uma função de inicialização da fila vazia
–Crie uma função push que cria e insere um novo nó para o final da fila.
–Crie uma função pop que remove o primeiro elemento da fila.

2. Crie uma função de busca em que o usuário insere um valor (inteiro) e o programa retorna a sua posição na fila.

3. Crie uma função que percorre e imprime todos os elementos da fila.
[1] [4] [5] [2] → [2] [5] [4] [1]

4. Escreva uma função que inverta a ordem dos elementos da fila.  Por exemplo:

"""

class Item:
    def __init__(self, valor=0):
        self.valor = valor
        self.proximo = None

    def __str__(self):
        return f'{self.valor} -> {self.proximo}'


class Fila:
    def __init__(self):
        self.primeiro = None
        self.ultimo = None

    def __str__(self):
        return f'[ {self.primeiro} ]'

    def push_item(self, valor):
        item = Item(valor)
        if self.primeiro == None:
            self.primeiro = item
            self.ultimo = item
        else:
            self.ultimo.proximo = item
            self.ultimo = item

    def pop_item(self):
        if self.primeiro == None:
            print('Fila vazia')
        else:
            self.primeiro = self.primeiro.proximo

    def buscar_item_por_valor(self, valor):
        item_analisado = self.primeiro
        index = 0
        encontrado = False
        while item_analisado != None:
            if item_analisado.valor == valor:
                if encontrado == False:
                    print(f'O valor {valor} está no {index+1}º lugar da fila')
                    encontrado = True
                else:
                    print(f'O valor {valor} também está no {index + 1}º lugar da fila')
            index += 1
            item_analisado = item_analisado.proximo
        if encontrado == False:
            print(f'O valor {valor} não está nessa fila')

    def imprimir_elementos(self):
        print(f'\n')
        item_analisado = self.primeiro
        index = 0
        if item_analisado == None:
            print(f'Fila vazia')
        else:
            while item_analisado != None:
                if item_analisado.proximo != None:
                    print(f'O valor {item_analisado.valor} é o {index + 1}º elemento da fila')
                else:
                    print(f'O valor {item_analisado.valor} é o {index + 1}º elemento da fila, e está na última posição.')
                index += 1
                item_analisado = item_analisado.proximo
        print(f'\n')

    def inverter_fila(self):
        print(f'\n[ {self.primeiro} ]')
        antigoPrimeiro = self.primeiro
        while antigoPrimeiro.proximo != None:
            novoPrimeiro = antigoPrimeiro.proximo
            antigoPrimeiro.proximo = antigoPrimeiro.proximo.proximo
            novoPrimeiro.proximo = self.primeiro
            self.primeiro = novoPrimeiro
            print(f'\n[ {self.primeiro} ]')







fila = Fila()
for i in range(5):
    print(fila)
    fila.push_item(i+1)
print(fila)
fila.push_item(2)
print(f'{fila}\n')


for i in range(6):
    fila.buscar_item_por_valor(i)

fila.imprimir_elementos()

fila.inverter_fila()

fila.imprimir_elementos()


for i in range(7):
    print(fila)
    fila.pop_item()



