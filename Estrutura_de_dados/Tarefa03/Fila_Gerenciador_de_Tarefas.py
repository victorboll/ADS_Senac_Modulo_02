"""5. No seu sistema operacional ao abrir o “gerenciador de tarefas” você pode exibir os processos que estão em
execução. Você já parou pra pensar como é possível executar todos esses aplicativos em apenas um processador?
Isso existe graças a uma funcionalidade chamada de tempo compartilhado (“time-shared”). Essa funcionalidade mantém uma
sequência de processos em uma fila, esperando para serem executados. Modifique a fila dinâmica que você implementou
anteriormente para armazenar as informações desses processos.

{
    id = 104,
    name = "Window Manager",
    priority = 4,
    wait = 20
}

Seu programa deverá permitir:
–Incluir novos processos na fila de processo;
–Matar o processo com o maior tempo de espera;
–Executar um processo (remover da fila)
–Imprimir o conteúdo da lista de processos."""


class Process:
    def __init__(self, id, name, priority, wait, next_process=None):
        self.id, self.name, self.priority, self.wait = id, name, priority, wait
        self.processInformation = {'id': self.id,  'name': self.name, 'priority': self.priority, 'wait': self.wait}
        self.next = next_process

    def __str__(self):
        if self.next == None:
            return f'| {self.processInformation}'
        else:
            return f'| {self.processInformation}\n{self.next}'


class TaskManager:
    def __init__(self):
        self.first = None
        self.last = None

    def __str__(self):
        if self.first == None:
            return f"No active processes\n"
        else:
            return f'----------------------------------------\n{self.first}\n________________________________________\n'

    def add_new_process(self, id, name, priority, wait):
        newProcess = Process(id, name, priority, wait)
        if self.first == None:
            self.first = newProcess
            self.last = newProcess
        else:
            self.last.next = newProcess
            self.last = newProcess

    def execute_process(self):
        if self.first == None:
            print('No processes to be executed\n')
        elif self.first.next == None:
            self.first = None
            self.last = None
        else:
            self.first = self.first.next

    def terminate_process_with_longest_wait(self):
        if self.first == None:
            print('No processes to be deleted\n')
        elif self.first.next == None:
            self.execute_process()
        else:
            longest_wait_time = self.first.processInformation["wait"]
            process_to_analyze = self.first
            while process_to_analyze != None:
                if process_to_analyze.processInformation["wait"] > longest_wait_time:
                    longest_wait_time = process_to_analyze.processInformation["wait"]
                process_to_analyze = process_to_analyze.next
            process_to_analyze = self.first
            while process_to_analyze.next != None:
                if self.first.processInformation['wait'] == longest_wait_time:
                    self.execute_process()
                elif process_to_analyze.next.processInformation['wait'] == longest_wait_time:
                    process_to_analyze.next = process_to_analyze.next.next
                    if process_to_analyze.next == None:
                        self.last = process_to_analyze
                else:
                    process_to_analyze = process_to_analyze.next

    def erase_task_manager(self):
        self.first = None
        self.last = None

    def print_task_manager(self):
        print(self)


gerenciadorDeTarefas = TaskManager()

print("Teste para verificar métodos caso a fila esteja vazia")
gerenciadorDeTarefas.execute_process()
gerenciadorDeTarefas.terminate_process_with_longest_wait()
gerenciadorDeTarefas.print_task_manager()

print("Teste para verificar métodos caso a fila tenha somente 1 elemento")
gerenciadorDeTarefas.add_new_process(1,1,1,1)
gerenciadorDeTarefas.print_task_manager()

gerenciadorDeTarefas.execute_process()
gerenciadorDeTarefas.print_task_manager()

gerenciadorDeTarefas.add_new_process(1,1,1,1)
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.terminate_process_with_longest_wait()
gerenciadorDeTarefas.print_task_manager()

print("Teste exclusão")
gerenciadorDeTarefas.add_new_process(1,1,1,1)
gerenciadorDeTarefas.add_new_process(2,2,2,2)
gerenciadorDeTarefas.add_new_process(3,3,3,3)
gerenciadorDeTarefas.add_new_process(4,4,4,4)
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.execute_process()
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.execute_process()
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.execute_process()
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.execute_process()
gerenciadorDeTarefas.print_task_manager()


print("Teste terminar processo com maior tempo de espera")

