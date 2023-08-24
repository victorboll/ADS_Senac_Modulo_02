"""
Tendo como dado de entrada a altura (h) de uma pessoa, construa um algoritmo que calcule seu peso ideal, utilizando as seguintes fórmulas:
Para homens: (72.7*h) - 58
Para mulheres: (62.1*h) - 44.7
"""

altura = float(input('Digite sua altura, em metros, para saber o seu peso ideal: '))
print(f'Caso você seja homem, seu peso ideal seria: {((72.7*altura) - 58):.1f}kg, '
      f'caso você seja mulher seu peso ideal seria: {((62.1*altura) - 44.7):.1f}kg')
