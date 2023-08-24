"""Faça um Programa que peça o raio de um círculo, calcule e mostre sua área."""

import math

raio = float(input('Digite, em centímetros, o raio do círculo que deseja saber a área: '))
print(f'Para um raio de {raio} centímetros, a área do círculo é de {(math.pi*(raio**2)):.2f} centímeros quadrados')
