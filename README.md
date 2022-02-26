Changes are in Master Branch
# spring-boot-hibernate-mysql-rest-api
A simple Spring boot application that demonstrates the usage of RESTful API using Spring boot, Hibernate and MySQL.

After cloning the project to successfully run the project follow below steps:

This App with require SQL connectivity:
 1> in Sql :  Add below querry to create a table
 
    CREATE TABLE tbl_employee
(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    	name VARCHAR(255),
    	gender VARCHAR(255),
    	department VARCHAR(255),
    	dob DATE
)

2> In your SpringBoot project src/main/resources>application.properties : Change MySQL Username and Password as per your MySQL Installation
