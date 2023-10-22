"""Tarefa 03 :: Estrutura Encadeada (Obrigatório)
Enviar arquivo zip contendo os exercícios de Estruturas Encadeadas (Lista, Fila e Pilha).
Os exercícios devem estar em formato python.

Esta atividade é individual.

Lista como Estrutura Encadeada
1. Implemente a função remove utilizando a função busca.

2. Remova duplicatas de uma lista ordenada. Suponha que lhe seja fornecida uma lista encadeada armazenando
números inteiros em ordem crescente. Sua tarefa é remover todos os elementos duplicados da lista.
Por exemplo, dada a lista [0 → 1 → 1 → 5 → 7 → 10 → 10 → None], seu programa deve retornar
a lista [0 → 1 → 5 → 7 → 10 → None].

3. Defina as funções inserção, remoção e busca como métodos da Classe Lista. (Vide apostila)

Pilha como Estrutura Encadeada
1. Escrever uma função que receba como parâmetro uma pilha. A função deve retornar o maior elemento da pilha.

2. Utilizando uma pilha resolver o exercício a seguir: Dada uma sequência contendo N (N >0) números reais, imprimi-la
na ordem inversa.

3. Escreva uma função que receba como parâmetro duas pilhas e verifique de elas são iguais. Duas pilhas são iguais se
possuem os mesmos elementos, na mesma ordem.

4. Construa um programa utilizando uma pilha que resolva o seguinte problema:

Armazene as placas dos carros (apenas os números) que estão estacionados numa rua sem saída estreita.
Dado uma placa verifique se o carro está estacionado na rua.
Caso esteja, informe a sequência de carros que deverá ser retirada para que o carro em questão consiga sair.
5. Implemente uma função chamada TPilha, que receba um vetor de inteiros com 15 elementos. Para cada um deles,
como segue:

Se o número for par, insira-o na pilha;
Se o número lido for ímpar, retire um número da pilha;
Ao final, esvazie a pilha imprimindo os elementos.
6. Escreva uma função chamada TPilha2 que recebe como parâmetro 2 pilhas (N e P) e um vetor de inteiros. Para cada um:

se positivo, inserir na pilha P;
se negativo, inserir na pilha N;
se zero, retirar um elemento de cada pilha.
Fila como Estrutura Encadeada

1. Implemente uma fila dinâmica contendo todas as funcionalidades de uma fila padrão. Para isso, resolvar:
–Crie um nó padrão da fila.
–Crie uma função de inicialização da fila vazia
–Crie uma função push que cria e insere um novo nó para o final da fila.
–Crie uma função pop que remove o primeiro elemento da fila.


2. Crie uma função de busca em que o usuário insere um valor (inteiro) e o programa retorna a sua posição na fila.

3. Crie uma função que percorre e imprime todos os elementos da fila.

4. Escreva uma função que inverta a ordem dos elementos da fila.  Por exemplo:

[1] [4] [5] [2] → [2] [5] [4] [1]

5. No seu sistema operacional ao abrir o “gerenciador de tarefas” você pode exibir os processos que estão em execução,
veja como isso é apresentado no windows:

Você já parou pra pensar como é possível executar todos esses aplicativos em apenas um processador? Isso existe graças
a uma funcionalidade chamada de tempo compartilhado (“time-shared”). Essa funcionalidade mantém uma sequência
deprocessos em uma fila, esperando para serem executados. Modifique a fila dinâmica que você implementou anteriormente
para armazenar as informações desses processos.

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
–Imprimir o conteúdo da lista de processos.
"""