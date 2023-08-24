class Automovel:
    """
    Classe do carro.
    Isso vai aparecer quando você coloca o mouse em cima da classe quando você vai instanciar um objeto dessa classe
    """
    def __init__(self, placa):
        self.set_placa(placa)

    def get_placa(self):
        return self.placa

    def set_placa(self, placa):
        if len(placa) != 6:
            print('A placa deve ter 6 caracteres')
        else:
            self.placa = placa

    def dirigir(self, velocidade):
        print('Estou dirigindo a %f km/h' % velocidade)


corola = Automovel('RJ1234')
fusca = Automovel('GVT')
fusca.placa = 'XPTO58'

print(corola.get_placa())
print(fusca.get_placa())

fusca.set_placa('XVC')
fusca.set_placa('XVC012')

print(fusca.get_placa())

atributos_e_valores = vars(fusca)
print(atributos_e_valores)
