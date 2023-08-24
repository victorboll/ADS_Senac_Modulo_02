"""
Faça um Programa que peça 2 números inteiros e um número real. Calcule e mostre:
o produto do dobro do primeiro com metade do segundo.

a soma do triplo do primeiro com o terceiro.

o terceiro elevado ao cubo.
"""

num1 = int(input('Digite um número inteiro: '))
num2 = int(input('Digite outro número inteiro: '))
num3 = int(input('Agora digite um número real: '))
print(f'O produto do dobro do primeiro número com metade do segundo é: {(2*num1)*(num2/2)}.')
print(f'A soma do triplo do primeiro com o terceiro é: {(3*num1)+num3}.')
print(f'O terceiro número ao cubo seria: {num3**3}.')
