package com.lusa.carros.clients;

import com.lusa.carros.model.Carro;
import com.lusa.carros.utils.BaseApi;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static com.lusa.carros.utils.StaticValues.*;
import static io.restassured.RestAssured.given;

public class PutCarrosClient extends BaseApi {

    public PutCarrosClient() { configBaseApi(); }

    public ValidatableResponse alterarCarros(Carro c, Long id){
        return
            given().
                spec(spec).
                pathParam(PARAM_PATH_ID, id).
                body(c).
            when().
                put(CARROS_WITH_ID).
            then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }
}
