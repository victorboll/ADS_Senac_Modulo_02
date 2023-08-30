def contagem_regressiva_recursiva(comeca_em: int = 10, termina_em: int = 0) -> int:
#Contagem regressiva iniciando em 'comeca_em' e terminando em 'termina_em'
    print(comeca_em)
# Caso-base
    if comeca_em <= termina_em:
# Perceba que aqui um valor real é retornado
# e não há mais recursão
        return comeca_em
# Caso recursivo
# Esse código será executado sempre, até
# 'comeca_em' se tornar menor ou igual a 'termina_em'
    return contagem_regressiva_recursiva(comeca_em - 1)

#variável especial do python. Ele carrega o bloco principal, mas só executa o que está embaixo, então se o que estiver
# embaixo não chamar o que estiver em cima, ele não é carregado
if __name__ == "__main__":
    contagem_regressiva_recursiva()