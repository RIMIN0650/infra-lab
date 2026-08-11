# 빌드 단계
FROM gradle:jdk17-alpine AS builder
WORKDIR /app


COPY build.gradle ./
COPY settings.gradle ./

RUN gradle dependencies --no-daemon

COPY ./src ./src
RUN gradle bootjar --no-daemon


# 실행 단계
FROM openjdk:17-ea-17-slim
COPY     --from=builder /app/build/libs/*.jar    /app.jar
EXPOSE 8080
CMD ["java", "-jar", "/app.jar"]