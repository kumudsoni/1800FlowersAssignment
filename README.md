# 1800FlowersAssignment-
Springboot and REST API Assignment

Using the JSON feed: http://jsonplaceholder.typicode.com/posts
Create REST endpoints that reads the above JSON feed using HTTP.  The service should perform the following tasks:
1.      Count endpoint 
2.      Tally the number of unique user Ids in the JSON and return in a JSON response.
3.      Updated User List endpoint
4.      Modify the 4th JSON array item, changing the title and body of the object to "1800Flowers".
5.      Return the modified JSON object to the main Java class.
6.      Return the modified JSON in the endpoint response.

Unit test the same.
Should be runnable via "mvn test"
Should be written to test all aspects of the application (include mock of the feed).
Containerization and Kube
Create a dockerfile to put the java application into
Create the appropiate yaml file to deploy your app using minikube
Requirements
1.      Use Java 1.8+
2.      Use Spring Boot
3.      Use Maven
4.      Use JUnit and Mockito
5.      All dependencies should be publicly available or properly included with the project and referenced within the POM

Endpoint Url has been created to check above requirment - 
1) get all user info from JSON feed -  http://localhost:8080/Userdata/findUserInfo
2) Count endpoint - http://localhost:8080/Userdata/countEndpoint
3) Get unique user Ids in the JSON and return in a JSON response - http://localhost:8080/Userdata/findUniqueUserIds
4) Modify the 4th JSON array item, changing the title and body of the object to "1800Flowers".Return the modified JSON object to the main Java class. 6.Return the modified JSON in the endpoint response - http://localhost:8080/Userdata/updateUserListEndpoint/{Id}

Unit test available UserControllerTest which is taking mock feed from JSOn file (userdata.json, userdata_with_updatedfield.json) file.








