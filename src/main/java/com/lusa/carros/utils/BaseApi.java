package com.lusa.carros.utils;

import com.lusa.carros.requestspecification.CarrosRequestSpecification;
import io.restassured.specification.RequestSpecification;

public class BaseApi {

    public static RequestSpecification spec;

    public static void configBaseApi(){
        spec = CarrosRequestSpecification.getRequestSpecification();
    }

}
