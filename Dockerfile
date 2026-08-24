FROM eclipse-temurin:17

LABEL maintainer="https://github.com/vitorfxp/API-Cadastro"

WORKDIR /app

COPY target/CadastroDeNinjas-0.0.1-SNAPSHOT.jar /app/cadastro-ninja.jar

ENTRYPOINT ["java", "-jar", "cadastro-ninja.jar"]
