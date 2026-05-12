import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SpoonacularTest {

    @Test
    void testSpoonacularSearch() {
        given()
                .queryParam("apiKey", "fd356c6b1c7540779db5427613146f7c") 
                .queryParam("query", "pasta")
                .queryParam("maxFat", "25")
                .when()
                .get("https://api.spoonacular.com/recipes/complexSearch")
                .then()
                .statusCode(200) // Проверяем статус
                .contentType("application/json") // Проверяем тип контента
                .body("results", notNullValue()); // Проверяем, что есть результаты
    }
}
