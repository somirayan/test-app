#!/bin/bash

# Assuming you are in the directory containing Dockerfile
DOCKERFILE_PATH="/app/test-app/Dockerfile"

# Build the Docker image
docker build -t lms -f "$DOCKERFILE_PATH" .

# Run the Docker container
docker run -d -p 8080:8080 \
    --env SPRING_PROFILES_ACTIVE=prod \
    --name lms-container \
    lms

