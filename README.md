```markdown
# 🧪 Cucumber Test Automation Framework

A scalable and robust **Cucumber + Selenium + TestNG** framework built with Maven for cross-browser test automation of web applications. Designed using industry best practices including the **Page Object Model**, **Factory Design Pattern**, and **Dependency Injection**, the framework supports data-driven testing, parallel execution, reporting, CI/CD integration, and failure diagnostics.

---

## 🚀 Features

- ✅ Maven-based Test Automation Project
- ✅ TestNG Runner for parallel test execution
- ✅ Cucumber BDD with feature files and step definitions
- ✅ Reusable Selenium utilities
- ✅ Cucumber Hooks to capture screenshots on test failure
- ✅ Cucumber Tags to run selected scenarios
- ✅ Data-driven test execution using JSON/Excel
- ✅ HTML and ExtentReports with embedded screenshots
- ✅ Execute tests via Maven CLI
- ✅ Jenkins CI/CD integration for scheduled and on-demand test runs
- ✅ Parameterized Jenkins jobs with runtime environment config
- ✅ Implements Page Object Model (POM)
- ✅ Factory Pattern for centralized object management
- ✅ Dependency Injection to share WebDriver across step classes

---

## 🧪 Test Execution

### 👉 Run all tests via Maven:
```bash
mvn test
```

### 👉 Run tests by tag:
Modify the tag in your `@CucumberOptions(tags = "...")` inside `TestNGTestRunner.java`.

### 👉 Parallel execution:
Handled via `@DataProvider(parallel = true)` using TestNG.

---

## 📊 Reports

- ✅ ExtentReports auto-generated in `/test-output/ExtentReport-*`
- ✅ Screenshots for failed steps attached to the report
- ✅ Reports accessible via `Spark.html` after execution

---

## 🧱 Technologies Used

| Tool / Library     | Description                          |
|--------------------|--------------------------------------|
| Java (JDK 8+)      | Programming language                 |
| Maven              | Build & dependency management       |
| Selenium WebDriver | UI automation                       |
| Cucumber           | BDD framework                       |
| TestNG             | Test runner & parallel execution    |
| ExtentReports      | Rich HTML reporting                 |
| Jenkins            | CI/CD automation                    |

---

## 🤖 CI/CD Integration

- Integrated with **Jenkins** for regular and on-demand executions
- Parameterized Jenkins jobs for passing environment-specific configs (`Global.properties`)
- Compatible with GitHub Actions, GitLab CI, and CircleCI

---

## 👨‍💻 Author

**Vikram Singh Gurjar**  
*Test Automation Architect | Selenium | Cucumber | TestNG | Jenkins | CI/CD*

---

## 📜 License

This project is licensed under the [MIT License](LICENSE)

---

## ⭐ Contributions & Feedback

Pull requests are welcome. Feel free to fork the repo and raise issues for enhancements or bugs.

**If you like this framework, don’t forget to ⭐ star the repository!**

---
