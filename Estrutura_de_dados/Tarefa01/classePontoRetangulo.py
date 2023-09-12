class Ponto:
    def __init__(self, x, y):
        self.__x = x
        self.__y = y

    def get_posicao(self):
        print([self.__x,self.__y])


class Retangulo:
    def __init__(self, largura, altura):
        self.__largura = largura
        self.__altura = altura
        self.set_verticePartida()


    def get_verticePartida(self):
        return self.__verticePartida.get_posicao()

    def get_centro(self):
        self.__centro_retangulo = Ponto(self.__largura/2, self.__altura/2)
        return self.__centro_retangulo.get_posicao()

    def set_verticePartida(self,instanciado=False):
        if instanciado == False:
            self.vertice = int(input('Indique o número correspondente ao vértice de partida:\n1- Inferior esquerdo\n'
                                '2- Inferior direito\n3- Superior direto\n4- Superior esquerdo\n'))
        posicoes = {1: Ponto(0, 0), 2: Ponto(self.__largura, 0), 3: Ponto(self.__largura, self.__altura),
                    4: Ponto(0, self.__altura)}
        while True:
            if 1 <= self.vertice <= 4:
                self.__verticePartida = posicoes[self.vertice]
                break
            else:
                self.vertice = int(input('Valor inválido, o valor deve estar entre 1 e 4: '))

    def set_altura(self):
        self.__altura = float(input('Informe a altura do retângulo: '))
        self.set_verticePartida(True)

    def set_largura(self):
        self.__largura = float(input('Informe a largura do retângulo: '))
        self.set_verticePartida(True)

    def menu(self):
        opcoes = {1: self.set_largura, 2: self.set_altura, 3: self.get_centro, 4: self.get_verticePartida, 5: None}
        while True:
            opcao = int(input('Indique o número correspondente ao ação desejada:\n1- Alterar Largura\n'
                              '2- Alterar Altura\n3- Mostrar centro\n4- Mostrar Vértice\n5- Sair\n'))
            if 1 <= opcao <= 4:
                opcoes[opcao]()
                opcao = 0
            elif opcao == 5:
                break
            else:
                opcao = int(input('Valor inválido, o valor deve estar entre 1 e 4: '))


retangulo1 = Retangulo(10,5)


retangulo1.menu()



