"""Faça um Programa que peça a temperatura em graus Farenheit, transforme e mostre a temperatura em graus Celsius. C = (5 * (F-32) / 9)."""

temperatura = float(input('Digite a temperatura que deseja converter de Celsius para Farenheit: '))
print(f'A temperatura convertida para Farenheit seria: {((temperatura*9/5)+32):.1f} graus Farenheit')
