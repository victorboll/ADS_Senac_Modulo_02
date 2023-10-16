class ItemPilha:
    def __init__(self, valor=0, item_anterior=None):
        self.valor = valor
        self.anterior = item_anterior

    def __str__(self):
        return f'{self.anterior} <- {self.valor}'


class Pilha:
    def __init__(self):
        self.topo = None

    def __str__(self):
        return f'[ {self.topo} ]'

    def inserir_Item(self, valor):
        item = ItemPilha(valor, self.topo)
        self.topo = item

    def remover_Item(self):
        if self.topo == None:
            return 'Não há elementos na lista'
        elif self.topo.anterior == None:
            self.topo = None
        else:
            self.topo = self.topo.anterior


pilha = Pilha()
pilha.inserir_Item(1)
pilha.inserir_Item(2)
pilha.inserir_Item(4)
pilha.inserir_Item(5)
pilha.inserir_Item(3)

print(pilha)

pilha.remover_Item()
pilha.remover_Item()
pilha.remover_Item()
print(pilha)


"""1. Escrever uma função que receba como parâmetro uma pilha. A função deve retornar o maior elemento da pilha."""
#maior de mais alto ou maior de maior valor? E se for maior valor, como comparar valores como listas com intergers?
def buscar_Maior_elemento(pilha):
    item_analisado = pilha.topo
    maior_valor = pilha.topo.valor
    while item_analisado.anterior != None:
        item_analisado = item_analisado.anterior
        if maior_valor < item_analisado.valor:
            maior_valor = item_analisado.valor
    return f'\n\n O maior valor é {maior_valor}\n'


pilha.inserir_Item(6)
pilha.inserir_Item(7)
pilha.inserir_Item(10)
pilha.inserir_Item(9)
pilha.inserir_Item(8)
print(pilha)
print(buscar_Maior_elemento(pilha))

"""2. Utilizando uma pilha resolver o exercício a seguir: Dada uma sequência contendo N (N >0) números reais, 
imprimi-la na ordem inversa."""
def imprimir_Sequencia_Ordem_Inversa(sequencia):
    print('\nInício da impressão da sequência inversa')
    print(f'sequência = {sequencia}')
    pilha_temporaria = Pilha()
    for i in sequencia:
        pilha_temporaria.inserir_Item(i)
    item_analisado = pilha_temporaria.topo
    while item_analisado.anterior != None:
        print(item_analisado.valor)
        item_analisado = item_analisado.anterior
    print(item_analisado.valor)
    print('Fim da impressão da sequência inversa\n\n')


sequencia = [1, 6, 8, 9, 7, 2, 3, 5, 1, 4, 6]
imprimir_Sequencia_Ordem_Inversa(sequencia)

"""3. Escreva uma função que receba como parâmetro duas pilhas e verifique de elas são iguais. Duas pilhas são iguais 
se possuem os mesmos elementos, na mesma ordem."""
def verificar_se_duas_pilhas_sao_iguais(pilha1, pilha2):
    item_analisado_pilha1 = pilha1.topo
    item_analisado_pilha2 = pilha2.topo
    while item_analisado_pilha1.valor == item_analisado_pilha2.valor and (item_analisado_pilha1.anterior != None and item_analisado_pilha1.anterior != None):
        item_analisado_pilha1 = item_analisado_pilha1.anterior
        item_analisado_pilha2 = item_analisado_pilha2.anterior
    if item_analisado_pilha1.valor == item_analisado_pilha2.valor and (item_analisado_pilha1.anterior == None and item_analisado_pilha1.anterior == None):
        return 'pilhas iguais'
    else:
        return 'pilhas diferentes'


pilha1 = Pilha()
pilha1.inserir_Item(1)
pilha1.inserir_Item(2)
pilha1.inserir_Item(4)
pilha1.inserir_Item(4)
pilha1.inserir_Item(4)
pilha1.inserir_Item(5)
pilha1.inserir_Item(3)
pilha2 = Pilha()
pilha2.inserir_Item(1)
pilha2.inserir_Item(2)
pilha2.inserir_Item(4)
pilha2.inserir_Item(4)
pilha2.inserir_Item(4)
pilha2.inserir_Item(5)
pilha2.inserir_Item(3)

print(pilha1)
print(pilha2)
print(verificar_se_duas_pilhas_sao_iguais(pilha1, pilha2))

pilha1.inserir_Item(3)
pilha2.inserir_Item(4)

print(pilha1)
print(pilha2)
print(verificar_se_duas_pilhas_sao_iguais(pilha1, pilha2))

pilha1.remover_Item()
pilha2.remover_Item()
pilha2.inserir_Item(5)

print(pilha1)
print(pilha2)
print(verificar_se_duas_pilhas_sao_iguais(pilha1, pilha2))


"""5. Implemente uma função chamada TPilha, que receba um vetor de inteiros com 15 elementos. 
Para cada um deles, como segue: 
-Se o número for par, insira-o na pilha; 
-Se o número lido for ímpar, retire um número da pilha; 
-Ao final, esvazie a pilha imprimindo os elementos"""

def tPilha(vetor):
    pilha_temporaria = Pilha()
    for i in vetor:
        if i % 2 == 0:
            pilha_temporaria.inserir_Item(i)
        elif i % 2 != 0:
            pilha_temporaria.remover_Item()
    print(pilha_temporaria)
    if pilha_temporaria.topo == None:
        print('Pilha vazia')
    elif pilha_temporaria.topo.anterior != None:
        while pilha_temporaria.topo.anterior != None:
            print(pilha_temporaria.topo.valor)
            pilha_temporaria.remover_Item()
        print(pilha_temporaria.topo.valor)



vetor1=[]
for i in range(0, 30, 2):
    vetor1.append(i)
print(f'\n\n{vetor1}')
tPilha(vetor1)

vetor2=[]
for i in range(1, 16):
    vetor2.append(i)
print(f'\n\n{vetor2}')
tPilha(vetor2)

vetor3 = [1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 1, 2, 1, 2, 2]
print(f'\n\n{vetor3}')
tPilha(vetor3)


"""6. Escreva uma função TPilha2 que recebe como parâmetro 2 pilhas (N e P) e um vetor de inteiros. Para cada um: 
se positivo, inserir na pilha P; 
se negativo, inserir na pilha N; 
se zero, retirar um elemento de cada pilha."""

