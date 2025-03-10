FROM openjdk:11-jdk-slim

WORKDIR /app

COPY . .

RUN javac Main.java

ENTRYPOINT ["java", "Main"]