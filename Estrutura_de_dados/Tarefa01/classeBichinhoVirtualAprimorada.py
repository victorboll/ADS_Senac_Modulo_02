class Tamagushi:
    def __init__(self, name):
        self.__name = name
        self.__age = 0
        self.__hunger = 50
        self.__health = 100
        self.__mood = (self.__health + self.__hunger) / 2

    def set_name(self, name):
        self.__name = name

    def set_hunger(self):
        if self.__hunger == 0: print('O Tamagushi já está satisfeito e não quer comer mais')
        else:
            while True:
                comida = int(input('Informe o alimento fornecido para alimentar seu Tamagushi:\n1- Cenoura\n'
                                   '2- Maçã\n3- Macarrão\n4- Carne\n5- Chocolate\n6- Sair\n'))
                tabelaAlimentar = {1: 15, 2: 10, 3: 35, 4: 50, 5: 10}
                if 1 <= comida <= 4:
                    self.__hunger -= tabelaAlimentar[comida]
                    if self.__hunger < 0: self.__hunger = 0
                    if comida == 5:
                        self.__health -= 10
                    break
                elif comida == 6:
                    break
                else:
                    comida = int(input('Valor inválido, informar um valor entre 1 e 6'))
        self.set_mood()

    def set_health(self, tempo):
        self.__health += tempo/2
        self.set_mood()

    def set_age(self, age):
        self.__age = age

    def set_mood(self):
        self.__mood = (self.__health + self.__hunger)/2


    def get_name(self):
        return self.__name

    def get_hunger(self):
        return  self.__hunger

    def get_health(self):
        return self.__health

    def get_age(self):
        return  self.__age

    def get_mood(self):
        return self.__mood


bobby = Tamagushi('Bobby')
bobby.set_hunger()
print(bobby.get_hunger())