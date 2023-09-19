"""
13) Faça uma função recursiva que receba um número inteiro positivo N
e imprima todos os números naturais de 0 até N em ordem decrescente.
"""
def imprimirNaturais(n):
    print(n)
    if n > 0:
        imprimirNaturais(n-1)


imprimirNaturais(10)
