class Vehicle:

    def __init__(self, name, max_speed, mileage):
        self.name = name
        self.max_speed = max_speed
        self.mileage = mileage

    def seating_capacity(self, capacity):
        return f"The seating capacity of a {self.name} is {capacity}"


class Bus(Vehicle):
    #assign default value to capacity
    def seating_capacity(self, capacity=50):
        return super().seating_capacity(capacity)
#super chama o objeto pai. Ao fazer essa alteração, você só está colocando um default, capacity ainda pode ser parâmetro
#qui tanto faz colocar capacity=50 no parâmetro (como está) ou na chamada (return super().seating_capacity(capacity=50)

class Moto(Vehicle):
    def seating_capacity(self, capacity=2):
        return super().seating_capacity(capacity)

school_bus = Bus("School Bus", 180, 12)
print(school_bus.seating_capacity())

moto_honda = Moto("CB 500", 250, 3)
print(moto_honda.seating_capacity())




