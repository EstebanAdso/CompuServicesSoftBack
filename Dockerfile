# Usa una imagen compatible con Java 21
FROM openjdk:22-jdk-slim

# Define el argumento para especificar el JAR a copiar
ARG JAR_FILE=target/CompuServicesSoft-0.0.1.jar

# Copia el archivo JAR al contenedor
COPY ${JAR_FILE} app_compuServicesSoft.jar

# Expone el puerto que usa tu aplicación
EXPOSE 8084

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app_compuServicesSoft.jar"]
