# simple multi-stage build
FROM eclipse-temurin:17-jdk-jammy as build
WORKDIR /workspace
COPY pom.xml .
COPY src src
RUN ./mvnw -version || echo "Using host mvn"
# If mvnw not present (we didn't include it), build with system maven:
RUN mvn -q -DskipTests package

FROM eclipse-temurin:17-jdk-jammy
ARG JAR_FILE=target/logrca-backend-0.1.0.jar
COPY ${JAR_FILE} /opt/logrca/logrca.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/opt/logrca/logrca.jar"]
