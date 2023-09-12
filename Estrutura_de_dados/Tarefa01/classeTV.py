class TV:
    def __init__(self, channel=1, volume=15):
        self.__channel = channel
        self.__volume = volume

    def set_channel(self,new_channel):
        while True:
            if 0 < new_channel <= 99:
                self.__channel = new_channel
                break
            else:
                channel=int(input('Valor inválido para canal, por favor informe um valor entre 1 e 99: '))
        print(self.__channel)

    def increase_volume(self, volume_increase):
        while True:
            if volume_increase > 0:
                self.__volume += volume_increase
                if self.__volume > 100: self.__volume = 100
                break
            else:
                volume_increase = int(input('Valor inválido para aumentar volume, '
                                            'por favor informe um valor positivo: '))
        print(self.__volume)

    def decrease_volume(self, volume_decrease):
        while True:
            if volume_decrease < 0:
                self.__volume += volume_decrease
                if self.__volume < 0: self.__volume = 0
                break
            else:
                volume_decrease = int(input('Valor inválido para diminuir volume, '
                                            'por favor informe um valor negativo: '))
        print(self.__volume)


televisor = TV()
televisor.set_channel(56)
televisor.increase_volume(-10)
televisor.decrease_volume(20)
