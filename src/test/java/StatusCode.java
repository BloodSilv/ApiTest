import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StatusCode {

    // аннотация Before показывает, что метод будет выполняться перед каждым тестовым методом
    @Before
    public void setUp() {
        // повторяющуюся для разных ручек часть URL лучше записать в переменную в методе Before
        // если в классе будет несколько тестов, указывать её придётся только один раз
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }

    // создаём метод автотеста
    @Test
    public void getMyInfoStatusCode() {
        // отправляет запрос и сохраняет ответ в переменную response, экзмепляр класса Response
        Response response = given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MjAzOThkYzgyMGZmYzAwM2QxM2M0NjciLCJpYXQiOjE2NDk3NDM1MTMsImV4cCI6MTY1MDM0ODMxM30.9v1ZD7zP_v1wTY_w6qY1gJQfKMuwfaOo_Lwl6onKMKI").get("/api/cards");
        // проверяем статус-код ответа на запрос «Получение всех карточек»
        response.then().statusCode(200);
        // вывод на экран
        System.out.println(response.body().asString());
    }
}
