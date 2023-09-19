"""
1) Faça uma função recursiva que calcule e retorne o fatorial de um número inteiro N.
"""

def fatorialN(n):
    if n <= 1:
        return 1
    return n * fatorialN(n - 1)


print(fatorialN(6))

