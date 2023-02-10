package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHello1Endpoint() {
        given()
          .when().get("/hello/1?s=toto")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive empty"));
        given()
            .when().get("/hello/1?S=toto")
            .then()
            .statusCode(200)
            .body(is("Hello from RESTEasy Reactive toto"));
        given()
            .when().get("/hello/1?S=toto&s=bar")
            .then()
            .statusCode(200)
            .body(is("Hello from RESTEasy Reactive toto"));
    }

    @Test
    public void testHello2Endpoint() {
        given()
            .when().get("/hello/2?s=toto")
            .then()
            .statusCode(200)
            .body(is("Hello from RESTEasy Reactive toto"));
        given()
            .when().get("/hello/2?s=toto&S=bar")
            .then()
            .statusCode(200)
            .body(is("Hello from RESTEasy Reactive toto"));
        given()
            .when().get("/hello/2?S=toto")
            .then()
            .statusCode(200)
            .body(is("Hello from RESTEasy Reactive empty"));
    }

    @Test
    public void testHello3Endpoint() {
        given()
            .when().get("/hello/3?s=toto")
            .then()
            .statusCode(200)
            .body(is("Hello from RESTEasy Reactive toto emptyS"));
        given()
            .when().get("/hello/3?s=toto&S=bar")
            .then()
            .statusCode(200)
            .body(is("Hello from RESTEasy Reactive toto bar"));
        given()
            .when().get("/hello/3?S=toto")
            .then()
            .statusCode(200)
            .body(is("Hello from RESTEasy Reactive emptys toto"));
    }

}