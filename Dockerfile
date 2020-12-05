FROM openjdk:8
EXPOSE 8080
ADD target/kanban-api.jar kanban-api.jar
ENTRYPOINT ["java","-jar","/kanban-api.jar"]


