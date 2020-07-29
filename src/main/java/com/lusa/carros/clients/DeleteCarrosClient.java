package com.lusa.carros.clients;

import com.lusa.carros.utils.BaseApi;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import static com.lusa.carros.utils.StaticValues.CARROS_WITH_ID;
import static com.lusa.carros.utils.StaticValues.PARAM_PATH_ID;
import static io.restassured.RestAssured.given;

public class DeleteCarrosClient extends BaseApi {

    public DeleteCarrosClient() {
        configBaseApi();
    }

    public ValidatableResponse deleteCarros(Long id) {
        return
            given().
                spec(spec).
                pathParam(PARAM_PATH_ID, id).
            when().
                delete(CARROS_WITH_ID).
            then().
                statusCode(HttpStatus.SC_NO_CONTENT);
    }

    public ValidatableResponse deleteCarroNotFound(Long id) {
        return
            given().
                spec(spec).
                pathParam(PARAM_PATH_ID, id).
            when().
                delete(CARROS_WITH_ID).
            then().
                statusCode(HttpStatus.SC_NOT_FOUND);
    }

}
