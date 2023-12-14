#!/bin/bash

# Assuming you are in the directory containing Dockerfile
DOCKERFILE_PATH="/app/test-app/Dockerfile"

# Stop the existing container
docker stop lms-container || true

# Remove the existing container
docker rm lms-container || true

# Build and run the new container
docker build -t lms -f "$DOCKERFILE_PATH" .
docker run -d -p 8080:8080 \
    --env SPRING_PROFILES_ACTIVE=prod \
    --name lms-container \
    --restart always \
    lms

