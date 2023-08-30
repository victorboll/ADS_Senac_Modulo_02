def fatorial(n: int) -> int:
    # -> int seria uma "hint", que indica qual vai ser o tipo do retorno da função
    if n == 1 or n == 0:
        return 1
    return n * fatorial(n - 1)

print(fatorial(5))