# Use the official Gradle image as the base
FROM gradle:7.1.1-jdk11 AS build

# Create a directory for the project
RUN mkdir /project

# Copy the project files into the container
COPY . /project

# Set the working directory to the project
WORKDIR /project

# Run the Gradle build command
RUN gradle clean build

# Switch to a different base image that supports adduser syntax
FROM adoptopenjdk/openjdk11:latest

RUN mkdir -p /app

# Create a non-root user and group
RUN addgroup --gid 1001 lmsgroup && useradd -u 1001 -g lmsgroup -m -s /bin/bash lms

COPY --from=build /project/build/libs/spring-react-v1.jar /app/lms.jar

# Create the /app directory
RUN mkdir -p /app

WORKDIR /app

RUN chown -R lms:lmsgroup /app

USER lms

CMD java $JAVA_OPTS -jar lms.jar

