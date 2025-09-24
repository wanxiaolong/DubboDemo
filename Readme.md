# How to run?

## Prerequisites

start zookeeper server

```bash
# using docker
docker run -d --name zookeeper -p 2181:2181 zookeeper

# using docker compose
docker compose up -d
```

## Run

- start ServiceProvider
- start ServiceConsumer
- call consumer API: http://localhost:8081/user/1