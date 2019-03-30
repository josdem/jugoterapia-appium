@RegressionTest
Feature: Jugoterapia run a easter egg feature
  Scenario: As a user I should be able to click five times in Jugoterapia header
    When I click on Jugoterapia header "5" times
    Then I validate I can see hello world message
