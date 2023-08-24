"""Faça um Programa que pergunte quanto você ganha por hora e o número de horas trabalhadas no mês. Calcule e mostre o total do seu salário no referido mês."""

print('Esse programa calcula seu salário mensal com base no quanto você recebe por hora, e quantas horas você trabalhou no mês.')
salario = float(input('Digite o valor que você recebe por hora: '))
horas = float(input('Digite a quantidade de horas trabalhadas: '))
print(f'Recebendo R${salario:.2f}, e tendo trabalhado {horas} horas no mês, seu salário mensal foi de R${(salario*horas):.2f}.')
