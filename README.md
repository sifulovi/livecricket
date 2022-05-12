### Technologies:

1. JAVA -11
2. Spring Boot
3. Docker for POSTGRES DB
4. Intellij Idea

Project Setup:

Step- 1 : Run Following command to resolve all dependencies,

```
   ❯ mvn install && mvn clean
```

Step- 2 : Run Following command to create docker container. You may skip following command if you have installed
POSTGRES in local machine.

```
   ❯ sudo docker-compose up -d
```

Default Admin Credential: 
```
username=root
password=root
```

Database Related config:
```
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.datasource.url=jdbc:postgresql://localhost:5432/scores
spring.datasource.username=root
spring.datasource.password=root
server.port=8999


spring.security.user.name=root
spring.security.user.password=root
```

Application base Url:
```
http://localhost:8999/
```
Enjoy !!
