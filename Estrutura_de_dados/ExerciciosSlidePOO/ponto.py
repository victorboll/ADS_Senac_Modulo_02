class Ponto:
    def __init__(self, nome: str, x: int, y: int):
        self.nome = nome
        self.x = x
        self.y = y

    def __str__(self):
        return f"{self.nome}: ({self.x}, {self.y})"