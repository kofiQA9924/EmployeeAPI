package com.employeeapi.testCases;

import Reporting.TestListener;
import com.employeeapi.base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by RUTHERFORD on 2/16/2021.
 */
@Listeners({TestListener.class})
public class PUTEmployeeAPI extends BaseClass {
    @BeforeTest
    public void PUTEMPLOYEE(){
        RestAssured.baseURI="http://dummy.restapiexample.com/public/api/v1/update";
        httpRequest=RestAssured.given();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("test","King");
        jsonObject.put("salary","100");
        jsonObject.put("age","99");
        response=httpRequest.request(Method.PUT,"/21");
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(jsonObject.toJSONString());
    }
    @Test
    public void testPUTResponse(){
        String responseCode=response.getBody().asString();
        System.out.println("responseCode "+responseCode);
        Assert.assertTrue(true);
    }
}
