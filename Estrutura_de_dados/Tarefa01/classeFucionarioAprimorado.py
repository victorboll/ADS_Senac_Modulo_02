class Funcionario:
    def __init__(self, nome: str, salario: float):
        self.nome = nome
        self.salario = salario

    def get_nome(self):
        return self.nome

    def get_salario(self):
        return self.salario

    def aumentarSalario(self,percentagemAumento):
        self.salario += self.salario * percentagemAumento / 100


victor = Funcionario('Victor', 5000)

print(f'O nome do funcionário é {victor.get_nome()}, e ele recebe R${victor.get_salario():.2f}.')

victor.aumentarSalario(10)

print(f'O nome do funcionário é {victor.get_nome()}, e ele recebe R${victor.get_salario():.2f}.')