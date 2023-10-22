"""3. Defina as funções inserção, remoção e busca como métodos da Classe Lista. (Vide apostila)"""

class ItemLista:
    def __init__(self, valor=0, proximo_item=None):
        self.valor = valor
        self.proximo = proximo_item

    def __str__(self):
        return f'{self.valor} -> {self.proximo}'


class Lista:
    def __init__(self):
        self.cabeca = None

    def __str__(self):
        return f'[ {self.cabeca} ]'


def adicionar_item_comeco(lista, valor):
    novo_item = ItemLista(valor, lista.cabeca)
    lista.cabeca = novo_item


lista = Lista()
print(lista)
adicionar_item_comeco(lista, 5)
print(lista)
adicionar_item_comeco(lista, 3)
print(lista)
adicionar_item_comeco(lista, 6)
print(lista)


def insere_item_final(lista, valor_novo_item):
    item_anterior = lista.cabeca
    while item_anterior.proximo != None:
        item_anterior = item_anterior.proximo
    item_anterior.proximo = ItemLista(valor_novo_item)


insere_item_final(lista, 10)
print(lista)
insere_item_final(lista, 12)
print(lista)


def insere_item_depois_posicao_escolhida(lista, valor_item_posicao_escolhida, valor_novo_item):
    item_verificado = lista.cabeca
    while item_verificado.valor != valor_item_posicao_escolhida:
        item_verificado = item_verificado.proximo
    novo_item = ItemLista(valor_novo_item, item_verificado.proximo)
    item_verificado.proximo = novo_item


insere_item_depois_posicao_escolhida(lista, 3, 7)
print(lista)
insere_item_depois_posicao_escolhida(lista, 6, 88)
print(lista)


def insere_item_antes_posicao_escolhida(lista, valor_item_posicao_escolhida, valor_novo_item):
    item_verificado = lista.cabeca
    if valor_item_posicao_escolhida == lista.cabeca.valor:
        novo_item = ItemLista(valor_novo_item, lista.cabeca)
        lista.cabeca = novo_item
    else:
        while item_verificado.proximo.valor != valor_item_posicao_escolhida:
            item_verificado = item_verificado.proximo
        novo_item = ItemLista(valor_novo_item, item_verificado.proximo)
        item_verificado.proximo = novo_item


insere_item_antes_posicao_escolhida(lista, 3, 4)
print(lista)
insere_item_antes_posicao_escolhida(lista, 6, 2)
print(lista)
insere_item_antes_posicao_escolhida(lista, 2, 2)
print(lista)
insere_item_antes_posicao_escolhida(lista, 2, 2)
print(lista)


def insere_item_pelo_index(lista, index, valor_novo_item):
    if index == 0:
        novo_item = ItemLista(valor_novo_item, lista.cabeca)
        lista.cabeca = novo_item
    else:
        item_anterior = lista.cabeca
        for i in range(index-1):
            item_anterior = item_anterior.proximo
        novo_item = ItemLista(valor_novo_item, item_anterior.proximo)
        item_anterior.proximo = novo_item


insere_item_pelo_index(lista, 5, 22)
print(lista)
insere_item_pelo_index(lista, 1, 36)
print(lista)
insere_item_pelo_index(lista, 0, 48)
print(lista)
insere_item_pelo_index(lista, 10, 2)
print(lista)

#Adicionar Busca e Remover

def remover_item_comeco(lista):
    lista.cabeca = lista.cabeca.proximo


remover_item_comeco(lista)
print(lista)
remover_item_comeco(lista)
print(lista)


def remove_item_final(lista):
    item_verificado = lista.cabeca
    while item_verificado.proximo.proximo != None:
        item_verificado = item_verificado.proximo
    item_verificado.proximo = None
#Mas aqui o garbage collector consegue tirar? Porque o último ainda vai estar apontando para o None.
#Então ambos ainda estão em uso


