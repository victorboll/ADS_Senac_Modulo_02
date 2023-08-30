import ponto

linhasArquivo = []

# Abre o arquivo no modo de leitura
with open('pontos.txt', 'r') as arquivo:
    # Lê o conteúdo completo do arquivo em uma única string
    for linha in arquivo:
        linhasArquivo.append(linha.split())

obj=[]
j=0
for i in range(int(len(linhasArquivo)/2)):
    obj.append(ponto.Ponto(linhasArquivo[j],linhasArquivo[j+1][0],linhasArquivo[j+1][1]))
    j+=2

for i in range(len(obj)):
    print(obj[i])






"""dicPontos[linhasArquivo[i]] = list(map(int, linhasArquivo[i+1].split()))
Usei o split para separar a linha que era uma string separada por espaço, em duas strings que eram as 
coordenadas, só que ainda eram strings. Usei o map para aplicar a função int() a lista que foi obtida,
e como map acaba retornando os iterators em si, coloquei a função list para colocar os valores modificados
por map em uma lista"""

