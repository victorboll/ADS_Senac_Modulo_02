function infoPessoa(nome, altura, peso){
    imc = peso / (altura * altura) //dividir o peso em quilos pelo quadrado da altura(em metros)
    return{
        nome,
        altura,
        peso,
        imc: imc, 
        info(){
            switch (true) {
                case (imc <  18.5):
                  console.log("Abaixo do peso");
                  console.log(imc)
                  break;
                case (imc >= 18.5 && imc < 25):
                  console.log("Peso normal");
                  break;
                case (imc >= 25 && imc < 30):
                  console.log("Acima do peso");
                  break;
                case (imc >= 30 && imc < 35):
                  console.log("Obesidade 1");
                  break;
                case (imc >= 35 && imc < 40):
                  console.log("Obesidade 2");
                  break;
                case (imc > 40):
                  console.log("Obesidade 3");
                  break;}
             }   
        }
    }

let pessoa = infoPessoa("Victor", 1.84, 105);

pessoa.info()