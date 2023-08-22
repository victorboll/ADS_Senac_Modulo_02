"""
Faça um Programa para uma loja de tintas. O programa deverá pedir o tamanho em metros quadrados da área a ser pintada.
Considere que a cobertura da tinta é de 1 litro para cada 6 metros quadrados e que a tinta é vendida em latas de
18 litros, que custam RS 80,00 ou em galões de 3,6 litros, que custam R$ 25,00.

Informe ao usuário as quantidades de tinta a serem compradas e os respectivos preços em 3 situações:

comprar apenas latas de 18 litros;

comprar apenas galões de 3,6 litros;

misturar latas e galões, de forma que o preço seja o menor. Acrescente 10% de folga e sempre arredonde os valores para
cima, isto é, considere latas cheias.
"""

import math

area = float(input('Insira a área em metros quadrados que será pintada: '))
litros = area/6
galao = math.ceil(litros/18)

print(f'A quantidade de latas necessárias para pintar uma área de {area} metros quadrados, seria {int(galao)} '
      f'galao, e o preço total será {(galao*80):.2f}.')

lata = math.ceil(litros/3.6)

print(f'A quantidade de latas necessárias para pintar uma área de {area} metros quadrados, seria {int(lata)} '
      f'latas, e o preço total será {(lata*25):.2f}.')

galao, lata = 0, 0
litros *= 1.1
if litros >= 18:
    galao = litros//18
    litros = round((litros - galao*18), 13)
    """Quando não dava round(), quando ele diminuia 3.6 de 10.8, estava dando
    7.200000000000001, o que dava um erro na conta"""
    print(litros)
if litros > 10.8:
    galao += 1
elif litros > 0:
    lata = math.ceil(litros / 3.6)

if galao > 0 and lata > 0:
    print(f'Tendo em vista o melhor custo, para pintar uma área de {area} metros quadrados, '
          f'será necessário {int(galao)} galoes e {int(lata)} latas, o preço total será '
          f'R${(lata * 25 + galao * 80):.2f} (R${(lata * 25):.2f} pelas latas e R${(galao * 80):.2f} pelos galoes.')
elif galao > 0 and lata == 0:
    print(f'Tendo em vista o melhor custo, para pintar uma área de {area} metros quadrados, '
          f'será necessário {int(galao)} galoes, o preço total será R${(galao * 80):.2f}.')
else:
    print(f'Tendo em vista o melhor custo, para pintar uma área de {area} metros quadrados, '
          f'será necessário {int(lata)} latas, o preço total será R${(lata * 25):.2f}.')
