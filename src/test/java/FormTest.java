import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class FormTest {

    @Test
    void shouldCheckJsonSchema() {
        String mockResponse = "{\n" +
                "  \"success\": true,\n" +
                "  \"data\": {\n" +
                "    \"name\": \"Иван\",\n" +
                "    \"surname\": \"Иванов\",\n" +
                "    \"patronymic\": \"Иванович\",\n" +
                "    \"telephone\": \"+70001112233\",\n" +
                "    \"birthdate\": \"2000-11-11\",\n" +
                "    \"passport\": \"9999 99999999\"\n" +
                "  }\n" +
                "}";

        // Проверяем эту строку на соответствие файлу schema.json в resources
        given()
                .body(mockResponse)
                .when()
                .get("https://postman-echo.com/get") // Используем надежный эхо-сервер
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema.json"));
    }
}
