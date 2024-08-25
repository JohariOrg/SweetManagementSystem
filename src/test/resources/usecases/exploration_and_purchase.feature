Feature: Exploration and Purchase of dessert recipes for beneficiaries

  Scenario: User browses available dessert recipes
    Given the user is on the recipe browsing page
    When the user views all available recipes
    Then the user should see a list of recipes

  Scenario: User filters recipes based on dietary needs
    Given the user has dietary preferences
    When the user filters for gluten-free and vegan recipes
    Then the user should see a list of filtered recipes

  Scenario: User purchases a dessert
    Given the user has selected a recipe
    When the user completes the purchase
    Then the recipe should be purchased successfully
