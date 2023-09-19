"""
15) Faça uma função recursiva que receba um número inteiro positivo par N
e imprima todos os números pares de 0 até N em ordem decrescente.
"""

def imprimirNaturais(n):
    if n % 2 != 0:
        print('Valor inválido, o valor deve ser um número par')
    else:
        print(n)
        if n > 0:
            imprimirNaturais(n - 2)


imprimirNaturais(10)
