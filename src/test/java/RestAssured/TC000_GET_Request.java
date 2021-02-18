package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC000_GET_Request {
    @Test
    public void GETemployees(){
        RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employees";
        RequestSpecification httpRequest=RestAssured.given();
        Response response=httpRequest.request(Method.GET);
        String responeBody=response.getBody().toString();
        System.out.println("The response Body is "+responeBody);

        String contentEncoding=response.header("Content-Encoding");
        Assert.assertEquals(contentEncoding,"gzip");
        Assert.assertTrue(true);

        Headers allheaders=response.headers();
        for (Header header:allheaders){
            System.out.println(header.getName()+""+header.getValue());
        }

        String cacheControl=response.header("Cache-Control");
        Assert.assertEquals(cacheControl,"no-cache, private, max-age=31536000");
        Assert.assertTrue(true);
    }
}
