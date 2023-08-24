"""
Faça um Programa que pergunte quanto você ganha por hora e o número de horas trabalhadas no mês.
Calcule e mostre o total do seu salário no referido mês, sabendo-se que são descontados 11% para o Imposto de Renda,
8% para o INSS e 5% para o sindicato, faça um programa que nos dê:

salário bruto.
quanto pagou ao INSS.
quanto pagou ao sindicato.
o salário líquido.
calcule os descontos e o salário líquido, conforme a tabela abaixo:

'+ Salário Bruto : R$'
'- IR (11%) : R$'
'- INSS (8%) : R$'
'- Sindicato ( 5%) : R$'
'= Salário Liquido : R$'

Obs.: Salário Bruto - Descontos = Salário Líquido.
"""

print('Esse programa calcula seu salário líquido mensal com base no quanto você recebe por hora, '
      'quantas horas você trabalhou no mês, e quais os descontos que indidem sobre ele.')
salario_hora = float(input('Digite o valor que você recebe por hora: '))
horas = float(input('Digite a quantidade de horas trabalhadas: '))
salario_bruto = salario_hora*horas
ir = salario_bruto*0.11
inss = salario_bruto*0.08
sindicato = salario_bruto*0.05
salario_liquido = salario_bruto-ir-inss-sindicato
print(f'\n+ Salário Bruto: R${salario_bruto:.2f}\n- IR (11%): R${ir:.2f}\n- INSS (8%): R${inss:.2f}\n- '
      f'Sindicato (5%): R${sindicato:.2f}\n= Salário Líquido: R${salario_liquido:.2f}')
