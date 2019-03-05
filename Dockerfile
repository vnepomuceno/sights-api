FROM openjdk:8-alpine
MAINTAINER Valter Nepomuceno

ENV GRADLE_OPTS "-Dorg.gradle.daemon=false"
ENV APP_HOME /app
RUN mkdir $APP_HOME
WORKDIR $APP_HOME

# Download dependencies
ADD build.gradle $APP_HOME
ADD settings.gradle $APP_HOME
ADD gradlew $APP_HOME
ADD gradle $APP_HOME/gradle

# Build
ADD . $APP_HOME/
