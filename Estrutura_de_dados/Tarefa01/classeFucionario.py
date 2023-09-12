class Funcionario:
    def __init__(self, nome: str, salario: float):
        self.nome = nome
        self.salario = salario

    def get_nome(self):
        return self.nome

    def get_salario(self):
        return self.salario

victor = Funcionario('Victor', 5000)

print(f'O nome do funcionário é {victor.get_nome()}, e ele recebe R${victor.get_salario():.2f}.')