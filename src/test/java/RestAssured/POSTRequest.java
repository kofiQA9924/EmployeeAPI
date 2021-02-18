package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POSTRequest{
    @Test
    public void POSTtest(){
        RestAssured.baseURI="https://reqres.in/api/users";
        RequestSpecification httpRequest=RestAssured.given();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","morpheus");
        jsonObject.put("job","leader");
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(jsonObject.toJSONString());

        Response response=httpRequest.request(Method.POST);
        String responseBody=response.getBody().asString();
        Assert.assertTrue(true);
        System.out.println("The response Body is"+responseBody);
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,201);
        Assert.assertTrue(true);
    }
}