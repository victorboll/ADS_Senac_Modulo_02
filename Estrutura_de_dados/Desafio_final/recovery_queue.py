import requests
r = requests.post("http://127.0.0.1:5000/pos_processing")
#Ele vai subit um serviço, como se fosse um servidor, que vai aguardar um request para executar alguma coisa
#Isso aqui é uma simulação de um request que será feita para o servidor
print(r.status_code)