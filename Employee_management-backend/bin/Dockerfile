FROM eclipse-temurin:21-jre
ADD target/employee.jar employee.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","employee.jar","--spring.profiles.active=docker"]
