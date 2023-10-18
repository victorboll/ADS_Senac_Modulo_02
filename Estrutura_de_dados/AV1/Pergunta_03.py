"""3) Implemente uma função recursiva para verificar se uma palavra é palíndromo (Ex. aba, abcba, xyzzyx).
Definição:  frase ou palavra que se pode ler, indiferentemente, da esquerda para a direita ou vice-versa."""

palavra = input('Digite uma palavra e o sistema vai verificar se ele é um palíndromo: ')
def verificar_palindromo(palavra):
    if len(palavra) <= 1:
        return 'É palindromo'
    if palavra[0] == palavra[len(palavra)-1]:
        return verificar_palindromo(palavra[1:-1])
    else:
        return 'Não é palindromo'

print(verificar_palindromo(palavra))