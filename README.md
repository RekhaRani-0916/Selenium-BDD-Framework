# 🚀 Selenium BDD Automation Framework – AutomationExercise

---

## 📌 Project Overview

This project is a robust end-to-end test automation framework built using **Selenium WebDriver with BDD (Cucumber)** to automate real user workflows on the **AutomationExercise** e-commerce application.

The framework is designed following industry best practices such as:

- Page Object Model (POM)
- Reusable utility classes
- Parallel test execution
- Structured reporting
- Clean separation of concerns

### ✔ Automated User Journeys

- Contact Us form submission  
- User Signup & Login  
- Product search functionality  
- Add to cart & checkout workflow  
- Authentication & session validation  

---

## 🏗️ Framework Architecture

### ✅ Page Object Model (POM)
- Each page is represented as a dedicated Java class
- Web elements and actions are encapsulated
- Enhances maintainability and scalability

### ✅ BDD Implementation (Cucumber)
- Test cases written in Gherkin syntax
- Human-readable feature files
- Clear separation of step definitions and test logic

### ✅ Hooks (Before / After)
- Centralized WebDriver initialization
- Proper browser lifecycle handling
- Automatic cleanup post execution

### ✅ Parallel Execution
- Configured using TestNG
- Reduces execution time
- Supports scalable test suites

### ✅ Reporting
- Integrated Extent Reports
- Detailed HTML execution reports
- Step-level logging with pass/fail visibility

---

## 📂 Project Structure

```
src/test/java
 ├── bases              → WebDriver setup & base configuration
 ├── hooks              → Cucumber lifecycle hooks
 ├── pages              → Page Object classes
 ├── runners            → Test execution configuration
 ├── stepdefinitions    → Cucumber step implementations
 ├── utils              → Reporting & utility classes

src/test/resources
 ├── features           → Gherkin feature files
 └── extent.properties  → Reporting configuration

pom.xml                 → Maven dependency management
```

---

## 🧪 Automated Test Scenarios

### 🔹 Contact Us
- Navigate to Contact page
- Fill required details
- Submit form
- Validate success message

### 🔹 Signup & Login
- Register new user
- Create account
- Logout
- Login with created credentials
- Validate successful authentication

### 🔹 Product Module
- Navigate to Products page
- Add product to cart
- Verify cart contents
- Proceed to checkout
- Complete login/registration during checkout

### 🔹 Product Search
- Search for product (e.g., **"T-Shirt"**)
- Validate relevant search results

---

## ⚙️ Tech Stack

- **Java 17**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **TestNG**
- **Maven**
- **Extent Reports**

---

## 🚀 How to Execute

Clone the repository:

```bash
git clone https://github.com/RekhaRani-0916/Selenium-BDD-Framework.git
```

Navigate to the project:

```bash
cd Selenium-BDD-Framework
```

Run tests:

```bash
mvn clean test
```

---

## 📊 Reporting

After execution:

- `ExtentReport.html` is generated
- Provides detailed step-level reporting
- Displays execution status and logs

---

## 💡 Key Highlights

✔ Industry-standard automation framework  
✔ Scalable & maintainable design  
✔ Parallel test execution support  
✔ Clean project structure  
✔ Professional Git version control  

---

## 👩‍💻 Author

**Rekha Rani**  
SDET | Automation Engineer  
Selenium | Java | BDD | TestNG | Maven  
