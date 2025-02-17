🎯 Trivia API - Java REST Client

The **Trivia API** is a Java library that enables retrieving trivia questions from the **Open Trivia DB API** via REST API calls. It uses **HttpClient** for managing requests and **Jackson** for deserializing JSON data.

🚀 Features
- Retrieve trivia questions from the Open Trivia DB API.
- Supports **category, difficulty, number of questions, and type (multiple choice / true-false) selection**.
- Convert JSON data into Java objects using **Jackson**.
- Generate a **.jar** file for use in other applications.

🛠️ Technologies & Dependencies
- **Java 17**
- **Maven** (for dependency management)
- **HttpClient** (for REST API requests)
- **Jackson** (for JSON deserialization)
- **JUnit 5 & Mockito** (for testing)

📥 Installation & Execution

1️⃣ **Clone the Repository**

git clone https://github.com/VasoUnipi/API.git

cd API

2️⃣ Install Dependencies with Maven

mvn clean install

3️⃣ Generate the JAR File

mvn package
The .jar file will be created inside the target/ folder.

🛠️ Using the API in Your Application
You can use the Trivia API in any Java application by adding the .jar file to your project.

📂 Project Structure

📁 API
 ┣ 📂 src
 ┃ ┣ 📂 main
 ┃ ┃ ┣ 📂 java
 ┃ ┃ ┃ ┣ 📜 TriviaApiClient.java
 ┃ ┃ ┃ ┣ 📜 Questions.java
 ┃ ┃ ┃ ┗ 📜 Result.java
 ┃ ┣ 📂 test
 ┃ ┃ ┣ 📜 TriviaApiClientTest.java
 ┃ ┃ ┣ 📜 QuestionTest.java
 ┃ ┃ ┣ 📜 ResultTest.java
 ┣ 📜 pom.xml
 ┣ 📜 README.md

🧪 Testing
The API was tested with JUnit 5 and Mockito. The tests include: 
✅ Mock testing for fetchQuestions()
✅ Handling invalid JSON responses

🏆 Thank you for using the API! 🎉
