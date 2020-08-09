package com.lusa.carros.clients;

import com.lusa.carros.model.Carro;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import static com.lusa.carros.requestspecification.CarrosRequestSpecification.getRequestSpecification;
import static com.lusa.carros.utils.StaticValues.*;
import static io.restassured.RestAssured.given;

public class PutCarrosClient  {

    public ValidatableResponse alterarCarros(Carro c, Long id){
        return
            given().
                spec(getRequestSpecification()).
                pathParam(PARAM_PATH_ID, id).
                body(c).
            when().
                put(CARROS_WITH_ID).
            then().
                statusCode(HttpStatus.SC_ACCEPTED).
                contentType(ContentType.JSON);
    }
}
