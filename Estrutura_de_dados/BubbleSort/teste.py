import matplotlib.pyplot as plt
import random

# Função para visualizar a lista com Matplotlib
def plot_bubble_sort(data_list):
    fig, ax = plt.subplots()
    ax.bar(range(len(data_list)), data_list)
    plt.show()

# Implementação do Bubble Sort
def bubble_sort(data):
    n = len(data)
    swapped = True
    data_states = [data.copy()]  # Lista para armazenar os estados da lista

    while swapped:
        swapped = False
        for i in range(1, n):
            if data[i - 1] > data[i]:
                data[i - 1], data[i] = data[i], data[i - 1]
                swapped = True
                data_states.append(data.copy())  # Adicionar cópia do estado da lista

    # Visualizar todos os estados em uma única figura
    for state in data_states:
        plot_bubble_sort(state)

# Criar uma lista de números aleatórios para classificar
data = random.sample(range(1, 101), 10)

# Iniciar o Bubble Sort
bubble_sort(data)
