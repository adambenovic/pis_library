FROM maven:3.6.3-openjdk-11 AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -f pom.xml  -Dmaven.test.skip=true clean package

FROM openjdk:11
COPY --from=build /workspace/target/*.jar app.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","app.jar"]