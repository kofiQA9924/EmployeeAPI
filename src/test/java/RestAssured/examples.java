package RestAssured;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.PreemptiveAuthSpec;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by RUTHERFORD on 2/13/2021.
 */
public class examples {
    @Test
    public void GETrequest(){
        RestAssured.baseURI="https://api.thecatapi.com/v1/images/search?limit=5&page=10&order=Desc?api_key=fc55ce53-ee2d-465f-b645-ea71e0140747";
        /*PreemptiveBasicAuthScheme preemptiveBasicAuthScheme=new PreemptiveBasicAuthScheme();
        preemptiveBasicAuthScheme.setPassword("kking");
        preemptiveBasicAuthScheme.setUserName("bbcd");            // For setting usernmame and password
        RestAssured.authentication=preemptiveBasicAuthScheme;

      */RequestSpecification httpRequest=RestAssured.given();
        Response response=httpRequest.request(Method.GET);
        String responseb=response.getBody().asString();
        System.out.println(responseb);
        Headers headers=response.headers();
        for(Header header:headers){
            System.out.println("header is"+header);
        }

    }
}