package com.lusa.carros.clients;

import com.lusa.carros.model.Carro;
import com.lusa.carros.utils.Env;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static com.lusa.carros.requestspecification.CarrosRequestSpecification.*;
import static com.lusa.carros.utils.StaticValues.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class CarrosClient {

    public CarrosClient(String env){
        Env.setEnv(env);
    }

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

    public ValidatableResponse getAllCarros(String accessToken){
        return
            given().
                header("Authorization", "Bearer " + accessToken).
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

    public ValidatableResponse criaNovoCarro(Carro carro){
        return
            given().
                spec(getRequestSpecification()).
                body(carro).
            when().
                post(CARROS).
            then().
                statusCode(HttpStatus.SC_CREATED).
                contentType(ContentType.JSON);
    }

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

    public String getTokenAuthentication(String user, String pass, String clientUser, String clientPass){
        return
            given().
                spec(getRequestSpecificationOauthToken()).
                auth().
                    preemptive().
                        basic(clientUser,clientPass).
                contentType("application/x-www-form-urlencoded").
                formParam("grant_type", "password").
                formParam("username", user).
                formParam("password", pass).
            when().
                post().
            then().
                statusCode(HttpStatus.SC_OK).
                extract().
                    body().
                        path("access_token");
    }
}
