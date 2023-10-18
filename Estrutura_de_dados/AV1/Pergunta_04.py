"""4) Implemente uma lista circular com estrutura encadeada com os seguintes métodos: inserção, remoção e busca."""


class Item:
    def __init__(self, valor=0):
        self.valor = valor
        self.proximo = None



class Lista_Circular:
    def __init__(self):
        self.cabeca = None
        self.cauda = None
        self.tamanho_atual = 0

    def inserir_item(self, valor):
        if self.cabeca == None:
            item = Item(valor)
            self.cabeca = item
            self.cauda = item
            self.cauda.proximo = self.cabeca
            self.tamanho_atual += 1
        else:
            item = Item(valor)
            item.proximo = self.cabeca
            self.cabeca = item
            self.cauda.proximo = self.cabeca
            self.tamanho_atual += 1

    def busca_item(self, valor):
        contador = 0
        encontrado = False
        if self.cabeca == None:
            print('Lista vazia')
        else:
            item_procurado = self.cabeca
            while item_procurado != self.cauda:
                if item_procurado.valor == valor and not encontrado:
                    print(f'O item se encontra na posicao {contador}')
                    encontrado = True
                elif item_procurado.valor == valor and not encontrado:
                    print(f'O item se encontra na posicao {contador}')
                item_procurado = item_procurado.proximo
                contador += 1
            if item_procurado.valor == valor and not encontrado:
                print(f'O item se encontra na posicao {contador}')
                encontrado = True
            elif item_procurado.valor == valor and not encontrado:
                print(f'O item se encontra na posicao {contador}')
            if not encontrado:
                print('Item não se encontra na lista')

    def busca_item_com_atributo_tamanho_atual(self, valor):
        encontrado = False
        if self.cabeca == None:
            print('Lista vazia')
        else:
            item_procurado = self.cabeca
            for i in range(self.tamanho_atual):
                if item_procurado.valor == valor and not encontrado:
                    print(f'O item se encontra na posicao {i}')
                    encontrado = True
                elif item_procurado.valor == valor and not encontrado:
                    print(f'O item se encontra na posicao {i}')
                item_procurado = item_procurado.proximo
            if not encontrado:
                print('Item não se encontra na lista')







lista = Lista_Circular()
lista.busca_item(5)
lista.inserir_item(5)
lista.inserir_item(6)
lista.inserir_item(7)
lista.inserir_item(8)
lista.inserir_item(9)
lista.busca_item(9)
lista.busca_item(8)
lista.busca_item(7)
lista.busca_item(6)
lista.busca_item(5)
lista.busca_item(4)
lista.busca_item_com_atributo_tamanho_atual(9)
lista.busca_item_com_atributo_tamanho_atual(8)
lista.busca_item_com_atributo_tamanho_atual(7)
lista.busca_item_com_atributo_tamanho_atual(6)
lista.busca_item_com_atributo_tamanho_atual(5)
lista.busca_item_com_atributo_tamanho_atual(4)



