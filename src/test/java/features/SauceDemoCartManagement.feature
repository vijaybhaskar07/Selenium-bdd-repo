Feature: Product Selection and Cart Management
    This feature file contains tests related to saucedemo product selection and cart management
    Pages Involved: LoginPage, HomePage, InventoryPage, ProductPage, CartPage
    1. Adding product to cart using Inventory page
    2. Adding product to cart using Product page
    3. Removing product from cart


	        @SauceDemoCartManagement @Inventory
        Scenario: 01. Adding product to cart using Inventory page
            Given the user is on SauceDemo application
             Then the user navigated to the InventoryPage
             When the user clicks on Add to Cart button
              And the user navigates to cart page
             Then the product "Sauce Labs Backpack" should be displayed in the cart


        @SauceDemoCartManagement
        Scenario: 02. Adding product to cart using Product page
            Given the user is on SauceDemo application
             Then the user navigated to the InventoryPage
             When the user selects a product "Sauce Labs Fleece Jacket"
              And the user clicks on Add to Cart button
              And the user navigates to cart page
             Then the product "Sauce Labs Fleece Jacket" should be displayed in the cart


        @SauceDemoCartManagementTest
        Scenario: 03. Removing product from cart
            Given the user is on SauceDemo application
             Then the user navigated to the InventoryPage
             When the user selects a product "Sauce Labs Onesie"
              And the user clicks on Add to Cart button
              And the user navigates to cart page
             Then the product "Sauce Labs Onesie" should be displayed in the cart
             When the user clicks on Remove button
             Then the product "Sauce Labs Onesie" should not be displayed in the cart
             
             @Logout
             Scenario: 04 SauceDemo logout functionality
              Given the user is on Saucedemo application
               Then the user clicks on logout button
                When the user navigates to swaglabs page
                
            @ValidLogin
            Scenario: 05 Successful login with valid credentials
      				Given User is on the Login Page
      				 When User enters Credentials:
       				  | Username | Password |
        			 | standard_user | secret_sauce |  
      					Then User should see the swaglabs page
               
             
             Scenario: 06. Add Multiple items to the cart
             Given the user is on SauceDemo application
             Then the user navigated to the InventoryPage
             When the user adds the following items to the cart:
    					| Item Name  | Quantity |
    					| Sauce Labs Bike Light     |  1        |
    					| Sauce Labs Backpack | 1        |
  					Then the items should be displayed in the cart
             
             
