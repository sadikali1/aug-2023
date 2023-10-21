package com.api;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.io.File;

public class PetsAPI {
	
	long id;
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://petstore.swagger.io/";
	}
	
	@Test(priority = 1)
	public void testAddPet() {
		String jsonBoddy = "{"
				+ "  \"id\": 0,"
				+ "  \"category\": {"
				+ "    \"id\": 0,"
				+ "    \"name\": \"Cat\""
				+ "  },"
				+ "  \"name\": \"doggie\","
				+ "  \"photoUrls\": ["
				+ "    \"string\""
				+ "  ],"
				+ "  \"tags\": ["
				+ "    {"
				+ "      \"id\": 0,"
				+ "      \"name\": \"Tag1\""
				+ "    },"
				+ "    {"
				+ "      \"id\": 0,"
				+ "      \"name\": \"Tag2\""
				+ "    }"
				+ "  ],"
				+ "  \"status\": \"available\""
				+ "}";
		Response response = given().header("accept", "application/json")
				.header("Content-Type", "application/json").body(jsonBoddy).when().post("v2/pet");
		//Assert.assertEquals(resposne.getStatusCode(), 200);
		response.then().statusCode(200).contentType("application/json");
		
		id = response.path("id");
		System.out.println(id);
		System.out.println(response.asString());
	
		response.then().body("status",  Matchers.equalTo("available"))
						.body("category.name",  Matchers.equalTo("Cat"))
				.and().body("tags[0].name",  Matchers.equalTo("Tag1"))
				.and().body("tags[1].name",  Matchers.equalTo("Tag2"));
	}
	
	@Test(priority = 2)
	public void testUpdatePet() {
		String jsonBoddy = "{"
				+ "  \"id\": "+id+","
				+ "  \"category\": {"
				+ "    \"id\": 0,"
				+ "    \"name\": \"string\""
				+ "  },"
				+ "  \"name\": \"doggie\","
				+ "  \"photoUrls\": ["
				+ "    \"string\""
				+ "  ],"
				+ "  \"tags\": ["
				+ "    {"
				+ "      \"id\": 0,"
				+ "      \"name\": \"string\""
				+ "    }"
				+ "  ],"
				+ "  \"status\": \"available\""
				+ "}";

		Response response = given().header("accept", "application/json")
				.header("Content-Type", "application/json").body(jsonBoddy).when().put("v2/pet");
		
		System.out.println(response.asString());
		response.then().statusCode(200).contentType("application/json");
	}
	
	@Test(priority = 3)
	public void testGetPetById() {
		Response response = given().header("accept", "application/json")
				.header("Content-Type", "application/json").when().get("v2/pet/"+id);
		response.then().statusCode(200).contentType("application/json");
		System.out.println(response.asString());
	}
	
	@Test(priority = 4)
	public void testDeletepet() {
		Response response = given().header("accept", "application/json")
				.header("Content-Type", "application/json").when().delete("v2/pet/"+id);
		response.then().statusCode(200).contentType("application/json");
		System.out.println(response.asString());
	}
	
	@Test(priority = 5)
	public void uploadFile() {
		File uploadFile = new File("C:\\Users\\admin\\Desktop\\MyPic.jpeg");
		Response response = given().multiPart(uploadFile).formParam("additionalMetadata", "Testing")
				.when().post("/v2/pet/"+id+"/uploadImage");
		
		System.out.println(response.asPrettyString());
	}

}
