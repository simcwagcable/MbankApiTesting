import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class MbankTest {

    @Test
    void shouldGetAccountsData() {
        given()
                .baseUri("http://localhost:9999/api/v1") // Адрес запущенного JAR
                .when()
                .get("/demo/accounts") // Путь из задания
                .then()
                .statusCode(200) // Проверяем, что сервер работает
                .contentType("application/json") // Проверяем тип данных
                // Сверяем данные первого счета
                .body("[0].id", equalTo(1))
                .body("[0].name", equalTo("Текущий счёт"))
                .body("[0].currency", equalTo("RUB"))
                .body("[0].balance", greaterThan(0));
    }
}