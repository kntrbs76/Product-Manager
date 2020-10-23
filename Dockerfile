FROM  openjdk:15
ADD target/Product-Manager-0.0.1-SNAPSHOT.jar docker-product_manager.jar
EXPOSE 8080
ENTRYPOINT ["java" , "-jar", "/docker-product_manager.jar"]