print("Se o de maior tempo for o primeiro")
gerenciadorDeTarefas.add_new_process(1,1,1,5)
gerenciadorDeTarefas.add_new_process(2,2,2,4)
gerenciadorDeTarefas.add_new_process(3,3,3,3)
gerenciadorDeTarefas.add_new_process(4,4,4,2)
gerenciadorDeTarefas.add_new_process(5,5,5,1)
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.terminate_process_with_longest_wait()
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.terminate_process_with_longest_wait()
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.erase_task_manager()

print("Se os 3 primeiros tiverem o maior tempo")
gerenciadorDeTarefas.add_new_process(11,1,1,5)
gerenciadorDeTarefas.add_new_process(12,2,2,5)
gerenciadorDeTarefas.add_new_process(13,3,3,5)
gerenciadorDeTarefas.add_new_process(14,4,4,2)
gerenciadorDeTarefas.add_new_process(15,5,5,1)
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.terminate_process_with_longest_wait()
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.erase_task_manager()

print("Se o de maior tempo forem os do meio")
gerenciadorDeTarefas.add_new_process(21,1,1,2)
gerenciadorDeTarefas.add_new_process(22,2,2,4)
gerenciadorDeTarefas.add_new_process(23,3,3,3)
gerenciadorDeTarefas.add_new_process(24,4,4,5)
gerenciadorDeTarefas.add_new_process(25,5,5,1)
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.terminate_process_with_longest_wait()
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.terminate_process_with_longest_wait()
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.terminate_process_with_longest_wait()
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.erase_task_manager()

print("Se 2 tiverem o maior tempo")

gerenciadorDeTarefas.add_new_process(31,1,1,2)
gerenciadorDeTarefas.add_new_process(32,2,2,5)
gerenciadorDeTarefas.add_new_process(33,3,3,3)
gerenciadorDeTarefas.add_new_process(34,4,4,5)
gerenciadorDeTarefas.add_new_process(35,5,5,1)
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.terminate_process_with_longest_wait()
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.erase_task_manager()

print("Se 2 seguidos tiverem o maior tempo")

gerenciadorDeTarefas.add_new_process(41,1,1,2)
gerenciadorDeTarefas.add_new_process(42,2,2,5)
gerenciadorDeTarefas.add_new_process(43,3,3,5)
gerenciadorDeTarefas.add_new_process(44,4,4,3)
gerenciadorDeTarefas.add_new_process(45,5,5,1)
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.terminate_process_with_longest_wait()
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.erase_task_manager()

print("Se 3 tiverem o maior tempo")

gerenciadorDeTarefas.add_new_process(51,1,1,2)
gerenciadorDeTarefas.add_new_process(52,1,1,5)
gerenciadorDeTarefas.add_new_process(53,2,2,5)
gerenciadorDeTarefas.add_new_process(54,3,3,3)
gerenciadorDeTarefas.add_new_process(55,4,4,5)
gerenciadorDeTarefas.add_new_process(56,4,4,4)
gerenciadorDeTarefas.add_new_process(57,5,5,1)
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.terminate_process_with_longest_wait()
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.erase_task_manager()

print("Se 3 seguidos tiverem o maior tempo")

gerenciadorDeTarefas.add_new_process(61,1,1,2)
gerenciadorDeTarefas.add_new_process(62,1,1,3)
gerenciadorDeTarefas.add_new_process(63,2,2,5)
gerenciadorDeTarefas.add_new_process(64,3,3,5)
gerenciadorDeTarefas.add_new_process(65,4,4,5)
gerenciadorDeTarefas.add_new_process(66,4,4,4)
gerenciadorDeTarefas.add_new_process(67,5,5,1)
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.terminate_process_with_longest_wait()
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.erase_task_manager()

print("Se o último tiver o maior tempo")
gerenciadorDeTarefas.add_new_process(71,1,1,1)
gerenciadorDeTarefas.add_new_process(72,2,2,2)
gerenciadorDeTarefas.add_new_process(73,3,3,3)
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.terminate_process_with_longest_wait()
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.terminate_process_with_longest_wait()
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.terminate_process_with_longest_wait()
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.terminate_process_with_longest_wait()
gerenciadorDeTarefas.erase_task_manager()

print("Os 3 últimos são os com o maior tempo")
gerenciadorDeTarefas.add_new_process(81,1,1,1)
gerenciadorDeTarefas.add_new_process(82,1,1,2)
gerenciadorDeTarefas.add_new_process(83,2,2,5)
gerenciadorDeTarefas.add_new_process(84,3,3,5)
gerenciadorDeTarefas.add_new_process(85,4,4,5)
gerenciadorDeTarefas.print_task_manager()
gerenciadorDeTarefas.terminate_process_with_longest_wait()
gerenciadorDeTarefas.print_task_manager()


