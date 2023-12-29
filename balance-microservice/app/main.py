import json
import requests
import os
from wsgiref.simple_server import make_server

def get_balance(card):
    URL = os.getenv('TULLAVE_BASE_URL') + f"{card}"
    headers = {
        'Authorization': 'Bearer ' + os.getenv('TULLAVE_TOKEN')
    }
    response = requests.get(URL, headers=headers)
    return response.json()

def application(environ, start_response):
    path = environ['PATH_INFO']
    if path.startswith('/cards/api/balance/'):
        tarjeta = path.split('/cards/api/balance/')[1]
        balance = get_balance(tarjeta)
        response_body = json.dumps(balance)
    else:
        response_body = json.dumps({'error': 'Invalid endpoint'})

    response_headers = [
        ('Content-type', 'application/json'),
        ('Content-Length', str(len(response_body)))
    ]

    start_response('200 OK', response_headers)
    return [bytes(response_body, 'utf-8')]

servidor = make_server('0.0.0.0', 8000, application)
servidor.serve_forever()
