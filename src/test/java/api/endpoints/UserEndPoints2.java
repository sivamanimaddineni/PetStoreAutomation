package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//UserEndPoints.java
// Created for perform Create, Read, Update, Delete requests t the user API.

public class UserEndPoints2 {
	
	// method created for getting URL's from properties file.
   static ResourceBundle getURL()
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes");  //Load properties file
		return routes;
	}
	
	
   public static Response createUser(User payload)
	{
	   
	  String post_url = getURL().getString("post_url");
	   
	   
	Response response = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		
		.when()
		   .post(Routes.post_url);
	
	return response;
	}

   public static Response readUser(String username)
	{
	   
	   String get_url = getURL().getString("get_url");
	   
	Response response = given()
		   .contentType(ContentType.JSON)
		   .pathParam("username", username)
		
		.when()
		   .get(Routes.get_url);
	
	return response;
	}
   
   public static Response updateUser(String username, User payload)
	{
	   
	   String update_url = getURL().getString("update_url");
	   
	Response response = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .pathParam("username", username)
		   .body(payload)
		
		.when()
		   .put(Routes.update_url);
	
	return response;
	}
   
   public static Response deleteUser(String username)
	{
	   
	   String delete_url = getURL().getString("delete_url");
	   
	Response response = given()
		   .pathParam("username", username)
		
		.when()
		   .delete(Routes.delete_url);
	
	return response;
	}
   
   
   
   
   
   
   
   
   
}
