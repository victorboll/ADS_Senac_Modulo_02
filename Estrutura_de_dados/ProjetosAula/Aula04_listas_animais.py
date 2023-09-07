#lista de valores
notas = [0, 10.0, 7.0, 7.0, 8.0, 8.0]
#Insere o elemento da lista na posição 1
notas.insert(1, 5.0)
#imprime a nova lista de notas
print(notas)
#Remove o primeiro elemento da lista que ele encontrou
#Se utilizasse novamente notas.remove(0) vai dar erro, porque ele não encontra nenhum outro 0
notas.remove(0)
#imprime a nova lista de notas
print(notas)

notas = [0, 10.0, 7.0, 7.0, 8.0, 8.0]
#Ordena a lista e altera o estado dela, realizando um inplace (Que seria alterar os valores em si)
notas.sort()
print(notas)
#Lista de strings
animais = ['gato', 'tatu', 'rato', 'pato']
#Ordena a lista sem alterar o inplace (Que significa só alterar o output, atributo que foi sorted continua como antes)
sorted(animais)

print(animais)
print(sorted(animais))