remove_item_final(lista)
print(lista)
remove_item_final(lista)
print(lista)

def buscar_item_valor(lista, valor):
    contador = 0;
    valor_analisado = lista.cabeca
    if valor == valor_analisado.valor:
        return lista.cabeca, f'O valor {valor} está na posição {contador} da lista, ele é a cabeça da lista'
    else:
        while valor_analisado.proximo.valor != valor and valor_analisado.proximo.proximo != None:
            valor_analisado = valor_analisado.proximo
            contador += 1
        if valor_analisado.proximo.valor == valor:
            contador += 1
            return valor_analisado, f'O valor {valor} está na posição {contador} da lista.'
        else:
            return f'O valor {valor} não está na lista.'
#Pensar em adicionar um novo atributo posicao quando um item for buscado


print(buscar_item_valor(lista, 36))
print(buscar_item_valor(lista, 88))
print(buscar_item_valor(lista, 100))


"""1. Implemente a função remove utilizando a função busca"""
def remover_valor(lista,valor):
    if buscar_item_valor(lista, valor)[0] == lista.cabeca:
        lista.cabeca = lista.cabeca.proximo
    elif len(buscar_item_valor(lista, valor)) != 2:
        print(buscar_item_valor(lista, valor))
    else:
        item = buscar_item_valor(lista, valor)[0]
        item.proximo = item.proximo.proximo


remover_valor(lista, 36)
print(lista)
remover_valor(lista, 88)
print(lista)
remover_valor(lista, 100)

def remover_item_pelo_index(lista, index):
    if index == 0:
        lista.cabeca = lista.cabeca.proximo
    else:
        item_anterior = lista.cabeca
        for i in range(index-1):
            item_anterior = item_anterior.proximo
        item_anterior.proximo = item_anterior.proximo.proximo


remover_item_pelo_index(lista, 3)
print(lista)
remover_item_pelo_index(lista, 0)
print(lista)


"""2. Remova duplicatas de uma lista ordenada. Suponha que lhe seja fornecida uma lista encadeada armazenando números 
inteiros em ordem crescente. Sua tarefa é remover todos os elementos duplicados da lista. Por exemplo, dada a lista 
[0 → 1 → 1 → 5 → 7 → 10 → 10 → None], seu programa deve retornar a lista [0 → 1 → 5 → 7 → 10 → None]."""
def remover_duplicatas(lista):
    posicao_geral = 0
    item_analisado = lista.cabeca
    while item_analisado.proximo != None:
        posicao_relativa = 0
        item_atual = item_analisado
        while item_atual.proximo != None:
            if posicao_relativa > 0 and item_analisado.valor == item_atual.valor:
                remover_item_pelo_index(lista, (posicao_geral + posicao_relativa))
            else:
                posicao_relativa += 1
            item_atual = item_atual.proximo
        if item_analisado.valor == item_analisado.proximo.valor and item_analisado.proximo.proximo == None:
            item_analisado.proximo = None
        else:
            item_analisado = item_analisado.proximo

        posicao_geral += 1



adicionar_item_comeco(lista, 6)
adicionar_item_comeco(lista, 6)
adicionar_item_comeco(lista, 6)
insere_item_final(lista, 12)
insere_item_final(lista, 12)
insere_item_final(lista, 12)
adicionar_item_comeco(lista, 60)
adicionar_item_comeco(lista, 60)
adicionar_item_comeco(lista, 60)
insere_item_final(lista, 60)
insere_item_final(lista, 120)
insere_item_final(lista, 120)
insere_item_final(lista, 120)
print(lista)
remover_duplicatas(lista)
print(lista)

lista2 = Lista()
adicionar_item_comeco(lista2, 7)
adicionar_item_comeco(lista2, 6)
adicionar_item_comeco(lista2, 6)
adicionar_item_comeco(lista2, 6)
print(lista2)
remover_duplicatas(lista2)
print(lista2)