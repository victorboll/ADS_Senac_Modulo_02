"""
4) Faça uma função recursiva que permita somar os elementos de um vetor de inteiros.
"""
def somarVetor(vetor):
    if vetor == []:
        return 0
    return vetor[0] + somarVetor(vetor[1:])


vetor=[1, 2, 3, 4, 10]

print(somarVetor(vetor))