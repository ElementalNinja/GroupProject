# ---- build stage ----
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /App

COPY pom.xml .
COPY src ./src

# Build with fat JAR (assembly plugin bound to package phase)
RUN mvn -q -DskipTests package

# ---- runtime stage ----
FROM eclipse-temurin:17
WORKDIR /App

# Copy the JAR built in the build stage
COPY --from=build /App/target/App.jar App.jar

ENTRYPOINT ["java", "-jar", "App.jar"]
