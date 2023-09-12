class Tamagushi:
    def __init__(self, name):
        self.__name = name
        self.__age = 0
        self.__hunger = 50
        self.__health = 100
        self.__set_mood()
        self.menu()

    def set_name(self):
        name = input('Qual o novo nome do seu bichinho?\n')
        self.__name = name
        self.__realizar_atividade()

    def set_hunger(self):
        if self.__hunger == 0: print('O Tamagushi já está satisfeito e não quer comer mais')
        else:
            while True:
                comida = int(input('Informe o alimento fornecido para alimentar seu Tamagushi:\n1- Cenoura\n'
                                   '2- Maçã\n3- Macarrão\n4- Carne\n5- Chocolate\n6- Sair\n'))
                tabela_alimentar = {1: 15, 2: 10, 3: 35, 4: 50, 5: 10}
                if 1 <= comida <= 4:
                    self.__hunger -= tabela_alimentar[comida]
                    if self.__hunger < 0: self.__hunger = 0
                    if comida == 5:
                        self.__health -= 10
                    break
                elif comida == 6:
                    break
                else:
                    comida = int(input('Valor inválido, informar um valor entre 1 e 6'))
        self.__realizar_atividade()
        self.__set_mood()

    def set_health(self):
        if self.__health > 100:
            print('O Tamagushi está cansado e não quer brincar')
        else:
            tempo = int(input('Por quantos minutos você quer brincar com seu Tamagushi?\n'))
            self.__health += tempo/2
            self.__set_mood()

    def __realizar_atividade(self):
        if self.__health > 0: self.__health -= 5

    def set_age(self):
        age = int(input('Qual é a idade atual do seu bichino?\n'))
        if self.__age < age:
            self.__age = age
            self.__realizar_atividade()

    def __set_mood(self):
        self.__mood = ((100-self.__health) + self.__hunger)/2

    def get_name(self):
        self.__realizar_atividade()
        print(self.__name)

    def get_hunger(self):
        self.__realizar_atividade()
        print(self.__hunger)

    def get_health(self):
        self.__realizar_atividade()
        print(self.__health)

    def get_age(self):
        self.__realizar_atividade()
        print(self.__age)

    def get_mood(self):
        self.__realizar_atividade()
        print(self.__mood)

    def opcao_secreta(self):
        print(str(self.__dict__))

    def menu(self):
        opcao = int(input('Escolha a opção desejada:\n1- Ver Nome\n2- Modificar Nome\n3- Ver Idade\n'
                          '4- Modificar Idade\n5- Ver nível de fome\n6- Alimentar\n7- Ver saúde\n'
                          '8- Brincar\n9- Ver Humor\n0- Sair\n'))
        while True:
            opcoes={1: self.get_name, 2: self.set_name, 3: self.get_age, 4: self.set_age, 5: self.get_hunger,
                    6: self.set_hunger, 7: self.get_health, 8: self.set_health, 9: self.get_mood,
                    10: self.opcao_secreta}
            if 1 <= opcao <= 10:
                opcoes[opcao]()
            elif opcao == 0: break
            else: opcao = int(input('Opção inválida, escolha um valor entre 0 e 9'))


bobby = Tamagushi('Bobby')