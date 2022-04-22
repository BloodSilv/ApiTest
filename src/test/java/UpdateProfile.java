import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UpdateProfile {
    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }
    @Test
    public void createNewPlaceAndCheckResponse(){
        File json = new File("src/test/resources/updateProfile.json");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MjAzOThkYzgyMGZmYzAwM2QxM2M0NjciLCJpYXQiOjE2NDk3NDM1MTMsImV4cCI6MTY1MDM0ODMxM30.9v1ZD7zP_v1wTY_w6qY1gJQfKMuwfaOo_Lwl6onKMKI")
                        .and()
                        .body(json)
                        .when()
                        .patch("/api/users/me");
        response.then().assertThat().body("data.name", equalTo("Василий Васильев"))
                .and()
                .statusCode(200);
    }
}
