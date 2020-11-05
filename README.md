:cyclone:Product Manager
-----------
Web application on Java using Spring Boot for managing goods at warehouse.

![Product_Manager(Git Hub)](https://user-images.githubusercontent.com/72156897/98236378-50f78c00-1f74-11eb-9b7d-eb4bb603c69b.png)

:cyclone:Description
-----------
The application does four basic (CRUD) functions: 

:heavy_minus_sign: Create; 

:heavy_minus_sign:  Read;

:heavy_minus_sign:  Update; 

:heavy_minus_sign:  Delete for each position in the list.

:cyclone: Rest requests
-----------
GET: localhost:8080/api/v1/products/ - get all products GET: localhost:8080/api/v1/products/1 - get product with ID 1

POST: localhost:8080/api/v1/products/ Request body: { "name": "Name1", "description": "Description1", "place_storage": "1", "create_date": "2020-11-01", "price": "3" }

PUT: localhost:8080/api/v1/products/ Request body: { "name": "Name2", "description": "Description2","place_storage": "2", "create_date": "2020-11-02", "price": "10" }

DELETE: localhost:8080/api/v1/products/2 - delete product with ID 2

:cyclone: Requirements
-----------
:heavy_minus_sign: Git;

:heavy_minus_sign: Maven;

:heavy_minus_sign: Docker.

:cyclone: Installation and launch
-----------
1)Cloning the repository: git clone - https://github.com/WoodySide/Product-Manager.git;

2)Go to the  directory, with the project itself;

3)Building the project: mvn install;

4)Сreating docker image docker: build -t docker-product_manager;

5)docker run -p 8080:8080 docker-product_manager.
