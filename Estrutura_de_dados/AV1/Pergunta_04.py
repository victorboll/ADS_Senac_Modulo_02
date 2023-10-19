"""4) Implemente uma lista circular com estrutura encadeada com os seguintes métodos: inserção, remoção e busca."""


class Item:
    def __init__(self, valor=0):
        self.valor = valor
        self.proximo = None

    def __str__(self):
        return f'{self.valor}'


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

    def visualizar_lista(self):
        if self.tamanho_atual == 0:
            print('Lista vazia')
        else:
            item_atual = self.cabeca
            print('[', end=' ')
            for i in range(self.tamanho_atual):
                if i+1 < self.tamanho_atual:
                    print(item_atual.valor, end=' -> ')
                else:
                    print(item_atual.valor,']')
                item_atual = item_atual.proximo


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
                elif item_procurado.valor == valor and encontrado:
                    print(f'O item também se encontra na posicao {contador}')
                item_procurado = item_procurado.proximo
                contador += 1
            if item_procurado.valor == valor and not encontrado:
                print(f'O item se encontra na última posicao da lista, que seria {contador}')
                encontrado = True
            elif item_procurado.valor == valor and encontrado:
                print(f'O item também se encontra na última posicao da lista. que seria {contador}')
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
                elif item_procurado.valor == valor and encontrado:
                    print(f'O item também se encontra na posicao {i}')
                item_procurado = item_procurado.proximo
            if not encontrado:
                print('Item não se encontra na lista')

    def remover_valor(self, valor):
        item_analisado = self.cabeca
        item_removido = False
        if item_analisado == None:
            print('Lista vazia')
        else:
            while True:
                if item_analisado == self.cabeca and item_analisado.valor == valor:
                    self.cabeca = item_analisado.proximo
                    self.cauda.proximo = self.cabeca
                    item_analisado.proximo = None
                    item_analisado = self.cabeca
                    self.tamanho_atual -= 1
                    item_removido = True
                    print('removido cabeca')
                elif item_analisado.proximo == self.cauda and item_analisado.proximo.valor == valor:
                    item_analisado.proximo = self.cabeca
                    self.cauda = item_analisado
                    print('removido cauda')
                    self.tamanho_atual -= 1
                    item_removido = True
                elif item_analisado.proximo.valor == valor:
                    item_analisado.proximo = item_analisado.proximo.proximo
                    print('item removido')
                    self.tamanho_atual -= 1
                    item_removido = True
                else:
                    item_analisado = item_analisado.proximo
                if item_analisado.proximo == self.cabeca: break
            if not item_removido:
                print('Valor informado não encontrado na lista')

    def remover_valor_com_atributo_tamanho_atual(self, valor):
        item_analisado = self.cabeca
        item_removido = False
        contador = 0
        if self.tamanho_atual == 0:
            print('Lista vazia')
        else:
            while contador < self.tamanho_atual:
                if contador == 0 and item_analisado == self.cabeca and item_analisado.valor == valor:
                    self.cabeca = item_analisado.proximo
                    self.cauda.proximo = self.cabeca
                    item_analisado.proximo = None
                    item_analisado = self.cabeca
                    self.tamanho_atual -= 1
                    item_removido = True
                    print('removido cabeca')
                elif item_analisado.proximo == self.cauda and item_analisado.proximo.valor == valor:
                    item_analisado.proximo = self.cabeca
                    self.cauda = item_analisado
                    print('removido cauda')
                    self.tamanho_atual -= 1
                    item_removido = True
                elif item_analisado.proximo.valor == valor:
                    item_analisado.proximo = item_analisado.proximo.proximo
                    print('item removido')
                    self.tamanho_atual -= 1
                    item_removido = True
                else:
                    item_analisado = item_analisado.proximo
                    contador += 1
            if not item_removido:
                print('Valor informado não encontrado na lista')



lista = Lista_Circular()
lista.busca_item(5)
lista.inserir_item(5)
lista.inserir_item(5)
lista.inserir_item(5)
lista.inserir_item(5)
lista.inserir_item(6)
lista.inserir_item(7)
lista.inserir_item(5)
lista.inserir_item(5)
lista.inserir_item(8)
lista.inserir_item(9)
lista.visualizar_lista()
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
lista.remover_valor(9)
lista.busca_item_com_atributo_tamanho_atual(9)
lista.busca_item_com_atributo_tamanho_atual(8)
lista.remover_valor(8)
lista.busca_item_com_atributo_tamanho_atual(8)
lista.busca_item_com_atributo_tamanho_atual(7)
lista.remover_valor(8)
lista.remover_valor(5)
lista.busca_item_com_atributo_tamanho_atual(5)
lista.remover_valor(5)
<<<<<<< HEAD
=======
lista.remover_valor(5)
lista.visualizar_lista()
lista.inserir_item(5)
lista.inserir_item(5)
lista.inserir_item(5)
lista.inserir_item(5)
lista.inserir_item(6)
lista.inserir_item(7)
lista.inserir_item(5)
lista.inserir_item(5)
lista.inserir_item(8)
lista.inserir_item(9)
lista.visualizar_lista()
lista.remover_valor_com_atributo_tamanho_atual(5)
lista.visualizar_lista()
lista.remover_valor_com_atributo_tamanho_atual(8)
lista.visualizar_lista()
lista.remover_valor_com_atributo_tamanho_atual(9)
lista.visualizar_lista()
lista.remover_valor_com_atributo_tamanho_atual(10)
lista.visualizar_lista()
lista.remover_valor_com_atributo_tamanho_atual(7)
lista.visualizar_lista()
lista.remover_valor_com_atributo_tamanho_atual(6)
lista.visualizar_lista()
>>>>>>> b37e1373a8d3e2c7bf02131403efb1796b5259ce
