#image python
FROM python:3.9-slim

#definir le repertoire du travail
WORKDIR /app

#installer flask
RUN pip install flask

#copier le fichier app.py dans le conteneur
COPY app.py .

#port a exposer
EXPOSE 5000


#commande pour lancer l'application
CMD ["python", "app.py"]