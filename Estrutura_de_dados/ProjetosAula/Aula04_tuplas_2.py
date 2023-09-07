t=(3)
print(type(t))
print(t)
t=(3,)
print(type(t))
print(t)
t=[3]
print(type(t))
print(t)

exemplo=('z','y') + ('x',)
print(exemplo)
exemplo+=(3,)
print(exemplo)
print(exemplo*2)


dicio={'a':1,'b':2,'c':3}

for k, v in dicio.items():
    print("Chave: ", k)
    print("Valor: ", v)