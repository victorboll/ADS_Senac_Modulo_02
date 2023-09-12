class Pessoa:
    def __init__(self, name, age, weight, height):
        self.__name = name
        self.__age = age
        self.__weight = weight
        self.__height = height

    def set_age(self):
        while True:
            age = int(input('Informe a nova idade da pessoa: '))
            if age > self.__age:
                if self.__age < 20:
                    if age > 21: age_for_calculation = 21
                    else: age_for_calculation = age
                    age_difference = age_for_calculation - self.__age
                self.set_height(age_difference * 0.5)
                self.__age = age
                break
            else:
                print(f'Valor inválido, a idade deve ser maior que {self.__age:.0f}')

    def get_age(self):
        return self.__age

    def gain_weight(self):
        while True:
            weight_difference = float(input('Informe quantos kilos a pessoa engordou: '))
            if weight_difference > 0:
                self.__weight += weight_difference
                break
            else:
                print(f'Valor inválido, por favor insira um valor maior que zero')

    def lose_weight(self):
        while True:
            weight_difference = float(input('Informe quantos kilos a pessoa emagreceu: '))
            if weight_difference > 0:
                self.__weight -= weight_difference
                break
            else:
                print(f'Valor inválido, por favor insira um valor maior que zero')

    def get_weight(self):
        return self.__weight

    def set_height(self, heightDifference = 0):
        if heightDifference > 0:
            self.__height += heightDifference
        else:
            while True:
                height = int(input('Informe, em centimetros, a nova altura da pessoa: '))
                if height > self.__height:
                    self.__height = height
                    break
                else: print(f'Valor inválido, a altura deve ser maior que {self.__height:.0f}')

    def get_height(self):
        return self.__height




victor = Pessoa('Victor', 15, 105, 184)
victor.set_age()
print(victor.get_height())
print(victor.get_age())
victor.set_height()
print(victor.get_height())
victor.gain_weight()
print(victor.get_weight())
victor.lose_weight()
print(victor.get_weight())