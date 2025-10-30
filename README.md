# SWE370-DigitalLost-Found

# 🧩 Digital Lost & Found System  
**Course:** SWE 370 — Software Engineering  
**Language:** Java (Swing GUI)  
**Build Tool:** Gradle  
**Repository:** https://github.com/ibarr8core/SWE370-DigitalLost-Found  

---

## 📖 Overview
The **Digital Lost & Found System** is a Java-based desktop application built to help users report, manage, and locate lost items digitally.  
It’s part of our SWE 370 team project at CSUSM.

The application features a simple Swing GUI for interaction and can be expanded later into a full web-based system.

---

## ⚙️ Project Setup

### 1️⃣ Requirements
- **JDK 17** or later  
- **Gradle Wrapper** (included — no manual Gradle install required)  
- Works on **Windows, macOS, and Linux**

### 2️⃣ Build & Run

#### 🏗️ Build
```bash
# From the repo root
./gradlew build        # (Linux / macOS)
gradlew.bat build      # (Windows)

./gradlew run
# or
gradlew.bat run

#### structure
SWE370-DigitalLost-Found/
├── src/
│   └── main/
│       ├── java/
│       │   └── edu/csusm/digitalfound/ <-------- This the root, add files to the room .\gradlew.bat build and .\gradlew.bat run to run the files 
│       │       ├── Main.java
│       │       ├── ui/          ← GUI components
│       │       ├── model/       ← data structures / item classes
│       │       └── logic/       ← core functionality
│       └── resources/            ← images, icons, configs
├── build.gradle
├── settings.gradle
├── gradlew / gradlew.bat
├── gradle/wrapper/
│   ├── gradle-wrapper.jar
│   └── gradle-wrapper.properties
└── README.md


#### how to deploy
git add .
git commit -m "Your commit message"
git push origin main


🧱 CI / CD (GitHub Actions)

The repo includes an automated workflow:

Builds on every push and PR to main

Runs Gradle build (./gradlew build)

Ensures the wrapper JAR is committed

JDK version: 17 (Temurin)
