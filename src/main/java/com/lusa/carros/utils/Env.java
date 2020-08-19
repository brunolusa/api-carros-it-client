package com.lusa.carros.utils;

public class Env {

    public Env() {
    }

    public static String environment;

    public static String getEnv() {
        return ((environment != null ) ? environment : EnvironmentInterface.HOM);
    }

    public static void setEnv(String environment) {
        Env.environment = environment;
    }

    public interface EnvironmentInterface {

        String HOM = "hom";
        String TST = "tst";

    }

}