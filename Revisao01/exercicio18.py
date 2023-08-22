"""Faça um programa que peça o tamanho de um arquivo para download (em MB) e a velocidade de um link de Internet
(em Mbps), calcule e informe o tempo aproximado de download do arquivo usando este link (em minutos).
1 megabyte = 8 megabits"""

tamanho = float(input('Informe o tamanho do arquivo, em MB(Megabytes) que será feito download: '))
velocidade = float(input('Informe a velocidade da conexão em Mbps(Megabits): '))
print(f'O tempo aproximado de download do arquivo de tamanho {tamanho}MB em uma velocidade de {velocidade}Mbps, '
      f'é de {((tamanho*8)/velocidade):.1f} segundos')
