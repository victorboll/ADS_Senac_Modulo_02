"""
9) Crie uma função recursiva que receba um número inteiro positivo N e calcule o produto dos números de 1 a N.
"""

def somatorioNumeroN(n):
    if n <= 1:
        return 1
    return n * somatorioNumeroN(n-1)


print(somatorioNumeroN(5))