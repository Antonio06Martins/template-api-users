FROM openjdk:11
ADD target/template-0.0.1-SNAPSHOT.jar app.jar
WORKDIR /app
COPY target/template-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

# docker build -f Dockerfile -t antonio/templateapi .
# docker run -p 8080:8080 antonio/templateapi