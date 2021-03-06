import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test01_GET {
	
	@Test
	void test_01() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.asString());
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getContentType());
		System.out.println(response.getTime());
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		
	}
	
	@Test
	void test_02() {
		RestAssured.given().
			get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200);
			
	}
}
