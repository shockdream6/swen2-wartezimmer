package swen.orm;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

/**
 * Simple Resource (REST) Test
 * 
 */
@QuarkusTest
public class PatientResourceTest {

    @Test
    public void testIndexHtml() {
        given()
          .when().get("/") // using the get-Method of http
          .then()
             .statusCode(200);        
    }
    
    @Test
    public void testListAllHtml() {
        given()
          .when().get("html/patient/list/all") // using the get-Method of http
          .then()
             .statusCode(200);       
    }
    
    @Test
    public void testListActiveHtml() {
        given()
          .when().get("html/patient/list/active") // using the get-Method of http
          .then()
             .statusCode(200);       
    }
    
    @Test
    public void testDeletePAtientHtml() {
        given()
          .when().get("html/patient/del") // using the get-Method of http
          .then()
             .statusCode(200);       
    }
    
    @Test
    public void testAddPatientHtml() {
        given()
          .when().get("html/patient/add") // using the get-Method of http
          .then()
             .statusCode(200);       
    }

}