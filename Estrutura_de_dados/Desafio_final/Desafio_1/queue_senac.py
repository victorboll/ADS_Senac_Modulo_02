from flask import Flask
import random

app = Flask(__name__)

# Create here the code of queue data structure SENAC
class Item:
    def __init__(self, valor=0):
        self.valor = valor
        self.proximo = None

    def __str__(self):
        if self.proximo is None:
            return f'{self.valor}'
        else:
            return f'{self.valor} -> {self.proximo}'

class Fila:
    def __init__(self):
        self.primeiro = None
        self.ultimo = None

    def __str__(self):
        return f'[ {self.primeiro} ]'

# You have created the follow methods:
# put() => To add a new value into the linked structure (queue)
    def push_item(self, valor):
        item = Item(valor)
        if self.primeiro == None:
            self.primeiro = item
            self.ultimo = item
        else:
            self.ultimo.proximo = item
            self.ultimo = item
        print(f'[Início da fila] {fila} [Fim da Fila]')


# get() => To recovery the element of linked structure (queue)
    def pop_item(self):
        if self.primeiro == None:
            print('Fila vazia')
        else:
            self.primeiro = self.primeiro.proximo
            print(f'[Início da fila] {fila} [Fim da Fila]')


fila = Fila()

# ####################################



@app.route('/start_processing', methods=['POST'])
def start_queue_senac():
    '''Every time you run this route, you must add a new Node to the Queue'''
    number = random.randint(0,9)
    #p rint(number, flush=True) # Example, We need to insert the variable number in the linked structure (queue)

    # You must call put() method
    # Your code here!

    fila.push_item(number)

    return '', 200

@app.route('/pos_processing', methods=['POST'])
def processing_queue_senac():
    '''Every time you run this route you must retrieve the value from the queue. And run the code below!!'''
    # You must call get() method
    # Loop to empty the queue....
    # For each value, print the value multiplied by 1000 and put a delay of 30 seconds.
    # When the Queue is empty, inform on the screen (Print)
    # Your code here!

    # print("Pos_Processing", flush=True)

    fila.pop_item()

    return '', 200



if __name__ == '__main__':
    app.run(debug=__debug__)
