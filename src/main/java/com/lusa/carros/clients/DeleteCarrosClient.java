package com.lusa.carros.clients;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import static com.lusa.carros.requestspecification.CarrosRequestSpecification.getRequestSpecification;
import static com.lusa.carros.utils.StaticValues.CARROS_WITH_ID;
import static com.lusa.carros.utils.StaticValues.PARAM_PATH_ID;
import static io.restassured.RestAssured.given;

public class DeleteCarrosClient  {

    public ValidatableResponse deleteCarros(Long id) {
        return
            given().
                spec(getRequestSpecification()).
                pathParam(PARAM_PATH_ID, id).
            when().
                delete(CARROS_WITH_ID).
            then().
                statusCode(HttpStatus.SC_NO_CONTENT);
    }

    public ValidatableResponse deleteCarroNotFound(Long id) {
        return
            given().
                spec(getRequestSpecification()).
                pathParam(PARAM_PATH_ID, id).
            when().
                delete(CARROS_WITH_ID).
            then().
                statusCode(HttpStatus.SC_NOT_FOUND);
    }

}
