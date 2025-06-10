#!/bin/bash

echo "📦 Gerando build do projeto (Maven)..."
./mvnw clean package -DskipTests

echo "🐳 Subindo containers com Docker Compose (modo destacado)..."
docker-compose down -v
docker-compose up --build -d

echo "🌐 Acesse a aplicação em: http://localhost:8080/swagger-ui.html"
