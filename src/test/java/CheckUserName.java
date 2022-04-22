import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;

public class CheckUserName {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }

    @Test
    public void checkUserName() {
        Response response = given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MjAzOThkYzgyMGZmYzAwM2QxM2M0NjciLCJpYXQiOjE2NDk3NDM1MTMsImV4cCI6MTY1MDM0ODMxM30.9v1ZD7zP_v1wTY_w6qY1gJQfKMuwfaOo_Lwl6onKMKI").get("/api/users/me");
        response.then().assertThat().body("data.name", equalTo("Автор автотестов"));
        System.out.println(response.asString());
    }
}
