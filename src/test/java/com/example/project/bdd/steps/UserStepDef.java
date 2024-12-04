package com.example.project.bdd.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.example.project.ProjectApplication;
import com.example.project.service.UserService;
import com.example.project.vo.UserVO;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@SpringBootTest(classes=ProjectApplication.class)
@ContextConfiguration(classes= {com.example.project.ProjectApplication.class})
public class UserStepDef {
	
	@Autowired
    private UserService userService;
    
	private int responseStatus;
    private String responseMessage;
    private UserVO createdUserDetails;
   // private UserVO createdUser;
    private UserVO retrievedUser;
    private boolean healthCheckResult;

   

    // Scenario: Create user details
    @When("I call POST endpoint {string} with valid user details")
    public void i_call_post_endpoint_with_valid_user_details(String endpoint) {
      
        UserVO userVO = new UserVO();
        userVO.setName("Rizwana");
        userVO.setAge(24);

        try {
            UserVO createdUser = userService.createUser(userVO);
            responseStatus = 200; 
            responseMessage = "User created successfully";
            createdUserDetails = createdUser; 
        } catch (Exception ex) {
            responseStatus = 400; 
            responseMessage = ex.getMessage();
        }
    }

    @Then("the response status should be {int}")
    public void the_response_status_should_be(Integer expectedStatus) {
        assertEquals(expectedStatus, responseStatus, "Response status mismatch!");
    }


    @Then("the response should confirm user creation")
    public void the_response_should_confirm_user_creation() {
        assertEquals("User created successfully", responseMessage, "Response message mismatch!");
        assertNotNull(createdUserDetails, "Created user details are null!");
        assertEquals("Rizwana", createdUserDetails.getName(), "User name mismatch!");
        assertEquals(24, createdUserDetails.getAge(), "User age mismatch!");
  
    }

    // Scenario: Retrieve user details by ID
    @Given("the App1 is running")
    public void the_app1_is_running() {
    	
    }
  
    @When("I call GET endpoint {string}")
    public void i_call_get_endpoint(String endpoint) {
        try {
            UserVO user = userService.getUser(1L); 
            if (user != null) {
                responseStatus = 200; 
                responseMessage = "Backend call successful"; 
                retrievedUser = user; 
            }
        } catch (Exception ex) {
            responseStatus = 404; 
            responseMessage = ex.getMessage(); 
        }
    }


    @Then("the response body should contain the user details")
    public void the_response_body_should_contain_the_user_details() {
        assertNotNull(retrievedUser, "User retrieval failed!");
        assertEquals("Rizwana", retrievedUser.getName(), "User name mismatch!");
    }

    // Scenario: Perform health check
    @When("I call GET endpoint \"/app1/api/users/health\"")
    public void i_call_get_endpoint_health_check() {
        healthCheckResult = userService.HealthCheck();

        if (healthCheckResult) {
            responseStatus = 200;
            responseMessage = "Backend call successful";
        }
    } 

    @Then("the response should confirm the health status {string}")
    public void the_response_should_confirm_the_health_status(String expectedMessage) {
        assertEquals(expectedMessage, responseMessage, "Health check message mismatch!");
    }
}