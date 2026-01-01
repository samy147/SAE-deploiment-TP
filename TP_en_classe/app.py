from flask import Flask, jsonify, request
#test

#creer l'application flask
app = Flask(__name__)

#pas de base de donnéée
#save les etudiants dans une liste

students = [
    {'id': 1, 'prenom': 'Samir', 'age': 31},
    {'id': 2, 'prenom': 'Safa', 'age': 22}
]

@app.route('/')
def home():
    return """
        <html>
            <head>
                <title>API Étudiants</title>
            </head>
            <body style="font-family: Arial; text-align: center; margin-top: 50px;">
                <h1>Bienvenue dans l'API des étudiants </h1>
                <p>Utilise <a href="/students">/students</a> pour voir la liste des étudiants en JSON.</p>
                <p>Créé en Flask par Samy Mehamli</p>
            </body>
        </html>
    """

@app.route('/students', methods=['GET'])  #route pour obtenir la liste des étudiants
def get_students():
    return jsonify(students)  #retourner la liste des étudiants en format json  



#ajouter un etudiant
@app.post('/students')
def add_student():
    new_student = request.get_json() #obtenir données envoyées en json
    new_student['id'] = len(students) + 1  #attribuer un id unique
    students.append(new_student)  #ajouter l'étudiant à la liste
    return jsonify(new_student), 201  #retourner l'étudiant ajouté avec code

@app.route('/students/<int:id>', methods=['GET'])  #route pour obtenir un étudiant par id
def get_student(id):
    student = next((s for s in students if s['id'] == id), None)
    if student:
        return jsonify(student)
    else:
        return jsonify({'message': 'Étudiant non trouvé'}), 404

#modifier un etudiant
@app.route('/students/<int:student_id>', methods=['PUT'])
def update_student(student_id):
    data = request.get_json()  #obtenir données envoyées en json
    student = next((s for s in students if s['id'] == student_id), None)
    if not student:
        return jsonify({'message': 'Étudiant non trouvé'}), 404
    if 'prenom' in data:
        student['prenom'] = data['prenom']
    if 'age' in data:
        student['age'] = data['age']
    # student.update(data)  #mettre à jour les informations de l'étudiant
    return jsonify(student)


#supprimer un etudiant
@app.route('/students/<int:id>', methods=['DELETE'])
def delete_student(id):
    global students
    students = [s for s in students if s['id'] != id]
    return jsonify({'message': 'Étudiant supprimé'}), 200



if __name__ == '__main__':  #si le fichier est exécuté directement
    app.run(host='0.0.0.0', port=5000, debug=True)     #lancer le serveur local en mode debug

