"""4. Construa um programa utilizando uma pilha que resolva o seguinte problema:
Armazene as placas dos carros (apenas os números) que estão estacionados numa rua sem saída estreita.
Dado uma placa verifique se o carro está estacionado na rua.
Caso esteja, informe a sequência de carros que deverá ser retirada para que o carro em questão consiga sair."""

class Carro:
    def __init__(self, numeracao_placa, carro_anterior=None):
        self.numeracao_placa = numeracao_placa
        self.carro_anterior = carro_anterior

    def __str__(self):
        if self.carro_anterior != None:
            return f'{self.carro_anterior} [{self.numeracao_placa}]'
        else:
            return f'[{self.numeracao_placa}]'


class Beco:
    def __init__(self):
        self.carro_no_final_beco = None

    def __str__(self):
        return f'[{self.carro_no_final_beco}'

    def estacionar_Carro(self, numeracao_placa):
        carro = Carro(numeracao_placa, self.carro_no_final_beco)
        self.carro_no_final_beco = carro

    def retirar_Carro(self):
        if self.carro_no_final_beco == None:
            return 'Não há carros no Beco'
        elif self.carro_no_final_beco.carro_anterior == None:
            self.carro_no_final_beco = None
        else:
            self.carro_no_final_beco = self.carro_no_final_beco.carro_anterior

    def verificar_se_carro_estacionado(self, valor):
        carro_verificado = self.carro_no_final_beco
        while carro_verificado
"""Dado uma placa verifique se o carro está estacionado na rua.
Caso esteja, informe a sequência de carros que deverá ser retirada para que o carro em questão consiga sair."""

        


rua_sem_saida = Beco()
rua_sem_saida.estacionar_Carro(1234)
rua_sem_saida.estacionar_Carro(5678)
rua_sem_saida.estacionar_Carro(3692)
rua_sem_saida.estacionar_Carro(8642)
print(rua_sem_saida)

rua_sem_saida.retirar_Carro()
rua_sem_saida.retirar_Carro()
rua_sem_saida.retirar_Carro()
rua_sem_saida.retirar_Carro()
rua_sem_saida.retirar_Carro()
print(rua_sem_saida)

