This is a spring boot project with REST API to get all the user accounts and the selected account transactions.
Used inmemory H2 database. data.sql loads the sample data on start up.

'gradlew build' will build the project.

Run 'UserAccountInformation.java' as java application.

And then start the frontend application.


'pom.xml' is the maven config
Run 'mvn clean install' to build the application
Run 'java -jar target/useraccount-0.0.1-SNAPSHOT.jar' to run the application
http://localhost:8080/accounts list all accounts
http://localhost:8080/accountTransactions/12345 list all account transactions for account 12345.
