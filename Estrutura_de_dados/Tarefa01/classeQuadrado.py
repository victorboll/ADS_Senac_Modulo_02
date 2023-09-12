class Square:
    def __init__(self,side):
        self.__side = side

    def set_side(self,side):
        self.__side = side

    def get_side(self):
        return self.__side

    def get_area(self):
        return self.__side * self.__side


quadrado = Square(10)
print(f'\n{quadrado.get_side()}')
print(f'{quadrado.get_area()}')

quadrado.set_side(8)
print(f'\n{quadrado.get_side()}')
print(f'{quadrado.get_area()}')