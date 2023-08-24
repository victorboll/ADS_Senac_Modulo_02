"""Faça um Programa que peça as 4 notas bimestrais e mostre a média."""

notas = []
for i in range(4):
    notas.append(float(input(f'Digite a nota {i+1} do aluno: ')))
print(f'A média do aluno foi {sum(notas)/4}.')
