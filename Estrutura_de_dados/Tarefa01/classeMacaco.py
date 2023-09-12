class Macaco:
    def __init__(self, name, bucho=None):
        self.__name = name
        if bucho == None: self.__bucho = []
        else: self.__bucho = [bucho]

    def comer(self,alimento):
        self.__bucho.append(alimento)
        print(self.verBucho())

    def verBucho(self):
        return self.__bucho

    def digerir(self):
        self.__bucho = []



macaco1 = Macaco('José')
macaco2 = Macaco('João','Morango')

macaco1.comer('banana')
macaco1.comer('maça')
macaco1.comer('jabuticaba')
macaco1.comer(macaco2)

