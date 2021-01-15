Feature: Lets go to Frame Page
  @frame
  Scenario: User goes to Frame Page
    Given user opens "baseUrl"
    And user see "iFrame" in the title
    And user click author
    Then user should see in the "authorUrl"
    And user returns previous page
    And user switch to frame "frame1"
    And user switch to default page
