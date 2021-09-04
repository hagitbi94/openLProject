FROM maven:3.8.1-jdk-8 AS MAVEN_BUILD


COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package


FROM openjdk:8-jre-alpine

WORKDIR /app
EXPOSE 8095
COPY --from=MAVEN_BUILD /build/target/open-l-project-0.0.1-REALESE.jar /app/

ENTRYPOINT ["java", "-jar", "open-l-project-0.0.1-REALESE.jar"]