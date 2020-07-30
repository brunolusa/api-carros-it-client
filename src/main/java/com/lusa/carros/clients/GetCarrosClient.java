package com.lusa.carros.clients;

import com.lusa.carros.requestspecification.CarrosRequestSpecification;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static com.lusa.carros.requestspecification.CarrosRequestSpecification.getRequestSpecification;
import static com.lusa.carros.utils.StaticValues.*;
import static io.restassured.RestAssured.given;

public class GetCarrosClient  {

    public ValidatableResponse getAllCarros(){
       return
           given().
               spec(getRequestSpecification()).
           when().
               get(CARROS).
           then().
               statusCode(HttpStatus.SC_OK).
               contentType(ContentType.JSON);
    }

    public ValidatableResponse getCarroById(Long id){
        return
            given().
                spec(getRequestSpecification()).
                pathParam(PARAM_PATH_ID, id).
            when().
                get(CARROS_WITH_ID).
            then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }
    public ValidatableResponse getCarrosNotFound(Long id){
        return
            given().
                spec(getRequestSpecification()).
                pathParam(PARAM_PATH_ID, id).
            when().
                get(CARROS_WITH_ID).
            then().
                statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
