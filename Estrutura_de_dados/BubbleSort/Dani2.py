import matplotlib.pyplot as plt
from matplotlib.animation import FuncAnimation


def bubble_sort(lista):
    fig, ax = plt.subplots()

    def init():
        ax.set_ylim(0, max(lista) + 5)
        return ax.bar(range(1, len(lista) + 1), lista)

    def update(frame):
        bars = ax.bar(range(1, len(lista) + 1), lista, color='blue')

        if lista[frame] > lista[frame + 1]:
            lista[frame], lista[frame + 1] = lista[frame + 1], lista[frame]

        bars[frame].set_color('red')
        bars[frame + 1].set_color('red')

        if frame == 9 and lista == sorted(lista):
            bars = ax.bar(range(1, len(lista) + 1), lista, color='blue')
            ani.event_source.stop()  # Se não houver mais alterações e a lista estiver ordenada, interrompe a animação

        return bars

    previous_state = lista.copy()
    ani = FuncAnimation(fig, update, frames=len(lista) - 1, init_func=init, blit=True, interval=800)
    plt.show()