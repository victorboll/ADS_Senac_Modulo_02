class Tamagushi:
    def __init__(self, name, hunger, health, age):
        self.__name = name
        self.__hunger = hunger
        self.__health = health
        self.__age = age

    def set_name(self, name):
        self.__name = name

    def set_hunger(self, hunger):
        self.__hunger = hunger

    def set_health(self, health):
        self.__health = health

    def set_age(self, age):
        self.age = age

    def get_name(self):
        return self.__name

    def get_hunger(self):
        return  self.__hunger

    def get_health(self):
        return self.__health

    def get_age(self):
        return  self.__age

    def get_mood(self):
        return self.__health + self.__hunger

