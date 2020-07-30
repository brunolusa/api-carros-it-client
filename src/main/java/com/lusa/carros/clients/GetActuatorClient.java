package com.lusa.carros.clients;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import static com.lusa.carros.requestspecification.CarrosRequestSpecification.getRequestSpecificationActuator;
import static org.hamcrest.CoreMatchers.*;
import static io.restassured.RestAssured.given;

public class GetActuatorClient{

    public ValidatableResponse getHealthCheck(){
        return
            given().
                spec(getRequestSpecificationActuator()).
            when().
                get().
            then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON).
                body("status",is("UP"));
    }
}
