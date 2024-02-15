FROM openjdk:19-alpine

WORKDIR /github-trending-repositories/core

ENV SERVER_PORT=8090

RUN apk update && apk add --no-cache wget

ARG JAR_VERSION=v1.0.0

ARG JAR_DOWNLOAD_URL=https://github.com/sliderzxc/telegram-bots/releases/download/$JAR_VERSION/application.jar

RUN wget --quiet --show-progress --no-cache --progress=bar: ${JAR_DOWNLOAD_URL} -O application.jar

EXPOSE $SERVER_PORT

CMD ["java", "-jar", "application.jar"]