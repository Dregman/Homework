package com.example.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.JSONObject;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequestTest {

    @Test
    public void testGetRequest() {

        Response response = given()
                .header("User-Agent", "PostmanRuntime/7.42.0")
                .when()
                .get("https://postman-echo.com/get")
                .then()
                .assertThat()
                .statusCode(200)  // Проверяем код ответа
                .extract()
                .response();


        String expectedUrl = "https://postman-echo.com/get";
        String expectedHost = "postman-echo.com";
        String expectedUserAgent = "PostmanRuntime/7.42.0";

        String actualUrl = response.jsonPath().getString("url");
        String actualHost = response.jsonPath().getString("headers.host");
        String actualUserAgent = response.jsonPath().getString("headers.user-agent");


        Assert.assertEquals(actualUrl, expectedUrl, "URL should match");
        Assert.assertEquals(actualHost, expectedHost, "Host should match");
        Assert.assertEquals(actualUserAgent, expectedUserAgent, "User-Agent should match");

        Assert.assertNotNull(response.jsonPath().get("headers.connection"), "Connection header should not be null");
        Assert.assertNotNull(response.jsonPath().get("headers.x-forwarded-proto"), "X-Forwarded-Proto header should not be null");
        Assert.assertNotNull(response.jsonPath().get("headers.x-forwarded-port"), "X-Forwarded-Port header should not be null");
        Assert.assertNotNull(response.jsonPath().get("headers.x-amzn-trace-id"), "X-Amzn-Trace-Id header should not be null");
        Assert.assertNotNull(response.jsonPath().get("headers.accept"), "Accept header should not be null");

        String postmanToken = response.jsonPath().getString("headers.postman-token");
        if (postmanToken != null) {
            Assert.assertNotNull(postmanToken, "Postman-Token header should not be null");
        } else {
            System.out.println("Postman-Token header is not present in the response.");
        }
    }


    @Test
    public void testPostRequest() {

        String requestBody = "{\"test\": \"value\"}";
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("User-Agent", "PostmanRuntime/7.42.0")
                .body(requestBody)
                .post("https://postman-echo.com/post");


        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");


        String actualData = response.jsonPath().getString("data");
        Assert.assertTrue(actualData.contains("test:value"), "Response data should contain key-value pair 'test:value'");

        String actualHost = response.jsonPath().getString("headers.host");
        Assert.assertEquals(actualHost, "postman-echo.com", "Host should match");


        Assert.assertNotNull(response.jsonPath().get("headers.connection"), "Connection header should not be null");
        Assert.assertNotNull(response.jsonPath().get("headers.x-forwarded-proto"), "X-Forwarded-Proto header should not be null");
        Assert.assertNotNull(response.jsonPath().get("headers.x-forwarded-port"), "X-Forwarded-Port header should not be null");
        Assert.assertNotNull(response.jsonPath().get("headers.x-amzn-trace-id"), "X-Amzn-Trace-Id header should not be null");
        Assert.assertNotNull(response.jsonPath().get("headers.accept"), "Accept header should not be null");


        String postmanToken = response.jsonPath().getString("headers.postman-token");
        if (postmanToken != null) {
            Assert.assertNotNull(postmanToken, "Postman-Token header should not be null");
        } else {
            System.out.println("Postman-Token header is not present in the response.");
        }
    }

    @Test
    public void testPostRequest1() {

        String requestBody = "foo1=bar1&foo2=bar2"; // Правильный формат


        Response response = RestAssured.given()
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8") // Указываем заголовок с кодировкой
                .body(requestBody) // Передаем тело запроса
                .post("https://postman-echo.com/post"); // URL для запроса


        System.out.println("Response Status: " + response.getStatusCode());
        System.out.println("Response Body: " + response.asString());


        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");


        String data = response.jsonPath().getString("data");
        Assert.assertEquals(data, "", "Response data should be empty");


        Map<String, String> form = response.jsonPath().getMap("form");
        Assert.assertEquals(form.get("foo1"), "bar1", "foo1 should be 'bar1'");
        Assert.assertEquals(form.get("foo2"), "bar2", "foo2 should be 'bar2'");


        String actualHost = response.jsonPath().getString("headers.host");
        Assert.assertEquals(actualHost, "postman-echo.com", "Host should match");

        Assert.assertNotNull(response.jsonPath().get("headers.connection"), "Connection header should not be null");
        Assert.assertNotNull(response.jsonPath().get("headers.x-forwarded-proto"), "X-Forwarded-Proto header should not be null");
        Assert.assertNotNull(response.jsonPath().get("headers.x-forwarded-port"), "X-Forwarded-Port header should not be null");
        Assert.assertNotNull(response.jsonPath().get("headers.x-amzn-trace-id"), "X-Amzn-Trace-Id header should not be null");
        Assert.assertNotNull(response.jsonPath().get("headers.accept"), "Accept header should not be null");


        String postmanToken = response.jsonPath().getString("headers.postman-token");
        if (postmanToken != null) {
            Assert.assertEquals(postmanToken, "e568961c-7123-4cd7-910f-e8a47bf49e2a", "Postman-Token should match the expected value");
        } else {
            System.out.println("Postman-Token header is missing in the response.");
        }
    }

    @Test
    public void testPutRequest() {

        RestAssured.baseURI = "https://postman-echo.com";


        Response response = RestAssured.given()
                .contentType("application/x-www-form-urlencoded") // Указываем тип содержимого
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .put("/put");


        Assert.assertEquals(response.getStatusCode(), 200, "Response status code should be 200");


        String expectedBody = "{\"args\":{},\"data\":\"\",\"files\":{},\"form\":{\"foo1\":\"bar1\",\"foo2\":\"bar2\"},\"headers\":{\"host\":\"postman-echo.com\",\"x-request-start\":\"t=1727180396.607\",\"connection\":\"close\",\"content-length\":\"19\",\"x-forwarded-proto\":\"https\",\"x-forwarded-port\":\"443\",\"x-amzn-trace-id\":\"Root=1-66f2ae6c-1e9a274263a0e983636997a2\",\"accept\":\"*/*\",\"content-type\":\"application/x-www-form-urlencoded; charset=UTF-8\",\"user-agent\":\"Apache-HttpClient/4.5.13 (Java/11.0.23)\",\"accept-encoding\":\"gzip,deflate\"},\"json\":{\"foo1\":\"bar1\",\"foo2\":\"bar2\"},\"url\":\"https://postman-echo.com/put\"}";
        Assert.assertEquals(response.getBody().asString(), expectedBody, "Response body does not match the expected value.");


        String postmanToken = response.getHeader("Postman-Token");
        Assert.assertNotNull(postmanToken, "Postman-Token header should not be null");



    }


    @Test
    public void testPatchRequest() {

        RestAssured.baseURI = "https://postman-echo.com";


        Response response = RestAssured.given()
                .contentType("application/json") // Указываем тип содержимого
                .body("{\"foo1\":\"bar1\",\"foo2\":\"bar2\"}") // Тело запроса
                .when()
                .patch("/patch");


        Assert.assertEquals(response.getStatusCode(), 200, "Response status code should be 200");


        String actualBody = response.getBody().asString();
        System.out.println("Actual Response Body: " + actualBody);

        //ожидаемое тело ответа
        String expectedBody = "{\n" +
                "    \"args\": {},\n" +
                "    \"data\": {\n" +
                "        \"foo1\": \"bar1\",\n" +
                "        \"foo2\": \"bar2\"\n" +
                "    },\n" +
                "    \"files\": {},\n" +
                "    \"form\": {},\n" +
                "    \"headers\": {\n" +
                "        \"host\": \"postman-echo.com\",\n" +
                "        \"connection\": \"close\",\n" +
                "        \"content-length\": \"58\",\n" +
                "        \"x-forwarded-proto\": \"https\",\n" +
                "        \"x-forwarded-port\": \"443\",\n" +
                "        \"content-type\": \"application/json\",\n" +
                "        \"user-agent\": \"PostmanRuntime/7.42.0\",\n" +
                "        \"accept\": \"*/*\",\n" +
                "        \"accept-encoding\": \"gzip, deflate, br\"\n" +
                "    },\n" +
                "    \"json\": {\n" +
                "        \"foo1\": \"bar1\",\n" +
                "        \"foo2\": \"bar2\"\n" +
                "    },\n" +
                "    \"url\": \"https://postman-echo.com/patch\"\n" +
                "}";


        JSONObject actualJson = new JSONObject(actualBody);
        JSONObject expectedJson = new JSONObject(expectedBody);


        Assert.assertEquals(actualJson.getJSONObject("args").toString(), expectedJson.getJSONObject("args").toString(), "Args should match");
        Assert.assertEquals(actualJson.getJSONObject("data").toString(), expectedJson.getJSONObject("data").toString(), "Data should match");
        Assert.assertEquals(actualJson.getJSONObject("files").toString(), expectedJson.getJSONObject("files").toString(), "Files should match");
        Assert.assertEquals(actualJson.getJSONObject("form").toString(), expectedJson.getJSONObject("form").toString(), "Form should match");
        Assert.assertEquals(actualJson.getJSONObject("headers").getString("host"), expectedJson.getJSONObject("headers").getString("host"), "Host should match");
        Assert.assertEquals(actualJson.getJSONObject("headers").getString("content-type"), expectedJson.getJSONObject("headers").getString("content-type"), "Content-Type should match");


        String postmanToken = response.getHeader("Postman-Token");
        if (postmanToken != null) {
            System.out.println("Postman-Token: " + postmanToken);
        } else {
            System.out.println("Postman-Token header is not present.");
        }

    }

    @Test
    public void testDeleteRequest() {

        RestAssured.baseURI = "https://postman-echo.com";


        Response response = RestAssured.given()
                .contentType("application/json") // Указываем тип содержимого
                .when()
                .delete("/delete");


        Assert.assertEquals(response.getStatusCode(), 200, "Response status code should be 200");


        String actualBody = response.getBody().asString();
        System.out.println("Actual Response Body: " + actualBody);

        //ожидаемое тело ответа
        String expectedBody = "{\n" +
                "    \"args\": {},\n" +
                "    \"data\": {},\n" + // Обновлено с {} вместо строки
                "    \"files\": {},\n" +
                "    \"form\": {},\n" +
                "    \"headers\": {\n" +
                "        \"host\": \"postman-echo.com\",\n" +
                "        \"connection\": \"close\",\n" +
                "        \"content-length\": \"58\",\n" +
                "        \"x-forwarded-proto\": \"https\",\n" +
                "        \"x-forwarded-port\": \"443\",\n" +
                "        \"content-type\": \"application/json\",\n" +
                "        \"accept\": \"*/*\",\n" +
                "        \"user-agent\": \"Apache-HttpClient/4.5.13 (Java/11.0.23)\",\n" +
                "        \"accept-encoding\": \"gzip,deflate\"\n" +
                "    },\n" +
                "    \"json\": null,\n" +
                "    \"url\": \"https://postman-echo.com/delete\"\n" +
                "}";


        JSONObject actualJson = new JSONObject(actualBody);
        JSONObject expectedJson = new JSONObject(expectedBody);


        Assert.assertEquals(actualJson.getJSONObject("args").toString(), expectedJson.getJSONObject("args").toString(), "Args should match");


        String actualData = actualJson.optString("data", null);
        Assert.assertTrue(actualJson.has("data"), "Response should have 'data' field");

        Assert.assertEquals(actualJson.getJSONObject("files").toString(), expectedJson.getJSONObject("files").toString(), "Files should match");
        Assert.assertEquals(actualJson.getJSONObject("form").toString(), expectedJson.getJSONObject("form").toString(), "Form should match");
        Assert.assertEquals(actualJson.getJSONObject("headers").getString("host"), expectedJson.getJSONObject("headers").getString("host"), "Host should match");
        Assert.assertEquals(actualJson.getJSONObject("headers").getString("content-type"), expectedJson.getJSONObject("headers").getString("content-type"), "Content-Type should match");


        String postmanToken = response.getHeader("Postman-Token");
        if (postmanToken != null) {
            System.out.println("Postman-Token: " + postmanToken);
        } else {
            System.out.println("Postman-Token header is not present.");
        }

    }
}