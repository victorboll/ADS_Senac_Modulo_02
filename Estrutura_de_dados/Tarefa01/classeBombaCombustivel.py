class BombaCombustivel:
    def __init__(self, tipoCombustivel, valorLitro, quantidadeCombustivel):
        self.tipoCombustivel = tipoCombustivel
        self.valorLitro = valorLitro
        self.quantidadeCombustivel = quantidadeCombustivel

    def abastecerPorValor(self, valor):
        litros = valor / self.valorLitro
        print(f'{litros:.2f}')
        self.alterarQuantidadeCombustivel(self.quantidadeCombustivel - litros)

    def abastecerPorLitro(self, litros):
        print(f'{(litros * self.valorLitro):.2f}')
        self.alterarQuantidadeCombustivel(self.quantidadeCombustivel - litros)

    def alterarValor(self, novoValor):
        self.valorLitro = novoValor

    def alterarCombustivel(self, novoTipo):
        self.tipoCombustivel = novoTipo

    def alterarQuantidadeCombustivel(self, novaQuantidade):
        self.quantidadeCombustivel = novaQuantidade

bomba1 = BombaCombustivel('gasolina',3.50, 100)

bomba1.alterarCombustivel('Diesel')
bomba1.alterarValor(2.20)
bomba1.abastecerPorLitro(10)
bomba1.abastecerPorValor(25)
print(bomba1.quantidadeCombustivel)
