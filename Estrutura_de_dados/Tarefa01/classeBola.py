class Ball:
    def __init__(self, color, circumference, material):
        self.__color = color
        self.__circumference = circumference
        self.__material = material

    def set_color(self, color):
        self.__color = color

    def get_color(self):
        return self.__color


bola = Ball('Azul',  30, 'Wood')

print(f'\n{bola.get_color()}')

bola.set_color('Amarela')

print(f'\n{bola.get_color()}')
