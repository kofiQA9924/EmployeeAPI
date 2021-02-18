package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserLoginPOST {
    @Test
    public void testUserlogin(){
        RestAssured.baseURI="https://reqres.in/api/login";
        RequestSpecification httpRequest=RestAssured.given();

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("email","peter@klaven");

        Response response=httpRequest.request(Method.POST);
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(jsonObject.toJSONString()); // attach data to the request

        String responseBody=response.getBody().asString();
        Assert.assertEquals(responseBody,"Login Unsuccessful");
        System.out.println("The response Body is "+responseBody);

        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,400);
        Assert.assertTrue(true);
        System.out.println("Status Code"+statusCode);
    }
}
