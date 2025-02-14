package com.example;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class InvestorResourceTest {

    @Test
    public void testGetAllInvestors() {
        given()
          .when().get("/investors")
          .then()
             .statusCode(200);
    }

    @Test
    public void testCreateInvestor() {
        given()
          .header("Content-Type", "application/json")
          .body("{\"name\":\"New Investor\",\"email\":\"new.investor@example.com\"}")
          .when().post("/investors")
          .then()
             .statusCode(201);
    }
}