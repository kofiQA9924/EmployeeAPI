package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testApi{
    @Test
    public void testRest(){
        RestAssured.baseURI="https://reqres.in/api/users/2";
        RequestSpecification httpRequest=RestAssured.given();
        Response response=httpRequest.request(Method.GET);
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is "+responseBody);
        int statusCode=response.getStatusCode();
        System.out.println("Status Code is "+statusCode);
        Assert.assertEquals(statusCode,200);
        Assert.assertTrue(true);
    }
}