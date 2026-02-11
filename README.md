\# 🚀 Selenium BDD Automation Framework – AutomationExercise



\## 📌 Project Overview



This project is a robust end-to-end test automation framework built using \*\*Selenium WebDriver with BDD (Cucumber)\*\* to automate real user workflows on the \*\*AutomationExercise\*\* e-commerce web application.



The framework is designed following industry best practices such as:



\- Page Object Model (POM)

\- Reusable utilities

\- Parallel execution

\- Structured reporting



\### ✔ Validated User Journeys



\- Contact Us form submission  

\- User Signup and Login  

\- Product search functionality  

\- Add to cart \& checkout workflow  

\- User authentication and session handling  



---



\## 🏗️ Framework Architecture



\### ✅ Page Object Model (POM)

\- Each web page is represented as a separate class  

\- UI elements and actions are encapsulated  

\- Improves maintainability and reusability  



\### ✅ BDD Implementation (Cucumber)

\- Test scenarios written in Gherkin format  

\- Business-readable feature files  

\- Clear separation of steps and implementation  



\### ✅ Hooks (Before / After)

\- Centralized WebDriver initialization  

\- Cleanup after execution  

\- Proper browser lifecycle handling  



\### ✅ Parallel Execution

\- Configured using TestNG  

\- Enables faster execution of test scenarios  

\- Scalable for large test suites  



\### ✅ Reporting

\- Extent Reports integration  

\- Detailed HTML report generation  

\- Step-level execution logging  

\- Pass/Fail visibility  



---



\## 📂 Project Structure



```

src/test/java

&nbsp;├── bases              → WebDriver setup \& base configuration

&nbsp;├── hooks              → Cucumber lifecycle hooks

&nbsp;├── pages              → Page Object classes

&nbsp;├── runners            → Test execution configuration

&nbsp;├── stepdefinitions    → Cucumber step implementations

&nbsp;├── utils              → Extent Report \& utility classes



src/test/resources

&nbsp;├── features           → Gherkin feature files

&nbsp;└── extent.properties  → Reporting configuration



pom.xml                 → Maven dependencies

```



---



\## 🧪 Automated Test Scenarios



\### 🔹 Contact Us Functionality

\- Navigate to Contact page  

\- Fill required details  

\- Submit form  

\- Validate success message  



\### 🔹 User Signup \& Login

\- Register new user  

\- Create account  

\- Logout  

\- Login with created credentials  

\- Validate successful authentication  



\### 🔹 Product Functionality

\- Navigate to Products page  

\- Add product to cart  

\- Verify cart contents  

\- Proceed to checkout  

\- Register/Login during checkout  



\### 🔹 Product Search

\- Search for specific product (e.g., \*\*"T-Shirt"\*\*)  

\- Validate search results  



---



\## ⚙️ Tech Stack



\- Java 17  

\- Selenium WebDriver  

\- Cucumber (BDD)  

\- TestNG  

\- Maven  

\- Extent Reports  



---



\## 🚀 How to Execute



Clone the repository:



```bash

git clone https://github.com/RekhaRani-0916/Selenium-BDD-Framework.git

```



Navigate to project directory:



```bash

cd Selenium-BDD-Framework

```



Run tests:



```bash

mvn clean test

```



---



\## 📊 Reporting



After execution:



\- `ExtentReport.html` is generated  

\- Provides detailed step-level reporting  

\- Includes execution status and logs  



---



\## 💡 Key Highlights



✔ Industry-standard automation architecture  

✔ Clean separation of concerns  

✔ Maintainable and scalable framework  

✔ Parallel test execution  

✔ Structured reporting  

✔ Professional Git version control  



---



\## 👩‍💻 Author



\*\*Rekha Rani\*\*   

Selenium | Java | BDD | TestNG | Maven  



