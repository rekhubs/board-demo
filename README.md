# board-demo
A demo project using Spring Boot and OpenFeign to consume and populate [JSONPlaceholder](https://jsonplaceholder.typicode.com/)'s `posts` and `comments` APIs, and serves as a new API service. A simple Angular Material frontend app is embedded to consume and display the posts. \
Initial build and commit on 11th May 2021.

backend 
* Spring Boot 2.4.5
* Spring Cloud 2020.0.2 (for OpenFeign)
* springdoc-openapi 1.5.8 (for API utils/Swagger)

frontend
* Angular 11 
* node 14.4.0
* npm 6.14.5

integration tool
* [eirslett/frontend-maven-plugin](https://github.com/eirslett/frontend-maven-plugin) 1.11.3

### 1. Run and use the service
Start the service with prebuilt package in `out` directory using java jre 8:

```bash
java -jar out/demo-0.0.1.jar
```
Once the service is started, find the endpoints at:
* `posts` API \
  http://localhost:8080/api/v1/posts
* Angular frontend \
  http://localhost:8080/
* browse all exposed APIs on Swagger UI \
  http://localhost:8080/swagger
* ported JSONPlaceholder APIs \
  http://localhost:8080/api/v1/raw/posts \
  http://localhost:8080/api/v1/raw/comments 

### 2. Build
Build the project - all backend and frontend source code - from scratch with one command: \
*enviroment prerequisites: jdk 8, maven 3.3+*
```bash
mvn clean spring-boot:run
```
<!-- todo: frontend build commands -->
  
### 3. Screenshots
#### Angular Material frontend
![Angular frontend](media/Screen%20Shot%202021-05-11%20at%209.39.31%20PM.png)
#### APIs
![APIs](media/Screen%20Shot%202021-05-11%20at%209.40.04%20PM.png)
#### Swagger UI
![Swagger UI](media/Screen%20Shot%202021-05-11%20at%209.39.45%20PM.png)
#### hot serve and debug frontend separately `ng serve`
![ng serve](media/Screen%20Shot%202021-05-11%20at%209.40.18%20PM.png)
