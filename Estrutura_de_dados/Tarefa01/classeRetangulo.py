class Rectangle:
    def __init__(self, width, height):
        self.__width = width
        self.__height = height

    def set_width(self, width):
        self.__width = width

    def set_height(self, height):
        self.__height = height

    def get_sides(self):
        return [self.__width, self.__height]

    def get_area(self):
        return self.__width * self.__height

    def get_perimeter(self):
        return (self.__width * 2) + (self.__height * 2)

retangulo = Rectangle(10, 20)

largura = float(input('Por favor informe, em mentros, a largura do local a ser analisado: '))
altura = float(input('Por favor informe, em metros, o comprimento do local a ser analisado: '))

local = Rectangle(largura, altura)
print(f'Você irá precisar de aproximadamente {local.get_perimeter()} metros de rodapé para preencher o local,'
      f'assim como {local.get_area()} metros quadrados de piso')