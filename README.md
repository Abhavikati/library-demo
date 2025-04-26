# library-demo
library demo using full stack frontend primevue and springboot

1. make sure db is ready and running
```shell

docker run -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres
```

2. Introduce docker compose 
```shell

docker-compose up
```

```shell

docker-compose down
```

docker compose down -v  
docker compose up --build