"""
João Papo-de-Pescador, homem de bem, comprou um microcomputador para controlar o rendimento diário de seu trabalho.
Toda vez que ele traz um peso de peixes maior que o estabelecido pelo regulamento de pesca do estado de São Paulo
(50 quilos) deve pagar uma multa de R$ 4,00 por quilo excedente. João precisa que você faça um programa
que leia a variável peso (peso de peixes) e calcule o excesso. Gravar na variável excesso a quantidade de quilos
além do limite e na variável multao valor da multa que João deverá pagar. Imprima os dados do programa com
as mensagens adequadas.
"""

peso = float(input('Digite o peso total, em quilos, do que foi pescado: '))
excesso = peso-50
if excesso > 0:
    multa = excesso*4
    print(f'O peso total pescado foi {peso:.1f}kg. '
          f'Houve um excesso de {excesso:.1f}kg, que gerou uma multa de R${multa:.2f}')
else:
    print(f'O peso total pescado foi {peso:.1f}kg. Não houve excesso.')
