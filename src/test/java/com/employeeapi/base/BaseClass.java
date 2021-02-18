package com.employeeapi.base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;

import java.util.logging.Logger;

/**
 * Created by RUTHERFORD on 2/15/2021.
 */
public class BaseClass {
    public static RequestSpecification httpRequest;
    public static Response response;
    public static Logger logger;
    public static JSONObject jsonObject;

    public void initialization(){
        PropertyConfigurator.configure("Log4j.properties");
        logger=Logger.getLogger("EmployeeApi's");
    }
}
