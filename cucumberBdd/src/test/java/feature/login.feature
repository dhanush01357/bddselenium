Feature: Login

Scenario Outline: Verify homepage is displayed
Given Let me login as a guest user
When user enter username as "<someusername>" and password as "<somepassword>"
And click on login button
Then user should get "<expected>" result
Examples: 
|someusername|somepassword|expected|
|Dhanush|Dhanu@!23|Failure|
|SeleniumByArun|Test143$|Success|