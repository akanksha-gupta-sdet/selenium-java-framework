# Selenium Java Automation Framework

A robust, enterprise-grade test automation framework built with Selenium 4 and Java, designed for scalable end-to-end testing of web applications and REST APIs.

## 🎯 Key Features

- **Page Object Model (POM)** - Maintainable and scalable test structure
- **Parallel Test Execution** - Efficient test runs across multiple threads
- **ThreadLocal WebDriver** - Thread-safe browser instance management
- **Retry Mechanism** - Automatic retry logic for flaky tests
- **Comprehensive Reporting** - Extent Reports with screenshots and logs
- **REST API Testing** - Rest Assured integration with JSON Schema Validation
- **Data-Driven Testing** - Excel-based test data management with Apache POI
- **Logging & Monitoring** - Log4j2 for detailed test execution logs
- **CI/CD Ready** - GitHub Actions integration for continuous testing

## 🛠 Tech Stack

| Component | Technology | Version |
|-----------|-----------|---------|
| **Language** | Java | 17 |
| **UI Automation** | Selenium WebDriver | 4.33.0 |
| **API Testing** | Rest Assured | 5.5.1 |
| **Test Framework** | TestNG | 7.11.0 |
| **Reporting** | Extent Reports | 5.1.2 |
| **Data Management** | Apache POI | 5.4.1 |
| **Build Tool** | Maven | 3.9+ |
| **Logging** | Log4j2 | 2.24.3 |
| **Browser Management** | WebDriverManager | 6.1.0 |
| **Assertions** | Hamcrest | 3.0 |

## 📁 Project Structure

```
selenium-java-framework/
├── src/
│   ├── main/java/com/akanksha/automation/
│   │   ├── api/                    # REST API client wrappers
│   │   ├── config/                 # Configuration management
│   │   ├── constants/              # Test constants and enums
│   │   ├── factory/                # DriverFactory & Object creation
│   │   ├── pages/                  # Page Object Models
│   │   ├── pojo/                   # Data classes for API testing
│   │   └── utils/                  # Utility classes & helpers
│   │
│   └── test/java/
│       ├── api/                    # API test cases
│       ├── base/                   # BaseTest & BaseApiTest classes
│       ├── dataproviders/          # TestNG data providers
│       ├── listeners/              # Custom test listeners
│       ├── reporting/              # Reporting utilities
│       ├── retry/                  # Retry logic implementation
│       └── tests/                  # UI test cases
│
├── src/test/resources/
│   ├── config.properties           # Environment configuration
│   ├── log4j2.xml                  # Logging configuration
│   ├── testdata/
│   │   └── LoginData.xlsx          # Excel-based test data
│   └── schemas/                    # JSON schema validation files
│
├── pom.xml                         # Maven dependencies & plugins
├── testng.xml                      # Default test suite
├── api-testng.xml                  # API tests suite
├── master-testng.xml               # Complete test suite
└── README.md                       # This file
```

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.9 or higher
- Git
- A modern web browser (Chrome, Firefox, Edge, Safari)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/selenium-java-framework.git
   cd selenium-java-framework
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Configure environment settings**
   - Update `src/test/resources/config.properties` with your test environment details
   - Set browser, base URL, and other configurations as needed

## 🧪 Running Tests

### Execute All Tests
```bash
mvn clean test
```

### Execute UI Tests Only
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### Execute API Tests Only
```bash
mvn clean test -DsuiteXmlFile=api-testng.xml
```

### Execute Complete Framework
```bash
mvn clean test -DsuiteXmlFile=master-testng.xml
```

### Parallel Execution
Tests are configured to run in parallel by default. Adjust thread count in TestNG XML files:
```xml
<suite parallel="methods" thread-count="4">
```

## 📊 Test Reports

After test execution, view reports at:
- **Extent Report**: `test-output/ExtentReport.html`
- **TestNG Report**: `target/surefire-reports/index.html`
- **Screenshots**: `screenshots/` directory (on test failures)
- **Logs**: `logs/automation.log`

## 🏗 Framework Architecture

### Page Object Model (POM)
All page elements and interactions are encapsulated in page classes:
```java
public class LoginPage {
    // Page elements and methods
}
```

### BaseTest Class
Provides common setup/teardown functionality for UI tests:
```java
@BeforeMethod
public void setup() { /* Initialize WebDriver */ }

@AfterMethod
public void tearDown() { /* Close WebDriver */ }
```

### BaseApiTest Class
Dedicated base class for REST API testing with Rest Assured.

### ThreadLocal WebDriver Management
Ensures thread-safe WebDriver instances for parallel execution:
```java
DriverFactory.setDriver(webDriver);
WebDriver driver = DriverFactory.getDriver();
```

### Data-Driven Testing
Test data managed through:
- Excel files (Apache POI)
- TestNG Data Providers
- Property files

## 🔄 CI/CD Integration

The framework is ready for GitHub Actions CI/CD pipeline:
- Automated test runs on push/pull requests
- Parallel test execution in cloud environments
- Automated report generation and distribution

## 📝 Configuration

Update `src/test/resources/config.properties`:
```properties
browser=chrome
url=https://your-application-url.com
timeout=10
headless=false
```

## 📚 Key Classes & Components

| Class | Purpose |
|-------|---------|
| `DriverFactory` | Creates and manages WebDriver instances |
| `ConfigReader` | Reads configuration from properties files |
| `BaseTest` | Base class for UI test scenarios |
| `BaseApiTest` | Base class for API test scenarios |
| `ExtentLogger` | Handles reporting and logging |
| `RetryAnalyzer` | Implements retry logic for failed tests |
| `TestListener` | Listens to test events for reporting |

## ✨ Best Practices Implemented

- ✅ Single Responsibility Principle - Each class has one purpose
- ✅ DRY (Don't Repeat Yourself) - Reusable utilities and base classes
- ✅ Wait Strategies - Explicit waits instead of hard waits
- ✅ Exception Handling - Comprehensive error handling and logging
- ✅ Configuration Management - Externalized configuration
- ✅ Logging - Detailed logs for debugging
- ✅ Reporting - Rich visual reports with screenshots

## 🐛 Troubleshooting

### WebDriver Issues
- Ensure WebDriverManager dependency is included (auto-downloads drivers)
- Check browser version compatibility

### Parallel Execution Issues
- Verify ThreadLocal WebDriver implementation
- Check for shared state between tests

### Report Generation Issues
- Ensure `test-output/` directory has write permissions
- Check Extent Reports configuration


---

**Last Updated**: July 2026  
**Framework Version**: 1.0-SNAPSHOT  
**Java Version**: 17
