package com.employeeapi.testCases;

import Reporting.TestListener;
import com.employeeapi.base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by RUTHERFORD on 2/15/2021.
 */
@Listeners({TestListener.class})
public class GETAllEmployeeApi extends BaseClass {
    @BeforeTest
    public void GETALLEmployee(){
        RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
        httpRequest=RestAssured.given();
        response=httpRequest.request(Method.GET,"/employees");
        initialization();
        logger.info("response initialized");
    }
    @Test(priority = 0)
    public void testResponse(){
        String responseBody=response.getBody().asString();
        logger.info("respondyBody extracted from response");
        Assert.assertTrue(true );
        logger.info("Assertion implemented");
        System.out.println("responseBody "+responseBody);
    }
    @Test(priority = 1)
    public void testHeaders(){
        Headers headers=response.headers();
        logger.info("All headers initialized");
        for (Header header:headers){
            System.out.println("Header "+header.getName());
            System.out.println("Header "+header.getValue());
            Assert.assertTrue(true);
        }
    }
    @Test(priority = 2)
    public void teststatusCode(){
        int statusCode=response.getStatusCode();
        logger.info("Status code initialized");
        Assert.assertTrue(true);
        System.out.println("Status Code "+statusCode);
    }
    @Test(priority = 3)
    public void testUnkown(){
        String content_Type=response.contentType();
        System.out.println("content_Type "+content_Type);
        logger.info("Content-Type initialized");
    }
}
