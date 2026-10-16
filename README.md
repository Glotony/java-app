# JavaFX Desktop Application

A Java desktop application built to explore native desktop UI development with **JavaFX**, FXML-based views, MaterialFX controls, screen navigation, user account flows, and session handling.

The project is a hands-on sample application: it brings several screens together into one desktop workflow rather than serving as a web application.

## Overview

The application is organized around a simple user flow:

1. **Welcome screen** — the entry point for the application.
2. **Login screen** — accepts a username and password and delegates user lookup to `DBHelper`.
3. **Registration window** — collects account details and performs basic input checks before calling the database helper.
4. **Dashboard** — provides navigation to the profile, contact page, and logout action.
5. **Profile screen** — displays the current user's username, full name, and email from the in-memory session.
6. **Contact screen** — displays sample contact information.

JavaFX FXML separates the screen layouts from their Java controllers. `SceneManager` centralizes navigation between the main views, while `UserSession` stores the currently signed-in user for screens that need it.

## Features

- Desktop UI built with JavaFX and FXML.
- MaterialFX controls for buttons and form fields.
- Separate controllers for individual screens.
- Navigation between the welcome, login, dashboard, profile, and contact views.
- Login and registration flows wired to a database helper interface.
- Basic registration validation for required fields and password length.
- Lightweight session state for the active user.
- Maven-based dependency management and JavaFX launch configuration.

> **Current status:** This project is a work in progress, not a production-ready authentication system. The public repository currently has two missing pieces described in [Known limitations](#known-limitations).

## Tech Stack

| Technology | Purpose |
| --- | --- |
| Java | Application logic |
| JavaFX 26 | Desktop application framework |
| FXML | Declarative UI layouts |
| MaterialFX 11.17.0 | Extended JavaFX controls and styling |
| Maven | Dependency management and application launch |
| MySQL Connector/J 8.0.33 | MySQL JDBC driver dependency |

The configured Java source and target level in `pom.xml` is Java 17. However, **JavaFX 26 itself requires JDK 24 or later** to run. Use JDK 24 or newer; JDK 26 is recommended. See the [JavaFX 26 release notes](https://github.com/openjdk/jfx/blob/master/doc-files/release-notes-26.md).

## Project Structure

```text
java-app/
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   └── com/app/
│       │       ├── App.java
│       │       ├── MainController.java
│       │       ├── SecondController.java
│       │       ├── ThirdController.java
│       │       ├── FourthController.java
│       │       ├── FifthController.java
│       │       ├── RegisterController.java
│       │       ├── SceneManager.java
│       │       ├── User.java
│       │       └── UserSession.java
│       └── resources/
│           ├── main.fxml
│           ├── second.fxml
│           ├── third.fxml
│           ├── fourth.fxml
│           ├── fifth.fxml
│           └── registration.fxml
└── .gitignore
```

## Requirements

- JDK 24 or newer
- Maven
- MySQL, if using the database-backed login and registration flow

Verify your Java and Maven installations:

```bash
java -version
mvn -version
```

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/Glotony/java-app.git
cd java-app
```

### 2. Check database support

Before building from a fresh clone, restore or implement `src/main/java/com/app/DBHelper.java` and configure its database connection. The login and registration controllers call this class, but its source is not currently tracked in the public repository. The repository does not provide a database schema or a database configuration file, so those must be supplied as part of your local setup.

### 3. Run the application

Once the missing database helper is available and configured, start the JavaFX application from the project root:

```bash
mvn clean javafx:run
```

Maven downloads the dependencies declared in `pom.xml` and invokes the configured JavaFX entry point, `com.app.App`.

You can also open the project in an IDE with Maven support, import it as a Maven project, and run `com.app.App` using a JDK compatible with JavaFX 26.

## Application Flow

```text
App
└── Welcome screen (main.fxml)
    └── Login screen (second.fxml)
        ├── Registration window (registration.fxml)
        └── Dashboard (third.fxml)
            ├── Profile (fifth.fxml)
            ├── Contact (fourth.fxml)
            └── Logout → Login
```

## Known Limitations

- **Database helper is not included in the public source.** `SecondController` and `RegisterController` reference `DBHelper`, but `src/main/java/com/app/DBHelper.java` is excluded by the current `.gitignore`. A clean checkout therefore needs this class added before the project can compile.
- **Products page is not included.** The dashboard controller references `products.fxml`, but that resource is not present in the public repository. The Products navigation action will need a corresponding view/controller or should be removed until it is implemented.
- The contact details shown in the UI are sample placeholder values.
- This is a learning project. Authentication, database configuration, validation, and session management should be reviewed and strengthened before any real-world use.

## Purpose

This project is a practical space for experimenting with Java desktop application development: structuring JavaFX screens, connecting FXML layouts to controllers, managing navigation, handling user interaction, and exploring database-backed account workflows.

---

Created by [Glotony](https://github.com/Glotony).
