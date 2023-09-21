"""
7) Crie um programa em python que receba um vetor de números reais com 100 elementos.
Escreva uma função recursiva que inverta ordem dos elementos presentes no vetor.
"""

lista = []
for i in range(100):
    lista.append(i + 1)
print(lista)


def inverteVetor(vetor, n=0):
    if n == len(vetor):
        return vetor
    else:
        temporaria = vetor.pop((n + 1) * -1)
        vetor.append(temporaria)
        return inverteVetor(vetor, n + 1)


print(inverteVetor(lista))

