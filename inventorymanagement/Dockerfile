# Starting with Docker base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Added Maintainer Info here. Details of Anshul Gautam
LABEL maintainer="anshulgammy@outlook.com"

# Added a volume
VOLUME inv-datavolume: /volume/data/inv

# This application will be accessible from port 7002 outside the container.
EXPOSE 7002

# Copying the jar file to workdir
COPY ./target/giveaway-inventorymanagement.jar /usr/app/

# Defined WORKDIR
WORKDIR /usr/app/

# executing the jar file here...
ENTRYPOINT ["java","-jar","giveaway-inventorymanagement.jar"]  