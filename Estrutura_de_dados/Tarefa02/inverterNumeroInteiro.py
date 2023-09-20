"""
3) Faça uma função recursiva que permita inverter um número inteiro N. Ex: 123 - 321
"""

def inverterN(n):
    if n < 1:
        return n
    return n // (10 ** (len(str(n))-1)) + inverterN(n - (n // (10 ** (len(str(n))-1))) * (10 ** (len(str(n))-1)))*10


print(inverterN(2539))



