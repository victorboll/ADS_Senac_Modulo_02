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
        if self.carro_no_final_beco == None:
            print('Não há carros no beco')
            return
        carro_verificado = self.carro_no_final_beco
        while carro_verificado != None:
            if carro_verificado.numeracao_placa == valor:
                print(f'Carro com a placa de numeração {valor} está estacionado no Beco')
                if carro_verificado == self.carro_no_final_beco:
                    print('Não há carros bloqueando ele, ele pode sair')
                else:
                    carro_bloqueando = self.carro_no_final_beco
                    while carro_bloqueando.numeracao_placa != valor:
                        print(f'O carro com a placa de numeração {carro_bloqueando.numeracao_placa} precisa sair para '
                              f'que o carro anterior possa sair.')
                        carro_bloqueando = carro_bloqueando.carro_anterior
                    print(f'Depois que todos os carros acima sairem, o carro com placa de numeração '
                          f'{carro_bloqueando.numeracao_placa} poderá sair')
                return
            else:
                carro_verificado = carro_verificado.carro_anterior
        print(f'Não tem nenhum carro com a placa de numeração {valor} estacionado no beco')


"""Caso esteja, informe a sequência de carros que deverá ser retirada para que o carro em questão consiga sair."""

        


rua_sem_saida = Beco()
rua_sem_saida.estacionar_Carro(1234)
rua_sem_saida.estacionar_Carro(5678)
rua_sem_saida.estacionar_Carro(3692)
rua_sem_saida.estacionar_Carro(8642)
print(rua_sem_saida)

rua_sem_saida.verificar_se_carro_estacionado(1111)

rua_sem_saida.retirar_Carro()
rua_sem_saida.retirar_Carro()
rua_sem_saida.retirar_Carro()

print(rua_sem_saida)

rua_sem_saida.verificar_se_carro_estacionado(1234)

