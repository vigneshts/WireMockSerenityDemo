package com.wiremockserenity.testbase;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import io.restassured.RestAssured;

import java.io.IOException;

public class TestBase {
    private static Process p;
    private static ProcessBuilder pb;

    @BeforeClass
    public static void init() throws IOException {
        // Command to execute the wiremock sh file
        pb = new ProcessBuilder("src/test/resources/wiremock/wiremock.sh");
        p = pb.start();
        RestAssured.baseURI = "http://api.openweathermap.org/data/2.5";

    }

    @AfterClass
    public static void tearDown() throws IOException{
        String[] cmd = { "src/test/resources/wiremock/wiremock.sh", "-k" };
        p = Runtime.getRuntime().exec(cmd);
    }
}
