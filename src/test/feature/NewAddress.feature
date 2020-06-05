Feature: Making new address
  Scenario Outline: Guest create new address
    Given User logging
    When User going to page add new address
    And Guest added <alias>, <address>, <city>, <postCode>, <country>, <phone> on address page
    Then Guest checking address correctnes

    Examples:
      | alias | address   | city       | postCode | country        | phone      |
      | address| Gorka 10  | Gdansk     | 80-888   | United Kingdom | 555555555  |


