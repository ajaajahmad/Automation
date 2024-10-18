# Java Selenium WebDriver Automation Project

## Overview

This project is an automation testing framework built using Java and Selenium WebDriver. It follows a hybrid framework approach, combining both data-driven and keyword-driven testing methodologies to ensure robust and scalable test automation for web applications.

## Features

- **Hybrid Framework**: Combines data-driven and keyword-driven testing for flexibility.
- **Selenium WebDriver**: Uses Selenium WebDriver for browser automation.
- **JUnit/TestNG**: Supports test case execution with JUnit or TestNG for better management and reporting.
- **Data Management**: Utilizes Excel/CSV files for data-driven testing.
- **Reporting**: Generates comprehensive reports using Extent Reports or Allure.
- **Page Object Model (POM)**: Implements the Page Object Model design pattern for better code organization and maintainability.
- **Cross-Browser Testing**: Supports execution on multiple browsers (Chrome, Firefox, etc.).
- **Logging**: Integrated logging using Log4j2 for better debugging and traceability.

## Prerequisites

- **Java JDK 21 or higher**: Ensure that Java is installed and the environment variable is set.
- **Maven**: Ensure Maven is installed for dependency management.
- **IDE**: Use an IDE like IntelliJ IDEA or Eclipse for development.

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/ajaajahmad/automation.git
cd automation
```

### Setup the Project

1. **Open the project in your IDE**: Use IntelliJ IDEA or Eclipse.
2. **Resolve dependencies**: Run the following command to ensure all dependencies are resolved:

    ```bash
    mvn clean install
    ```

### Configuration

1. **WebDriver Configuration**: Update the WebDriver path in the `config.properties` file located in the `src/test/resources` directory.
2. **Test Data**: Add your test data in the `data` folder (Excel/CSV files) as per the test cases.

### Running Tests

To run the tests, execute the following command:

```bash
mvn test
```

You can also run specific tests or test suites by specifying them in the Maven command.

### Viewing Reports

After executing the tests, you can find the reports in the `target/reports` directory. Open the `index.html` file in a web browser to view the test results.

### Contributing

1. **Fork the repository**.
2. **Create a new branch**:

    ```bash
    git checkout -b feature/your-feature-name
    ```

3. **Make your changes and commit them**:

    ```bash
    git commit -m 'Add some feature'
    ```

4. **Push to the branch**:

    ```bash
    git push origin feature/your-feature-name
    ```

5. **Open a pull request**.

### License

This project is licensed under the MIT License - see the `LICENSE` file for details.

### Acknowledgments

- **Selenium** - For web automation.
- **JUnit / TestNG** - For testing framework.
- **Log4j2** - For logging.

Feel free to make any further modifications to fit your project's needs!
