import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetApiCards {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }

    @Test
    public void checkUserName() {
        // отправляет запрос и сохраняет ответ в переменную response, экзмепляр класса Response
        Response response = given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MjAzOThkYzgyMGZmYzAwM2QxM2M0NjciLCJpYXQiOjE2NDk3NDM1MTMsImV4cCI6MTY1MDM0ODMxM30.9v1ZD7zP_v1wTY_w6qY1gJQfKMuwfaOo_Lwl6onKMKI").get("/api/users/me");
        // проверяет, что в теле ответа ключу name соответствует нужное имя пользователя
        response.then().assertThat().body("data.name", equalTo("Аристарх Сократович"));
        // выводит тело ответа на экран
        System.out.println(response.body().asString());
    }

}
