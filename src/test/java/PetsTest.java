import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.http.ContentType;
import org.example.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Alexandra")
@DisplayName("Тесты с питомцами")
@Tag("pets")
public class PetsTest {
    public final static String url = "https://petstore.swagger.io/";

    @DisplayName("Добавление питомца в мазазин")
    @Description("Инициалтзация питомца, отправка запроса на сервер, получение ответа и его проверка на соответствие по json схеме и по коду ответа - 200")
    @Tag("put")
    @Test
    public void putPet(){
        Specifications.installSpec(Specifications.requestSpec(url),Specifications.responseSpec(200));

        PetsAdd pets = PetsAdd.Add(123,"Volodymyr","url11");

        SuccessAddPet successAddPet = given()
                .body(pets)
                .when()
                .put("v2/pet")
                .then().log().all()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(Pets.setSchema("petSchema.json")))
                .extract().as(SuccessAddPet.class);
    }
    @DisplayName("Обновление имени питомца по id")
    @Description("Инициалтзация обновленных данных питомца, отправка запроса на сервер, получение ответа и его проверка на соответствие по json схеме и по коду ответа - 200")
    @Tag("post")
    @Test
    public void postName(){
        Specifications.installSpec(Specifications.requestSpec(url),Specifications.responseSpec(200));

        SuccessUpdatePet updatePet = given()
                .contentType(ContentType.URLENC)
                .formParam("name", Pets.setName("Valera"))
                .when()
                .log().all()
                .post(String.format("v2/pet/%d",Pets.setId(15)))
                .then().log().all()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(Pets.setSchema("petResponseSchema.json")))
                .extract().as(SuccessUpdatePet.class);
    }
    @DisplayName("Возврат питомцев с статусом pending")
    @Description("Отправка запроса на сервер, получение ответа и его проверка на соответствие по json схеме и по коду ответа - 200")
    @Tag("get")
    @Test
    public void getStatus(){
        Specifications.installSpec(Specifications.requestSpec(url),Specifications.responseSpec(200));

        List<Pets> petsStatus = given()
                .when()
                .get("v2/pet/findByStatus?status=" + Pets.setStatus("pending"))
                .then().log().all()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(Pets.setSchema("statusPetSchema.json")))
                .extract().jsonPath().getList("$.body",Pets.class);
    }
    @DisplayName("Удаление питомца из мазазина")
    @Description("Отправка запроса на сервер с id питомца, получение ответа и его проверка на соответствие по json схеме и по коду ответа -200")
    @Tag("delete")
    @Test
    public void deletePet(){
        Specifications.installSpec(Specifications.requestSpec(url),Specifications.responseSpec(200));
        given()
                .when()
                .delete(String.format("v2/pet/%d",Pets.setId(123)))
                .then().log().all()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(Pets.setSchema("petResponseSchema.json")));


    }
}
