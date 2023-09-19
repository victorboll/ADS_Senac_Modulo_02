"""
6) Crie um programa em python, que contenha uma função recursiva que receba dois inteiros positivos k e n e calcule k^n.
 Utilize apenas multiplicações. O programa principal deve solicitar ao usuário os valores de k e n e imprimir o
 resultado da chamada da função.
"""
def exponenciacao(n , k):
    if k <= 1:
        return n
    return n * exponenciacao(n, k-1)

print(exponenciacao(3, 9))