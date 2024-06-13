# api-storage
## Exemplo simples de uma API Spring Boot 3 com MySQL para upload de imagens

Executar projeto: 
```bash
./mvnw spring-boot:run
```


Exemplo container Docker Mysql: 
```bash
docker run -d --name mysql-server --restart=always -e MYSQL_ROOT_PASSWORD=root -v "$PWD/data:/var/lib/mysql" -p 3306:3306 mysql
```
