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
(N.B :For this project port for POSTGRES is **5444**, have a look on **application.properties** file)


Enjoy !!
