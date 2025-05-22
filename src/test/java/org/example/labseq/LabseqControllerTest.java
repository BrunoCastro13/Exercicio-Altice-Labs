package org.example.labseq;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class LabseqControllerTest {

    @Test
    public void testLabseqBaseCase0() {
        given()
                .when().get("/labseq/0")
                .then()
                .statusCode(200)
                .body(is("{\"result\": 0}"));
    }

    @Test
    public void testLabseqBaseCase1() {
        given()
                .when().get("/labseq/1")
                .then()
                .statusCode(200)
                .body(is("{\"result\": 1}"));
    }

    @Test
    public void testLabseqBaseCase2() {
        given()
                .when().get("/labseq/2")
                .then()
                .statusCode(200)
                .body(is("{\"result\": 0}"));
    }

    @Test
    public void testLabseqBaseCase3() {
        given()
                .when().get("/labseq/3")
                .then()
                .statusCode(200)
                .body(is("{\"result\": 1}"));
    }

    @Test
    public void testLabseqSequenceValue4() {
        given()
                .when().get("/labseq/4")
                .then()
                .statusCode(200)
                .body(is("{\"result\": 1}"));
    }

    @Test
    public void testLabseqSequenceValue10() {
        given()
                .when().get("/labseq/10")
                .then()
                .statusCode(200)
                .body(is("{\"result\": 3}"));
    }

    @Test
    public void testLabseqNegativeNumber() {
        given()
                .when().get("/labseq/-1")
                .then()
                .statusCode(400);
    }
}