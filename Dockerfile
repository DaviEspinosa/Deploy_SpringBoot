FROM ubuntu:latest AS build

#OpenJdk não é o JDK
#intale  o OpenJdk
#-y para aceitar(YES)
RUN apt-get update && apt-get install -y openjdk-21-jdk

#copia mimnha aplicação na maquina virtual
COPY . .

RUN apt-get install maven -y

RUN mvn clean install

FROM openjdk:21-jdk-slim

#expondo a porta da minha aplicação
EXPOSE 8181

COPY --from-build /target/game_store.jar /app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]