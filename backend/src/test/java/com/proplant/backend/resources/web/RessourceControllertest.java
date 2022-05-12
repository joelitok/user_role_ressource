package com.proplant.backend.resources.web;

import com.proplant.backend.BackendApplication;
import com.proplant.backend.domaines.account.service.AccountService;
import com.proplant.backend.domaines.ressource.mappers.RessourceMapper;
import com.proplant.backend.domaines.ressource.repository.dao.RessourceRepository;
import com.proplant.backend.domaines.ressource.repository.entity.Ressource;
import com.proplant.backend.domaines.ressource.service.RessourceService;
import com.proplant.backend.utils.LoadDataDB;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
/*
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.equalTo; */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = BackendApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

@SpringBootTest(
  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
  properties = {
  "spring.security.user.name=admin",
  "spring.security.user.password=1234",
  "spring.security.user.roles=ADMIN"
})
public class RessourceControllertest {
 
    @LocalServerPort
    private Integer port;
  
    @Test
    void shouldReturnSuccessfullyWhengetaddRessource() {
  
      ExtractableResponse<Response> response = RestAssured
        .given()
          //.filter(new RequestLoggingFilter())
          //.auth().preemptive().basic("admin", "1234")
          .contentType("application/json")
          .body("{\"name\": \"programme Java\"}")
        .when()
          .post("http://localhost:2022/ressource/new")
        .then()
          .statusCode(200)
          .extract();
  
      /*RestAssured
        .when()
         .get(response.header("Location"))
        .then()
          .statusCode(200)
          .body("id", Matchers.notNullValue())
          .body("name", Matchers.equalTo("programme Java"));*/
    }
 
 
    @Test
    public void shouldReturnSuccessfullyWhengetallRessource(){
        RestAssured.baseURI="http://localhost:2022";
        RestAssured.given().get("ressource/all").then().statusCode(200);
        
    }
 
 
 
 
 /*import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@WebMvcTest(BookController.class)
class BookControllerTest {

  @MockBean
  private BookService bookService;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    RestAssuredMockMvc.mockMvc(mockMvc);
  }

  @Test
  void shouldAllowBookRetrievalWithoutAuthentication() {

    Mockito.when(bookService.getAllBooks(42)).thenReturn(
      List.of(new Book(42L, "42", "REST Assured With Spring Boot", "Duke")));

    RestAssuredMockMvc
      .given()
        .auth().none()
        .param("amount", 42)
      .when()
        .get("/api/books")
      .then()
        .statusCode(200)
        .body("$.size()", Matchers.equalTo(1))
        .body("[0].id", Matchers.equalTo(42))
        .body("[0].isbn", Matchers.equalTo("42"))
        .body("[0].author", Matchers.equalTo("Duke"))
        .body("[0].title", Matchers.equalTo("REST Assured With Spring Boot"));
  }

  @Test
  void shouldAllowBookRetrievalWithoutAuthenticationShort() {

    Mockito.when(bookService.getAllBooks(anyInt())).thenReturn(
      List.of(new Book(42L, "42", "REST Assured With Spring Boot", "Duke")));

    RestAssuredMockMvc
      .when()
        .get("/api/books")
      .then()
        .statusCode(200)
        .body("$.size()", Matchers.equalTo(1))
        .body("[0].id", Matchers.equalTo(42))
        .body("[0].isbn", Matchers.equalTo("42"))
        .body("[0].author", Matchers.equalTo("Duke"))
        .body("[0].title", Matchers.equalTo("REST Assured With Spring Boot"));
  }

  @Test
  void shouldAllowBookCreationForAuthenticatedAdminUsers() {

    Mockito.when(bookService.createNewBook(any(BookRequest.class))).thenReturn(42L);

    RestAssuredMockMvc
      .given()
        .auth().with(SecurityMockMvcRequestPostProcessors.user("duke").roles("ADMIN"))
        .contentType("application/json")
        .body("{\"title\": \"Effective Java\", \"isbn\":\"978-0-13-468599-1 \", \"author\":\"Joshua Bloch\"}")
      .when()
        .post("/api/books")
      .then()
        .statusCode(201)
        .header("Location", Matchers.containsString("/api/books/42"));
  }

  @Test
  @WithMockUser(username = "duke", roles = {"USER", "EDITOR"})
  void shouldBlockBookCreationForNonAdminUsers() {

    RestAssuredMockMvc
      .given()
        .contentType("application/json")
        .body("{\"title\": \"Effective Java\", \"isbn\":\"978-0-13-468599-1 \", \"author\":\"Joshua Bloch\"}")
      .when()
        .post("/api/books")
      .then()
        .statusCode(403);
  }
}*/
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
    /*
    @LocalServerPort
    private int port; 

    private String ENDPOINT_REGISTER = "/users/register";
    private final String RESSOURCE_1 = "Ressource1";
   
    @Autowired
    public  RessourceService ressourceService;
    @Autowired
    public  AccountService accountService;
    @Autowired
    public  RessourceMapper ressourceMapper;
    @Autowired    
    public  RessourceRepository ressourceRepository;

    private LoadDataDB loadDataDB;

    @Before
    public void setPort() {
        RestAssured.port = port;
        loadDataDB = new LoadDataDB(ressourceService, accountService, ressourceMapper, ressourceRepository);
    }

    @Test
    public void shouldReturnSuccessfullyWhenAddNewRessource() {

        Ressource ressource = new Ressource();
        ressource.setName(RESSOURCE_1);
        RestAssured.
                given().
                header("Content-Type", "application/json").
                body(ressource).
                when().
                post(ENDPOINT_REGISTER).
                then().
                statusCode(403);
               // .and().
               // body("Name", equalTo(RESSOURCE_1));
    }

    @Test
    public void shouldReturnSuccessfullyWhenDeleteRessource(){
        String ressourceID = "2";//loadDataDB.loadCoursesDB(MARKETING_COURSE).getId().toString();
        RestAssured.
                given().
                header("Content-Type", "application/json").
                when().
                delete("/ressource/".concat(ressourceID)).
                then().
                statusCode(200);
       // assertFalse(ressourceService.listRessources().iterator().hasNext());
        
    }

    @Test
    public void shouldReturnSuccessfullyWhengetallRessource(){
        RestAssured.baseURI="http://localhost:2022";
        RestAssured.given().get("ressource/all").then().statusCode(200);
        
    }



    @Test
    public void authenticationUserTest(){
        RestAssured.baseURI="http://localhost:"+port;
        RequestSpecification request =RestAssured.given();
        String credentials = "admin:1234";
        byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());
        String encodedCredentialsAsString = new String(encodedCredentials);
        request.header("Authorization", "Basic "+encodedCredentialsAsString);
        String payload ="{\r\n"+"Name\":\"Ressource 1\"\r\n}";
        request.header("Content-type","application/json");
        Response response =request.body(payload).post("/ressource/new");
        System.out.println("Response status code is "+response.getStatusCode());
        response.prettyPrint();


    }


    @Test
	public void bearerTokenAuthenticationTest() {
		RestAssured.baseURI = "http://localhost:"+port;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		Response responseFromGenerateToken = request.body(login()).post("/login");
		responseFromGenerateToken.prettyPrint();	
		String jsonString = responseFromGenerateToken.getBody().asString();
		String tokenGenerated = JsonPath.from(jsonString).get("token");
		request.header("Authorization","Bearer "+tokenGenerated)
			   .header("Content-Type","application/json");
		String addRessource = "{\r\n"+"\"Name\":\"ressource4\"\r\n}";
		Response addRessourceResponse = request.body(addRessource).post("/ressource/new");
		
		//Assertions.assertEquals(201, addRessourceResponse.getStatusCode());
		addRessourceResponse.prettyPrint();
		
				
	}


    public String login(){
           String payload = "{\r\n" + "  \"username\": \"admin\",\r\n" + "  \"password\": \"1234\"\r\n" + "}";
           return payload; 
    }
 */   






}
