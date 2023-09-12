class ContaDeInvestimento:
    def __init__(self, account_number, account_holder_name, balance, taxaJuros):
        self.__account_number = account_number
        self.__account_holder_name = account_holder_name
        self.__balance = balance
        self.__taxaJuros = taxaJuros

    def set_account_holder_name(self, account_holder_name):
        self.account_holder_name = account_holder_name

    def get_account_holder_name(self):
        return self.__account_holder_name

    def deposit(self, amount):
        self.__balance += amount
        print(f'Novo saldo R${self.__balance:.2f}')

    def withdrawal(self, amount):
        self.__balance -= amount
        print(f'Novo saldo R${self.__balance:.2f}')

    def adicioneJuros(self):
        self.__balance += self.__balance * self.__taxaJuros / 100

    def get_balance(self):
        print(self.__balance)


conta_itau = ContaDeInvestimento('03265-9', 'Victor', 1000, 10)
for i in range(5):
    conta_itau.adicioneJuros()

conta_itau.get_balance()
