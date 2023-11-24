import matplotlib.pyplot as plt
from matplotlib.animation import FuncAnimation


def bubble_sort(lista):
    fig, ax = plt.subplots()

    def init():
        ax.set_ylim(0, max(lista) + 5)
        return ax.bar(range(1, len(lista) + 1), lista)

    def update(frame):
        alterado = False

        bars = ax.bar(range(1, len(lista) + 1), lista, color='blue')

        if lista[frame] > lista[frame + 1]:
            lista[frame], lista[frame + 1] = lista[frame + 1], lista[frame]
            alterado = True

        bars[frame].set_color('red')
        bars[frame + 1].set_color('red')

        return bars

    ani = FuncAnimation(fig, update, frames=len(lista) - 1, init_func=init, blit=True, interval=500)
    plt.show()


array = [15, 1, 3, 2, 4, 30, 8, 7, 0, 6, 98]
print(array)
bubble_sort(array)
print(array)