import requests
r = requests.post("http://127.0.0.1:5000/start_processing")
#serv para simular o post
print(r.status_code)