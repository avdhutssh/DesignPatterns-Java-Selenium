<!--
    #/**
    # * @author Avdhut Shirgaonkar
    # * Email: avdhut.ssh@gmail.com
    # * LinkedIn: https://www.linkedin.com/in/avdhut-shirgaonkar-811243136/
    # */
    #/***************************************************/
-->

---

# 🎨 Design Patterns in JAVA with Selenium

## 📑 Table of Contents

- [Introduction](#introduction)
- [Design Patterns Implemented](#DesignPatternsImplemented)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Running Examples](#running-tests)
- [Contributions](#contributions)
- [Contacts](#contacts)

## 📖 Introduction

This repository demonstrates various design patterns applied in Selenium WebDriver with Java, aimed at creating a robust and maintainable automation framework. The concepts are based on a structured course, covering good code practices and the implementation of design patterns like Factory, Strategy, Command, Template Method, Proxy, and Decorator.

## 🎨 Design Patterns Implemented

- **Single Responsibility Principle:** Ensures that each class has only one reason to change by focusing on a single responsibility. This pattern is essential in test automation to keep the code clean and maintainable.

- **Factory Pattern:** This pattern is used to create objects without specifying the exact class of the object that will be created. In test automation, it helps in managing different browser instances or page objects based on specific test requirements.

- **Strategy Pattern:** The strategy pattern allows defining a family of algorithms, encapsulating each one, and making them interchangeable. In automation, it is useful for switching between different testing strategies or browser configurations without altering the core framework.

- **Command Pattern:** Encapsulates a request as an object, allowing for parameterization of clients with queues, requests, and operations. In test automation, it's used to encapsulate different actions (like click, type, etc.) that can be executed in a flexible manner.

- **Template Method Pattern:** This pattern defines the skeleton of an algorithm in a method, deferring some steps to subclasses. It is widely used in test automation to define a workflow of tests where the steps can be overridden as needed.

- **Proxy Pattern:** The proxy pattern provides a surrogate or placeholder for another object to control access to it. In automation, it can be used to manage browser sessions or network interactions, providing controlled access and adding layers like logging or validation.

- **Execute Around Method Pattern:** This pattern is used to abstract away repetitive tasks or setup/cleanup code that needs to be executed around the main logic. In test automation, it’s particularly useful for ensuring certain conditions are met before and after executing a test step, such as opening and closing a browser or handling authentication.

- **Decorator Pattern:** This pattern allows behavior to be added to individual objects, either statically or dynamically, without affecting the behavior of other objects from the same class. It's particularly useful in test automation for adding additional functionalities like logging, taking screenshots, or handling waits without changing the core logic of page objects or components.

## 📁 Project Structure

```plaintext
Pattern/
├──────src/main/java
│   │  │  │  ├── PageObjects and Wrapper Classes/      # Page Object classes and wrapper classes
Pattern/
├──────src/main/test
│   │  │  │  ├── BaseTest and main Test   # Test classes
```

## ▶️ Getting Started

### Prerequisites

- Java JDK 8 or higher
- Maven
- WebDriver binaries and dependencies in pom.xml
- IDE (e.g., IntelliJ IDEA, Eclipse)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/avdhutssh/Advanced-Selenium-Webdriver.git
   cd Advanced-Selenium-Webdriver
   ```

2. Install dependencies:

   ```bash
   mvn clean install
   ```

## 🚀 Running Examples

You can run the tests under test packages using the following Maven command:

```bash
mvn test
```

## 💡 Contributions

Contributions are welcome! Please fork the repository and submit a pull request to propose changes.

## 📧 Contacts

- [![Email](https://img.shields.io/badge/Email-avdhut.ssh@gmail.com-green)](mailto:avdhut.ssh@gmail.com)
- [![LinkedIn](https://img.shields.io/badge/LinkedIn-Profile-blue)](https://www.linkedin.com/in/avdhut-shirgaonkar-811243136/)

Feel free to reach out if you have any questions or suggestions.

Happy Learning!!!
