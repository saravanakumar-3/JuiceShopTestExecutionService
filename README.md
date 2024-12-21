# JuiceShopTestExecutionService

**Automation framework for testing Juice-Shop application**

### Built With:

- Spring Boot
- Selenium
- Cucumber

### Prerequisites:
- Java 17
- Maven

### How to Run:
**Below are the command with different options:**
- To just run - "mvn clean test"
- mvn clean test -"Ddataproviderthreadcount=2" -"Dautomation.browser=firefox"
    - dataproviderthreadcount will set the number of thread when running parallel
      - By default scenarios will run in sequence
    - automation.browser can be used to change the browser and all configurations can be changes like this