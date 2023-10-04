export class Negociacao {

    constructor(  
        private  _data: Date,
        public readonly quantidade: number,
        public readonly valor: number
        ){} 
        //Se no parâmetro do construtor, você coloca private ou public, ele identifica que se trata de um novo atributo, e você não precisa declará-lo anteriormente
        //colocando public readonly data, você está garantindo que o dado só poderá ser utilizado para leitura e não modificado, tirando a necessidade de um getter para ele
        //readonly funciona para proteger só durante atribuição (x = 1). Mas ainda pode ser afetado por métodos mutáveis como setdate

    get volume(): number{
        return this.quantidade * this.valor
    }

    get date(): Date{
        const data = new Date(this._data.getTime()); // Pega o _data em milissegundos
        return data //É uma nova data que faz referência a data que foi colocada no construtor, então qualquer mudança feita a essa data, não afete o construtor
    }
}