# Starting with Docker base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Added Maintainer Info here. Details of Anshul Gautam
LABEL maintainer="anshulgammy@outlook.com"

# Added a volume
VOLUME zuul-datavolume: /volume/data/zuul

# This application will be accessible from port 7706 outside the container.
EXPOSE 7706

# Copying the jar file to workdir
COPY ./target/giveaway-zuul.jar /usr/app/

# Defined WORKDIR
WORKDIR /usr/app/

# executing the jar file here...
ENTRYPOINT ["java","-jar","giveaway-zuul.jar"]