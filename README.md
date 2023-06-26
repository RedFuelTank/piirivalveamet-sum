# Introduction
This work provides ability to summarize two integers, as well as request one of previous cases of summarization by sum or addend

This work was written as a home assignment for Police and Border Guard Board

## Technical Stack

Database
- PostgreSQL

Back-End
- Spring Boot 3.1
- Swagger - UI

# Run instruction

### Docker Compose
The project uses Docker with Docker Compose for containerization and deployment the application

Command for running the application via Docker Compose:  
```docker-compose up ```

Docker Compose creates Docker containers for every part of the application.
If containers should be deleted, use Docker Compose command:  
```docker-compose down```

### Default URL addresses

- Application: ```http://localhost:8080```

# Entry points

[Swagger-UI](http://localhost:8080/api/swagger-ui/index.html) (The application should be run)

![swagger-ui.png](assets/swagger-ui.png)

# Description
This application consists two endpoints, one of these endpoints for handling a request of summarizing of two integers 
and second endpoint for searching a previous cases of summarization. 

In search purpose, you can use a sorting for your requests, if you want to search results by sum:
```http://localhost:8080/search/{number for search}?sort=sum,{desc|asc}```

Also with searching by first addend and second addend:
```http://localhost:8080/search/{number for search}?sort={firstAddend|secondAddend},{desc|asc}```

There was implemented an error handling and possibility to run an application using Docker and Docker Compose as well.  

All requests has conditions for inbound parameters
