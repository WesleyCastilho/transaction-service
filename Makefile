# Makefile para Transaction Service

.PHONY: build up down clean test

build:
	@echo "📦 Gerando build do projeto..."
	./mvnw clean package -DskipTests

up:
	@echo "🐳 Subindo containers com Docker Compose..."
	docker-compose up -d --build

down:
	@echo "🛑 Parando containers..."
	docker-compose down

clean:
	@echo "🧹 Limpando projeto..."
	./mvnw clean

test:
	@echo "🧪 Executando testes..."
	./mvnw test
