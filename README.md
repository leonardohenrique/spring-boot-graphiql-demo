# Spring Boot Graphiql Demo
A simple demo of Spring Boot 2 with GraphQL

### Requirements 

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

### How to run

```
git clone https://github.com/leonardohenrique/spring-boot-graphiql-demo.git
cd spring-boot-graphiql-demo
mvn spring-boot:run
```

Access: http://localhost:8080/graphiql

#### Query

```
{
  books {
    id,
    title,
    author {
      name
    },
    genres {
      name
    }
  }
}
```

#### Mutation

```
mutation {
  addBook(input: {
    title:"The Silmarillion",
    authorId:1,
    genreIds: [1, 2]
  }) {
    id
  }
}
```
