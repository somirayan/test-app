#!/bin/bash

# Assuming you are in the directory containing Dockerfile
DOCKERFILE_PATH="/app/test-app/Dockerfile"

# Stop the existing container (if it exists)
docker stop lms-container 2>/dev/null

# Wait for the container to stop
while [ "$(docker inspect -f '{{.State.Running}}' lms-container 2>/dev/null)" == "true" ]; do
    sleep 1
done

# Remove the existing container (if it exists)
docker rm lms-container 2>/dev/null

# Build and run the Docker container with restart policy
docker build -t lms -f "$DOCKERFILE_PATH" .

# Create a directory in your home folder
mkdir ~/logs

# Run the Docker container with the volume mount
docker run -d -p 8080:8080 \
   --env SPRING_PROFILES_ACTIVE=prod \
   --name lms-container \
   --restart always \
   -v ~/logs:/var/log/app  # Mount the volume here


