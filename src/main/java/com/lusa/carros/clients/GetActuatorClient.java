package com.lusa.carros.clients;

import com.lusa.carros.utils.BaseApi;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import static org.hamcrest.CoreMatchers.*;
import static io.restassured.RestAssured.given;

public class GetActuatorClient extends BaseApi{

    public GetActuatorClient() { configBaseApi(); }

    public ValidatableResponse getHealthCheck(){
        return
            given().
                spec(specActuator).
            when().
                get().
            then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON).
                body("status",is("UP"));
    }
}
