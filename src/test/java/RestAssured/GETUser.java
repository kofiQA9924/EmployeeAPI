package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GETUser{
    @Test
    public void GETRestTest(){
        RestAssured.baseURI="https://reqres.in/api/users/2";
        RequestSpecification httpRequest=RestAssured.given();
        Response response=httpRequest.request(Method.GET,"first_name");
        String responseBody=response.getBody().asString();
        System.out.println("The response Body is"+responseBody);
    }
}