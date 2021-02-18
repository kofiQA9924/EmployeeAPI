package com.employeeapi.testCases;

import Reporting.TestListener;
import com.employeeapi.base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by RUTHERFORD on 2/15/2021.
 */
@Listeners({TestListener.class})
public class GETEmployeeID extends BaseClass{
    @BeforeTest
    public void testGETID(){
        RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employee";
        httpRequest=RestAssured.given();
        response=httpRequest.request(Method.GET,"/1");
        initialization();
    }
    @Test(priority = 0)
    public void testGETresponse(){
        String responseBody=response.getBody().asString();
        Assert.assertTrue(true);
        logger.info("Response Assertion implemented");
        System.out.println("responseBody "+responseBody);
    }
    @Test(priority = 1)
    public void testGETstatus(){
        int statusCode=response.getStatusCode();
        logger.info("Status code Assertion implemented");
        System.out.println("statusCode "+statusCode);
    }
}
