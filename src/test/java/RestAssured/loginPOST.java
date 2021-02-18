package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginPOST{
    @Test
    public void testPOST(){
        RestAssured.baseURI="https://reqres.in/api/login";
        RequestSpecification httpRequest=RestAssured.given();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("email","peter@klaven");
        jsonObject.put("password","cityslicka");

        httpRequest.header("Content-Type","application/json");
        httpRequest.body(jsonObject.toJSONString());

        Response response=httpRequest.request(Method.POST);
        String responseBody=response.getBody().asString();
        Assert.assertEquals(responseBody,"{\"error\":\"user not found\"}");
        Assert.assertTrue(true);
        System.out.println("Response Body is "+responseBody);

        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200);
        Assert.assertTrue(true);
        System.out.println("Status Code is "+statusCode);
    }
}