Feature: Amazon Test without login
  Scenario: Verify Amazon home page title
    Given Amazon home page is launched
    Then Verify page title contains Amazon

  Scenario: Search for a product
    Given Amazon home page is launched
    When Search for product "Laptop"
    Then Verify search results are displayed

  Scenario: Apply category filter
    Given Amazon home page is launched
    When Search for product "Mobile Phones"
    And Apply brand filter "Samsung"
    Then Verify search results are displayed

  Scenario: Open product details page
    Given Amazon home page is launched
    When Search for product "Headphones"
    And Open first product from results
    Then Verify product title and price are displayed

  Scenario: Add product to cart without login
    Given Amazon home page is launched
    When Search for product "USB Cable"
    And Open first product from results
    And Add product to cart
    Then Verify product added to cart