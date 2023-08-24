class Funcionario:
    def __init__(self):
        self.__salario = None
        self.__nome = None

    def get_nome(self):
        return self.__nome

    def set_nome(self, nome):
        self.__nome = nome

    def get_salario(self):
        return self.__salario

    def set_salario(self, salario):
        self.__salario = salario

tales = Funcionario()
victor = Funcionario()
victor.set_nome('Victor')
victor.set_salario('R$2500.00')
victor._Funcionario__nome = "Vitor"  #Sobreescreve o atributo __nome, mesmo ele sendo definido como privado
victor.__nome = "Victorio"           # Cria um novo atributo __nome, que não está relacionado a classe, mas somente ao objeto
print(victor.get_nome(), victor.get_salario())
#print(victor.salario)
# print(victor.__nome)

atributos_e_valores = vars(victor)
print(atributos_e_valores)

atributos_e_valores2 = vars(tales)
print(atributos_e_valores2)