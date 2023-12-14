#!/bin/bash

# Assuming you are in the directory containing Dockerfile
DOCKERFILE_PATH="/app/test-app/Dockerfile"

docker stop lms-container || true
while [ "$(docker inspect -f '{{.State.Running}}' lms-container 2>/dev/null)" == "true" ]; do
    sleep 1
done
docker rm lms-container || true

# Build the Docker image
docker build -t lms -f "$DOCKERFILE_PATH" .

# Run the Docker container with restart policy
docker run -d -p 8080:8080 \
    --env SPRING_PROFILES_ACTIVE=prod \
    --name lms-container \
    --restart always \
    lms
