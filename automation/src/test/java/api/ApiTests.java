package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTests {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    public void testGetUserDetails() {
        given()
            .when()
            .get("/users/2")
            .then()
            .statusCode(200)
            .body("data.id", equalTo(2))
            .body("data.email", notNullValue());
    }

    @Test
    public void testCreateUser() {
        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";

        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
            .when()
            .post("/users")
            .then()
            .statusCode(201)
            .body("name", equalTo("morpheus"))
            .body("id", notNullValue());
    }

    @Test
    public void testUpdateUser() {
        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";

        given()
            .contentType(ContentType.JSON)
            .body(requestBody)
            .when()
            .put("/users/2")
            .then()
            .statusCode(200)
            .body("job", equalTo("zion resident"));
    }

    @Test
    public void testDeleteUser() {
        given()
            .when()
            .delete("/users/2")
            .then()
            .statusCode(204);
    }

    @Test
    public void testNegativeUserNotFound() {
        given()
            .when()
            .get("/users/23")
            .then()
            .statusCode(404);
    }
}
