"""
3) Faça uma função recursiva que permita inverter um número inteiro N. Ex: 123 - 321
"""

def inverterN(n):
    if n / 10 <= 0:
        return n
    return (n % 10) + inverterN(n // 10)


print(inverterN(1503))
