Feature: App1 users management  
  
  Scenario: Create user details
           When I call POST endpoint "/app1/api/users/create" with valid user details
           Then the response status should be 200
           And the response should confirm user creation

  Scenario: Retrieve user details by ID
            Given the App1 is running
            When I call GET endpoint "/app1/api/users/retrieve/1"
            Then the response status should be 200
            And the response body should contain the user details
            
  Scenario: Perform health check
            Given the App1 is running
            When I call GET endpoint "/app1/api/users/health"
            Then the response status should be 200
            And the response should confirm the health status "Backend call successful"