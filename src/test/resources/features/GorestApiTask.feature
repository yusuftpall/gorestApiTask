@GorestAPI
Feature: Gorest API Tests


  Scenario: User validates from the returned query response
    Given User gets query of all users and validates
    And   User verify the if the total record is 20
    And   User verify the if the name of id = 5318 is equal to "Bhanumati Mehrotra"
    And   User checks name "Kama Adiga" in list
    And   User checks names "Kama Adiga" and "Bhanumati Mehrotra" in list
    And   User, user ID = 3154 verify email is same as "mehrotra_bhanumati@purdy.io"
    And   user, verify that the status of the record with id = 3154 is 'active'.
    And   User verifies that username "Bhanumati Mehrotra" is "male"