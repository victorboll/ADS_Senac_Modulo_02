class Vehicle:

    def __init__(self, name, max_speed, mileage):
        self.name = name
        self.max_speed = max_speed
        self.mileage = mileage


class Car(Vehicle):

    def __init__(self, name, max_speed, mileage, color):
        super().__init__(name, max_speed, mileage)
        self.color = color

    color = 'Blue'


# Creating an instance of Car
my_car = Car("MyCar", 200, 30, "Red")

# Accessing attributes
print(f"Car Name: {my_car.name}")
print(f"Max Speed: {my_car.max_speed}")
print(f"Mileage: {my_car.mileage}")
print(f"Color: {my_car.color}")

atributos_e_valores = vars(my_car)
print(atributos_e_valores)
