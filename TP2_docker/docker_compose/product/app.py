from flask import Flask, jsonify, request
from flask_restful import Api, Resource

#creer l'application flask
app = Flask(__name__)   
api = Api(app)

class Product(Resource):
    def get(self):
        return {
            'products': ['Ipad pro 14', 'Macbook pro', 'Rmarkable pro', 'Ordinateur de bureau']
        }

#def d'une route pour l'API
api.add_resource(Product, '/')

#execution de l'application
if __name__ == '__main__':
    app.run(host='0.0.0.0', port=80, debug=True)