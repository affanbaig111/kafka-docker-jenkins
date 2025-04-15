#!/bin/bash

# Check if container name is provided
if [ -z "$1" ]; then
  echo "Usage: $0 <container_name>"
  exit 1
fi

CONTAINER_NAME="$1"

# Get the container PID
PID=$(docker inspect --format '{{.State.Pid}}' "$CONTAINER_NAME" 2>/dev/null)

# Kill the process if PID exists
if [ -n "$PID" ] && [ "$PID" -ne 0 ]; then
  echo "Killing PID $PID..."
  sudo kill -9 "$PID" 2>/dev/null
fi

# Stop the container (ignore errors if already stopped)
echo "Stopping container $CONTAINER_NAME..."
docker stop "$CONTAINER_NAME" >/dev/null 2>&1

# Remove the container
echo "Removing container $CONTAINER_NAME..."
docker rm "$CONTAINER_NAME"

echo "Container $CONTAINER_NAME has been removed."
