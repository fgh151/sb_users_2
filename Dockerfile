FROM gradle:8.4-jdk11-jammy AS builder
WORKDIR /app
COPY . .
RUN gradle build -x test --no-daemon


FROM eclipse-temurin:11-jdk-alpine
VOLUME /tmp
COPY --from=builder /app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]