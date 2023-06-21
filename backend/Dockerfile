# STAGE 1 - BUILD
FROM maven AS build
WORKDIR /home/maven
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# STAGE 2 - RUN
FROM openjdk:17-oracle
WORKDIR /home/app
COPY --from=build /home/maven/target/*.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]

