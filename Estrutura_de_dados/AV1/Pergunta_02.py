"""2) Implemente uma função recursiva para calcular 1 + 1/2 + 1/3 + 1/4 + ... + 1/N."""


def serie_harmonica(numero_n, contador=1):
    if numero_n == contador:
        return 1 / numero_n
    return 1 / contador + serie_harmonica(numero_n, contador+1)

print('Insera um valor N inteiro e maior que 0 para calcular a expressão 1 + 1/2 + 1/3 + 1/4 + ... + 1/N.')
while True:
    try:
        numeroN = int(input())
        if numeroN >= 1:
            break
        else:
            print('Erro: Por favor, insira um valor válido, ele deve ser inteiro e maior que 0.')
    except ValueError:
        print('Erro: Por favor, insira um valor válido, ele deve ser inteiro e maior que 0.')

print(serie_harmonica(numeroN))