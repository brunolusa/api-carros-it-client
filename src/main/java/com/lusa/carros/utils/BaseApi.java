package com.lusa.carros.utils;

import io.restassured.specification.RequestSpecification;
import static com.lusa.carros.requestspecification.CarrosRequestSpecification.*;

public class BaseApi {

    public static RequestSpecification spec;
    public static RequestSpecification specActuator;

    public static void configBaseApi(){
        spec = getRequestSpecification();
        specActuator = getRequestSpecificationActuator();
    }

}
