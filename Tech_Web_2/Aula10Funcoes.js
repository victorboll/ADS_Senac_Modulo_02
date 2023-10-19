function infoPessoa(nome, sobrenome, i){
    return{
        nome,
        sobrenome,
        idade: i,
        info(){
            console.log(`Seu nome é: ${this.nome} e sua idade é ${this.idade}`)
        }
    }
}

let funcionario = infoPessoa("Lucas", "Silva", 40);

funcionario.info()