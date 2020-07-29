package com.lusa.carros.clients;

import com.lusa.carros.utils.BaseApi;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import static com.lusa.carros.utils.StaticValues.*;
import static io.restassured.RestAssured.given;

public class GetCarrosClient extends BaseApi {

    public GetCarrosClient() { configBaseApi(); }

    public ValidatableResponse getAllCarros(){
       return
           given().
               spec(spec).
           when().
               get(CARROS).
           then().
               statusCode(HttpStatus.SC_OK).
               contentType(ContentType.JSON);
    }

    public ValidatableResponse getCarroById(Long id){
        return
            given().
                spec(spec).
                pathParam(PARAM_PATH_ID, id).
            when().
                get(CARROS_WITH_ID).
            then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }
}
