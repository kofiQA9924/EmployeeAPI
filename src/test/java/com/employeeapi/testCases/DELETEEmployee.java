package com.employeeapi.testCases;

import Reporting.TestListener;
import com.employeeapi.base.BaseClass;
import com.google.common.base.Verify;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by RUTHERFORD on 2/16/2021.
 */
@Listeners({TestListener.class})
public class DELETEEmployee extends BaseClass {
    @BeforeTest
    public void setUpDelete(){
        RestAssured.baseURI="http://dummy.restapiexample.com/public/api/v1/delete";
        httpRequest=RestAssured.given();
        response=httpRequest.request(Method.DELETE,"/2");
    }
    @Test
    public void testResponse(){
        String responseBody=response.getBody().asString();
        System.out.println("responseBody "+responseBody);
        Verify.verify(true);
    }
}
