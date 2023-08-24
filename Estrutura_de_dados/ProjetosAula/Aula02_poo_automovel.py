class Automovel:
    """
    Classe do carro.
    Isso vai aparecer quando você coloca o mouse em cima da classe quando você vai instanciar um objeto dessa classe
    """
    def __init__(self, placa):
        self.__placa = None
        self.set_placa(placa)

    def get_placa(self):
        return self.__placa

    def set_placa(self, placa):
        if len(placa) != 6:
            print('A placa deve ter 6 caracteres')
        else:
            self.__placa = placa

    def dirigir(self, velocidade):
        print('Estou dirigindo a %f km/h' % velocidade)


corola = Automovel('RJ1234')
fusca = Automovel('GVT')
fusca.set_placa('ABC856')

fusca.__placa = 'ABCDEF'
"""Nada acontece quando isso é feito, porque, como o atributo foi definido como privado na classe, ele não pode
ser modificado difetamente através do atributo, só através do método
Na verdade acontece"""

print(corola.get_placa())
print(fusca.get_placa())

fusca.set_placa('XVC')
fusca.set_placa('XVC012')

print(fusca.get_placa())

print(fusca.__placa, fusca.get_placa())

atributos_e_valores = vars(fusca)
print(atributos_e_valores)
