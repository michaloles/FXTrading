# Run

As it's a maven spring boot application just use mvn spring-boot:run to start it.

# Test

Tests are written using Spock framework so groovy needs to be installed.

# Solution description

I haven't got enought business knowledge about forex transactions so probably some of my assumptions are wrong.

This application seems as perfect use case for rule engine like JBoss Drools. I don't use it as I don't thing that was a purpose of this task.
For graceful shutdown there is Spring actuator endpoint under /shutdown (POST method) which can be used for graceful shutdown. Other solution is to use this endpoint that is even more mercy:
https://github.com/gesellix/graceful-shutdown-spring-boot

There are also few things that can be improved but I don't have time to do that:
* All validation messages should be moved to properties file
* We can add additional layers to provide better concern separation
* We can write HolidayProvider to provide list of holidays, so it will be flexible to add support for different countries holidays
* Inside spock tests - validation messages should be also verified
* Error with swagger annotation should be fixed (now when @EnableSwagger2 annotation is present tests fail to run)

# Approach for providing high availability of the service and its scalability

We can build cluster and use load balancer to split load over many nodes. As this sample is very simple this will be very easy to deploy in clustered environment.
In normal production applicaion of course there is few factors that we need to consider deploying application in clustered environment.

Other solution may be to split this monolith application to microservices architecture. Of course in that case there are also many factors to consider.

# Create online documentation of the REST API exposed by the service

I used Swagger for that. Swagger UI is availible under http://localhost:8080/swagger-ui.html (You need to uncomment @EnableSwagger2 annotation).

# Create online documentation of the REST API exposed by the service

Application can be deployed into cluster so this will provide scalability and high avalibity. Of courese there are few things that we need to consider in that case.