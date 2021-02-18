package com.employeeapi.testCases;

import Reporting.TestListener;
import com.employeeapi.base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class POSTEmployeeAPI extends BaseClass{
    @BeforeTest
    public void POSTEmployee(){
        RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
        httpRequest=RestAssured.given();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","test");
        jsonObject.put("salary","123");
        jsonObject.put("age","23");
        response=httpRequest.request(Method.POST,"/create");
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(jsonObject.toJSONString());
    }
    @Test(priority = 0)
    public void testResponse(){
        String responseBody=response.getBody().asString();
        System.out.println("responseBody "+responseBody);
    }
    @Test(priority = 1)
    public void testHeader(){
        Headers headers=response.headers();
        for (Header header:headers){
            System.out.println("header "+header.getName());
            System.out.println("header "+header.getValue());
        }
    }
}