package com.lusa.carros.utils;

import com.lusa.carros.requestspecification.CarrosRequestSpecification;
import io.restassured.specification.RequestSpecification;

public class BaseApi {

    public static CarrosRequestSpecification carrosRequestSpecification;
    public static RequestSpecification spec;
    public static RequestSpecification specActuator;

    public void configBaseApi(){
        carrosRequestSpecification = new CarrosRequestSpecification();
        spec = carrosRequestSpecification.getRequestSpecification();
        specActuator = carrosRequestSpecification.getRequestSpecificationActuator();
    }

}
