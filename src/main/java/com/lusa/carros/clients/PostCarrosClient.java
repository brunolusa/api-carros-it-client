package com.lusa.carros.clients;

import com.lusa.carros.model.Carro;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import static com.lusa.carros.requestspecification.CarrosRequestSpecification.getRequestSpecification;
import static com.lusa.carros.utils.StaticValues.CARROS;
import static io.restassured.RestAssured.given;

public class PostCarrosClient  {

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
}
