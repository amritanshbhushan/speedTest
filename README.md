# SpeedTest
# 🚀 SpeedTest Web App - Setup & Installation Guide  

This guide will help you set up and run the **SpeedTest Web App** built with **React (Frontend)** and **Spring Boot (Backend)**.

---

## **🛠 Prerequisites**
Before starting, make sure you have the following installed:  
✅ **Node.js** (for React) → [Download](https://nodejs.org/)  
✅ **Java 17+** (for Spring Boot) → [Download](https://adoptium.net/)  
✅ **Maven** (for Java dependencies) → [Download](https://maven.apache.org/download.cgi)  
✅ **Python** (for `speedtest-cli`) → [Download](https://www.python.org/downloads/)  
✅ **Git** (to clone the repository) → [Download](https://git-scm.com/downloads)  

---

## **📥 Installing SpeedTest CLI (pip)**
### **🔹 Windows, macOS, and Linux**
1. Open **Command Prompt (Windows)** or **Terminal (Mac/Linux)**.
2. Run the following command to install `speedtest-cli`:
    - pip install speedtest-cli 

3. Verify the installation by running:
    - speedtest-cli --json
## ** If you see a JSON response, the installation is successful.

4. If using Windows, check the installation path:
    - where speedtest-cli
If needed, add the Python Scripts folder to your System Environment Variables.

## ** CLONE THE REPOSITORY
    - https://github.com/amritanshbhushan/speedTest.git

## ** Frontend
    - cd speedTest
    - cd speedTest-react
    - npm install
    - npm start

## ** Backend
    - cd speedTest/speedTest
## ** Build the Project
    - mvn clean install
## ** Run the backend server
    - mvn spring-boot:run

## ** DEPLOYMENT STEPS 
1. Java->
    - mvn package
    - java -jar target/speedtest-app.jar
2. Angular->
    - npm run build

## ** 🎯 Notes
✅ For issues with speedtest-cli, ensure the correct Python path is used in SpeedTestService.java.
✅ For UI issues, check browser console logs (F12 → Console).
✅ For CORS issues, update WebConfig.java in the backend.

## ** 📌 Contributors
    - Amritansh Bhushan