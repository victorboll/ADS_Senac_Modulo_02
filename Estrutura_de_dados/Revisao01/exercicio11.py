"""
Faça um Programa que peça a temperatura em graus Celsius, transforme e mostre a temperatura em graus Farenheit.
C = (5 * (F-32) / 9).
"""

temperatura = float(input('Digite a temperatura que deseja converter de Farenheit para Celsius: '))
print(f'A temperatura convertida para Celcius seria: {(5*(temperatura-32)/9):.1f} graus Celsius')