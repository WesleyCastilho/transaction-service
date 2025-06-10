# Etapa 1: build com Maven
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: imagem final com apenas o JAR
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /app/target/transaction-service.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
