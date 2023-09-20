"""
10) Escreva uma função recursiva que determine quantas vezes um dígito K ocorre em um número natural N. Por exemplo, o dígito 2 ocorre 3 vezes em 762021192.
"""

def frequenciaDigitoK(n, k):
    if n <= 0:
        return 0
    if n % 10 == k:
        return 1 + frequenciaDigitoK((n - (n % 10))/10, k)
    else:
        return frequenciaDigitoK((n - (n % 10))/10, k)


print(frequenciaDigitoK(762021292782942, 2))
