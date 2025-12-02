# Étape 1 : compilation
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

COPY Hello.java .

RUN javac Hello.java

# Étape 2 : image finale minimaliste
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/Hello.class .

# Commande exécutée au lancement
CMD ["java", "Hello"]
