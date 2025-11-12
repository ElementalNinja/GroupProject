# ---- build stage ----
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# build a fat jar
RUN mvn -q -DskipTests package assembly:single

# ---- runtime stage ----
FROM eclipse-temurin:17
WORKDIR /app
COPY --from=build /app/target/*-jar-with-dependencies.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
