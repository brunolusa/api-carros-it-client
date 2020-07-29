package com.lusa.carros.requestspecification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static com.lusa.carros.utils.PropertyLoader.retornarValorArquivoConfiguracao;
import static com.lusa.carros.utils.StaticValues.ACTUATOR;

public class CarrosRequestSpecification {

    private static final String BASEURI = retornarValorArquivoConfiguracao("baseUri");
    private static final String PORT = retornarValorArquivoConfiguracao("port");
    private static final String BASEPATH = retornarValorArquivoConfiguracao("basePath");

    public static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setConfig(
                        new RestAssuredConfig()
                                .sslConfig(
                                        new SSLConfig().relaxedHTTPSValidation()
                                )
                )
                .setContentType(ContentType.JSON)
                .setBaseUri(BASEURI)
                .setPort(Integer.parseInt(PORT))
                .setBasePath(BASEPATH)
                .log(LogDetail.ALL)
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public static RequestSpecification getRequestSpecificationActuator() {
        return new RequestSpecBuilder()
                .setConfig(
                        new RestAssuredConfig()
                                .sslConfig(
                                        new SSLConfig().relaxedHTTPSValidation()
                                )
                )
                .setContentType(ContentType.JSON)
                .setBaseUri(BASEURI)
                .setPort(Integer.parseInt(PORT))
                .setBasePath(ACTUATOR)
                .log(LogDetail.ALL)
                .addFilter(new ResponseLoggingFilter())
                .build();
    }
}
