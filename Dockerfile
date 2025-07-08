#Step 1 - Build backend
FROM maven:3.9.4-eclipse-temurin-21-alpine AS build
COPY . /home/app/contacts/Contatos/contatos
RUN mvn -v
RUN mvn -f /home/app/contacts/Contatos/contatos/pom.xml clean package


#Step 2 - Run backend
FROM alpine/java:21-jdk
COPY --from=build /home/app/contacts/Contatos/contatos/target/*.jar /usr/local/lib/contacts/Contatos/contatos.jar
VOLUME /tmp
EXPOSE 80:8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/contacts/Contatos/contatos.jar"]