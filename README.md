# recipe book
collections of Web APIs to do CRUD operations of recipe data. some features are : 
* user registration 
* authentication
* data validation 
  * for user data registration
  * for recipe data
* CRUD operation of recipe data and its authorization 
  * add new recipe => all authorized user 
  * get recipe by id => all authorized user
  * delete recipe by id => only the author of the recipe 
  * update recipe by id => only the author of the recipe
  * get list of recipes by category => all authorized user
  * get list of recipes by name => all authorized user
  * get list of your recipes => all authorized user


# dependencies 
```java
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-security'
	implementation 'org.springframework.boot:spring-boot-starter-validation'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.springdoc:springdoc-openapi-ui:1.6.12'
	compileOnly 'org.projectlombok:lombok'
	runtimeOnly 'com.h2database:h2'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testImplementation 'org.springframework.security:spring-security-test'
}
```

# documentation
documentation of the APIs can be accessed in http://localhost:8080/swagger-ui.html

# rest api testing
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/16178423-b7fe888e-1f41-49c9-8296-8d1c1e689017?action=collection%2Ffork&collection-url=entityId%3D16178423-b7fe888e-1f41-49c9-8296-8d1c1e689017%26entityType%3Dcollection%26workspaceId%3D21a71018-9661-4b2c-8aa3-1bdf4302da2e)