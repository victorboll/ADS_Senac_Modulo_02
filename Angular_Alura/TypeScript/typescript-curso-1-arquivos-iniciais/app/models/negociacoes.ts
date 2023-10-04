import { Negociacao } from "./negociacao.js";

export class Negociacoes {
    private negociacoes: Negociacao[] = []; //Array<Negociacao> = Negociacao[]

    adiciona(negociacao: Negociacao) {
        this.negociacoes.push(negociacao)
    }

    lista(): readonly Negociacao[] { //Mas ele só fica read only enquanto estiver dentro do contexto de Lista()
        //ReadonlyArray<Negociacao> = readonly Negociacao[]
        return this.negociacoes

        /*Para podermos fazer negociacoes ser readonly no javascript, sem o typescript, teríamos que fazer:
        return [...this.negociacoes]; os 3 pontos simbolizam o spread operator. Ele não coloca uma lista  
        dentro de outra lista, ele na verdade pega cada item da lista negociacoes, e coloca dentro dessa nova lista. 
        Então pode-se modificar a lista sem se modificar a lista negociação original, que vai estar encapsulada 
        No final das contas ele não está retornando negociacao, mas sim uma imagem de negociacao, 
        então quando o lista().pop() ocorre, ele está fazendo pop da imagem, e não da lista negociação em si
        Se tivéssemos feito return this.negociacoes', o lista().pop() iria afetar a lista negociacao em si*/
    }
}