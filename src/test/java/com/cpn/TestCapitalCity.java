package com.cpn;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Scanner;

import static io.restassured.RestAssured.*;

public class TestCapitalCity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String more = "yes";
        while (more.equalsIgnoreCase("yes")) {
            System.out.println("Please enter country name:");
            String userInputs = scanner.nextLine();
            baseURI = "https://restcountries.com";
            basePath = "/v3.1/name/";
            Response response = given().log().uri()
                    .contentType(ContentType.JSON)
                    .when()
                    .get(userInputs);
            JsonPath js = response.jsonPath();
            String jsResponse = js.getString("capital");
            System.out.println("Capital city of " + userInputs + " is: " + jsResponse);
            System.out.println("Would you like to perform another query?: yes or no");
            more = scanner.nextLine();
            if (more.equals("no")) {
                System.out.println("Thank you for using our service, Have a great day!!");
            }
        }
    }
}