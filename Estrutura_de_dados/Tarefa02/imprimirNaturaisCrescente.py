"""
12) Faça uma função recursiva que receba um número inteiro positivo N
e imprima todos os números naturais de 0 até N em ordem crescente.
"""

def imprimirNaturais(n):
    if n > 0:
        imprimirNaturais(n-1)
    print(n)


imprimirNaturais(5)
