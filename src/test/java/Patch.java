import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class Patch {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }

    @Test
    public void createNewPlaceAndCheckResponse(){
        File json = new File("src/test/resources/newCard.json");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MjAzOThkYzgyMGZmYzAwM2QxM2M0NjciLCJpYXQiOjE2NDk3NDM1MTMsImV4cCI6MTY1MDM0ODMxM30.9v1ZD7zP_v1wTY_w6qY1gJQfKMuwfaOo_Lwl6onKMKI")
                        .and()
                        .body(json)
                        .when()
                        .patch("/api/cards");
        response.then().assertThat().body("data._id", notNullValue())
                .and()
                .statusCode(201);
    }
}
