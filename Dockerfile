FROM maven:3.8.6-amazoncorretto-17 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY . .
RUN mvn clean package -Dmaven.test.skip=true


FROM amazoncorretto:17.0.14-alpine3.19

WORKDIR /deployments

COPY --from=build app/target/quarkus-app/lib     ./lib
COPY --from=build app/target/quarkus-app/app     ./app
COPY --from=build app/target/quarkus-app/quarkus ./quarkus
COPY --from=build app/target/quarkus-app/*.jar   .

EXPOSE 8080

CMD ["java", "-jar","./quarkus-run.jar"]
