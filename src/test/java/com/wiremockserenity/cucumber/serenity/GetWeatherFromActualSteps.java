package com.wiremockserenity.cucumber.serenity;

import com.wiremockserenity.utils.TestUtils;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.collection.IsMapContaining.hasKey;

public class GetWeatherFromActualSteps {

    public void validateResponseOfZipCode(String zipCode){
        SerenityRest.rest()
                .given()
                .when()
                .get("/weather?zip=" + zipCode + TestUtils.getAPIKey())
                .then()
                .assertThat()
                .body("$", hasKey("weather"));

    }

    public void validateResponseOfCityName(String cityName){
         SerenityRest.rest()
                .given()
                .when()
                .get("/weather?q=" + cityName + TestUtils.getAPIKey())
                .then()
                 .assertThat()
                .body("$", hasKey("weather"));

    }

    public void validateResponseOfCityID(String cityID){
        SerenityRest.rest()
                .given()
                .when()
                .get("/weather?id=" + cityID + TestUtils.getAPIKey())
                .then()
                .assertThat()
                .body("$", hasKey("weather"));

    }

    public void validateStatusCode(int statusCode) {
        SerenityRest.rest()
                .then()
                .statusCode(200)
                .log()
                .all();
    }
}
