class Carro:
    def __init__(self, consumo):
        self.consumo = consumo
        self.quantidadeCombustivel = 0

    def andar(self, distancia):
        self.quantidadeCombustivel -= distancia / self.consumo

    def obterGasolina(self):
        print(self.quantidadeCombustivel)

    def adicionarGasolina(self, quantidadeGasolina):
        self.quantidadeCombustivel += quantidadeGasolina


meuFusca = Carro(15)
meuFusca.obterGasolina()
meuFusca.adicionarGasolina(20)
meuFusca.obterGasolina()
meuFusca.andar(100)
meuFusca.obterGasolina()