:cyclone:Project Manager
-----------
Web application on Java using Spring Boot for managing goods at warehouse.

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

POST: localhost:8080/api/v1/products/ Request body: { "name": "Name1", "description": "Description1", "create_date": "2020-11-01", "place_storage": "1" }

PUT: localhost:8080/api/v1/products/ Request body: { "id": 2, "name": "Name2", "description": "Description2", "create_date": "2020-11-02", "place_storage": "2" }

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

4)Сreating docker image docker: build -t docker-project_manager;

5)docker run -p 8080:8080 docker-project_manager.
