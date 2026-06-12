# ==========================================
# Etapa 1: Construcción (Compilar el código)
# ==========================================
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copiamos el pom.xml y descargamos las dependencias primero
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el resto del código fuente
COPY src ./src

# Compilamos el proyecto saltando las pruebas para que sea más rápido
RUN mvn clean package -DskipTests

# ==========================================
# Etapa 2: Ejecución (Levantar el servidor)
# ==========================================
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copiamos solo el archivo .jar compilado de la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto 8080 (el que usa Spring Boot por defecto)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]