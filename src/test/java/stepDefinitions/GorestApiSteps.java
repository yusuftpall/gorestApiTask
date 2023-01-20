package stepDefinitions;


import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GorestApiSteps {
    private ValidatableResponse response;
    @Given("User gets query of all users and validates")
    public void user_gets_query_of_all_users_and_validates() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        response = given()
                .when()
                .queryParam("page", "1")
                .queryParam("per_page", "20")
                .get("/users")
                .then().statusCode(200);
    }
    @Given("User verify the if the total record is {int}")
    public void user_verify_the_if_the_total_record_is(Integer totalRecord) {
        response.body("total.size", equalTo(totalRecord));
    }
    @Given("User verify the if the name of id = 5318 is equal to {string}")
    public void user_verify_the_if_the_name_of_id_is_equal_to_bhanumati_mehrotra(String name) {
        response.body("[0].name", equalTo(name));
    }
    @Given("User checks name {string} in list")
    public void user_checks_name_in_list(String name) {
        response.body("name", hasItem(name));
    }
    @Given("User checks names {string} and {string} in list")
    public void user_checks_names_and_in_list(String name1, String name2) {
        response.body("name", hasItems(name1,
                name2));
    }
    @Given("User, user ID = {int} verify email is same as {string}")
    public void user_user_id_verify_email_is_same_as(Integer id, String email) {
        response.body("find{it.id == "+ id +"}.email",equalTo(email));
    }
    @Given("user, verify that the status of the record with id = {int} is {string}.")
    public void user_verify_that_the_status_of_the_record_with_username_is(int id, String status) {
        response.body("find{it.id == "+id+"}.status",equalTo(status));
    }
    @Given("User verifies that username {string} is {string}")
    public void user_verifies_that_username_is(String name, String gender) {
        response.body("find{it.name == '"+name+"'}.gender",equalTo(gender));
    }
}
