class ContaCorrente:
    def __init__(self, account_number, account_holder_name, balance = 0):
        self.__account_number = account_number
        self.__account_holder_name = account_holder_name
        self.__balance = balance

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


conta_itau = ContaCorrente('03265-9','Victor')
conta_itau.set_account_holder_name('Victor Jacob')
print(conta_itau.get_account_holder_name())
conta_itau.deposit(5000)
conta_itau.withdrawal(2530)
