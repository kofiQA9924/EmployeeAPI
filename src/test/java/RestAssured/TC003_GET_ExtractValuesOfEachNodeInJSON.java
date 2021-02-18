package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TC003_GET_ExtractValuesOfEachNodeInJSON {
    @Test
    public void GETEmployeeJSON(){
        RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employee/1";
        RequestSpecification httpRequest=RestAssured.given();
        Response response=httpRequest.request(Method.GET);
        JsonPath jsonPath=response.jsonPath();
        System.out.println(jsonPath.get("employee_salary"));
        System.out.println(jsonPath.get("employee_name"));
        System.out.println(jsonPath.get("employee_age"));
        System.out.println(jsonPath.get("id"));
    }
}
