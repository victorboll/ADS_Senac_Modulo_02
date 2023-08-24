"""
Tendo como dados de entrada a altura de uma pessoa, construa um algoritmo que calcule seu peso ideal,
usando a seguinte fórmula: (72.7*altura) - 58
"""

altura = float(input('Digite sua altura, em metros, para saber o seu peso ideal: '))
print(f'Seu peso ideal seria: {((72.7*altura) - 58):.1f}kg')
