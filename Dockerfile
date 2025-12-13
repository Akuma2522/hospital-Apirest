# Imagen base con Java
FROM eclipse-temurin:17-jdk

# Directorio de trabajo
WORKDIR /app

# Copiar el jar
COPY target/hospital-Apirest-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto del backend
EXPOSE 3333

# Ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
