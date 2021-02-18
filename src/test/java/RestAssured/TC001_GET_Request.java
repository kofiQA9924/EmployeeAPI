package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_GET_Request {
    @Test
    public void GETemployee(){
        RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employee/";
        RequestSpecification httpRequest=RestAssured.given();
        Response response=httpRequest.request(Method.GET,"1");

        String responseBody=response.getBody().asString();
        System.out.println("Response Body"+responseBody);

        Assert.assertEquals(responseBody.contains("1"),true);
    }
}
