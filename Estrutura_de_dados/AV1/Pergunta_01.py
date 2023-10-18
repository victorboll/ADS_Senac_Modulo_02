"""1) Faça um programa que receba a temperatura média de cada mês do ano e armazene-as em uma lista. Em seguida, calcule a
média anual das temperaturas e mostre a média calculada juntamente com todas as temperaturas acima da média anual, e em
que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro, . . . )."""

print('Insira o ano a ser analisado. O ano deve ser menor que 2023 e maior ou igual a 2000:')
while True:
    try:
        ano = int(input())
        if ano >= 2000 and ano < 2023:
            break
        else:
            print('Erro: Por favor, insira um valor válido, o ano deve ser entre 2000 e 2023.')
    except ValueError:
        print('Erro: Por favor, insira um valor válido, ele deve ser inteiro e entre 2000 e 2023.')

temperaturas_ano=[]
meses_ano = {1: "Janeiro", 2: "Fevereiro", 3: "Março", 4: "Abril", 5: "Maio", 6: "Junho", 7: "Julho",
                     8: "Agosto", 9: "Setembro", 10: "Outubro", 11: "Novembro", 12: "Dezembro"}
print(f'Por favor insira as temperaturas médias dos meses do ano de {ano}')
for i in range(12):
    temperatura = 0
    print(f'Insira em celsius a temperatura média do mês de {meses_ano[i+1]}')
    while True:
        try:
            temperatura = float(input())
            if temperatura >= -70 and temperatura <= 60:
                temperaturas_ano.append(temperatura)
                break
            else:
                print('Erro: Por favor, insira um valor válido, a temperatura deve ser entre -70 cº e 60 cº.')
        except ValueError:
            print('Erro: Por favor, insira um valor válido, ele deve um número real e entre -70 cº e 60 cº.')

media_temperaturas_ano = sum(temperaturas_ano)/len(temperaturas_ano)
print(f'A temperatura média para o ano de {ano} foi {media_temperaturas_ano:.1f}')
print('Os meses que tiveram a temperatura acima da média anual de {media_temperaturas_ano:.1f} foram:')
for i in range(len(temperaturas_ano)):
    if temperaturas_ano[i] > media_temperaturas_ano:
        print(f'{meses_ano[i+1]} com a temperatura de {temperaturas_ano[i]}cº')
